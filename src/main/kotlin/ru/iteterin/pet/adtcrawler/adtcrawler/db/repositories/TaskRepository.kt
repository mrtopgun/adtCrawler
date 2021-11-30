package ru.iteterin.pet.adtcrawler.adtcrawler.db.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.iteterin.pet.adtcrawler.adtcrawler.db.entities.EventStatus
import ru.iteterin.pet.adtcrawler.adtcrawler.db.entities.Task

interface TaskRepository : JpaRepository<Task, Long> {
    fun findByState(state: EventStatus): Task?
}
