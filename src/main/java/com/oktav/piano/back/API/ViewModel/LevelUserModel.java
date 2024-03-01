package com.oktav.piano.back.API.ViewModel;

import com.oktav.piano.back.API.EntityModel.LevelsEntity;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LevelUserModel {
    //ToDo UserID und ServerID entfernen und Servernamen und Usernamen einbauen -> Via API-Call zu Discord ermitteln
    private String userid;
    private String serverid;
    private Byte lv;
    private Integer xp;

    @NotNull
    public static LevelUserModel toResponse(LevelsEntity levels){
        LevelUserModel model = new LevelUserModel();
        model.setUserid(levels.getUserid());
        model.setServerid(levels.getServerid());
        model.setLv(levels.getLv());
        model.setXp(levels.getXp());
        return model;
    }
}
