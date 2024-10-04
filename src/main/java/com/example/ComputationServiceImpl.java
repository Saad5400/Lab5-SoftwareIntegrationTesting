package com.example;

public class ComputationServiceImpl implements IComputationService {
    @Override
    public String calculateSquare(int number) {
        return String.valueOf(number * number);
    }
}
