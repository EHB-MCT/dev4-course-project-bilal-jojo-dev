package ehb.multimedia.loans.services
import ehb.multimedia.loans.dto.CreateLoan
import ehb.multimedia.loans.models.Loan
import ehb.multimedia.loans.repositories.copyRepository
import ehb.multimedia.loans.repositories.itemRepository
import ehb.multimedia.loans.repositories.loanRepository
import ehb.multimedia.loans.repositories.userRepository
import org.springframework.stereotype.Service


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
            date = createLoan.startDate,
            expirationDate = createLoan.endDate
        )

        // TODO: Pattern works technically but causes the item in the loan above to become a string when it's supposed to be an integer

        /*val confirmationEmailStrategy: EmailStrat = ReminderMail()
        user.email.let {
            println(user.email)
            println("${user.firstName} made a loan for ${item.name} from ${loan.date} to ${loan.expirationDate}")
            confirmationEmailStrategy.sendEmail(
                    emailTo = it,
                    subject = "Registration",
                    message = "You've created an account with email adress ${user.email}"
            )
        }*/

        return loanRepository.save(loan)

    }

    /*} else {
        throw IllegalArgumentException("De opgegeven gebruiker of het item bestaat niet.")
    }*/
    }









