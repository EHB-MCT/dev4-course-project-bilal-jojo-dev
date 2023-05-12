package ehb.multimedia.loans.services
import ehb.multimedia.loans.dto.CreateLoan
import ehb.multimedia.loans.models.Loan
import ehb.multimedia.loans.repositories.copyRepository
import ehb.multimedia.loans.repositories.itemRepository
import ehb.multimedia.loans.repositories.loanRepository
import ehb.multimedia.loans.repositories.userRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class LoanService(val loanRepository: loanRepository, val userRepository: userRepository, val itemRepository: itemRepository, val copyRepository: copyRepository) {

    fun getLoans(): List<Loan> {
        return loanRepository.findAll()
    }

    fun saveLoan(createLoan: CreateLoan): Loan {
        val item = copyRepository.findById(createLoan.itemId)
        val user = userRepository.findById(createLoan.userId)

        val loan = Loan(
            itemId = item,
            userId = user,
            date = java.sql.Date.valueOf(createLoan.startDate),
            expirationDate = java.sql.Date.valueOf(createLoan.endDate)
        )
        return loanRepository.save(loan)
    }

    /*} else {
        throw IllegalArgumentException("De opgegeven gebruiker of het item bestaat niet.")
    }*/
    }









