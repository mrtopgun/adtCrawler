package ru.iteterin.pet.adtcrawler.adtcrawler.db.entities

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tasks")
data class Task(
    /**
     * Идентификатор задачи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val taskId: Long = 0,

    /**
     * URL ссылки
     */
    val url: String,

    /**
     * Время создания задачи
     */
    @CreatedDate
    val createAt: LocalDateTime = LocalDateTime.now(),

    /**
     * Время изменения задачи
     */
    val modifiedAt: LocalDateTime? = null,

    /**
     * Статус обработки задачи
     */
    @Enumerated(EnumType.STRING)
    val state: EventStatus = EventStatus.NEW
)
