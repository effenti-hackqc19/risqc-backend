package ca.effenti.risqc.controller;

import ca.effenti.risqc.model.Message;
import ca.effenti.risqc.model.ZoneRisqc;
import ca.effenti.risqc.repository.ZoneRisqcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RisksController {
    @Autowired
    ZoneRisqcRepository zoneRisqcRepository;


    private static final String MESSAGE = "Pong";

    @GetMapping(value = "/ping",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Message hello() {
        Message message = new Message();
        message.setMessage(MESSAGE);
        return message;
    }

    @GetMapping(value = "/flood-zones",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ZoneRisqc> floodZones() {

        List<ZoneRisqc> zones = zoneRisqcRepository.findClosestZones(46.815741, -71.200443);
        Message message = new Message();
        message.setMessage(MESSAGE);
        return zones;
    }



}
