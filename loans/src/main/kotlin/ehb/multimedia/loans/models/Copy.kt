package ehb.multimedia.loans.models

import jakarta.persistence.*

@Entity
@Table(name = "copies")
class Copy (
    @Id
    @GeneratedValue
    val id: Int = 0,
    val name: String,
    val serial: Int,
    val status: Boolean,
    val remarks: String,
    @ManyToOne
    val item: Item

        ) {
    // constructor(name: String, serial: Int, status: Boolean, remarks: String, item: Item) : this(0, name, serial, status, remarks, item)

}