package ehb.multimedia.loans.controllers

import ehb.multimedia.loans.dto.CreateCopy
import ehb.multimedia.loans.models.Copy
import ehb.multimedia.loans.services.CopyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("copy")
class CopyController(val copyService: CopyService) {

    @GetMapping("")
    fun getAllCopies(): List<Copy> {
        return copyService.getCopies()
    }

    @PostMapping("")
    fun saveCopy(@RequestBody copy: CreateCopy): Copy {
        return copyService.saveCopy(copy)
    }

}