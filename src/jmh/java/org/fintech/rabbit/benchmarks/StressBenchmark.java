package org.fintech.rabbit.benchmarks;

import org.fintech.kafka.benchmarks.KafkaProducerConsumerBenchmarkBase;

public class StressBenchmark extends RabbitMQBenchmarkBase {

    public StressBenchmark() {
        super(10, 10);
    }
}