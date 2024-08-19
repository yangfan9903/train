作业: 1.git.ignore文件是配置到整个工程中的,不是每个子模块,搜一下资料看看全局怎么配置 
     2.学习lombok注解常用的用法,废弃sout.println,用log代替,熟悉常见的链式和构造者模块创建类 
     3.了解完基本的类的用法,熟悉反射如何使用? 
     4.集合如何排序,熟悉集合的常用方法

1.将git.ignore目录移到根目录就可以完成整个工程的配置,全局配置可以使用git config --global core.excludesfile ~/.gitignore_global
2.builderdemo练习了常见的建造者模块创建类,builddemo2练习了链式和建造者创建类,collectiondemo练习了注解的使用以及log.info的日志答应输出
3.反射的基本作用，可以获取类的全部成分,成员变量,构造器,方法等,可以破坏私有的封装性通过setAccessible(true)来修改私有变量的值,可以获取类的成员变量,构造器,方法等,可以修改私有的封装性通过setAccessible(true)来修改私有变量的值,可以获取类的成员变量,构造器,方法等,可以修改私有的封装性通过setAccessible(true)来修改私有变量
还可以绕过泛型约束,对于特定类型的集合,通过反射可以加入不同类型的参数,先拿到集合的Class,然后获取对应的add方法,然后反射调用add方法添加参数。反射还适合做java
的框架，通过反射的特性设置一些功能,反射是很多框架的底层技术
4.集合排序,集合排序的常用方法有Collections.sort(list),list.sort(comparator),还有stream流的方式


