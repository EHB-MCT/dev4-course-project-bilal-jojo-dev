package ehb.multimedia.loans.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("items")
class ItemsController {

    @GetMapping()
    fun getItems(): String {
        return "Test"
    }

    @GetMapping("item")
    fun getItem(): String {
        return "This is on the Jojo branch";
    }

}