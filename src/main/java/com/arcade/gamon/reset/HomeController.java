package com.arcade.gamon.reset;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("")
    public String inform(){
        return "==== SPRING BOOT APPLICATION IS RUNNING ====";
    }

    // ============================================================================

    @GetMapping("/spring")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String spring() {
        return "APPLICATION STARTED!";
    }

    // ============================================================================

    @GetMapping("/message/{message}")
    public String printMessage(@PathVariable String message) {
        return message;
    }

    // ============================================================================

    @GetMapping("/message")
    public String printMessageParam(
            @RequestParam String message,
            @RequestParam String name) {
        return message + " " + name;
    }

    // ============================================================================

    @PostMapping("/message")
    public String message(@RequestBody String message) {
        return "user says : " + message;
    }

    // ============================================================================

    @PostMapping("/message-object")
    public String sampleObject(@RequestBody SampleObject sampleObject) {
        return "The object is : " + sampleObject.toString();
    }

    // ============================================================================

    @PostMapping("/message-record")
    public String userRecord(@RequestBody User user) {
        return "The user details : " + user.toString();
    }
}
