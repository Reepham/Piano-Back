package com.oktav.piano.back.API.Controller;

import com.oktav.piano.back.API.ServiceHandler.LevelsService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/levels")
public class LevelsController {

    private final LevelsService levelsService;

    @Autowired
    public LevelsController(LevelsService levelsService) {
        this.levelsService = levelsService;
    }

}