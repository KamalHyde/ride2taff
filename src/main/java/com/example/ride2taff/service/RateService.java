package com.example.ride2taff.service;

import com.example.ride2taff.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateService {
    @Autowired
    RateRepository rate_repository;

}
