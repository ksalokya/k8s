package com.k8s.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/info")
    public String displayMessage() {
        return "Successfully deployed application on Kubernetes.";
    }
}
