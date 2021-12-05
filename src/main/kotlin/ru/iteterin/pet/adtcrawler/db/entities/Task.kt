package ru.iteterin.pet.adtcrawler.db.entities

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
    var taskId: Long = 0,

    /**
     * URL ссылки
     */
    var url: String,

    /**
     * Время создания задачи
     */
    @CreatedDate
    var createAt: LocalDateTime = LocalDateTime.now(),

    /**
     * Время изменения задачи
     */
    var modifiedAt: LocalDateTime? = null,

    /**
     * Статус обработки задачи
     */
    @Enumerated(EnumType.STRING)
    var state: EventStatus = EventStatus.NEW
)
