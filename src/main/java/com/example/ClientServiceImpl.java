package com.example;

public class ClientServiceImpl implements IClientService {
    private final IComputationService computationService;

    // Constructor-based Dependency Injection
    public ClientServiceImpl(IComputationService computationService) {
        this.computationService = computationService;
    }

    @Override
    public String fetchSquare(int number) {
        return computationService.calculateSquare(number);
    }
}
