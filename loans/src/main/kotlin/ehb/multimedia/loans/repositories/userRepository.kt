package ehb.multimedia.loans.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface userRepository : JpaRepository<User, Long> {
}