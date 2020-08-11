package com.rao.usermanagement.integration;


import com.rao.usermanagement.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerIT extends AbstractControllerIT {

    @Autowired
    private MockMvc mockMvc;

    public UserControllerIT() {
    }

    @Test
    public void shouldCreateNewUser() throws Exception {

        Thread.sleep(5000);
        User user = User.builder().firstName("Rao").lastName("konda").password("Ras67@12aa")
                .email("rao.konda@gmail.com").city("vijayawada").phoneNumber("95454545")
                .state("Andhra Pradesh").streetName("Mill Lane").build();

        MvcResult result = this.mockMvc.perform(post("/user/createUser").contentType(APPLICATION_JSON_VALUE)
                .content(getJsonFromObject(user))).andExpect(status().is2xxSuccessful()).andReturn();

        String json = result.getResponse().getContentAsString();
        User dbUser = mapper.readValue(json, User.class);


        this.mockMvc.perform(get("/user/" + dbUser.getId()).contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.email").value("rao.konda@gmail.com"));

    }


}
