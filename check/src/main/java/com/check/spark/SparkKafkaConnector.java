package com.check.spark;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.StringDecoder;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaPairInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;


public class SparkKafkaConnector {

	private static void runSparkStream() {

		SparkConf conf = new SparkConf().setAppName("kafka-sandbox").setMaster(
				"local[*]");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaStreamingContext ssc = new JavaStreamingContext(sc, new Duration(
				2000));

		// TODO: processing pipeline

		ssc.start();
		ssc.awaitTermination();

		Map<String, String> kafkaParams = new HashMap<>();
		kafkaParams.put("metadata.broker.list", "localhost:9092");
		Set<String> topics = Collections.singleton("mytopic");

		JavaPairInputDStream<String, String> directKafkaStream = Kafka.createDirectStream(ssc, String.class, String.class,
						StringDecoder.class, StringDecoder.class, kafkaParams,
						topics);

	}

	public static void main(String args[]) {

	}

}
