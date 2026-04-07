package com.virtual.virtualThreads.controller;

import com.virtual.virtualThreads.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api" )

public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    // tradicional
    @GetMapping("/normal")
    public String normal() {
        return testService.processoNormal();
    }

    // virtual threads (ativado via config)
    @GetMapping("/virtual")
    public CompletableFuture<String> virtual() {
        return testService.processoVirtual();
    }



}
