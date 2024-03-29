package ehb.multimedia.loans.controllers

//import ehb.multimedia.loans.services.EmailService


import ehb.multimedia.loans.dto.CreateUser
import ehb.multimedia.loans.dto.LoginUserRequest
import ehb.multimedia.loans.models.User
import ehb.multimedia.loans.services.UserService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@CrossOrigin
@RestController
@RequestMapping("users")

//set userRepository as class parameter
class UsersController (val userService: UserService) {

    @GetMapping()
    fun getAllUsers(@RequestHeader(name = HttpHeaders.AUTHORIZATION, required = false) token: String?): List<User> {
        if (token != null && userService.isAuthenticated(token)) {
            val users = userService.getUsers();
            return users
        } else {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication token not present or accepted")
        }
    }




    @PostMapping("")
    fun saveUser(@RequestBody user: CreateUser): User {
        // Registreer de nieuwe gebruiker
        val newUser = userService.saveUser(user)

        // Stuur een welkomst e-mail naar de nieuwe gebruiker
        val to = newUser.email
        val subject = "Welkom bij onze applicatie"
        val text = "Beste ${newUser.firstName} ${newUser.lastName},\n\nBedankt voor je registratie"

        //emailService.sendEmail(to, subject, text)

        return newUser
    }

    @RequestMapping("/login")
    @PostMapping
    fun loginUser(@RequestBody userRequest: LoginUserRequest): String? {
        return userService.loginUser(userRequest)
    }

}

