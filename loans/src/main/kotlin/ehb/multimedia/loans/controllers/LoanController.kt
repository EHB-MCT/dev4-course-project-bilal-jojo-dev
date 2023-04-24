package ehb.multimedia.loans.controllers

import ehb.multimedia.loans.models.Loan
import ehb.multimedia.loans.services.LoanService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/loans")
class LoanController(private val loanService: LoanService) {

    @GetMapping("")
    fun getLoans(): List<Loan> {
        return loanService.getLoans()
    }

    @PostMapping("")
    fun createLoan(@RequestBody loan: Loan): Loan {
        return loanService.saveLoan(loan)
    }
}
