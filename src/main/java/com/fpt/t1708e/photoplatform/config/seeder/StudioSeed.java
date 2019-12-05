package com.fpt.t1708e.photoplatform.config.seeder;

import com.fpt.t1708e.photoplatform.entity.StudioInfo;

import java.util.ArrayList;
import java.util.List;

public class StudioSeed {
    public static List<StudioInfo> studioInfoSeeder = new ArrayList<>();
    public void addSeed(){
        StudioInfo studioInfo = new StudioInfo();
        studioInfo.setEmail("Email la gi");
    }
    //

    //
}
