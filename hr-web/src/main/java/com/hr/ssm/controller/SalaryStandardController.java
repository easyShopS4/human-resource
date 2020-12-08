package com.hr.ssm.controller;


import com.hr.api.base.CommonResult;
import com.hr.ssm.entity.SalaryStandard;
import com.hr.ssm.entity.Users;
import com.hr.ssm.service.SalaryStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/ssm/salary-standard")
public class SalaryStandardController {

    @Autowired
    private SalaryStandardService salaryStandardService;

    //http://127.0.0.1:8080/ssm/salary-standard/SalaryStandardAdd
    @RequestMapping("/SalaryStandardAdd")
    public String  SalaryStandardAdd(SalaryStandard ss) {
     // int i= salaryStandardService.SalaryStandardInser(ss);
      boolean bool=  salaryStandardService.save(ss);

        System.out.println("============"+ss +"\t");

    if(bool){
        return "ok";
    }
     //   CommonResult<Object> res = new CommonResult<>(200, "消息");
    //    res.setData(ss);
     return "no";

    }
    //http://127.0.0.1:8080/ssm/salary-standard/SalaryStandardList
    @RequestMapping("/SalaryStandardList")
    public List<SalaryStandard> SalaryStandardList() {
    System.out.println(123);
        return salaryStandardService.list();

    }

}

