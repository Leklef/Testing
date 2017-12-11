package com.example.tests.Test;

import com.example.tests.Model.AccountData;
import com.example.tests.Model.DataHandler;
import com.example.tests.Model.ProgramData;
import com.example.tests.Util.Generator;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.List;

public class CreateNote extends AuthBase {
    @Test
    public void testCreate() throws Exception {
        //Робит
        manager.getNavigationHelper().openPrograms();
        List<ProgramData> programDataList = unmarshalFromXml().getProgramDataList();
        for (ProgramData program : programDataList) {
            manager.getProgramsHelper().createProgram(program);
            Assert.assertEquals(program.getName(), manager.driver.findElement(By.linkText(program.getName())).getText());
        }
        manager.getLoginHelper().logout();
    }

    public DataHandler unmarshalFromXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(DataHandler.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (DataHandler) unmarshaller.unmarshal(Generator.file);
    }
}
