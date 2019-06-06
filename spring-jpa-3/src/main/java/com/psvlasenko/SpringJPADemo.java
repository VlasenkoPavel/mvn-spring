package com.psvlasenko;

import java.util.List;

import com.psvlasenko.domain.Singer;
import com.psvlasenko.infrastructure.entities.SingerRecord;
import com.psvlasenko.service.ISingerRepository;
import com.psvlasenko.service.SingerRepositoryImpl;
import com.psvlasenko.service.SingerService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringJPADemo {
    public static void main(String... args) {
        var ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        SingerService singerService = ctx.getBean(SingerService.class);
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
