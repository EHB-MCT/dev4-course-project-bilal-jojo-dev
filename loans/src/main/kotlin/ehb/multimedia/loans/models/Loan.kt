package ehb.multimedia.loans.models

import jakarta.persistence.*


@Entity
@Table(name = "loans")
class Loan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val date: String,
    val expirationDate: String,
    @OneToOne
    val itemId: Copy,
    @OneToOne
    val userId: User,

    //@OneToOne var copyId: Copy,
    //@OneToOne
    //var userId: User
) {


}