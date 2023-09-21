package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

    // handle request at path /hola
    @GetMapping("hola")
    public String hello (){
        return "Hello, Spring!";
    }

    @GetMapping("adios")
    public String goodbye (){
        return "Goodbye, Spring!";

    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParameter(@RequestParam String name){
        return "Hello, " + name +"!";

    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParameter(@PathVariable String name){
        return "Hello, " + name +"!";
    }

    // Handles requests using a Form
    @GetMapping("form")
    @ResponseBody
    public String helloWithForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Dime algo!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
