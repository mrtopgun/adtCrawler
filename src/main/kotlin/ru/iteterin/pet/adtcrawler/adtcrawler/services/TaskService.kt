package ru.iteterin.pet.adtcrawler.adtcrawler.services

import org.springframework.stereotype.Service
import ru.iteterin.pet.adtcrawler.adtcrawler.db.entities.EventStatus
import ru.iteterin.pet.adtcrawler.adtcrawler.db.entities.Task
import ru.iteterin.pet.adtcrawler.adtcrawler.db.repositories.TaskRepository

@Service
class TaskService(
    private val taskRepository: TaskRepository,
    private val kafkaService: KafkaService
) {
    fun createTask(task: Task) {
        try {
            taskRepository.save(task)
            kafkaService.createTaskEvent("task created")
        } catch (e: Exception) {

        }
    }

    fun onNewTask() {
        val newTask = taskRepository.findByState(EventStatus.NEW)
        println(newTask)
    }
}