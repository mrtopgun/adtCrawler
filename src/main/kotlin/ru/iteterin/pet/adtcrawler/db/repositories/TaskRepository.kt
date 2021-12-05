package ru.iteterin.pet.adtcrawler.db.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.iteterin.pet.adtcrawler.db.entities.EventStatus
import ru.iteterin.pet.adtcrawler.db.entities.Task

interface TaskRepository : JpaRepository<Task, Long> {
    fun findByState(state: EventStatus): List<Task>
}
