package com.mypack.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.mypack.domain.Person;
import com.mypack.repository.PersonRepository;
import com.mypack.service.PersonService;

public class Test1 {
	private ApplicationContext ctx = null;
	private PersonRepository personRepository = null;
	private PersonService personService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		personRepository = ctx.getBean(PersonRepository.class);
		personService = ctx.getBean(PersonService.class);
	}
	
	
	@Test
	public void testPagingAndSortingRespoingtory() throws Exception {
		int pageNo = 3-1;
		int pageSize = 5;
		//Order是具体针对于某一个属性进行升序还是降序，
		Order order1 = new Order(Direction.DESC,"id");
		Order order2 = new Order(Direction.ASC,"email");
		Sort sort = new Sort(order1,order2);
		//Pageable接口通常使用的是PageRequest实现类，其中封装了需要分页的信息
		PageRequest pageable = new PageRequest(pageNo, pageSize,sort);
		
		
		
		
		
		Page<Person> page = personRepository.findAll(pageable);
		System.out.println("总记录数"+page.getTotalElements());
		System.out.println("当前第几页"+(page.getNumber()+1));
		System.out.println("总页数"+page.getTotalPages());
		System.out.println("当前页面的List"+page.getContent());
		System.out.println("当前页面的记录数"+page.getNumberOfElements());
	}
	
	
	
	
	
	
	@Test
	public void testDataSource() throws Exception {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void testJpa() throws Exception {
		
	}
	@Test
	public void testHelloWorld() throws Exception {
		PersonRepository p = ctx.getBean(PersonRepository.class);
		System.out.println(p.getClass().getName());
		Person person = p.getByLastName("sss");
		System.out.println(person);
	}
	
	@Test
	public void testQuery() throws Exception {
		Person ps = personRepository.getMaxIdPerson();
		//System.out.println(p.getMaxIdPerson());
		System.out.println(ps);
	}
	@Test
	public void testQueryAnnotataion() {
		String lastName = "3";
		List<Person> list = personRepository.testQueryAnnotationParam1(lastName);
		for (Person person : list) {
			System.out.println(person);
		}
	}
	@Test
	public void testQueryAnnotataion2() {
		String lastName = "3";
		String email = "14";
		List<Person> list = personRepository.testQueryAnnotationParam2(email,lastName);
		for (Person person : list) {
			System.out.println(person);
		}
	}
	
	@Test
	public void testQueryAnnotationParam3() {
		String lastName = "3";
		String email = "14";
		List<Person> list = personRepository.testQueryAnnotationParam2(email,lastName);
		for (Person person : list) {
			System.out.println(person);
		}
	}
	
	@Test
	public void testQueryAnnotationParam4() {
		
		 long totalCount = personRepository.getTotalCount();
		 System.out.println(totalCount);
	}
	
	@Test
	public void testUpdate() throws Exception {
		personService.updatePerson("真香~", 8);
	}
	
	@Test
	public void testCrud() {
		List<Person> persons = new ArrayList<>();
		for(int i='a';i <='z';i++) {
			Person p = new Person();
			p.setBirth(new Date());
			p.setEmail((char)i+""+(char)i+"@qq.com");
			p.setLastName((char)i+""+(char)i);
			persons.add(p);
		}
		personService.savePersons(persons);
	}
}
