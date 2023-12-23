package gmail_service.service

import gmail_service.dto.EmailMessageDto
import org.slf4j.LoggerFactory
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service


@Service
class EmailService(
    private val mailSender: JavaMailSender
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun send(emailMessageDto: EmailMessageDto) {
        val simpleMailMessage = SimpleMailMessage()
        simpleMailMessage.setTo(emailMessageDto.email)
        simpleMailMessage.text = emailMessageDto.message
        simpleMailMessage.subject = "Notificator"
        mailSender.send(simpleMailMessage)
        logger.info("Email message sent successfully to " + emailMessageDto.email)
    }
}