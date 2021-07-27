package com.example.internKotlin


import com.example.internKotlin.controllers.MerchentController
import com.example.internKotlin.entities.Merchent
import com.example.internKotlin.services.MerchentService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.filter.CharacterEncodingFilter

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(MerchentController::class)
@ActiveProfiles("test")
internal class ControllerTest @Autowired constructor(
    private val objectMapper: ObjectMapper,
    private val webApplicationContext: WebApplicationContext,
    private var mockMvc: MockMvc
) {

    @MockBean
    lateinit var merchentService: MerchentService


    lateinit var merchentDto: Merchent

    @BeforeAll
    fun setUp() {

         merchentDto = Merchent(
            id = 6,
            name = "test1",
            day = 20001010
        )


        this.mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .alwaysDo<DefaultMockMvcBuilder>(MockMvcResultHandlers.print())
            .addFilter<DefaultMockMvcBuilder>(CharacterEncodingFilter("UTF-8", true))
            .build()
    }
//    @Test
//    fun testCreateMerchant() {
//        val expectedMerchent = Merchent(10, "test", 20120101)
//        doReturn(expectedMerchent).`when`(merchentService)?.save((Merchent(10, "test", 20120101)))
//
//        mockMvc.perform(
//            MockMvcRequestBuilders.post("/api/Merchents/save")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(toJsonString(merchentDto))
//        )
//            .andExpect(status().isCreated)
//
//    }
//    @Throws(JsonProcessingException::class)
//    private fun toJsonString(merchent: Merchent): String {
//        return objectMapper.writeValueAsString(merchentDto)
//    }

}