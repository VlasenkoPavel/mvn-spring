package com.psvlasenko;

import java.util.List;

import com.psvlasenko.infrastructure.entities.Singer;
import com.psvlasenko.service.SingerService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringJPADemo {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        SingerService singerService = ctx.getBean(SingerService.class);

        List<Singer> singers = singerService.findAll();

        for(Singer singer : singers) {
            System.out.println(singer);
        }

        ctx.close();
    }
}
