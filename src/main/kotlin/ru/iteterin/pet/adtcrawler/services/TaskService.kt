package ru.iteterin.pet.adtcrawler.services

import it.skrape.core.htmlDocument
import it.skrape.fetcher.BrowserFetcher
import it.skrape.fetcher.response
import it.skrape.fetcher.skrape
import org.springframework.stereotype.Service
import ru.iteterin.pet.adtcrawler.db.entities.EventStatus
import ru.iteterin.pet.adtcrawler.db.entities.Link
import ru.iteterin.pet.adtcrawler.db.entities.Task
import ru.iteterin.pet.adtcrawler.db.repositories.LinkRepository
import ru.iteterin.pet.adtcrawler.db.repositories.TaskRepository
import java.time.LocalDateTime

@Service
class TaskService(
    private val taskRepository: TaskRepository,
    private val linkRepository: LinkRepository,
    private val kafkaService: KafkaService
) {
    fun createTask(task: Task) {
        try {
            taskRepository.save(task)
            kafkaService.createTaskEvent("task created")
        } catch (_: Exception) {

        }
    }

    fun readTask() {
        val newTasks = taskRepository.findByState(EventStatus.NEW)
        newTasks.onEach {
            it.state = EventStatus.HANDLING
            it.modifiedAt = LocalDateTime.now()
        }
        taskRepository.saveAll(newTasks)

        newTasks.forEach {
            val links: Map<String, String> = getAllLinks(it.url)
            links.forEach { (text, href) ->
                val link = Link(link = href, text = text, task = it)
                linkRepository.save(link)
            }
            it.state = EventStatus.COMPLETED
            it.modifiedAt = LocalDateTime.now()
            taskRepository.save(it)
        }

    }

    fun getAllLinks(taskUrl: String): Map<String, String> = skrape(BrowserFetcher) {
        request {
            url = taskUrl
            userAgent =
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36"
            cookies = mapOf(
                "u" to "2p0wcdb0.uim6h5.oq9ug3ppm100",
                "v" to "1638479660"
            )
            headers = mapOf(
                "Accept" to "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
                "Accept-Encoding" to "gzip, deflate, br",
                "Cache-Control" to "no-cache",
                "Connection" to "keep-alive",
                "Accept-Language" to "ru-RU,ru;q=0.9"
            )
        }
        response {
            htmlDocument { eachLink }
        }
    }
}