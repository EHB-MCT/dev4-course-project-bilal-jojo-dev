package ehb.multimedia.loans.services
import ehb.multimedia.loans.models.User
import ehb.multimedia.loans.repositories.userRepository

import org.springframework.stereotype.Service




@Service
class UserService(val userRepository: userRepository) {

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

}

