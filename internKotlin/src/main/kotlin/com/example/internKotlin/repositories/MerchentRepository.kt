package com.example.internKotlin.repositories

import com.example.internKotlin.entities.Merchent
import org.springframework.data.jpa.repository.JpaRepository



interface MerchentRepository : JpaRepository<Merchent, Int>