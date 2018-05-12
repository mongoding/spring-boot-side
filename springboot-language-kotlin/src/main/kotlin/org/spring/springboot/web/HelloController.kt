package org.spring.springboot.web

import org.spring.springboot.domain.HelloDto
import org.spring.springboot.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(val helloService: HelloService) {

    // ...

    @GetMapping("/hello-service")
    fun helloKotlinService(): String {
        return helloService.getHello()
    }

    @GetMapping("/hello-dto")
    fun helloDto(): HelloDto {
        return HelloDto("Hello from the dto")
    }
}