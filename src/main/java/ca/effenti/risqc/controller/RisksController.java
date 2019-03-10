package ca.effenti.risqc.controller;

import ca.effenti.risqc.model.Message;
import ca.effenti.risqc.model.ZoneRisqc;
import ca.effenti.risqc.repository.ZoneRisqcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
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
    public List<ZoneRisqc> floodZones(@RequestParam("lat") Double lat, @RequestParam("lng") Double lng) {

        List<ZoneRisqc> zones = zoneRisqcRepository.findClosestZones(lat, lng);
        return zones;
    }



}
