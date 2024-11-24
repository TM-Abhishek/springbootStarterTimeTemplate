package org.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class TimestampController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Mono<ResponseEntity<String>> websiteCheck() {
        LocalDate today = LocalDate.now();
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        String formattedTime = istTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        String htmlContent = "<html>" +
                "<head>" +
                "<title>Website Status</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }" +
                ".box { width: 300px; padding: 20px; background-color: #4CAF50; color: white; text-align: center; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); }" +
                "h1 { margin: 0; font-size: 24px; }" +
                "p { font-size: 16px; margin: 10px 0 0 0; }" +
                "#currentTime { font-size: 18px; margin-top: 20px; font-weight: bold; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='box'>" +
                "<h1>Website is working Fine</h1>" +
                "<p>Date: " + today + "</p>" +
                "<p>Status: SUCCESS</p>" +
                "<p id='currentTime'>Current Time: " + formattedTime + "</p>" +
                "</div>" +
                "</body>" +
                "</html>";

        return Mono.just(new ResponseEntity<>(htmlContent, HttpStatus.OK));
    }

}
