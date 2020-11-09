package com.ifi.dat.image.controller;

import com.ifi.dat.image.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping("/images")
    public List<Image> getImages() {
        List<Image> images = Arrays.asList(
                new Image(1, "Image 1"),
                new Image(2, "Image 2"),
                new Image(3, "Image 3"));
        return images;
    }
}
