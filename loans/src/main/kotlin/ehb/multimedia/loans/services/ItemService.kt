package ehb.multimedia.loans.services

import ehb.multimedia.loans.controllers.DatabaseController
import ehb.multimedia.loans.models.Item
import ehb.multimedia.loans.repositories.itemRepository
import org.apache.commons.logging.Log
import org.springframework.stereotype.Service

@Service
class ItemService (val itemRepository: itemRepository) {

    fun getItems(): List<Item> {
        return itemRepository.findAll()
    }

    fun saveItem(item: Item): Item {
        return itemRepository.save(item)
    }

}