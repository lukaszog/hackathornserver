package com.hackathorn.database;

/**
 * Created by root on 21.06.15.
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/getdata")
    public void getData(){
        System.out.println("Dziala");
        prepare();
    }

    public void prepare(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");

        EventDAO eventDAO = ctx.getBean("eventDAO", EventDAO.class);

        Collection<Event> eve = new LinkedList<Event>();
        List<Event> allEvents = mongoOperation.findAll(Event.class);
        System.out.println("Ilczba rekordow :" + allEvents.size());

        String TOKEN = "CAACEdEose0cBAG71m3z0eGfFTUVZATZALM6oGKZAPHprz4TqZA5SOggWyvIgqZCVoKams0lDph2Wy4rog9oxKjNP1ZCsM94gmKnw4Nd3jZAShmZBNSVZBEZAxBLMljXUz28oyMzv7oFclJApg7CjaEFIOZC4MpuQc7zlt1xKlZC9uR4YZBR0nvhwtdYP2SaV1LAxXsyisZAJN8q3BRejRxZAAOtvn7w";



        // search tool
        FBFetcher fbFetcher = new FBFetcher(TOKEN);

        // search arguments
        String category = "IT";
        String[] searchTags = { "IT", "komputery", "programowie", "technologie", "dev", "php", "sql", "java",
                "python", "c#", "javascript", "techklub", "hardware", "geek", "mission torun",
                "hackaton", "hackathon", "ataki sieciowe", "sieci", "smartspace", "Informat",
                "internet", "nowoczesn", "jug", "plssug", "Informatyki", "roboty", "3d"};

        // perform search
        List<FBEvent> events = fbFetcher.fetchIncomingEvents(category, searchTags);



        for(FBEvent ev: events) {
            System.out.println(ev.getEventID() + " || "  + ev.getLocationCity() + " || " + ev.getEventName());

            eve.add(new Event(ev.getEventID(),ev.getEventName(),
                    ev.getEventDescription(),ev.getEventCategory(),
                    ev.getEventOwner(),ev.getStartTime(),
                    ev.getPictureURL(),ev.getLocationPlace(),
                    ev.getLocationCity(),ev.getLocationStreet(),"IT"
                    ));
        }
        mongoOperation.insert(eve, Event.class);


        ctx.close();
    }

}