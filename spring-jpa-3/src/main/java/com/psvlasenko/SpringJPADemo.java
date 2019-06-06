package com.psvlasenko;

import java.util.List;

import com.psvlasenko.domain.Singer;
import com.psvlasenko.service.ISingerRepository;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringJPADemo {
    public static void main(String... args) {
        var ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        ISingerRepository singerRepository = ctx.getBean(ISingerRepository.class);
        List<Singer> singers = singerRepository.findAll();

        for(Singer singer : singers) {
            System.out.println(singerRepository);
            System.out.println(singer.getFulName());
            System.out.println(singer.dto().getId());
        }

        ctx.close();
    }
}
