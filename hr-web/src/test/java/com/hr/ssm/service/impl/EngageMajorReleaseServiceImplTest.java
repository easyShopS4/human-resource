package com.hr.ssm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageMajorRelease;
import com.hr.ssm.service.EngageMajorReleaseService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.List;

/**
 * @author echo lovely
 * @date 2020/12/8 15:17
 */

public class EngageMajorReleaseServiceImplTest {

    @Test
    public void test1() {

        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext-core.xml");

        EngageMajorReleaseService b = app.getBean(EngageMajorReleaseService.class);

        Page<EngageMajorRelease> page = new Page<>(1, 2);

        DataGridView dgv =
                b.getMajorReleaseByPage(page, null);

        @SuppressWarnings("unchecked")
        Collection<EngageMajorRelease> res = (List<EngageMajorRelease>) dgv.getData();
        res.forEach(System.out::println);
    }

}
