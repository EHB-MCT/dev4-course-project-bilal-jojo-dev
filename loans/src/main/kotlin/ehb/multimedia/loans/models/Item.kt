package ehb.multimedia.loans.models

import jakarta.persistence.*

@Entity
@Table(name = "items")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "name", nullable = false)
    val name: String = "",
    @Column(name = "brand", nullable = false)
    val brand: String = "",
    @Column(name = "serial", nullable = false)
    val serial: Int = 0
    ) {

    }