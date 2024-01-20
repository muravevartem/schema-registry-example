package ru.semura.notifier.rest.controller

import io.confluent.kafka.serializers.subject.RecordNameStrategy
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.semura.notifier.broker.producer.HelloProducer

@RestController
@RequestMapping("/hello")
class HelloController(
    private val producer: HelloProducer
) {

    @GetMapping
    fun sayHello() {
        producer.sayHello()
    }
}