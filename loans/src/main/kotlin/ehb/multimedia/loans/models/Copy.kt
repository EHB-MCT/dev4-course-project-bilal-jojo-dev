package ehb.multimedia.loans.models

import jakarta.persistence.*

@Entity
@Table(name = "copies")
data class Copy (
    @Id
    @GeneratedValue
    val id: Int = 0,
    val name: String = "",
    val serial: Int = 0,
    val status: Boolean,
    val remarks: String = "",
    @ManyToOne
    val Item: Item

        ) {
    constructor(name: String, serial: Int, status: Boolean, remarks: String, Item: Item) : this(0, name, serial, status, remarks, Item)
}