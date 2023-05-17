package ehb.multimedia.loans.strategy

class ConfirmationUser() : EmailStrat {

    override fun sendEmail(emailTo: String, subject: String, message: String) {
        // Customize the message for reservation confirmation
        val confirmationMessage = "Reservation confirmation: $message"
        super.sendEmail(emailTo, subject, confirmationMessage)
    }

}
