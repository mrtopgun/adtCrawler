package ru.iteterin.pet.adtcrawler.adtcrawler.controller

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import ru.iteterin.pet.adtcrawler.adtcrawler.db.entities.Task

@RequestMapping(
    path = ["/api"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
interface Api {

    @PostMapping(path = ["/tasks"])
    fun createTask(
        @RequestBody task: Task
    ): ResponseEntity<Any>

}