package ru.iteterin.pet.adtcrawler.dispatcher.handler

import org.springframework.stereotype.Service
import ru.iteterin.pet.adtcrawler.dispatcher.handler.EventHandler
import ru.iteterin.pet.adtcrawler.services.TaskService

@Service
class NewTaskEventHandler (
    private val taskService: TaskService
        ) : EventHandler<String> {
    override fun process(event: String) {
        taskService.readTask()
    }

}