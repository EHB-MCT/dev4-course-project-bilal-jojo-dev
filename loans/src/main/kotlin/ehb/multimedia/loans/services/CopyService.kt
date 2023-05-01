package ehb.multimedia.loans.services

import ehb.multimedia.loans.dto.CreateCopy
import ehb.multimedia.loans.models.Copy
import ehb.multimedia.loans.models.Item
import ehb.multimedia.loans.repositories.copyRepository
import ehb.multimedia.loans.repositories.itemRepository
import org.springframework.stereotype.Service

@Service
class CopyService(val copyRepository: copyRepository, val itemRepository: itemRepository) {

    fun getCopies(): List<Copy> {
        return copyRepository.findAll()
    }

    fun saveCopy(createCopy: CreateCopy): Copy {

        val Item = itemRepository.findById(createCopy.Item)/*.orElseThrow {
            throw IllegalArgumentException("User with id ${createCopy.Item} not found")
        }*/

        val copy = Copy(
            name = createCopy.name,
            remarks = createCopy.remarks,
            serial = createCopy.serial,
            status = createCopy.status,
            Item = Item
        )

        return copyRepository.save(copy)
    }
}