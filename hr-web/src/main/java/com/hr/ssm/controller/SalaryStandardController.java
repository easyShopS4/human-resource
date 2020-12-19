package com.hr.ssm.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.api.base.CommonResult;
import com.hr.api.base.DataGridView;
import com.hr.ssm.entity.*;
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

      boolean bool=  salaryStandardService.save(ss);
        System.out.println("============"+ss +"\t");

       if(bool){
           return "ok";
        }
         return "no";

     }
    //http://127.0.0.1:8080/ssm/salary-standard/SalaryStandardList
    @RequestMapping("/SalaryStandardList") //多条件查询
    public DataGridView SalaryStandardList(SalaryStandard ss,Integer page, Integer limit) {
        System.out.println("============"+ss +"\t页数"+page+"--行数"+limit);

        // 页数，每页多少行~
        Page<SalaryStandard> p = new Page<>();
        p.setCurrent(page);
        p.setSize(limit);


       // Wrapper<SalaryStandard> w = new QueryWrapper<>(ss);

        // 分页，带条件~
        DataGridView dg= salaryStandardService.findSalaryStandard(p, ss);
        return dg;


    }

    //http://127.0.0.1:8080/ssm/salary-standard/SalaryStandardListBG
    //http://127.0.0.1:8080/ssm/salary-standard/SalaryStandardListBG
    @RequestMapping("/SalaryStandardListBG") //变更 多条件查询
    public DataGridView SalaryStandardListBG(SalaryStandard ss,Integer page, Integer limit) {
        System.out.println("============"+ss +"\t页数"+page+"--行数"+limit);

        // 页数，每页多少行~
        Page<SalaryStandard> p = new Page<>();
        p.setCurrent(page);
        p.setSize(limit);


        // Wrapper<SalaryStandard> w = new QueryWrapper<>(ss);

        // 分页，带条件~
        DataGridView dg= salaryStandardService.findSalaryStandardBG(p, ss);
        return dg;


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


    @GetMapping("/FeiYe") //分页查询
    public DataGridView getMajorReleaseByPage(Integer page, Integer limit) {
        System.out.println("酬薪标准登记复核");
        // 页数，每页多少行~
        Page<SalaryStandard> p = new Page<>();
        p.setCurrent(page);
        p.setSize(limit);

        // 分页，带条件~
        return salaryStandardService.getSalaryStandardByPage(p, null);
    }

   // P_Registration.html
  @RequestMapping("/P_RegistrationReview")
    public List<SalaryStandard> getRegistrationReview() {

        List<SalaryStandard> list=salaryStandardService.fintBname();
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        return   list;
    }
    //P_RegistrationReviewSecond.html
        @RequestMapping("/P_RegistrationReviewSecond")
        public  List<SalaryStandard>  getRegistrationReviewSecond(String id){

              Integer i= Integer.parseInt(id);

       return salaryStandardService.fintChangeStatus(i);

        }

}

