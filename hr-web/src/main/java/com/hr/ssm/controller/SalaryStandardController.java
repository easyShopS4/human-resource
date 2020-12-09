package com.hr.ssm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.EngageMajorRelease;
import com.hr.ssm.entity.SalaryStandard;
import com.hr.ssm.entity.Users;
import com.hr.ssm.service.SalaryStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/SalaryStandardList") //条件查询
    public List<SalaryStandard> SalaryStandardList(SalaryStandard ss) {
        return  salaryStandardService.findSalaryStandard(ss);

    }


   // http://127.0.0.1:8080/ssm/salary-standard/E_RegistrationReviewList
    @RequestMapping("/E_RegistrationReviewList")
    public SalaryStandard e_RegistrationReviewList(SalaryStandard id) {
        System.out.println("访问E_RegistrationReviewList成功"+id.getSsdId());
        return  salaryStandardService.getById(id.getSsdId());

    }

    // http://127.0.0.1:8080/ssm/salary-standard/E_RegistrationReviewList
    @RequestMapping("E_RegistrationReviewUpdate")
    public String e_RegistrationReviewUpdate(SalaryStandard standard) {
        System.out.println("访问e_RegistrationReviewUpdate成功"+standard);
        boolean bool= salaryStandardService.updateById(standard);
        if (bool) {
            return "ok";
        }
        return "on";

    }


    @GetMapping("/FeiYe") //分页
    public DataGridView getMajorReleaseByPage(Integer page, Integer limit) {

        // 页数，每页多少行~
        Page<SalaryStandard> p = new Page<>();
        p.setCurrent(page);
        p.setSize(limit);

        // 分页，不带条件~
        return salaryStandardService.getSalaryStandardByPage(p, null);
    }

}

