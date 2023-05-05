package ehb.multimedia.loans.controllers

import ehb.multimedia.loans.dto.CreateCopy
import ehb.multimedia.loans.models.Copy
import ehb.multimedia.loans.services.CopyService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("copy")
class CopyController(val copyService: CopyService) {

    @GetMapping("")
    fun getAllCopies(): List<Copy> {
        return copyService.getCopies()
    }

    @GetMapping("/{id}")
    fun getCopyById(@PathVariable id: Int): Copy {
        return copyService.getCopyById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteCopu(@PathVariable id: Long) {
        return copyService.deleteCopy(id)
    }

    @PutMapping("/{id}")
    fun updateCopy(@PathVariable id: Int, @RequestBody copy: Copy, @RequestParam createCopy: CreateCopy): Copy {
        return copyService.updateCopy(copy, createCopy)
    }

    @PostMapping("")
    fun saveCopy(@RequestBody copy: CreateCopy): Copy {
        return copyService.saveCopy(copy)
    }

}