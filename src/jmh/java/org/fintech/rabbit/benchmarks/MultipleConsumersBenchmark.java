package org.fintech.rabbit.benchmarks;

import org.fintech.kafka.benchmarks.KafkaProducerConsumerBenchmarkBase;

public class MultipleConsumersBenchmark extends RabbitMQBenchmarkBase {

    public MultipleConsumersBenchmark() {
        super(1, 3);
    }
}