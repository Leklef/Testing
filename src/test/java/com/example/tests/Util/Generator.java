package com.example.tests.Util;

import com.example.tests.Model.DataHandler;
import com.example.tests.Model.ProgramData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.*;

public class Generator {
    public static File file = new File("/Users/lenar/Downloads/Testing-master/src/test/java/com/example/tests/Util/out.xml");

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        generateJavaObject(i);
        scanner.close();
    }

    static void generateJavaObject(int count) {
        List<ProgramData> listPrograms = new ArrayList<ProgramData>();
        for (int i = 0; i < count; i++) {
            ProgramData programData = new ProgramData();
            programData.setName(generateRandomString(10));
            listPrograms.add(programData);
        }
        DataHandler handler = new DataHandler();
        handler.setPrograms(listPrograms);
        try {
            JAXBContext context = JAXBContext.newInstance(DataHandler.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(handler, file);

        } catch (JAXBException exception) {
            System.out.println(exception.toString());
        }
    }


    public static String generateRandomString(int count) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            char c = chars[random.nextInt(chars.length)];
            if (i == 0) {
                c = Character.toUpperCase(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
