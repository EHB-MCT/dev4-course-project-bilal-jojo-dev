package ehb.multimedia.loans.models

import jakarta.persistence.*

@Entity
@Table(name = "copies_of_item")
data class copyOfItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "serial")
    val serial: Int = 0,
    @Column(name = "status")
    val status: String = "",
    @Column(name = "remarks")
    val remarks: String = ""
) {

}