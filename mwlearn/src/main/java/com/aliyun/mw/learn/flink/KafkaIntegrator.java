package com.aliyun.mw.learn.flink;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer082;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;

public class KafkaIntegrator {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        DataStream<String> messageStream = env.addSource(
            new FlinkKafkaConsumer082(parameterTool.getRequired("topic"), new SimpleStringSchema(),
                parameterTool.getProperties()));

        messageStream.rebalance().map(s -> "kafka and flink said: " + s).print();
        env.execute("KafkaIntegrator");
    }
}
