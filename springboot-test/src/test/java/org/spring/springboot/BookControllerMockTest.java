package org.spring.springboot;

import org.junit.Before;
import org.junit.Test;
import org.spring.springboot.mvc.controller.BookController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;

public class BookControllerMockTest {

    private MockMvc mvc; //初始化执行

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new BookController()).build();
    }

    //验证controller是否正常响应并打印返回结果
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    //验证controller是否正常响应并判断返回结果是否正确
    @Test
    public void testHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("Hello World")));
    }

}
