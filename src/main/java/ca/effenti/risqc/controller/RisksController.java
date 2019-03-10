package ca.effenti.risqc.controller;

import ca.effenti.risqc.model.Message;
import ca.effenti.risqc.model.ZoneRisqc;
import ca.effenti.risqc.repository.ZoneRisqcRepository;
import ca.effenti.risqc.service.RisqcResponse;
import ca.effenti.risqc.service.RisqcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RisksController {
    @Autowired
    private RisqcService riskService;


    private static final String MESSAGE = "Pong";

    @GetMapping(value = "/ping",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Message hello() {
        Message message = new Message();
        message.setMessage(MESSAGE);
        return message;
    }

    @GetMapping(value = "/flood-zones",produces = {MediaType.APPLICATION_JSON_VALUE})
    public RisqcResponse floodZones(@RequestParam("lat") Double lat, @RequestParam("lng") Double lng) {
        RisqcResponse risk = riskService.computeRisksFrom(lng, lat);
        return risk;
    }

}
