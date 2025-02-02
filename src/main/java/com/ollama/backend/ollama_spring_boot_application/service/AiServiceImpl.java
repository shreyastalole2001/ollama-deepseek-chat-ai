package com.ollama.backend.ollama_spring_boot_application.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AiServiceImpl implements AiService {

    private ChatClient client;

    public AiServiceImpl(ChatClient.Builder builder) {
        this.client = builder.build();
    }

    @Override
    public String askAi(String question) {
        return client.prompt(question).call().content();
    }

    public Flux<String> streamResponse(String question) {
        return client.prompt(question).user(question).stream().content();
    }
}
