package com.jcdecaux.kata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jcdecaux.kata.web.SpringBootRestTestClient;

@SpringBootApplication
@EnableJpaRepositories
public class SampleApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(SampleApplication.class, args);
 
  
    SpringBootRestTestClient.createDeveloppeur();
    SpringBootRestTestClient.createLangage();
    SpringBootRestTestClient.updateDeveloppeur();
    SpringBootRestTestClient.associerLanguage();
  SpringBootRestTestClient.recupereListDeveloppeur();
   SpringBootRestTestClient.recupereAllDeveloppeur();
   
  }

}
 