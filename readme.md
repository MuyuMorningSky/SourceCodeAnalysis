### mapperProxyFactory：
```
MyBatis添加的Mapper的操作实际上添加的是MapperProxyFactory，这个是MapperProxy的工厂类，但是MapperProxyFactory生产的也不是MapperProxy，而是Mapper的Proxy代理。
使用的InvocationHandler是MapperProxy，MapperProxy的invoke方法实际上是把Mapper接口方法包装为了MapperMethod，并执行的MapperMethod的execute方法。
MapperMethod处理的逻辑是Mapper方法与xml中的SQL的一些映射关系
```