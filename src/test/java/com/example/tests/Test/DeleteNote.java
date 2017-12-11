package com.example.tests.Test;

import com.example.tests.Model.ProgramData;
import org.junit.Test;

public class DeleteNote extends AuthBase {
    @Test
    public void testDestroy() throws Exception {
        //Робит
        ProgramData data = new ProgramData();
        data.setName("Программа тренировки(удаление)");
        manager.getNavigationHelper().openPrograms();
        manager.getProgramsHelper().createProgram(data);
        manager.getProgramsHelper().deleteProgram(data);
        manager.getLoginHelper().logout();
    }
}
