package ru.iteterin.pet.adtcrawler.controller.impl

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import ru.iteterin.pet.adtcrawler.controller.Api
import ru.iteterin.pet.adtcrawler.db.entities.Task
import ru.iteterin.pet.adtcrawler.services.TaskService

@RestController
class TaskController(
    private val taskService: TaskService
) : Api {
    override fun createTask(
        task: Task
    ): ResponseEntity<Any> =
        ResponseEntity
            .status(HttpStatus.OK)
            .body(taskService.createTask(task))
}