package ehb.multimedia.loans.repositories

import ehb.multimedia.loans.models.Copy
import ehb.multimedia.loans.models.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface itemRepository : JpaRepository<Item, Long> {

    fun findById(Item: Int): Item
}