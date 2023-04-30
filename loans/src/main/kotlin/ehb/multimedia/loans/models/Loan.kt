package ehb.multimedia.loans.models

import jakarta.persistence.*
import java.time.LocalDate
import java.util.Date


@Entity
@Table(name = "loans")
data class Loan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "item_id", nullable = false)
    val itemId: Long,
    @Column(name = "user_id", nullable = false)
    val userId: Long,
    @Column(name = "date")
    val date: Date,
    @Column(name = "expiration_date")
    val expirationDate: Date
)