package gmail_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GmailServiceApplication

fun main(args: Array<String>) {
	runApplication<GmailServiceApplication>(*args)
}
