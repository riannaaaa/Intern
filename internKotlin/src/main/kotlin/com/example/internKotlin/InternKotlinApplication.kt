package com.example.internKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.net.URISyntaxException


@SpringBootApplication
class InternKotlinApplication

@Bean
@Throws(URISyntaxException::class)
//fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean? {
//	val entityManagerFactoryBean = LocalContainerEntityManagerFactoryBean()
//
//	//additional config of factory
//	return entityManagerFactoryBean
//}

fun main(args: Array<String>) {
	runApplication<InternKotlinApplication>(*args)
}
