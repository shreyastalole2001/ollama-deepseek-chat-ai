package com.ollama.backend.ollama_spring_boot_application.service;

import reactor.core.publisher.Flux;

public interface AiService {

    String askAi(String question);
    Flux<String> streamResponse(String question);
}
