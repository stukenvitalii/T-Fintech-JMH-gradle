package org.fintech.kafka.benchmarks;

public class StressBenchmark extends KafkaProducerConsumerBenchmarkBase {

    public StressBenchmark() {
        super(10, 10);
    }
}