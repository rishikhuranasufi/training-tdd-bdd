package com.infy.cucumber.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamUtils {

    public static void copyFile(File inputFile, File outputFile) {
        try {
            FileInputStream instream = null;
            FileOutputStream outstream = null;

            instream = new FileInputStream(inputFile);
            outstream = new FileOutputStream(outputFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = instream.read(buffer)) > 0) {
                outstream.write(buffer,0, length);
            }
            instream.close();
            outstream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();

        }


    }
}
