package ehb.multimedia.loans.controllers

import ehb.multimedia.loans.models.Item
import ehb.multimedia.loans.services.ItemService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("items")
class ItemsController (val itemService: ItemService) {

    @GetMapping("")
    fun getAllItems(): List<Item> {
        return  itemService.getItems()
    }

    @PostMapping("")
    fun saveItem(@RequestBody item: Item): Item {
        return itemService.saveItem(item)
    }

}

