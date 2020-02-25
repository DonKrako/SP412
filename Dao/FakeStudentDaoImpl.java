package com.henningSB412.Dao;


import com.henningSB412.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students;

    static {
        students =new HashMap<Integer, Student>(){
            {
                put( 1, new Student(1, "Henning", "Mecanics"));
                put( 2, new Student(2, "Lokas", "Mecanics2"));
                put( 3, new Student(3, "Flo", "Mecanics3"));
                put( 4, new Student(4, "Paul", "Electrical"));
                put( 7, new Student(7, "Eva", "Medicine"));
            }
        };
    }
    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }
    @Override

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(),student);
    }

    @Override
    public void insertStudentToDb(Student student) {
        this.students.put(student.getId(),student);
    }



    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/Tags")
    public List<Student> getStudent(){

        String url ="http://localhost:8080/Tags";
        ResponseEntity<Student[]> response = restTemplate.getForEntity(url, Student[].class);
        Student[] students = response.getBody();
        return Arrays.asList(students);
    }
    public void turnLightOn() {

        String ip = "129.13.247.19";
        String token = getToken(ip,"Admin", "Balluff#1");


        int[] values = {1};
        Processdata befehl = new Processdata(new iolink( true, values));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        String postURL = "http://"+ ip + "/iolink/v1/devices/master1ports4/processdata/value";
        HttpEntity<Processdata> request = new HttpEntity<>(befehl, headers);

        ResponseEntity<Processdata> response = restTemplate
                .exchange(postURL, HttpMethod.POST, request, Processdata.class);
        System.out.println(response.getStatusCode());
    }

    public String getToken(String ip, String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://" + ip +"/api/balluff/v1/users/login";
        Authentication authentication = new Authentication(username, password);

        HttpEntity<Authentication> request = new HttpEntity<>(authentication, headers);

        String response = restTemplate
                .postForObject(url, request, String.class);

        System.out.println(response);
        response = response.replace("{", "");
        response = response.replace("}", "");
        response = response.replace("\"", "");
        return response.split(":")[1];
    }
}
