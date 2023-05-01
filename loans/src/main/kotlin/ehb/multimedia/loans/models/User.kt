package ehb.multimedia.loans.models

import jakarta.persistence.*


@Entity
@Table(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val role: String = "",
    val phoneNr: Int = 0
)





