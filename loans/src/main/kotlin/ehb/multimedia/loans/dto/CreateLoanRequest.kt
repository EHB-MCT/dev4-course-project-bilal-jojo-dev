package ehb.multimedia.loans.dto

import java.time.LocalDate

data class CreateLoanRequest(val userId: Int, val itemId: Int, val startDate: LocalDate, val endDate: LocalDate)
