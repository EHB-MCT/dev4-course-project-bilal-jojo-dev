package ehb.multimedia.loans.services

//import ehb.multimedia.loans.controllers.DatabaseController
import ehb.multimedia.loans.dto.CreateItem
import ehb.multimedia.loans.models.Copy
import ehb.multimedia.loans.models.Item
import ehb.multimedia.loans.repositories.copyRepository
import ehb.multimedia.loans.repositories.itemRepository
import jakarta.persistence.EntityNotFoundException
import org.apache.commons.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ItemService () {

    @Autowired
    lateinit var itemRepository: itemRepository

    fun getItems(): List<Item> {
        return itemRepository.findAll()
        //val items = DatabaseController.getAllItems()
        /*for (item in items) {
            println(item.name)
        }*/
    }

    /*fun getCopies(): List<Copy> {
        return copyRepository.findById()
    }*/

    fun saveItem(item: Item): Item {
        return itemRepository.save(item)
    }

    fun getItemById(id: Int): Item {
        val itemEnt = itemRepository.findById(id)
        return itemEnt
    }

    fun deleteItem(id: Long) {
        return itemRepository.deleteById(id)
    }

    fun updateItem(item: Item): Item {

        val itemEntity = itemRepository.findById(item.id)

        val itemData = Item(
                id = itemEntity.id,
                name = item.name,
                brand = item.brand
        );
        return itemRepository.save(itemData)


    }




}