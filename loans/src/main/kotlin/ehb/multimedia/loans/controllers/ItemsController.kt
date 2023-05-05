package ehb.multimedia.loans.controllers

import ehb.multimedia.loans.models.Item
import ehb.multimedia.loans.services.ItemService
import org.springframework.web.bind.annotation.*
@CrossOrigin


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



