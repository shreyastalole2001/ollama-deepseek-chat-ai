package com.ollama.backend.ollama_spring_boot_application.controller;


import com.ollama.backend.ollama_spring_boot_application.service.AiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {

    private AiService aiService;

    public AiController(AiService aiService){
        this.aiService = aiService;
    }

    @GetMapping()
    public ResponseEntity<String> askAi(
            @RequestParam(value = "query", required = false, defaultValue = "How are you?") String query)
    {
        String response = aiService.askAi(query);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/stream")
    public Flux<String> streamAi(
            @RequestParam(value = "query", required = false, defaultValue = "How can you help me?") String query
    ){
        return aiService.streamResponse(query);
    }


}
