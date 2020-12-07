package com.hr.ssm.demo;

import com.hr.api.util.UserUtil;
import org.junit.Test;

/**
 * @author echo lovely
 * @date 2020/12/7 11:22
 */

public class PwdTest {

    @Test
    public void test1() {
        UserUtil util = new UserUtil();

        String r1 = util.generatePassword("123456", "hi870");
        System.out.println(r1);
    }

}
