package com.oktav.piano.back.API.Repository;

import com.oktav.piano.back.API.EntityModel.LevelsEntity;
import com.oktav.piano.back.API.EntityModel.LevelsEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LevelsRepository extends JpaRepository<LevelsEntity, LevelsEntityPK> {

    @Query("Select l From LevelsEntity l Where l.serverid=:serverID And l.userid=:userID ")
    LevelsEntity findSpecficEntity(@Param("serverID") String serverID, @Param("userID") String userID);
    @Query("Select l From LevelsEntity l ORDER BY l.xp Asc")
    List<LevelsEntity> findOverViewAll();
}
