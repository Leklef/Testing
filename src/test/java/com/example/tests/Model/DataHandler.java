package com.example.tests.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "programs")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataHandler {
    @XmlElement(name = "program")
    private List<ProgramData> programDataList;

    public List<ProgramData> getProgramDataList() {
        return programDataList;
    }

    public void setPrograms(List<ProgramData> programs) {
        this.programDataList = programs;
    }

}
