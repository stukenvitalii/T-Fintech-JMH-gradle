package org.fintech.kafka.benchmarks;

public class LoadBalancingMultipleConsumersBenchmark extends KafkaProducerConsumerBenchmarkBase {

    public LoadBalancingMultipleConsumersBenchmark() {
        super(3, 3);
    }
}