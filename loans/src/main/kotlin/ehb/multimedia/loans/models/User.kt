package ehb.multimedia.loans.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue
    var id: Int = 0
    var firstName: String = ""
    var lastName: String = ""
    var email: String = ""
    var role: String = ""
    var phoneNr: String = ""
}
