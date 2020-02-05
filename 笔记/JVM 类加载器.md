# JVM 类加载器

- 在Java代码中，类型的加载、连接与初始化过程都是在程序运行期间完成的。
- 提供了更大的**灵活性，增加了更多的可能性（**加载时稍微增加了一些性能开销**）。**

##### 类在虚拟机中的生命周期包括：加载、验证、准备、解析、初始化、使用、卸载。

<svg width="684" height="299" xmlns="http://www.w3.org/2000/svg"><path d="M25 79q0-4 4-4h92q4 0 4 4v62q0 4-4 4H29q-4 0-4-4z" stroke="#323232" stroke-width="2" fill="#fff"/><text font-family="微软雅黑" text-anchor="middle" font-size="18" fill="#323232" font-weight="400" y="20.8" transform="translate(25 75)"><tspan dy="22" x="50"><tspan>加载</tspan></tspan></text><path d="M524 208q0-4 4-4h92q4 0 4 4v62q0 4-4 4h-92q-4 0-4-4z" stroke="#323232" stroke-width="2" fill="#fff"/><text font-family="微软雅黑" text-anchor="middle" font-size="18" fill="#323232" font-weight="400" y="20.8" transform="translate(524 204)"><tspan dy="22" x="50"><tspan>初始化</tspan></tspan></text><path d="M360 208q0-4 4-4h92q4 0 4 4v62q0 4-4 4h-92q-4 0-4-4z" stroke="#323232" stroke-width="2" fill="#fff"/><text font-family="微软雅黑" text-anchor="middle" font-size="18" fill="#323232" font-weight="400" y="20.8" transform="translate(360 204)"><tspan dy="22" x="50"><tspan>使用</tspan></tspan></text><path d="M192 208q0-4 4-4h92q4 0 4 4v62q0 4-4 4h-92q-4 0-4-4z" stroke="#323232" stroke-width="2" fill="#fff"/><text font-family="微软雅黑" text-anchor="middle" font-size="18" fill="#323232" font-weight="400" y="20.8" transform="translate(192 204)"><tspan dy="22" x="50"><tspan>卸载</tspan></tspan></text><path d="M192 79q0-4 4-4h92q4 0 4 4v62q0 4-4 4h-92q-4 0-4-4z" stroke="#323232" stroke-width="2" fill="#fff"/><text font-family="微软雅黑" text-anchor="middle" font-size="18" fill="#323232" font-weight="400" y="20.8" transform="translate(192 75)"><tspan dy="22" x="50"><tspan>验证</tspan></tspan></text><path d="M360 79q0-4 4-4h92q4 0 4 4v62q0 4-4 4h-92q-4 0-4-4z" stroke="#323232" stroke-width="2" fill="#fff"/><text font-family="微软雅黑" text-anchor="middle" font-size="18" fill="#323232" font-weight="400" y="20.8" transform="translate(360 75)"><tspan dy="22" x="50"><tspan>准备</tspan></tspan></text><path d="M524 79q0-4 4-4h92q4 0 4 4v62q0 4-4 4h-92q-4 0-4-4z" stroke="#323232" stroke-width="2" fill="#fff"/><text font-family="微软雅黑" text-anchor="middle" font-size="18" fill="#323232" font-weight="400" y="20.8" transform="translate(524 75)"><tspan dy="22" x="50"><tspan>解析</tspan></tspan></text><path d="M161 29q0-4 4-4h490q4 0 4 4v131q0 4-4 4H165q-4 0-4-4z" stroke="#323232" stroke-width="2" fill="none"/><g><path d="M330 25h160v40H330z" fill="none"/><text font-family="微软雅黑" text-anchor="middle" font-size="18" fill="#323232" font-weight="400" y="5.8" transform="translate(330 25)"><tspan dy="22" x="80"><tspan>连接</tspan></tspan></text></g><g><path d="M130 103.88h15.4V92l12.6 18-12.6 18v-11.88H130v-12.24z" stroke="#323232" stroke-width="2" fill="#cfcfcf"/></g><g><path d="M337 245.12h-15.4V257L309 239l12.6-18v11.88H337v12.24z" stroke="#323232" stroke-width="2" fill="#cfcfcf"/></g><g><path d="M580.12 172v15.4H592L574 200l-18-12.6h11.88V172h12.24z" stroke="#323232" stroke-width="2" fill="#cfcfcf"/></g><g><path d="M479 103.88h15.4V92l12.6 18-12.6 18v-11.88H479v-12.24z" stroke="#323232" stroke-width="2" fill="#cfcfcf"/></g><g><path d="M309 103.88h15.4V92l12.6 18-12.6 18v-11.88H309v-12.24z" stroke="#323232" stroke-width="2" fill="#cfcfcf"/></g><g><path d="M507 245.12h-15.4V257L479 239l12.6-18v11.88H507v12.24z" stroke="#323232" stroke-width="2" fill="#cfcfcf"/></g></svg>
#### 加载：

查找并加载类的二进制数据。类的加载的最终产品是位于内存找那个的class对象

有两种类型的类加载器

1. java虚拟机自带的加载器
  - 根类加载器（Bootstrap）
  - 扩展类加载器（Extension）
  - 系统（应用）类加载器（System）
2. 用户自定义的类加载器
  - java.lang.ClassLoader的子类
  - 用户可以定制类的加载方式

> 类加载器在预料到某个类将要被使用时就预先加载它，如果在预先加载的过程中遇到了.class文件确实或存在错误，类加载器必须在程序**首次主动使用**该类是才报告错误（LinkageError）

#### 获取ClassLoader的途径

- 获得当前类的ClassLoader

​        `clazz.getClassLoader();`

- 获得当前线程上线文的ClassLoader

​        `    Thread.currentThread().getContextClassLoader();`

- 获得系统的ClassLoader

​        `ClassLoader.getSystemClassLoader()`

- 获得调用者的ClassLoader

​        `DriverManager.getCallerClassLoader()`

#### 验证：

#### 准备： 
为类的静态变量分配内存，并将其初始化为默认值。但时在到达初始化之前，类变量都没有初始化为真正的初始值
#### 解析：
在类型的常量池中寻找类、接口、字段和方法的符号引用，把这些*符号引用*转换为*直接引用*
#### 初始化：
把类的静态变量赋予正确的*初始值*

Java程序对类的使用方式分为两种：

- 主动使用
- 被动使用

所有的Java虚拟机实现必须在每个类或接口被Java程序“ **首次主动使用** ”时才初始化他们。

##### 主动使用（七种）有且只有

1. 创建类的实例 
2. 访问某个类或接口的静态变量，或者对该静态变量赋值 
3. 调用类的静态方法 
    - 以上三种在jvm中表示为 使用 new、getstatic、putstatic或invokestatic这四个字节码指令时，如果类没进行初始化，则需要先触发初始化
4. 反射（如Class.forName(“com.test.Test”)) 
5. 初始化一个类的子类 
6. java虚拟机启动时被标明为启动类的类
7. JDK1.7开始提供的动态语言支持
  