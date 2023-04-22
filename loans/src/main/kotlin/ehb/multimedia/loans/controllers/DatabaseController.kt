package ehb.multimedia.loans.controllers

import ehb.multimedia.loans.dto.CreateItem
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.util.*

object DatabaseController {

    var con = getConnection("DEV4030", "86472935");

    private fun getConnection(username: String, password: String): Connection {
        val connectionProps = Properties()
        val databaseName = username
        connectionProps["user"] = username
        connectionProps["password"] = password
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()
        return DriverManager.getConnection(
            "jdbc:" + "mysql" + "://" +
                    "dt5.ehb.be" +
                    ":" + "3306" + "/" +
                    databaseName,
            connectionProps)
    }

    fun getAllItems(): MutableList<CreateItem> {
        val result = executeQuery(con, "SELECT * FROM items");
        val items = mutableListOf<CreateItem>()

        while (result!!.next()) {
            val id = result.getInt("id")
            val name = result.getString("name")
            val brand = result.getString("brand")
            val serial = result.getInt("serial")
            /*
            constructing a User object and
            putting data into the list
             */
            items.add(CreateItem(id, name, brand, serial))
        }

        return items
    }

    private fun executeQuery(connection: Connection, query: String): ResultSet? {
        val statement = connection.prepareStatement(query)
        return statement.executeQuery()
    }

}