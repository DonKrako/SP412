package com.henningSB412.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    public String sayHello(){
        return "<hr> hello World <hr>";
    }

    /*RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl
            = "http://localhost:8080/Tags";
    ResponseEntity<String> response
            = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

     */
}
