package ehb.multimedia.loans.dto

import ehb.multimedia.loans.models.Item

data class CreateCopy(val name: String, val remarks: String, val status: Boolean ,val serial: Int, val Item: Int)
