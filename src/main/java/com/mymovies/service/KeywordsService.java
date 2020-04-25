package com.mymovies.service;

import com.mymovies.dto.KeywordsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KeywordsService implements IKeywordsService {

	@Value("${resource.api.url}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	private static final Logger LOGGER = LoggerFactory.getLogger(KeywordsService.class);
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public KeywordsDTO getAPI_Keywords(String movie_id) {

		KeywordsDTO listOfKeywords = null;

		try {
			listOfKeywords = restTemplate.getForObject(BASE_URL+movie_id+"/keywords"+API_KEY+Language, KeywordsDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error: getAPI_Keywords: " + e);
		}

		return listOfKeywords;

	}

}