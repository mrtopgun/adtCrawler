package ru.iteterin.pet.adtcrawler

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class AdtCrawlerApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(AdtCrawlerApplication::class.java)
        .bannerMode(Banner.Mode.OFF)
        .run(*args)
}
