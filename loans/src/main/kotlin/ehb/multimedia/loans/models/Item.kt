package ehb.multimedia.loans.models

import jakarta.persistence.*

@Entity
@Table(name = "items")
class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    var name: String = "",
    var brand: String = "",
    /*@Column(name = "serial", nullable = false)
    val serial: Int = 0*/
    ) {

    @OneToMany
    var copies: List<Copy> = listOf()


    }