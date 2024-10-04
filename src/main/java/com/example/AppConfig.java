package com.example;

public class AppConfig {
    // Method to create and return a ComputationService object
    public IComputationService getComputationService() {
        return new ComputationServiceImpl();
    }

    // Method to create and return a ClientService object with injected ComputationService
    public IClientService getClientService() {
        return new ClientServiceImpl(getComputationService());
    }
}
