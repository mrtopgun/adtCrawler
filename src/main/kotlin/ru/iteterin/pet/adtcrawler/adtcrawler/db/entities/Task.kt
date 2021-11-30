package ru.iteterin.pet.adtcrawler.adtcrawler.db.entities

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tasks")
data class Task(
    /**
     * Идентификатор задачи
     */
    @Id
    val taskId: Long = 0,

    /**
     * URL ссылки
     */
    val url: String,

    /**
     * Время создания задачи
     */
    @CreatedDate
    val createAt: LocalDateTime = LocalDateTime.now()
)
