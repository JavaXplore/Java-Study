package com.javaxplore.functional.files;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesExample {
    public static void main(String[] args) throws IOException, URISyntaxException {
        File file = new File("resources/file.txt");
        System.out.println(file.getAbsolutePath());

        URL resource = FilesExample.class.getResource("file.txt");
        Paths.get(resource.toURI()).toFile();
        //Files.lines(Paths.get("file.txt")).forEach(System.out::println);
    }
}
