package com.check.elastic.search;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticSearchApp {

	public static void main(String[] args) {
		TransportClient client = null;
		
		 Settings settings = Settings.builder()
				 .put("cluster.name", "elasticsearch").put("transport.type","netty4")
				 .put("http.type", "netty4").build();


		
		try {
			client = new PreBuiltTransportClient(settings)
					.addTransportAddress(new TransportAddress(
							Inet4Address.getByName("localhost"), 9315));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// TransportClient client = new PreBuiltTransportClient(settings);

		SearchResponse response = client.prepareSearch("bookstore")
				.setTypes("book").setSearchType(SearchType.DEFAULT)
				.setQuery(QueryBuilders.matchQuery("title", "sharad")).get();

		SearchHits hits = response.getHits();

		for (SearchHit hit : hits.getHits()) {

			System.out.println("Got " + hit.getSourceAsString());
		}

		// on shutdown

		client.close();

	}

}
