package gmail_service.exception

import gmail_service.dto.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.mail.MailSendException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(MailSendException::class)
    fun handle(e: MailSendException): ErrorResponse {
        logger.error("Error occurred: ${e.stackTrace}")

        return ErrorResponse(
            errorCode = 400,
            errorMessage = e.message!!
        )
    }
}