package com.example.tests.Helper;

import com.example.tests.Util.AppManager;
import com.example.tests.Model.ProgramData;
import org.openqa.selenium.By;

public class ProgramsHelper extends HelperBase {

    public ProgramsHelper(AppManager manager) {
        super(manager);
    }

    public void createProgram(ProgramData data) {
        driver.findElement(By.linkText("Добавить новую программу")).click();
        fillTheFieldById("f_name", data.getName());
        if (data.getDescription() != null) {
            fillTheFieldById("f_description", data.getDescription());
        }
        driver.findElement(By.cssSelector("button.btn.btn-orange")).click();
    }

    public void updateProgram(ProgramData data, ProgramData oldData) {
        driver.findElement(By.linkText(oldData.getName())).click();
        driver.findElement(By.linkText("Изменить программу")).click();
        fillTheFieldById("f_name", data.getName());
        if (data.getDescription() != null) {
            fillTheFieldById("f_description", data.getDescription());
        }
        driver.findElement(By.cssSelector("button.btn.btn-orange")).click();
    }

    public void deleteProgram(ProgramData data) {
        driver.findElement(By.linkText(data.getName())).click();
        driver.findElement(By.linkText("Удалить программу")).click();
    }

}
