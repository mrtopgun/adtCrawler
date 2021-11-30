package ru.iteterin.pet.adtcrawler.adtcrawler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdtCrawlerApplication

fun main(args: Array<String>) {
    runApplication<AdtCrawlerApplication>(*args)
}
