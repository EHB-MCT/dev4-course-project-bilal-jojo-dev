package ehb.multimedia.loans.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "items")
class Item(name: String, brand: String, serial: Int) {
    @Id
    @GeneratedValue
    var id: Int = 0
    val name: String = ""
    val description: String = ""
    }