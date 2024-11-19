package org.fintech.rabbit.benchmarks;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.fintech.BaseTest;
import org.fintech.rabbit.RabbitMqConsumer;
import org.fintech.rabbit.RabbitMqProducer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;

public abstract class RabbitMQBenchmarkBase extends BaseTest {

    private List<RabbitMqProducer> producers;
    private List<RabbitMqConsumer> consumers;

    protected final int numberOfProducers;
    protected final int numberOfConsumers;



    public RabbitMQBenchmarkBase(int numberOfProducers, int numberOfConsumers) {
        this.numberOfProducers = numberOfProducers;
        this.numberOfConsumers = numberOfConsumers;
    }

    @Setup(Level.Trial)
    public void setup() throws IOException, TimeoutException {
        producers = new ArrayList<>();
        consumers = new ArrayList<>();

        for (int i = 0; i < numberOfProducers; i++) {
            producers.add(new RabbitMqProducer(i));
        }

        for (int i = 0; i < numberOfConsumers; i++) {
            consumers.add(new RabbitMqConsumer());
        }
    }

    @TearDown(Level.Trial)
    public void tearDown() {
        consumers.forEach(RabbitMqConsumer::close);
        producers.forEach(RabbitMqProducer::close);
    }

    @Benchmark
    public void rabbitProducerConsumer(Blackhole blackhole) {
        producers.forEach(producer -> {
            try {
                var message = "Тестовое сообщение " + producer.getIndex();
                producer.sendMessage(message);
                blackhole.consume(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            blackhole.consume(producer);
        });
        consumers.forEach(consumer -> {
            try {
                var message = consumer.consumeMessage();
                blackhole.consume(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            blackhole.consume(consumer);
        });
        blackhole.consume(producers);
        blackhole.consume(consumers);
    }
}
