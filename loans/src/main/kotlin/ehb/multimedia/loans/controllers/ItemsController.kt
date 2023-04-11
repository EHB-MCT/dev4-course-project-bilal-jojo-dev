package ehb.multimedia.loans.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("items")
class ItemsController {

    @GetMapping("")
    fun getAllItems(): String {
        return "This gets all Items"
    }

    @GetMapping("item/{id}")
    fun getItem(): String {
        return "This gets a specific Item";
    }

}

