package com.ollama.backend.ollama_spring_boot_application.controller;


import com.ollama.backend.ollama_spring_boot_application.service.AiService;
import com.ollama.backend.ollama_spring_boot_application.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.File;

@RestController
@RequestMapping("/ai")
public class AiController {

    private AiService aiService;
    private DocumentService documentService;


    @Autowired
    public AiController(AiService aiService, DocumentService documentService) {
        this.aiService = aiService;
        this.documentService = documentService;
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
            @RequestParam(value = "query", required = false, defaultValue = "What is the data provided to you?") String query
    ){
        try{

            // Load the PDF from resources
            File file = new ClassPathResource("static/Product_FAQs.pdf").getFile();
            String documentPath = file.getAbsolutePath();

            String documentText = documentService.extractTextFromPDF(documentPath);
            query = "Your task is to read data from DATA and provide answers to users; DATA = " + documentText + "QUESTION = " + query;
        }catch (Exception e) {
            e.printStackTrace();
            return Flux.just("Sorry, I encountered an error while processing your request.");
        }
        return aiService.streamResponse(query);
    }


}
