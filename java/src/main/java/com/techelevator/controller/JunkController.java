package com.techelevator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JunkController {
    @GetMapping("/junk")
    public String junk() {
        return "junk";
    }
}
