package tn.esprit.pokerplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pokerplanning.service.DialogflowService;

import java.io.IOException;

@RestController

public class ChatController {
    @Autowired
    private DialogflowService dialogflowService;

    @PostMapping("/query")
    public String query(@RequestBody String text) {
        try {
            return dialogflowService.detectIntentTexts(text);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error processing your request";
        }
    }
}
