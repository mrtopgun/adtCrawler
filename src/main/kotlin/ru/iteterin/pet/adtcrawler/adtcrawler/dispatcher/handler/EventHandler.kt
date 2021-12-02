package ru.iteterin.pet.adtcrawler.adtcrawler.dispatcher.handler

interface EventHandler<T> {
    fun process(event: T)
}