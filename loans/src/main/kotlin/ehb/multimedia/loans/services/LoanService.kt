package ehb.multimedia.loans.services

import ehb.multimedia.loans.dto.CreateLoanRequest
import ehb.multimedia.loans.models.Item
import ehb.multimedia.loans.models.Loan
import ehb.multimedia.loans.models.User
import ehb.multimedia.loans.repositories.itemRepository
import ehb.multimedia.loans.repositories.loanRepository
import ehb.multimedia.loans.repositories.userRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class LoanService(private val loanRepository: loanRepository, private val itemRepository: itemRepository, private val userRepository: userRepository) {

    fun createLoan(loanRequest: CreateLoanRequest): Loan {
        val loan = Loan()
        loan.startDate = loanRequest.startDate
        loan.endDate = loanRequest.endDate

        // Set the user field
        val user = userRepository.findById(loanRequest.userId.toLong())
        loan.user = user.orElse(null)

        // Set the item field
        val item = itemRepository.findById(loanRequest.itemId.toLong())
        loan.item = item.orElse(null)

        return loanRepository.save(loan)
    }

    fun getLoans(): List<Loan> {
        return loanRepository.findAll()
    }

    fun saveLoan(loan: Loan): Loan {
        return loanRepository.save(loan)
    }

}
