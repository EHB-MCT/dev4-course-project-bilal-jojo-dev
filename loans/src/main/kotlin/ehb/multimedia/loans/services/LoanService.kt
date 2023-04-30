package ehb.multimedia.loans.services
import ehb.multimedia.loans.dto.CreateLoan
import ehb.multimedia.loans.models.Loan
import ehb.multimedia.loans.repositories.itemRepository
import ehb.multimedia.loans.repositories.loanRepository
import ehb.multimedia.loans.repositories.userRepository
import org.springframework.stereotype.Service


@Service
class LoanService(val loanRepository: loanRepository, val userRepository: userRepository, val itemRepository: itemRepository) {

    fun getLoans(): List<Loan> {
        return loanRepository.findAll()
    }

    fun saveLoan(createLoan: CreateLoan): Loan {

        val userExists = userRepository.existsById(createLoan.userId)
        val itemExists = itemRepository.existsById(createLoan.itemId)

        if (userExists && itemExists) {
            val loan = Loan(
                itemId = createLoan.itemId,
                userId = createLoan.userId,
                date = createLoan.date,
                expirationDate = createLoan.expirationDate
            )
            return loanRepository.save(loan)
        } else {
            throw IllegalArgumentException("De opgegeven gebruiker of het item bestaat niet.")
        }
    }
}







