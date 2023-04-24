package ehb.multimedia.loans.repositories

import ehb.multimedia.loans.models.Loan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface loanRepository : JpaRepository<Loan, Long>