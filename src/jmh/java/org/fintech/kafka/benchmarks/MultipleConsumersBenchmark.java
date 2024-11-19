package org.fintech.kafka.benchmarks;

public class MultipleConsumersBenchmark extends KafkaProducerConsumerBenchmarkBase {

    public MultipleConsumersBenchmark() {
        super(1, 3);
    }
}