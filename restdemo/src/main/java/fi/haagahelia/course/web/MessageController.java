package fi.haagahelia.course.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.course.domain.Message;

@RestController // kaikki luokan metodit ovat REST-metodeita
public class MessageController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Message msg(@RequestParam(value="name", defaultValue="Noora") String name) {
        return new Message(counter.incrementAndGet(), "Hello " +  name);
        
        // Jackson-kirjasto muuttaa Message-luokan olion JSON-olioksi
    }
    
}
