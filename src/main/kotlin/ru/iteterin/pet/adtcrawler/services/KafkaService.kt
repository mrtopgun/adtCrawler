package ru.iteterin.pet.adtcrawler.services

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    fun createTaskEvent(message: String){
        kafkaTemplate.send("adt-crawler-create-task-event", message)
    }
}