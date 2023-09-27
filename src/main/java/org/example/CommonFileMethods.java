package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CommonFileMethods {
    public CommonFileMethods() {
    }
    //serialize - write
    //deserialize - read

    public static void serialize(String filePath) throws IOException {
        File firstFile = new File(filePath);
        //resources/data1.txt
        if (! firstFile.exists()) {
            firstFile.createNewFile();
        }

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(firstFile));

        fileWriter.write("name: Rostik");
        fileWriter.newLine();
        fileWriter.write("age: 17");
        fileWriter.newLine();
        fileWriter.write("hobby: music");
        fileWriter.newLine();

        fileWriter.flush();




    }
    public static void deserialize(String filePath) {
        File file = new File(filePath);
    }

}
