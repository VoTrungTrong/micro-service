package com.example.statisticservice.service;

import com.example.statisticservice.dto.StatisticDTO;

import java.util.List;

public interface StatisticService {

    StatisticDTO add(StatisticDTO statisticDTO);

    List<StatisticDTO> getAll();

}
