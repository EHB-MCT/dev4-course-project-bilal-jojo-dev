package ehb.multimedia.loans.services

import ehb.multimedia.loans.dto.CreateUser
import ehb.multimedia.loans.dto.LoginUserRequest
import ehb.multimedia.loans.models.User
import ehb.multimedia.loans.repositories.userRepository
import ehb.multimedia.loans.strategy.ConfirmationUser
import ehb.multimedia.loans.strategy.EmailStrat
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserService(val userRepository: userRepository) {

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun saveUser(user: CreateUser): User {
        val userInfo = User(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            password = user.password,
            role = user.role,
            phoneNr = user.phoneNr
        )

        val confirmationEmailStrategy: EmailStrat = ConfirmationUser()

        /* TODO: Design pattern is here but its integration affects the return save user.
        userInfo.email.let {
            println(userInfo.email)
            println("Registration complete for ${userInfo.firstName} ${userInfo.lastName} with email adress ${userInfo.email}")
            confirmationEmailStrategy.sendEmail(
                    emailTo = it,
                    subject = "Registration",
                    message = "You've created an account with email adress ${userInfo.email}"
            )
        }*/

        return userRepository.save(userInfo)

    }

    fun loginUser(userRequest: LoginUserRequest): String? {
        val u = userRepository.findByEmail(userRequest.email)
        if (u != null) {
            if (userRequest.password == u.password) {
                u.accessToken = UUID.randomUUID().toString()
                u.expirationDate = System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 1)
                userRepository.save(u)
                return u.accessToken
            }
        }
        return null
    }

    fun isAuthenticated(token: String): Boolean {
        val u = userRepository.findByAccessToken(token)
        return u != null && u.expirationDate > System.currentTimeMillis()
    }
}