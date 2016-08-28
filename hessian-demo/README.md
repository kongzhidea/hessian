# hessian

hessian 序列化
hessian rpc调用，集成spring，tomcat

mvn 中央仓库没有jar包，安装jar包到本地：
mvn install:install-file -DgroupId=hessian -Dar tifactId=hessian -Dversion=3.1.5 -Dpackaging=jar -Dfile=hessian-3.1.5.jar

序列化对象 要实现   Serializable接口，以及定义serialVersionUID。

HessianProxyFactoryBean 客户端集成spring

```code
<bean id="hessianService" class="org.springframework.remoting.caucho.HessianProxyFactoryBean">
    <property name="serviceUrl" value="${serverUrl}" />
    <property name="serviceInterface" value="com.kk.HessianService" />
    <property name="username" value="" />
    <property name="password" value="" />
</bean>
```

#### hessian auth验证
* 使用CustomHessianServlet，继承HessianServlet
* String auth = httpServletRequest.getHeader("Authorization");
* 去前缀，再base64解码
* 客户端调用, factory.setUser(), factory.setPassword()

#### hessian集成spring-mvc
* hessian-springmvc

