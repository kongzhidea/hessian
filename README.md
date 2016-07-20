# hessian

hessian 序列化
hessian rpc调用，集成spring，tomcat

mvn 中央仓库没有jar包，安装jar包到本地：
mvn install:install-file -DgroupId=hessian -Dar tifactId=hessian -Dversion=3.1.5 -Dpackaging=jar -Dfile=hessian-3.1.5.jar

序列化对象 要实现   Serializable接口，以及定义serialVersionUID。