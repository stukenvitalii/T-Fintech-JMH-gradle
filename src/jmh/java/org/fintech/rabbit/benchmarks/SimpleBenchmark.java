package org.fintech.rabbit.benchmarks;

import org.fintech.kafka.benchmarks.KafkaProducerConsumerBenchmarkBase;

public class SimpleBenchmark extends RabbitMQBenchmarkBase {

    public SimpleBenchmark() {
        super(1, 1);
    }
}