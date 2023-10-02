package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    // handle request at path /hola
    @GetMapping("hola")
    @ResponseBody
    public String hello (){
        return "Hello, Spring!";
    }

    @GetMapping("adios")
    @ResponseBody
    public String goodbye (){
        return "Goodbye, Spring!";

    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParameter(@RequestParam String name, Model model){
        String saludo = "Hello, " + name + "!";
        model.addAttribute("greeting", saludo);
        return "hello";

    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParameter(@PathVariable String name, Model model){
        String saludo = "Hello," + name + "!";
        model.addAttribute("greeting", saludo);
        return "Hello, " + name +"!";
    }

    // Handles requests using a Form
    @GetMapping("form")
    public String helloWithForm(){
        return "form";
    }

    // Passes an iterating list of names
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Juan");
        names.add("Pedro");
        names.add("Jose");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
