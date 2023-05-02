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
        // Valideren of de gebruiker en het item bestaan voordat je de lening opslaat
        //val userExists = userRepository.existsById(createLoan.userId)
        //val itemExists = itemRepository.existsById(createLoan.itemId)

        val item = copyRepository.findById(createLoan.itemId)
        val user = userRepository.findById(createLoan.userId)

            val currentDate = Date()
            val calendar = Calendar.getInstance()
            calendar.time = currentDate
            calendar.add(Calendar.DATE, 7)
            val expirationDate = calendar.time

            val loan = Loan(
                itemId = item,
                userId = user,
                date = currentDate,
                expirationDate = expirationDate
            )
            return loanRepository.save(loan)
        /*} else {
            throw IllegalArgumentException("De opgegeven gebruiker of het item bestaat niet.")
        }*/
    }
}








