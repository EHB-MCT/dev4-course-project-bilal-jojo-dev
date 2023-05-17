package ehb.multimedia.loans.dto

import ehb.multimedia.loans.models.Copy

data class CreateItem(val id: Int, val name: String, val brand: String, val copies: List<Copy>);
