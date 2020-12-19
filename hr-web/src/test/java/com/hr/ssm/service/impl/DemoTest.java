package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.ssm.entity.EngageResume;
import com.hr.ssm.mapper.EngageResumeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author echo lovely
 * @date 2020/12/19 10:24
 */

public class DemoTest {


    @Resource
    EngageResumeMapper mapper;

    @Test
    public void test1() {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-core.xml");

        mapper = context.getBean(EngageResumeMapper.class);

        Page<EngageResume> page = new Page<>(1, 3);

        EngageResume resume = new EngageResume();
        resume.setInterviewCheckStatus(1);
        resume.setInterviewStatus(1);

        // List<EngageResume> list = mapper.getAllPassResume(page, resume);

        // list.forEach(System.out::println);
        IPage<EngageResume> res = mapper.getAllPassResume(page, resume);
        System.out.println(res.getTotal() + "\t" + res.getRecords());

        System.out.println(page.getTotal() + "\t" + page.getRecords());

    }

}
