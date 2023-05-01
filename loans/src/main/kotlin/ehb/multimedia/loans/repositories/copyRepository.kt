package ehb.multimedia.loans.repositories

import ehb.multimedia.loans.models.Copy
import org.springframework.data.jpa.repository.JpaRepository

interface copyRepository : JpaRepository<Copy, Long> {

}