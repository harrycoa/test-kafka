import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;


public class Producer {
    public static void main(String[] args) {

        Properties props = new Properties();

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("buffer.memory", 33554432);

        KafkaProducer<String, String> prod = new KafkaProducer<>(props);
        String topic = "testtopic0511";
        int partition = 0;
        String key = "testKey";
        String value = "testValueharry";
        prod.send(new ProducerRecord<>(topic,partition,key, value));
        prod.close();
    }
}
