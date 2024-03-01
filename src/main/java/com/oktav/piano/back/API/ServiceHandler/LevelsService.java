package com.oktav.piano.back.API.ServiceHandler;
import com.oktav.piano.back.API.EntityModel.LevelsEntity;
import com.oktav.piano.back.API.Repository.LevelsRepository;
import com.oktav.piano.back.API.ViewModel.LevelOverviewModel;
import com.oktav.piano.back.API.ViewModel.LevelUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelsService {

    private final LevelsRepository levelsRepository;

    @Autowired
    public LevelsService(LevelsRepository levelsRepository){
        this.levelsRepository = levelsRepository;
    }

    public LevelOverviewModel  getOverviewAll(){
        List<LevelsEntity> userData=levelsRepository.findOverViewAll();
        if (userData == null) {
            return null;
        }

        return LevelOverviewModel.toResponse(userData);

    }
    public LevelUserModel getSpecificUser(String serverId, String userID){
        LevelsEntity userData=levelsRepository.findSpecificEntity(serverId,userID);
        if (userData == null) {
            return null;
        }

        return LevelUserModel.toResponse(userData);
    }
}
