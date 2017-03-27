package fr.dta.unit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import fr.dta.model.User;
import fr.dta.dao.UserService;

@Sql("classpath:test-user-data.sql")
public class UserIT extends IntegrationTest {

	@Autowired
	UserService userService;

	@Test
	@WithMockUser(authorities = "TEST")
	public void testCreate() throws Exception {
		User u = new User();
		u.setLogin("test");
		u.setName("name");
		u.setEmail("email@email.com");
		u.setLogin("login");
		u.setPassword("superpassword");

		this.mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
				.content(jsonHelper.serialize(u))).andExpect(status().isCreated());
		this.mockMvc.perform(get("/user")).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$", hasSize(3))).andExpect(status().isOk());

	}

	@Test
	@WithMockUser
	public void testCreatePreconditionFail() throws Exception {
		User u = new User();
		u.setLogin(null);
		u.setPassword(null);

		this.mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
				.content(jsonHelper.serialize(u)))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(jsonPath("$[*].field", containsInAnyOrder("password", "login")))
		.andExpect(jsonPath("$[0].objectName").value("user"))
		.andExpect(jsonPath("$[*].code", containsInAnyOrder("NotBlank", "NotBlank")))
		.andExpect(status().isPreconditionFailed());

	}
	
	@Test
	@WithMockUser
	public void testUpdate() throws Exception {
		User user = userService.getById(1);
		Assert.assertEquals("admin@iocean.fr", user.getLogin());

		user.setLogin("test@iocean.fr");
		this.mockMvc
				.perform(put("/user/{id}", 1).contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
						.content(jsonHelper.serialize(user)))
				.andExpect(jsonPath("$.login").value("test@iocean.fr")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(authorities = "TEST")
	public void testGetUser() throws Exception {
		this.mockMvc.perform(get("/user/{id}", 1)).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.login").value("admin@iocean.fr"))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(authorities = "TEST")
	public void testGetNotFoundUser() throws Exception {
		this.mockMvc.perform(get("/user/{id}", 55)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isNotFound());
	}
	
	@Test
	@WithMockUser(authorities = "TEST")
	public void testGetAllUsers() throws Exception {
		this.mockMvc.perform(get("/user")).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$", hasSize(2))).andExpect(status().isOk());
	}

}
