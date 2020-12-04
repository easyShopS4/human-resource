package com.hr.ssm.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * @author echo lovely
 * @date 2020/12/4 19:54
 */

public class CodeGenerator {

    public static void main(String[] args) {
        System.out.println("=======Generator Start=========");
        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // 此处建议写项目/src/main/java源代码的绝对路径
        // gc.setOutputDir(projectPath+"\\src\\main\\java");
        gc.setOutputDir("E:\\HRShcool\\s4\\project\\human-resource");
        // 生成注释时的作者
        gc.setAuthor("jz_lee");
        //生成后是否打开资源管理器
        gc.setOpen(false);
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        gc.setIdType(IdType.AUTO); //主键策略
        gc.setDateType(DateType.ONLY_DATE); //定义生成的实体类中日期类型
        // 如果开启Swagger,要引入相应的包
        //gc.setSwagger2(true); //开启Swagger2模式

        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://47.99.161.195:3310/human_resource?serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        // 此处要注意：parent + moduleName 为包的名字，在这个包下，创建对应的controller...
        pc.setParent("com.hr");
        pc.setModuleName("ssm"); //模块名

        pc.setController("controller");
        // pc.setEntity("entity");
        // pc.setService("service");
        // pc.setMapper("mapper");
        //mapper映射文件所放目录
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库中表的名字，表示要对哪些表进行自动生成controller service、mapper...
        // 不设置的时候表示当前数据库下所有表
        String[] tabList =  new String[]{
                "bonus", "config_file_first_kind", "config_file_second_kind", "config_file_third_kind",
                "config_major", "config_major_kind", "config_primary_key",
                "config_public_char", "config_question_first_kind", "config_question_second_kind",
                "engage_answer", "engage_answer_details", "engage_exam",
                "engage_exam_details", "engage_interview", "engage_major_release", "engage_resume",
                "engage_subjects", "human_file", "human_file_dig", "major_change",
                "salary_grant", "salary_grant_details", "salary_standard", "salary_standard_details",
                "training", "users"
        };
        strategy.setInclude(tabList);
        // 数据库表映射到实体的命名策略,驼峰命名法
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 生成实体时去掉表前缀，比如edu_course，如果不加下面这句，生成的实体类名字就是：EduCourse
        // strategy.setTablePrefix("db_");
        // 生成实体时去掉表前缀
        //  strategy.setTablePrefix(pc.getModuleName() + "_");

        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();

        System.out.println("=======Generator End=========");
    }

}
