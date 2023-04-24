package ehb.multimedia.loans.models

import jakarta.persistence.*
import java.time.LocalDate
import java.util.Date

@Entity
@Table(name = "loans")
class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var startDate: LocalDate? = null
    var endDate: LocalDate? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    var item: Item? = null
}
