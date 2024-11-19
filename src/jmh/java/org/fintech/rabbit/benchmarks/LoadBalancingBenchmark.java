package org.fintech.rabbit.benchmarks;

import org.fintech.kafka.benchmarks.KafkaProducerConsumerBenchmarkBase;

public class LoadBalancingBenchmark extends RabbitMQBenchmarkBase {

    public LoadBalancingBenchmark() {
        super(3, 1);
    }
}