package ru.semura.client.broker

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service
import ru.semura.client.util.logger
import ru.semura.messages.HelloWorld

@Service
class HelloMessageListener {

    companion object {
        private val logger = logger<HelloMessageListener>()
    }

    @KafkaListener(topics = ["topic.hello"])
    fun listen(record: ConsumerRecord<String, HelloWorld>) {
        logger.info("Hello from kafka id={}", record.value()?.id)
    }
}