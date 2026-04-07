package com.virtual.virtualThreads.service;

import java.util.concurrent.CompletableFuture;

public interface TestService {

    String processoNormal();
    CompletableFuture<String> processoVirtual();
}
