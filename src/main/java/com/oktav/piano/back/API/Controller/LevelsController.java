package com.oktav.piano.back.API.Controller;

import com.oktav.piano.back.API.ServiceHandler.LevelsService;

import com.oktav.piano.back.API.ViewModel.LevelOverviewModel;
import com.oktav.piano.back.API.ViewModel.LevelUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/levels")
public class LevelsController {

    private final LevelsService levelsService;

    @Autowired
    public LevelsController(LevelsService levelsService) {
        this.levelsService = levelsService;
    }
    @Operation(
            summary = "Gets all levels",
            description = "Gets leveldata for every user in every server"
    )
    @GetMapping(path = "/all")
    public @ResponseBody ResponseEntity<LevelOverviewModel> getAllLevels() {
        LevelOverviewModel model=levelsService.getOverviewAll();
        if(model==null)
            return ResponseEntity.status(204).build();

        return ResponseEntity.ok(model);
    }
    @Operation(
            summary = "Gets the level of one user",
            description = "Gets the level of a specific user in a specific server"
    )
    @GetMapping(path = "/one/{serverId}/{userId}")
    public @ResponseBody ResponseEntity<LevelUserModel> getUserLevel(@PathVariable String serverId, @PathVariable String userId) {
        LevelUserModel model=levelsService.getSpecificUser(serverId,userId);
        if(model==null)
            return ResponseEntity.status(204).build();

        return ResponseEntity.ok(model);
    }
}