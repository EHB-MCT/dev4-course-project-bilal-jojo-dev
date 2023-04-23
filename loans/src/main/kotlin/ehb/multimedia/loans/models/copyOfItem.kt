package ehb.multimedia.loans.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "copiesOfItem")
class copyOfItem {
    @Id
    @GeneratedValue
    val id: Int = 0
    val serial: Int = 0
    val status: String = ""
    val lastLoaner: String = ""
    val remarks: String = ""
}