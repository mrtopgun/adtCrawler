package ru.iteterin.pet.adtcrawler.dispatcher.handler

interface EventHandler<T> {
    fun process(event: T)
}