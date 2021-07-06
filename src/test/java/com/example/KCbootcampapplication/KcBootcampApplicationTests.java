package com.example.KCbootcampapplication;

import com.example.KCbootcampapplication.controller.AdminController;
import com.example.KCbootcampapplication.controller.LoginController;
import com.example.KCbootcampapplication.controller.StudentController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class KcBootcampApplicationTests{

	@Autowired
	public MockMvc mockMvc;
	@Autowired
	public AdminController adminController;

	@Autowired
	public LoginController loginController;

	@Autowired
	public StudentController studentController;

	@Test
	public void contextLoads() throws Exception{
		assertThat(adminController).isNotNull();
		assertThat(loginController).isNotNull();
		assertThat(studentController).isNotNull();
	}

	@Test
	public void loginUp() throws Exception {
		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
	}

}
