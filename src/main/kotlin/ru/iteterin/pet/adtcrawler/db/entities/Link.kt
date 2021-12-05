package ru.iteterin.pet.adtcrawler.db.entities

import javax.persistence.*

@Entity
@Table(name = "links")
data class Link(
    /**
     * Идентификатор ссылки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var linkId: Long = 0,

    var link: String,

    var text: String,

    @ManyToOne
    var task: Task
)