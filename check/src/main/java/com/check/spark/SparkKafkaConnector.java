package com.check.spark;



public class SparkKafkaConnector {

//	private static void runSparkStream() throws InterruptedException {
//
//		SparkConf conf = new SparkConf().setAppName("kafka-sandbox").setMaster(
//				"local[*]");
//		JavaSparkContext sc = new JavaSparkContext(conf);
//		JavaStreamingContext ssc = new JavaStreamingContext(sc, new Duration(
//				2000));
//
//		// TODO: processing pipeline
//
//		ssc.start();
//		ssc.awaitTermination();
//
//		Map<String, String> kafkaParams = new HashMap<>();
//		kafkaParams.put("metadata.broker.list", "localhost:9092");
//		Set<String> topics = Collections.singleton("mytopic");
////
////		JavaPairInputDStream<String, String> directKafkaStream = Kafka.createDirectStream(ssc, String.class, String.class,
////						StringDecoder.class, StringDecoder.class, kafkaParams,
////						topics);
//
//	}

	public static void main(String args[]) {

	}

}
