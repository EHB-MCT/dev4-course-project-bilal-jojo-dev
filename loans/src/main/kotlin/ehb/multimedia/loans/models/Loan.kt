package ehb.multimedia.loans.models

import jakarta.persistence.*
import java.time.LocalDate
import java.util.Date


@Entity
@Table(name = "loans")
class Loan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val date: Date,
    val expirationDate: Date,
    @OneToOne
    val itemId: Copy,
    @OneToOne
    val userId: User,

    //@OneToOne var copyId: Copy,
    //@OneToOne
    //var userId: User
) {


}