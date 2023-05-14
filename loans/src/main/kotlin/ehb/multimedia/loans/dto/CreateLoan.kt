package ehb.multimedia.loans.dto

import ehb.multimedia.loans.models.Copy
import ehb.multimedia.loans.models.User
import java.time.LocalDate
import java.util.*


data class CreateLoan(val itemId: Int, val userId: Int, val startDate: LocalDate, val endDate: LocalDate)

