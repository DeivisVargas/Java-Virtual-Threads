package com.virtual.virtualThreads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
public class TestServiceImpl  implements TestService{


    @Autowired
    private ExecutorService executor; // Executor de virtual threads

    //Método normal (bloqueante)
    @Override
    public String processoNormal() {
        simulateIO();
        // Apenas retorna string após o bloqueio
        return "Normal";
    }

    //Método virtual (executa em virtual thread)
    @Override
    public CompletableFuture<String> processoVirtual() {
        // CompletableFuture roda o simulateIO() em uma virtual thread
        return CompletableFuture.supplyAsync(() -> {
            simulateIO();
            // Confirma visualmente que está usando virtual thread
            System.out.println(Thread.currentThread());
            return "Virtual";
        }, executor);
    }

    // Simula operação bloqueante (I/O)
    private void simulateIO() {
        try {
            Thread.sleep(500); // simula banco/API externa
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
