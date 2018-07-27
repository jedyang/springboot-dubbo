springboot的框架项目
整合多项技术  
api -- 对外暴露接口和模型  
service -- 业务处理逻辑，DAO等在这里。演示mysql，mongo，redis使用
web  -- 页面，controller层在这里  
provider -- 演示dubbo暴露服务，使用注解配置dubbo服务，演示了使用当当的ConfigTool  
consumer -- 演示dubbo消费服务，演示了使用xml配置dubbo服务，演示了使用当当的ConfigTool  
web、provider、consumer根据需要删减即可    

关于打包:
像api，service这种不是程序对外启动入口的，不要打包。即pom文件中，不要加
    
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
否则会找不到依赖。  

打出的jar包，直接java -jar运行即可。



