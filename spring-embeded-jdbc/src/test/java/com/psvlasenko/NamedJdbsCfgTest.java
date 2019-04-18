package com.psvlasenko;

import static org.junit.Assert.assertTrue;

import com.psvlasenko.dao.SingerDao;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NamedJdbsCfgTest {

    @Test
    public void shouldAnswerWithTrue() {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/embedded-h2-cfg.xml");
        ctx.refresh();
        SingerDao dao = ctx.getBean(SingerDao.class);

        assertTrue("John".equals(dao.findFirstNameById(1l)));
    }
}
