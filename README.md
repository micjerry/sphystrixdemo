验证Spring Service Hystrix方案


hystrix-circuit-backend 提供普通的rest服务，端口号8090;


hystrix-circuit-front 端口号8080，使用backend获取数据，并提供对外的rest服务，当backend异常时，使用fallback熔断方法直接返回数据。

   
验证：
   
    (1) 执行hystrix-circuit-backend
   
    (2) 执行hystrix-circuit-front
   
    (3) 执行curl http://localhost:8080/hystrix/front 返回backend提供的数据
           [root@5gtest /]# curl http://localhost:8080/hystrix/front
           {result:"normal"}
        停止hystrix-circuit-backend
        执行curl http://localhost:8080/hystrix/front 返回fallback方法提供的数据
          [root@5gtest /]# curl http://localhost:8080/hystrix/front
           {result:"BREAKER ENABLED"}
       
   
 
