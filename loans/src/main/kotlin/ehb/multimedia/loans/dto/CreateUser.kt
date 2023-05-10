package ehb.multimedia.loans.dto

data class CreateUser(val firstName: String, val lastName: String, val email: String, val password: String, val role: String, val phoneNr: Int, var accessToken: String = "",
                      var expirationDate: Long = System.currentTimeMillis());
