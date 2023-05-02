package ehb.multimedia.loans.repositories

import ehb.multimedia.loans.models.Copy
import ehb.multimedia.loans.models.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface copyRepository : JpaRepository<Copy, Long> {

    fun findById(Copy: Int): Copy

}