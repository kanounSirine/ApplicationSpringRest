package com.jcdecaux.kata.web;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.jcdecaux.kata.domain.DeveloppeurEntity;
import com.jcdecaux.kata.domain.LangageEntity;

public class SpringBootRestTestClient {
	public static final String REST_SERVICE_URI = "http://localhost:8080/";

	/* POST */
	public static void createDeveloppeur() {
		System.out.println("Testing create Developpeur API----------");
		RestTemplate restTemplate = new RestTemplate();
		DeveloppeurEntity developpeur = new DeveloppeurEntity("Sarah", "kk");
		DeveloppeurEntity developpeur1 = new DeveloppeurEntity("sirine", "kanoun");
		DeveloppeurEntity developpeur2 = new DeveloppeurEntity("Sara", "kk");
		List<DeveloppeurEntity> listDev = new ArrayList<DeveloppeurEntity>();
		listDev.add(developpeur);
		listDev.add(developpeur1);
		listDev.add(developpeur2);
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/developpeur/", listDev);

	}

	/* PUT */
	public static void updateDeveloppeur() {
		System.out.println("Testing update Developpeur API----------");
		RestTemplate restTemplate = new RestTemplate();
		DeveloppeurEntity developpeur = new DeveloppeurEntity("Tomy", "kk");

		restTemplate.put(REST_SERVICE_URI + "/developpeur/1", developpeur);
		System.out.println("update developpeur");

	}

	/* PUT */
	public static void associerLanguage() {
		System.out.println("Testing associer langage API----------");
		RestTemplate restTemplate = new RestTemplate();
		LangageEntity langage = new LangageEntity("");

		restTemplate.put(REST_SERVICE_URI + "/developpeur/1/langage/2", langage);
		System.out.println("associer un langage a un developpeur 1 ");
		restTemplate.put(REST_SERVICE_URI + "/developpeur/2/langage/2", langage);
		System.out.println("associer un langage a un developpeur 2 ");
		restTemplate.put(REST_SERVICE_URI + "/developpeur/2/langage/1", langage);
		System.out.println("associer un langage a un developpeur 2 ");
		restTemplate.put(REST_SERVICE_URI + "/developpeur/1/langage/1", langage);
		System.out.println("associer un langage a un developpeur 1 ");
		restTemplate.put(REST_SERVICE_URI + "/developpeur/3/langage/1", langage);
		System.out.println("associer un langage a un developpeur 3 ");
		restTemplate.put(REST_SERVICE_URI + "/developpeur/3/langage/2", langage);
		System.out.println("associer un langage a un developpeur 3 ");
	}

	/* POST */
	public static void createLangage() {
		System.out.println("Testing create Langage API----------");
		RestTemplate restTemplate = new RestTemplate();
		LangageEntity langage = new LangageEntity("java");
		LangageEntity langage1 = new LangageEntity("c++");
		LangageEntity langage2 = new LangageEntity("c");
		List<LangageEntity> listlang = new ArrayList<LangageEntity>();
		listlang.add(langage);
		listlang.add(langage1);
		listlang.add(langage2);
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/langage/", listlang);

	}

	@SuppressWarnings("unchecked")
	public static void recupereListDeveloppeur() {
		System.out.println("recuperer liste des developpeur qui ont un langage particulier API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> Developeurs = restTemplate.getForObject(REST_SERVICE_URI + "/Language/specif/1", List.class);

		if (Developeurs != null) {
			for (LinkedHashMap<String, Object> map : Developeurs) {
				System.out.println("Developeur : id="+ map.get("id")+", Name="+map.get("firstname")
						);
			}
		} else {
			System.out.println("No Developeur exist----------");
		}
	}
	@SuppressWarnings("unchecked")
	public static void recupereAllDeveloppeur() {
		System.out.println("Test la liste des Developpeurs API-----------");

		RestTemplate restTemplate = new RestTemplate();
		 List<LinkedHashMap<String, Object>> Developeurs = restTemplate.getForObject(REST_SERVICE_URI + "/AllDeveloppeur", List.class);

		if (Developeurs != null) {
			for (LinkedHashMap<String, Object> map : Developeurs) {
				System.out.println("Developeur : id="+ map.get("id")+", Name="+map.get("firstname")
						);
			}
		} else {
			System.out.println("No Developeur exist----------");
		}
	}
}
