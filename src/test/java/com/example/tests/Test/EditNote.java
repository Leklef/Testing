package com.example.tests.Test;

import com.example.tests.Model.AccountData;
import com.example.tests.Model.ProgramData;
import org.junit.Test;

public class EditNote extends AuthBase {
    @Test
    public void testUpdate() throws Exception {
        //Робит
        ProgramData data = new ProgramData();
        data.setName("Программа тренировки(изменение)");
        manager.getNavigationHelper().openPrograms();
        manager.getProgramsHelper().createProgram(data);
        data.setDescription("Новый текст");
        manager.getProgramsHelper().updateProgram(data, data);
        manager.getLoginHelper().logout();
    }
}
