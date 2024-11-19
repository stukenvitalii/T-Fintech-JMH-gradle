package org.fintech.kafka.benchmarks;

public class LoadBalancingBenchmark extends KafkaProducerConsumerBenchmarkBase {

    public LoadBalancingBenchmark() {
        super(3, 1);
    }
}