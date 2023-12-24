package gmail_service.messaging

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import gmail_service.dto.EmailMessageDto
import gmail_service.service.EmailService
import org.slf4j.LoggerFactory

@Component
class EmailMessageListener(
    private val objectMapper: ObjectMapper,
    private val emailService: EmailService
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = ["\${topic.email}"], groupId = "immediate")
    fun listen(payload: ByteArray) {
        val messageDto = objectMapper.readValue(payload, EmailMessageDto::class.java)

        logger.info("email message received: {}", messageDto)

        emailService.send(messageDto)
    }
}