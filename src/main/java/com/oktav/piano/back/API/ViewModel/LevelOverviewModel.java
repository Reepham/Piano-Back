package com.oktav.piano.back.API.ViewModel;

import com.oktav.piano.back.API.EntityModel.LevelsEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class LevelOverviewModel {
    private List<LevelUserModel> users;
    @NotNull
    public static LevelOverviewModel toResponse(List<LevelsEntity> entities){
        LevelOverviewModel overviewModel= new LevelOverviewModel();
        overviewModel.setUsers(entities
                .stream()
                .sorted(Comparator.comparingInt(LevelsEntity::getXp))
                .map(LevelUserModel::toResponse)
                .collect(Collectors.toList())
        );
        return overviewModel;
    }
}
