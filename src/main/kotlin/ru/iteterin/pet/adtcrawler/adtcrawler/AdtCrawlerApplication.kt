package ru.iteterin.pet.adtcrawler.adtcrawler

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication

@SpringBootApplication
class AdtCrawlerApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(AdtCrawlerApplication::class.java)
        .bannerMode(Banner.Mode.OFF)
        .run(*args)
}
