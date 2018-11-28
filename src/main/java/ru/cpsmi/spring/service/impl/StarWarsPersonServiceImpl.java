package ru.cpsmi.spring.service.impl;import com.fasterxml.jackson.databind.JsonNode;import com.fasterxml.jackson.databind.ObjectMapper;import com.fasterxml.jackson.databind.ObjectReader;import org.springframework.beans.factory.annotation.Value;import org.springframework.http.*;import org.springframework.stereotype.Service;import org.springframework.web.client.RestTemplate;import ru.cpsmi.spring.model.Person;import ru.cpsmi.spring.service.StarWarsPersonService;import ru.cpsmi.spring.util.RestClient;import java.io.IOException;import java.util.Arrays;@Servicepublic class StarWarsPersonServiceImpl implements StarWarsPersonService {    @Value("${app.swapi.url}")    private String url;    @Override    public Person getPerson(String id) {        RestTemplate restTemplate = new RestTemplate();        HttpHeaders headers = new HttpHeaders();        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);        ResponseEntity<Person> personRE = restTemplate.exchange(url+ "people/" + id, HttpMethod.GET, entity ,Person.class);        Person person = personRE.getBody();        person.setId(id);        return person;    }    @Override    public Person getPersonWithRestClient(String id) {        RestClient client = new RestClient(url);        JsonNode node = client.get("people/" + id);        ObjectReader reader = new ObjectMapper().readerFor(Person.class);        try {            Person person = reader.readValue(node);            person.setId(id);            return person;        } catch (IOException e) {            e.printStackTrace();            return null;        }    }}