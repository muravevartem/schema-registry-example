package ru.semura.notifier.broker.producer

import io.confluent.kafka.serializers.KafkaAvroSerializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.semura.messages.HelloWorld
import ru.semura.notifier.util.logger

@Service
class HelloProducer(
    private val kafkaTemplate: KafkaTemplate<String, HelloWorld>
) {

    companion object {
        private val logger = logger<HelloProducer>()
    }

    fun sayHello() {
        val message = HelloWorld.newBuilder()
            .setId(12)
            .setText("Text")
            .build()
        kafkaTemplate.send("topic.hello", message.id.toString(), message)
            .handleAsync { t, _ -> logger.info("Message sent: offset = {}", t.recordMetadata.offset()) }
    }
}