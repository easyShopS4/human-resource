package com.hr.ssm.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hr.ssm.entity.SalaryGrant;
import com.hr.ssm.entity.SalaryGrantBatch;
import com.hr.ssm.entity.SalaryStandard;
import com.hr.ssm.service.SalaryGrantService;
import com.hr.ssm.service.SalaryStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jz_lee
 * @since 2020-12-04
 */
@RestController
@RequestMapping("/ssm/salary-grant")
public class SalaryGrantController {
    @Autowired
    private SalaryGrantService salaryGrantService;


    //http://127.0.0.1:8080/ssm/salary-grant/salaryGrantAdd

    @RequestMapping("/salaryGrantAdd")
    public String  salaryGrantAdd(SalaryGrantBatch sg) {

        List<SalaryGrant> list=sg.getListsg();

            for (int i=0;i<list.size();i++){
                System.out.println("第"+i+"条"+list.get(i).toString());

            }
        salaryGrantService.saveBatch(sg);

        return "1";
    }
    //http://127.0.0.1:8080/ssm/salary-grant/P_RegistrationCheck
    @RequestMapping("P_RegistrationCheck") //复核状态查询
    public List<SalaryGrant>  getRegistrationCheck() {

        List<SalaryGrant> list= salaryGrantService.findListCheck();
      /*  for (int i = 0; i < list.size(); i++) {
            System.out.println("第"+i+"条"+list.get(i).toString());
        }*/

        return list;
    }
    //http://127.0.0.1:8080/ssm/salary-grant/P_RegistrationCheckSecond
    @RequestMapping("P_RegistrationCheckSecond") //id查询(salary_grant(多表联查))
    public SalaryGrant  getRegistrationCheckSecond(Integer sgrId) {
                System.out.println("id值"+sgrId);
        SalaryGrant list= salaryGrantService.findById(sgrId);

        System.out.println("精确查找"+list);
        return list;
    }
//http://127.0.0.1:8080/ssm/salary-grant/updates
@RequestMapping("updates") //id查询(salary_grant(多表联查))
public String  getUpdates(SalaryGrant sg) {
     System.out.println("id值"+sg);
    salaryGrantService.Updates(sg);
    return "1";
    }
    //http://127.0.0.1:8080/ssm/salary-grant/P_Registration_Enquiry
    @RequestMapping("P_Registration_Enquiry") //单表查询
    public List<SalaryGrant>  getRegistration_Enquiry(SalaryGrant sg) {
        //System.out.println("id值"+sg);
       List<SalaryGrant> list= salaryGrantService.list();
        return list;
    }

}

