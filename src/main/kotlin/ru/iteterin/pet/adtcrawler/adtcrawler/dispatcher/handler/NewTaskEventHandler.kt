package ru.iteterin.pet.adtcrawler.adtcrawler.dispatcher.handler

import org.springframework.stereotype.Service
import ru.iteterin.pet.adtcrawler.adtcrawler.services.TaskService
import ru.iteterin.pet.adtcrawler.adtcrawler.dispatcher.handler.EventHandler as EventHandler

@Service
class NewTaskEventHandler (
    private val taskService: TaskService
        ) : EventHandler<String> {
    override fun process(event: String) {
        taskService.readTask()
    }

}