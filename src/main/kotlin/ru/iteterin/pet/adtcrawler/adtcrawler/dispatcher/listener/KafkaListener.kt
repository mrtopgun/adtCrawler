package ru.iteterin.pet.adtcrawler.adtcrawler.dispatcher.listener

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import ru.iteterin.pet.adtcrawler.adtcrawler.services.TaskService

@Service
class KafkaListener(
    private val taskService: TaskService
) {

    @KafkaListener(topics = ["adt-crawler-create-task-event"], groupId = "adt-crawler")
    fun listenNewTask(massage: String) {
        taskService.onNewTask()
    }

}