package ru.iteterin.pet.adtcrawler.adtcrawler.services

import org.springframework.stereotype.Service
import ru.iteterin.pet.adtcrawler.adtcrawler.db.entities.Task
import ru.iteterin.pet.adtcrawler.adtcrawler.db.repositories.TaskRepository

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {
    fun createTask(task: Task){
        taskRepository.save(task)
    }
}