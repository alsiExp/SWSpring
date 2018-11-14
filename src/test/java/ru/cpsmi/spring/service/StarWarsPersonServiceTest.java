package ru.cpsmi.spring.service;import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.test.context.junit4.SpringRunner;import org.springframework.util.Assert;import ru.cpsmi.spring.model.Person;import static org.springframework.util.StringUtils.isEmpty;@RunWith(SpringRunner.class)@SpringBootTestpublic class StarWarsPersonServiceTest {    @Autowired    private StarWarsPersonService starWarsPersonService;    @Test    public void testGetPerson() {        String id = "5";        Person person = starWarsPersonService.getPerson(id);        Assert.notNull(person, "");        Assert.isTrue(!isEmpty(person.getId()), "Id не должен быть пустым");        Assert.isTrue(!isEmpty(person.getName()), "Name не должен быть пустым");        Assert.isTrue(!isEmpty(person.getWeight()), "Weight не должен быть пустым");        Assert.isTrue(!isEmpty(person.getHeight()), "Height не должен быть пустым");        Assert.isTrue(!isEmpty(person.getGender()), "Gender не должен быть пустым");    }}