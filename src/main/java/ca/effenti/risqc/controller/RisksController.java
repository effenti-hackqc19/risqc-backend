package ca.effenti.risqc.controller;

import ca.effenti.risqc.model.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RisksController {

    private static final String MESSAGE = "Pong";

    @GetMapping(value = "/ping",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Message hello() {
        Message message = new Message();
        message.setMessage(MESSAGE);
        return message;
    }



}
