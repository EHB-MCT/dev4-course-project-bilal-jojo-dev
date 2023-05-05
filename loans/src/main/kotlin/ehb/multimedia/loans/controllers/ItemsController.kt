package ehb.multimedia.loans.controllers

import ehb.multimedia.loans.models.Item
import ehb.multimedia.loans.repositories.itemRepository
import ehb.multimedia.loans.services.ItemService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("items")
class ItemsController (val itemService: ItemService) {

    @GetMapping("")
    fun getAllItems(): List<Item> {
        return  itemService.getItems()
    }

    @GetMapping("/{id}")
    fun getItem(@PathVariable id: Int): Item {
        return itemService.getItemById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: Long) {
        return itemService.deleteItem(id)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: Int, @RequestBody item: Item): Item {
        return itemService.updateItem(item)
    }

    @PostMapping("")
    fun saveItem(@RequestBody item: Item): Item {
        return itemService.saveItem(item)
    }

}

