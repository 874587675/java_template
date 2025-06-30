package com.dfg.java_template.framework.generate;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class MybatisPlusGenerateCode {

    private static final String PROJECT_PATH = System.getProperty("user.dir");  // 获取当前项目路径

    public static void main(String[] args) {
        // 生成的数据库表名
        List<String> tableNames = new ArrayList<>();
//        tableNames.add("t_user");
//        
//        tableNames.add("t_sys_user");
//        tableNames.add("t_sys_role");
//        tableNames.add("t_sys_user_role");
        tableNames.add("t_sys_menu");   
//        tableNames.add("t_sys_role_menu");
        
        generateCode(tableNames);
    }

    /**
     * 生成代码
     *
     * @param tableNames 要生成表名集合
     */
    public static void generateCode(List<String> tableNames) {
        // 数据库配置信息
        String url = "jdbc:mysql://localhost:3306/java_template?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";

        // 代码生成器配置
        FastAutoGenerator.create(url, username, password)
                // ========== 全局配置 ==========
                .globalConfig(builder -> {
                    builder.author("zgc") // 设置作者
                            .outputDir(PROJECT_PATH + "/src/main/java") // 输出目录（当前项目路径）
                            .disableOpenDir() // 生成后不打开目录
                            .enableSwagger() // 开启 Swagger 注解（可选）
                            .dateType(DateType.ONLY_DATE) // 使用 java.util.Date（默认 TIME_PACK）
                            .commentDate("yyyy-MM-dd HH:mm:ss") // 注释日期格式
                    ;
                })
                // ========== 包配置 ==========
                .packageConfig(builder -> {
                    builder.parent("com.dfg.java_template.business") // 父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, PROJECT_PATH + "/src/main/resources/mapper")) // XML 文件路径
                            .entity("entity") // 实体类包名
                            .mapper("mapper") // Mapper包名
                            .xml("mappers") // XML包名
                            .service("service") // Service包名
                            .serviceImpl("service.impl") // ServiceImpl包名
                            .controller("controller") // Controller包名
                    ;
                })
                // ========== 策略配置 ==========
                .strategyConfig(builder -> {
                    builder.addInclude(tableNames) // 要生成的表名
                            .addTablePrefix("t_") // 表前缀过滤（如 "t_" 会去掉表名的前缀）
                            .addFieldPrefix("f_") // 字段前缀过滤（可选）

                            // Entity 策略
                            .entityBuilder().javaTemplate("/templates/entity.java") // 设置实体类模板
                            .enableLombok() // 使用 Lombok
                            .enableFileOverride() // 覆盖已生成文件
                            .enableTableFieldAnnotation() // 字段注解 @TableField
                            .enableChainModel() // 链式模型（setter 返回 this）
                            .enableActiveRecord() // 启用 ActiveRecord 模式（可选）
                            .logicDeleteColumnName("is_deleted") // 逻辑删除字段（可选）
                            .versionColumnName("version") // 乐观锁字段（可选）
                            .formatFileName("%s") // 自定义实体类文件名

                            // Mapper 策略
                            .mapperBuilder().enableBaseResultMap() // 生成 ResultMap
                            .enableFileOverride() // 覆盖已生成文件
                            .enableBaseColumnList() // 生成 columnList
                            .formatMapperFileName("%sMapper") // 自定义 Mapper 文件名
                            .formatXmlFileName("%sMapper") // 自定义 XML 文件名

                            // Service 策略
                            .serviceBuilder().serviceTemplate("/templates/service.java") // 设置 Service 模板
                            .formatServiceFileName("%sService") // 自定义 Service 文件名
                            .serviceImplTemplate("/templates/serviceImpl.java") // 设置 ServiceImpl 模板
                            .formatServiceImplFileName("%sServiceImpl") // 自定义 ServiceImpl 文件名
//                            .enableFileOverride() // 覆盖已生成文件

                            // Controller 策略
                            .controllerBuilder().enableRestStyle() // 启用 REST 风格（@RestController）
                            .enableHyphenStyle() // URL 使用连字符（如 /user/list）
                            .formatFileName("%sController") // 自定义 Controller 文件名
//                            .enableFileOverride() // 覆盖已生成文件
                    ;
                })
                // ========== 模板引擎 ==========
                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 模板引擎
                .injectionConfig(builder -> {
                    builder.beforeOutputFile((tableInfo, objectMap) -> {
                                log.info("正在生成表: {}", tableInfo.getName());
                            }).customMap(new HashMap<String, Object>() {{
                                put("savePackage", "com.dfg.java_template.business.param.save");
                                put("updatePackage", "com.dfg.java_template.business.param.update");
                                put("queryPackage", "com.dfg.java_template.business.param.query");
                                put("voPackage", "com.dfg.java_template.business.param.vo");
                                put("listPackage", "com.dfg.java_template.business.param.list");
                                put("pagePackage", "com.dfg.java_template.business.param.page");
                                put("convertorPackage", "com.dfg.java_template.business.param.convertor");
                            }})
                            .customFile(consumer -> {
                                consumer.fileName("SaveParam.java").templatePath("/templates/save.java.ftl").packageName("param.save").enableFileOverride();
                            }).customFile(consumer -> {
                                consumer.fileName("UpdateParam.java").templatePath("/templates/update.java.ftl").packageName("param.update").enableFileOverride();
                            }).customFile(consumer -> {
                                consumer.fileName("QueryParam.java").templatePath("/templates/query.java.ftl").packageName("param.query").enableFileOverride();
                            }).customFile(consumer -> {
                                consumer.fileName("VO.java").templatePath("/templates/vo.java.ftl").packageName("param.vo").enableFileOverride();
                            }).customFile(consumer -> {
                                consumer.fileName("ListParam.java").templatePath("/templates/list.java.ftl").packageName("param.list").enableFileOverride();
                            }).customFile(consumer ->{
                                consumer.fileName("PageParam.java").templatePath("/templates/page.java.ftl").packageName("param.page").enableFileOverride();
                            }).customFile(consumer -> {
                                consumer.fileName("Convertor.java").templatePath("/templates/convertor.java.ftl").packageName("param.convertor").enableFileOverride();
                            });
                }).execute(); // 执行生成
    }
}
