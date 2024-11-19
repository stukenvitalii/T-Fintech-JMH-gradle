package org.fintech.rabbit.benchmarks;

import org.fintech.kafka.benchmarks.KafkaProducerConsumerBenchmarkBase;

public class LoadBalancingMultipleConsumersBenchmark extends RabbitMQBenchmarkBase {

    public LoadBalancingMultipleConsumersBenchmark() {
        super(3, 3);
    }
}