package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.example.api.v1.RestControllerError;
import com.example.business.domain.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainingApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ObjectMapper mapper;
	
	private MockMvc mvc;
	
	private Employee tanaka;
	private Employee suzuki;
	private List<Employee> employees;

	@Before
	public void before() throws Exception {
		mvc = webAppContextSetup(webApplicationContext).build();
		// Controllerだけなら「MockMvcBuilders.standaloneSetup(new
		// EmployeeRestController()).build();」
		// その場合は、Service以下はインスタンス化されないので、別途MockBeanが必要
		
		// テストデータ
		this.tanaka = new Employee(0, "田中", "tanaka@sample.com");
		this.suzuki = new Employee(1, "鈴木", "suzuki@sample.com");
		this.employees = new ArrayList<Employee>();
		employees.add(tanaka);
		employees.add(suzuki);
		
	}

	@Test
	public void test_Get_0_Ok() throws Exception {
		mvc.perform(get("/v1/employees/0"))
		    .andExpect(status().isOk())
			.andExpect(content().json(mapper.writeValueAsString(tanaka)));
	}

	@Test
	public void test_Get_99_NotFound() throws Exception {
		RestControllerError e = new RestControllerError("そんな人はいません", "http://localhost:8080/v1/employees");
		mvc.perform(get("/v1/employees/99"))
		    .andExpect(status().isNotFound())
			.andExpect(content().json(mapper.writeValueAsString(e)));
	}

	@Test
	public void test_Get_All_Ok() throws Exception {
		mvc.perform(get("/v1/employees"))
		    .andExpect(status().isOk())
			.andExpect(content().json(mapper.writeValueAsString(employees)));
	}

	@Test
	public void test_Post_Ok() throws Exception {
		Employee saitou = new Employee(2, "斎藤", "saitou@sample.jp");
		mvc.perform(post("/v1/employees")
				.contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(saitou)))
		    .andExpect(status().isCreated());
	}
}