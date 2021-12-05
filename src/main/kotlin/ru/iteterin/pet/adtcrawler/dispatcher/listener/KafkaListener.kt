package ru.iteterin.pet.adtcrawler.dispatcher.listener

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service
import ru.iteterin.pet.adtcrawler.dispatcher.handler.NewTaskEventHandler

@Service
class KafkaListener(
    private val newTaskEventHandler: NewTaskEventHandler
) {

    @KafkaListener(topics = ["adt-crawler-create-task-event"], groupId = "adt-crawler")
    fun onNewTask(@Payload massage: String) {
        newTaskEventHandler.process(massage)
    }

}