package com.example.statisticservice.service.impl;

import com.example.statisticservice.dto.StatisticDTO;
import com.example.statisticservice.entity.Statistic;
import com.example.statisticservice.repository.StatisticRepository;
import com.example.statisticservice.service.StatisticService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StatisticDTO add(StatisticDTO statisticDTO) {
        Statistic statistic = this.modelMapper.map(statisticDTO, Statistic.class);
        Statistic statisticSaved = this.statisticRepository.save(statistic);
        statisticDTO.setId(statisticSaved.getId());
        return statisticDTO;
    }

    @Override
    public List<StatisticDTO> getAll() {
        List<StatisticDTO> statisticDTOs = new ArrayList<>();

        this.statisticRepository.findAll().forEach(statistic -> {
            statisticDTOs.add(this.modelMapper.map(statistic, StatisticDTO.class));
        });

        return statisticDTOs;
    }
}
