package ehb.multimedia.loans.controllers

import ehb.multimedia.loans.models.User
import ehb.multimedia.loans.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("users")

//set userRepository as class parameter
class UsersController (val userService: UserService) {

    @GetMapping("")
    fun getAllUsers(): List<User> {
        return userService.getUsers()
    }

    @PostMapping("")
    fun saveUser(@RequestBody user: User): User {
        return userService.saveUser(user)
    }

}

