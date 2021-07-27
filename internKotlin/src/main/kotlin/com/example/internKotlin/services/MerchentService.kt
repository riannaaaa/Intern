package com.example.internKotlin.services

import com.example.internKotlin.entities.Merchent
import com.example.internKotlin.repositories.MerchentRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MerchentService (private val MerchentRepository: MerchentRepository) {

    fun getAllMerchents(): List<Merchent> = MerchentRepository.findAll()

    fun save(Merchent: Merchent): Merchent = MerchentRepository.save(Merchent)

    fun getMerchentById(MerchentId: Int): Optional<Merchent> = MerchentRepository.findById(MerchentId)

    fun updateMerchentById(MerchentId: Int, newMerchent: Merchent): Optional<Merchent> {
        return MerchentRepository.findById(MerchentId).map { existingMerchent ->
            val updatedMerchent: Merchent = existingMerchent
                .copy(id = newMerchent.id, name = newMerchent.name, day = newMerchent.day)
            MerchentRepository.save(updatedMerchent)
        }
    }

    fun deleteMerchentById(MerchentId: Int): Optional<Unit> {
        return MerchentRepository.findById(MerchentId).map { Merchent ->
            MerchentRepository.delete(Merchent)

        }
    }


}
