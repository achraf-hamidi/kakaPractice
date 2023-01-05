package corg.sid.demosppringcloudstreamkafka.services;

import corg.sid.demosppringcloudstreamkafka.entites.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

@Service
public class PageEventService {
    @Bean
    public Consumer<PageEvent> pageEventConsumer(){
        return (input)->{
            System.out.println("***********************************");
            System.out.println(input.toString());
            System.out.println("***********************************");
        };
    }
    @Bean
    public Supplier<PageEvent> pageEventSupplier(){
        return ()->new PageEvent(
                Math.random()>0.5?"p1":"p2",
                Math.random()>0.5?"u2":"u3",
                new Date(),
                new Random().nextInt(9000));

    }
    @Bean
    public Function<PageEvent,PageEvent> pageEventFunction (){
        return (input)->{
            input.setName("L"+input.getName().length());
            input.setUser("UUUUU");
            return input;

        };
    }
}
