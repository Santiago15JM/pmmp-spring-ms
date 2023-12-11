package com.ppyd.statisticsservice.controllers;

import com.ppyd.statisticsservice.models.Summary;
import com.ppyd.statisticsservice.services.StatisticsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/stats")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/getPublicStatus")
    public List<Summary> getPublicStatus(@RequestParam ObjectId user) {
       return statisticsService.getPublicStatus(user);
    }

}
