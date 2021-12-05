package ru.iteterin.pet.adtcrawler.db.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.iteterin.pet.adtcrawler.db.entities.Link

interface LinkRepository: JpaRepository<Link, Long> {
}