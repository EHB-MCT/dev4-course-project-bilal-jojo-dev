package ehb.multimedia.loans.controllers

import ehb.multimedia.loans.dto.CreateLoan
import ehb.multimedia.loans.models.Loan
import ehb.multimedia.loans.services.LoanService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("loans")
class LoansController(val loanService: LoanService) {

    @GetMapping("")
    fun getAllLoans(): List<Loan> {
        return loanService.getLoans()
    }

    @PostMapping("")
    fun saveLoan(@RequestBody createLoan: CreateLoan): Loan {
        return loanService.saveLoan(createLoan)
    }
}
