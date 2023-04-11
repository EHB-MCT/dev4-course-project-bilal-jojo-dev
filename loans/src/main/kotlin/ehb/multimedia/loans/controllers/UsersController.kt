package ehb.multimedia.loans.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class UsersController {

    @GetMapping("")
    fun getUsers(): String {
        return "This is the users class"
    }

    @GetMapping("/user")
    fun getUser(): String {
        return "This is on the features branch"
    }

}