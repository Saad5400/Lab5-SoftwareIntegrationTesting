package com.example;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ComputationService {

    // API Endpoint to compute square of a number
    @GetMapping("/square/{number}")
    public String calculateSquare(@PathVariable int number) {
    	int result = number * number;
        return "" + result;
    }
} 
