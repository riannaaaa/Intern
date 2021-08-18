package com.example.internKotlin.controllers

import com.example.internKotlin.entities.Merchent
import com.example.internKotlin.services.MerchentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class MerchentController(@Autowired private val MerchentService: MerchentService) {

    @GetMapping("/Merchents")
    fun getAllMerchents(): List<Merchent> = MerchentService.getAllMerchents()

    @PostMapping("/Merchents/save")
    fun createNewMerchent(@RequestBody  Merchent: Merchent): Merchent = MerchentService.save(Merchent)

    @DeleteMapping("/Merchents/delete")
    fun deleteMerchentById(@RequestParam("id") MerchentId: Int): ResponseEntity<Void> {

        return MerchentService.deleteMerchentById(MerchentId).map { _ ->
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }


    @PutMapping("/Merchents/{id}")
    fun updateMerchentById(@PathVariable(value = "id") MerchentId: Int,
                          @Valid @RequestBody newMerchent: Merchent): ResponseEntity<Merchent> {

        val updatedMerchent: Optional<Merchent> = MerchentService.updateMerchentById(MerchentId, newMerchent)
        return updatedMerchent.map { updated ->
            ResponseEntity.ok().body(updated)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/Merchents/search")
    fun getMerchentById(@RequestParam("id") MerchentId: Int): ResponseEntity<Merchent> {
        return MerchentService.getMerchentById(MerchentId).map { Merchent ->
            ResponseEntity.ok(Merchent)
        }.orElse(ResponseEntity.notFound().build())
    }
}