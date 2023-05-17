package ehb.multimedia.loans.services

//import ehb.multimedia.loans.dto.Email
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

/*@Service
class EmailService(private val emailSender: JavaMailSender) {

    fun sendEmail(to: String, subject: String, text: String) {
        val message = SimpleMailMessage()
        message.setTo(to)
        message.setSubject(subject)
        message.setText(text)

        emailSender.send(message)
    }
}*/