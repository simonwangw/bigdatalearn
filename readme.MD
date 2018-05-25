1. kafka and flink
install kafka and zookeeper and start both of them 


./bin/kafka-console-consumer.sh --topic test --zookeeper localhost:2181
./bin/kafka-console-producer.sh --topic test --broker-list localhost:9092
java -cp mw.learn-1.0-SNAPSHOT-jar-with-dependencies.jar com.aliyun.mw.learn.flink.KafkaIntegrator --topic test --bootstrap.servers localhost:9092 --zookeeper.connect localhost:2181 --group.id myGroup
