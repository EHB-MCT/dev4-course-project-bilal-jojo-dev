package ehb.multimedia.loans.services

import ehb.multimedia.loans.dto.CreateCopy
import ehb.multimedia.loans.models.Copy
import ehb.multimedia.loans.models.Item
import ehb.multimedia.loans.repositories.copyRepository
import ehb.multimedia.loans.repositories.itemRepository
import ehb.multimedia.loans.services.ItemService
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
            item = Item
        )

        return copyRepository.save(copy)
    }

    fun getCopyById(id: Int): Copy {
        val copyEnt = copyRepository.findById(id)

        return copyEnt
    }

    fun deleteCopy(id: Long) {
        return copyRepository.deleteById(id)
    }

    fun updateCopy(copy: Copy, createCopy: CreateCopy): Copy {

        val copyEntity = copyRepository.findById(copy.id)
        val itemEntity = itemRepository.findById(createCopy.Item)


        val copyData = Copy(
                id = copyEntity.id,
                name = copyEntity.name,
                serial = copyEntity.serial,
                status = copyEntity.status,
                remarks = copyEntity.remarks,
                item = itemEntity.copy(id = itemEntity.id)
        )

        return copyRepository.save(copyData)

    }
}