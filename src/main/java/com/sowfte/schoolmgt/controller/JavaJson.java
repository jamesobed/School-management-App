package com.sowfte.schoolmgt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/test")
public class JavaJson {
    private static final Logger logger = LoggerFactory.getLogger(JavaJson.class);
    private String URL = "https://jsonplaceholder.typicode.com/posts/";
    private List<Person> people = new  PersonDb().getAllPersons();

    @GetMapping
    public String sendOut() throws JsonProcessingException {
        String resp = "{\n" +
                "  \"amount\": \"222555555\",\n" +
                "  \"billsname\": \"AIRTEL\",\n" +
                "  \"channel\": \"11\",\n" +
                "  \"phone\": \"222222\",\n" +
                "  \"serialnumber\": \"98220415908303\",\n" +
                "  \"telco\": \"airtel\",\n" +
                "  \"tid\": \"21035514\",\n" +
                "  \"userReference\": \"231020122240\",\n" +
                "  \"transferpin\": \"1234\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        PaymentData payment1 = new PaymentData(1L,"230.40","Obed","mobile","2341234567890","878695868575868786","mtn","2312345","2123345432","1234");
        PaymentData payment2 = new PaymentData(1L,"230.40","Obed","mobile","2341234567890","878695868575868786","mtn","2312345","2123345432","1234");
        PaymentData payment3 = new PaymentData(1L,"230.40","Obed","mobile","2341234567890","878695868575868786","mtn","2312345","2123345432","1234");

        List<PaymentData> payment = new ArrayList<>();
        payment.add(payment1);
        payment.add(payment2);
        payment.add(payment3);
        return mapper.writeValueAsString(payment);
    }

@PostMapping
    public List<PaymentData> sendOut1() throws JsonProcessingException {
        String resp = "{\n" +
                "  \"amount\": \"222555555\",\n" +
                "  \"billsname\": \"AIRTEL\",\n" +
                "  \"channel\": \"11\",\n" +
                "  \"phone\": \"222222\",\n" +
                "  \"serialnumber\": \"98220415908303\",\n" +
                "  \"telco\": \"airtel\",\n" +
                "  \"tid\": \"21035514\",\n" +
                "  \"userReference\": \"231020122240\",\n" +
                "  \"transferpin\": \"1234\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        PaymentData payment1 = new PaymentData(1L,"230.40","Obed","mobile","2341234567890","878695868575868786","mtn","2312345","2123345432","1234");
        PaymentData payment2 = new PaymentData(1L,"230.40","Obed","mobile","2341234567890","878695868575868786","mtn","2312345","2123345432","1234");
        PaymentData payment3 = new PaymentData(1L,"230.40","Obed","mobile","2341234567890","878695868575868786","mtn","2312345","2123345432","1234");

        List<PaymentData> payment = new ArrayList<>();
        payment.add(payment1);
        payment.add(payment2);
        payment.add(payment3);
        return  payment;
    }

@GetMapping("/person/{id}")
public  Person seePerson(@PathVariable String id){
        Person res = null;
        for(Person x : people){
            if(Objects.equals(x.id(), id)) res = x;
        }
        return res;
}

@GetMapping("/people")
public  List<Person> people(){
        logger.info("-->{}",people);
    return people;
}

@GetMapping("see-payment")
public  PaymentData resPay() throws JsonProcessingException {
        String Body = "{\n" +
                "  \"id\": \"12\",\n" +
                "  \"amount\": \"222555555\",\n" +
                "  \"billsname\": \"AIRTEL\",\n" +
                "  \"channel\": \"11\",\n" +
                "  \"phone\": \"222222\",\n" +
                "  \"serialnumber\": \"98220415908303\",\n" +
                "  \"telco\": \"airtel\",\n" +
                "  \"tid\": \"21035514\",\n" +
                "  \"userReference\": \"231020122240\",\n" +
                "  \"transferpin\": \"1234\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(Body, new TypeReference<PaymentData>() {})
;
}

@GetMapping("/post/{id}")
    public Post getPost (@PathVariable String id){
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> requestEntity = new HttpEntity<>(headers);
    ResponseEntity<String> responseEntity = restTemplate.exchange(
            URL+id,
            HttpMethod.GET,
            requestEntity,
            String.class
    );
logger.info("-->{}",responseEntity.getBody());

    return null;
//    return responseEntity.getBody();
}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class PaymentData{
    private Long id;
    private String amount;
    private String billsname;
    private String channel;
    private String phone;
    private String serialnumber;
    private String telco;
    private String tid;
    private String userReference;
    private String transferpin;
}

record Person(String id, String name, String location, String sex){}
record Post(String id, String userId, String title, String body){}
class PersonDb {
  private  ArrayList<Person> allPersons = new ArrayList<>(
            Arrays.asList(
                    new Person("1", "Bimpe Mayowa", "Ibadan", "Female"),
                    new Person("2", "Nuhu Yohana", "Adamawa", "Male"),
                    new Person("3", "Chibuzo Wasiu", "Lagos", "Male"),
                    new Person("4", "Kosoko Wasiu", "Abuja", "Male")
            )
    );

    public ArrayList<Person> getAllPersons() {
        return allPersons;
    }
}
