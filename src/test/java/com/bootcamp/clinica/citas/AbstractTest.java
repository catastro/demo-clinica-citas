package com.bootcamp.clinica.citas;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class AbstractTest {

    public static String readJSON(String path) throws URISyntaxException, IOException {
        return new String(Files.readAllBytes(Paths.get(AbstractTest.class.getResource(path).toURI())));
    }


    public static <T> T convertTo(String path, Class<T> clazz)
            throws IOException, URISyntaxException {
        String jsonRequest = readJSON(path);
        return new Gson().fromJson(jsonRequest, clazz);
    }
}
