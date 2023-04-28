package ehb.multimedia.loans.repositories

import ehb.multimedia.loans.models.copyOfItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface copyRepository : JpaRepository<copyOfItem, Long> {
}