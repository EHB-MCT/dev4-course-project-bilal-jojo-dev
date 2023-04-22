package ehb.multimedia.loans.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "items")
    class Item {
    @Id
    @GeneratedValue
    val id: Int = 0
    val name: String = ""
    val description: String = ""
    }