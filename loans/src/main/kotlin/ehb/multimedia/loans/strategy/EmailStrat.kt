package ehb.multimedia.loans.strategy
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

interface EmailStrat {

    fun sendEmail(emailTo: String, subject: String, message: String) {
        val emailFrom = "ehb.medialab@gmail.com"
        val username = "ehb.medialab@gmail.com"
        val password = "Z4Dhm2wUt3gYGWNc"

        val props = Properties().apply {
            put("mail.smtp.host", "smtp-relay.sendinblue.com")
            put("mail.smtp.port", "587")
            put("mail.smtp.auth", "true")
            put("mail.smtp.starttls.enable", "true")
        }

        val session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(username, password)
            }
        })

        session.debug = true

        try {
            val mimeMessage = MimeMessage(session)
            mimeMessage.setFrom(InternetAddress(emailFrom))
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo, false))
            mimeMessage.setText(message)
            mimeMessage.subject = subject
            mimeMessage.sentDate = Date()

            Transport.send(mimeMessage)
        } catch (messagingException: MessagingException) {
            messagingException.printStackTrace()
        }
    }

}