package com.example.statisticservice.controller;

import com.example.statisticservice.dto.StatisticDTO;
import com.example.statisticservice.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistic")
@Slf4j
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @PostMapping
    public StatisticDTO add(@RequestBody StatisticDTO statisticDTO) {
        log.info("Statistic : {}", statisticDTO);
        log.debug("Add statistic");

//        try {
//            Thread.sleep(10 * 1000);
//        } catch (InterruptedException e) {
//            log.debug(e.getMessage());
//            e.printStackTrace();
//        }
        return this.statisticService.add(statisticDTO);
    }

    @GetMapping
    public List<StatisticDTO> getAll() {
        log.info("Get all statistic");
        return this.statisticService.getAll();
    }
}
