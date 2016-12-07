package com.example;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.api.v1.RestControllerError;
import com.example.business.domain.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // テストを順番通りに実施する
@AutoConfigureMockMvc
@AutoConfigureRestDocs("target/generated-snippets")
public class TrainingApplicationTests {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private MockMvc mvc;

	private Employee tanaka;
	private Employee suzuki;
	private List<Employee> employees;

	@Before
	public void setUp() throws Exception {
		// テストデータ
		this.tanaka = new Employee(0, "田中", "tanaka@sample.com");
		this.suzuki = new Employee(1, "鈴木", "suzuki@sample.com");
		this.employees = new ArrayList<Employee>();
		employees.add(tanaka);
		employees.add(suzuki);
	}

	@Test
	public void test_Get_0_Ok() throws Exception {
		mvc.perform(get("/v1/employees/{id}", 0))
		    .andExpect(status().isOk())
			.andExpect(content().json(mapper.writeValueAsString(tanaka)))
			.andDo(document("test_Get_0_Ok", pathParameters(
					parameterWithName("id").description("従業員番号"))));
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
				.contentType(TestHelper.APPLICATION_JSON_UTF8)
                .content(TestHelper.convertObjectToJsonBytes(saitou)))
		    .andExpect(status().isCreated())
		    .andExpect(header().string("Location", "http://localhost:8080/v1/employees/2"))
		    .andExpect(content().json(mapper.writeValueAsString(saitou)));
	}

    @TestConfiguration
    static class RestDocsConfiguration {
        @Bean
        public RestDocumentationResultHandler restDocumentation() {
            return document("{methodName}",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()));
        }
    }
}