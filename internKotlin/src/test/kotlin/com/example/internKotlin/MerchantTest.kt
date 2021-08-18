

package com.example.internKotlin

import com.example.internKotlin.entities.Merchent
import com.example.internKotlin.services.MerchentService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.mock.mockito.MockBean


@DataJpaTest
class MerchantTest {

    @MockBean
    private lateinit var merchentService: MerchentService

//    @Test
//    fun testCreateMerchent() {
//        var merchent = merchentService.save(Merchent(11, "iphone", 20201010));
//        println(merchent)
//    }

    @Test
    fun testGetAllMerchent() {

        val expectedMerchent = listOf(Merchent(1, "test", 20120101))
        val result1 = merchentService.getAllMerchents()
        Mockito.doReturn(expectedMerchent).`when`(merchentService).getAllMerchents()
        val result = merchentService.getAllMerchents()
        assertEquals(result, expectedMerchent)

    }

//    @Test
//    fun testCreateMerchent1() {
//        var before =  (merchentService).getAllMerchents().size
//        var merchent = merchentService.save(Merchent(1, "iphone", 20201010))
//        var after =  (merchentService).getAllMerchents().size
//        println(before)
//        assertEquals(before + 1, after)
//    }
//    @Test
//    fun testMasterDataControllerQueryMasterDataByCode(){
//
//        val template: TestRestTemplate = TestRestTemplate()
//        val url = "http://localhost:8080/api/Merchents";
//        val result: ArrayList<String> = template.getForObject<ArrayList<*>>(url, ArrayList::class.java) as ArrayList<String>
//        assertNotNull(result)
//        println(result)
//    }
}