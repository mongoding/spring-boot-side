package org.spring.springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringbootKotlinApplication>(*args)
}
