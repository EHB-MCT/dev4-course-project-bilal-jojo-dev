package ehb.multimedia.loans.models

import jakarta.persistence.*


@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "firstName", nullable = false)
    val firstName: String = "",
    @Column(name = "lastName", nullable = false)
    val lastName: String = "",
    @Column(name = "email", nullable = false)
    val email: String = "",
    @Column(name = "password", nullable = false)
    val password: String = "",
    @Column(name = "role", nullable = false)
    val role: String = "",
    @Column(name = "phoneNr", nullable = false)
    val phoneNr: Int = 0,

) {
}
