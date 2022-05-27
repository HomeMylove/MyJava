# 反射

## 引出反射

> 问题

根据配置文件re.properties指定信息，创建对像并调用方法
```java
classfullpath=com.homemylove.Cat;  // 全路径
method=hi                          // 方法
```

Cat类

```java
public class Cat{
    private String name = "mimi";
    public void hi(){
        System.out.println("hi " + name);
    }
}
```

---

传统方法无法实现，必须使用反射

```java
public class ReflectionQuestion {
    public static void main(String[] args) throws InvocationTargetException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
//        简化读取的步骤
        String classsfullpath = "Cat";
        String methodName = "hi";

//        加载类，返回Class类型的对象cls
        Class cls = Class.forName(classsfullpath);
//        通过 cls 可以创建加载的类 Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass());  // class Cat
//        获取名为 “hi” 的方法对象
        Method method = cls.getMethod(methodName);
//        通过 “方法对象” 调用方法
        method.invoke(o);
    }
}
```

## 反射原理

### 反射介绍

1. 反射机制允许程序在执行期借助于ReflectionAPI取得任何类的内部信息（比如成员变量，构造器，成员方法等等，并能操作对像的属性及方法。反射在设计模式和框架底层都会用到。

2. 加载完类之后，在堆中就产生了一个Class类型的对像（一个类只有一个Class对象），这个对象包含了类的完整结构信息。通过这个对象得到类的结构。这个对像就像一面镜子，透过这个镜子看到类的结构，所以，形象地称之为：反射。

### Java 程序三个阶段

1. 代码阶段/编译阶段

   定义如下类

   ````java
   class Cat{
       private String name;   // 成员变量
       public Cat(){};        // 构造器
       public hi(){};         // 成员方法
       //...
   }
   ````

   经过 javac 的编译，生成 Cat.class 字节码文件

2. Class 类阶段(类加载阶段)

   在堆中创建一个 Class 类对象

   类似于:

   ```java
   成员变量 Field[] fields
   构造器  Constructor[] cons
   成员方法 Method[] ms
   ```

   在这里体现了反射

3. Runtime 运行阶段

   ````java
   Cat cat = new Cat();
   cat.hi();
   ````

   在堆中创建 Cat 对象时，它始终知道自己属于哪一个 Class 对象

### 反射机制的作用

1. 在运行时判断任意一个对像所属的类

2. 在运行时构造任意一个类的对象

3. 在运行时得到任意一个类所具有的成员变量和方法

4. 在运行时调用任意一个对象的成员变量和方法

5. 生成动态代理

## 反射相关类

1. java.lang.Class:代表一个类，Class对像表示某个类加载后在堆中的对像

2. java.lang.reflect.Method:代表类的方法

3. java.lang.reflect.Field:代表类的成员变量

   拿到字段

   ```java
   // Cat 类的定义
   public class Cat{
       private String name = "mimi";
       int age = 10;
   }
   ```

   ```java
   public class ReflectionField{
       public static void main(String[] args){
           Class cls = Class.forName("Cat");
           Object o = cls.newInstance();
           // 注意不能拿到 private 修饰的字段
           // Field nameField = cls.getField("name");  错的
           Field nameFiled = cls.getField("age");
           // 获取值
           System.out.println(nameField.get(o));
       }
   }
   ```

   

4. java.lang.reflect.Constructor:代表类的构造方法

   Cat 定义

   ```java
   public class Cat{
       private String name;
       public Cat(){};
       public Cat(String name){
           this.name = name;
       }
   }
   ```

   ```java
   public class ReflectionConstructor{
       public static void main(String[] args){
           Class cls = Class.forName("Cat");
           Object o = cls.newInstance();
           // 拿到无参构造器 Cat()
           Constructor constructor = cls.getConstructor();
           // 在() 中指定参数类型，拿到带参构造器 Cat(String name)
           Constructor constructor = cls.getConstructor(String.class);// 这里传入了String类的class类对象
       }
   }
   ```

## 反射调用优化

### 反射的优缺点

1. 优点：可以动态的创建和使用对象（也是框架底层核心），使用灵活，没有反射机制，框架技术就失去底层支撑。

2. 缺点：使用反射基本是解释执行，对执行速度有影响

### 调用优化

1. Method和Field、Constructor对象都有setAccessible()方法

2. setAccessible作用是启动和禁用访问安全检查的开关

3. 参数值为true表示反射的对像在使用时取消访问检查，提高反射的效率。

   参数值为false则表示反射的对象执行访问检查

   ---

   ```java
   public class ReflectionSetAccessible{
       public static void main(String[] args){
           //...
           Method method = cls.getMethod("hi");
           method.setAccessible(true);  // 取消访问检查
       }
   }
   ```

## Class 类

### Class 类分析

1. Class也是类，因此也继承Object类

2. Class:类对象不是new出来的，而是系统创建的

3. 对于某个类的Class类对像，在内存中只有一份，因为类只加载一次

4. 每个类的实例都会记得自己是由哪个Class实例所生成

5. 通过Class可以完整地得到一个类的完整结构，通过一系列API

6. Class对象是存放在堆的

7. 类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据（包括方法代码
   变量名，方法名，访问权限等等）https://www.zhihu.com/question/38496907

### Class 类常用方法

```java
public class ClassMethod{
    public static void main(String[] args) throws ClassNotFoundException{
        String classAllPath = "com.homemylove.Cat";
        // 1.获取 Cat 类对用的 Class 对象
        Class<?> cls = Class.forName(classAllPath);
        // 2.输出 cls
        System.out.println(cls); // 显示是哪个类的 Class 对象 com.homemylove.Cat
        System.out.println(cls.getClass());// 获取cls的运行类型 java.lang.Class
        // 3.获取包名
        System.out.println(cls.getPackage().getName()); // com.homemylove
        // 4.获取类名
        System.out.println(cls.getName);  // 获取全类名
        // 5.创建对象实例
        Cat cat = cls.newInstance();
        // 6.获取属性
        Field name = cls.getField("name");
        System.out.println(name.get(cat)); // 打印
        // 7.设置属性
        name.set(cat,"mimi");
        // 8.获取所有属性
        Field[] fields = cls.getFields();
    }
}
```

### 获取 Class 类对象六种方法

1. 前提：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取，可能抛出ClassNotFoundException

   ```java
   public class GetClass01{
       public static void main(String[] args) throws ClassNotFoundException{
           String classFullPath = "com.homemylove.Cat"; // 往往是读取出来的
           Class cls = Class.forName(classFullPath);
       }
   }
   ```

   > 应用场景：多用于配置文件，读取类全路径，加载类

2. 前提：若已知具体的类，通过类的class获取，该方式最为安全可靠，程序性能最高

   ```java
   public class GetClass02{
       public static void main(String[] args){
           Class cls = Cat.class;
       }
   }
   ```

   > 应用场景：多用于参数传递，比如通过反射得到对应构造器对象

3. 前提：已知对象实例，通过 getClass( )获取，实际上就是获取运行类型

   ```java
   public class GetClass03{
       public static void main(String[] args){
           Cat cat = new Cat();
           Class cls = cat.getClass(); 
       }
   }
   ```

4. 通过类加载器 ClassLoader 的 loadClass( ) 方法

   ```java
   public class GetClass04{
       public static void main(String[] args){
           //1.先得到类加载器
           ClassLoader classLoader = cat.getClass().getClassLoader();
           //2.获取 Class 对象
           Class cls = classLoader.loadClass(classFullPath);
       }
   }
   ```

5. 基本数据(int,char,boolean,float,double,byte,long,short)按如下方式得到Class类对象

   ```java
   public class GetClass05{
       public static void main(String[] args){
           Class<Integer> integerClass = int.class;
           Class<Character> characterClass = char.class;
           //...
       }
   }
   ```

6. 基本数据类型对应的包装类，可以通过.TYPE得到Class类对象

   ```java
   public class GetClass06{
       public static void main(String[] args){
           Class<Integer> type = Integer.TYPE;
       }
   }
   ```


### 动态加载和静态加载

> 反射机制是java实现动态语言的关键，也就是通过反射实现类动态动加载。

1. 静态加载：编译时加载相关的类，如果没有则报错，依赖性太强

2. 动态加载：
   运行时加载需要的类，如果运行时不用该类，则不报错，降低了依赖性

3. 举例说明

   假设没有Dog类

   ```java
   public class ClassLoad {
       public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
           Scanner scanner = new Scanner(System.in);
           System.out.println("输入key:");
           String key = scanner.next();
           switch (key){
               case "1":
                   Dog dog = new Dog();  // 编译错误，因为没有 Dog 类
                   dog.cry();
                   break;
               case "2":
                   Class cls = Class.forName("Dog");
                   Object o = cls.newInstance();
                   Method method = cls.getMethod("cry");
                   method.invoke(o);
                   break;
               default:
                   break;
           }
       }
   }
   ```

   因为 new Dog() 是静态加载，因此必须编写 Dog ，否则会报错

   Class.forName("Dog"); 是动态加载，所以没有编写 Dog 也不会报错，只有当执行到这句话的时候才会报错。

### 类加载时机

1. 当创健对象时(new)                               // 静态加载

2. 当子类被加载时 ，父类也会被加载   // 静态加载

3. 调用类中的静态成员时                        // 静态加载

4. 通过反射                                               // 动态加载

### 获取类的结构信息

#### java.lang.Class 类

定义如下两个类

```java
package com.homemylove;

class Animal{
    public String hobby;
    public void hi(){};
    public Animal();
}

class Person extends Animal{
    // 属性
    public String name;
    protected int age;
    String job;
    public double sal;
    // 构造器
    public Person(){};
    public Person(String name){};
    // 方法
    public void m1(){};
    protected void m2(){};
    void m3(){};
    private void m4(){};
}
```

拿到 Person 类的 Class 对象 personClass

1. getName(): 获取全类名

   ```java
   personClass.personClass.getName();  // com.homemylove.Person
   ```

2. getSimpleName(): 获取简单类名

   ```java
   personClass.personClass.getSimpleName();   // Person
   ```

3. getFields: 获取所有 public 修饰的字段（包括父类）

   ```java
   personClass.getFields();  // {name,hobby}
   ```

4. getDeclaredFields()：获取本类所有属性

   ```java
   personClass.getDeclaredFields();  // {name,age,job,sal}
   ```

5. getMethods(): 获取本类即父类的 public 修饰的方法

   ```java
   personClass.getMethods();  
   ```

6. getDeclaredMethods(): 获取本类的所有方法

   ```java
   personClass.getDeclaredMethods(); //{m1,m2,m3,m4}
   ```

7. getConstructors(): 获取本类所有 public 修饰的构造器

   ```java
   personClass.getConstructors();
   ```

8. getDeclaredConstructors(): 获取哦本类中所有构造器

9. getPackage();  获取包信息

10. getSuperClass(): 获取父类的信息

11. getInterfaces(): 获取接口信息

12. getAnnotations(): 获取注解信息

#### java.lang.reflect.Field 类

1. getModifiers:以int形式返回修饰符

   默认修饰符是0，

   public是1，

   private是2，

   protected是4，

   static是8，

   final是16

   > 组合关系会相加
   >
   > public static ==> 8
   >
   > public final  ==> 17

2. getType:以Class形式返回类型

3. getName:返回属性名

#### java.lang.reflect.Method类

1. getModifiers:以int形式返回修饰符
   默认修饰符是0，

   public是1，

   private是2，

   protected是4，
   static是8，

   final是16

2. getReturnType:以Class形式获取 返回类型

3. getName:返回方法名

4. getParameterTypes:以Class[]返回 参数类型数组

#### java.lang.reflect.Constructor 类

1. getModifiers:以int形式返回修饰符

2. getName:返回构造器名（全类名）

3. getParameterTypes:以Class返回参数类型数组

## 暴破

### 反射暴破创建实例

1. 方式一：调用类中的 public 修饰的无参构造器

2. 方式二：调用类中的指定构造器

3. Class类相关方法
   newlnstance：调用类中的无参构造器，获取对应类的对象
   getConstructor(Class class):根据参数列表，获取对应的public构造器对像
   getDecalaredConstructor(Class class):根据参数列表，获取对应的所有构造器对象

4. Constructor类相关方法
   setAccessible:暴破
   newInstance(Object obj):调用构造器

---

演示

```java
package com.homemylove;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1. 获取 User 类的 Class 对象
        Class<?> userClass = Class.forName("com.homemylove.User");
        // 2. 通过 public 无参构造器创建对象
        Object o1 = userClass.newInstance();
        System.out.println(o1);  // User{age=0, name='null'}
        // 3. 通过 public 有参构造器创建对象
        Constructor<?> constructor1 = userClass.getConstructor(String.class, int.class);
        Object yae = constructor1.newInstance("Yae", 500);
        System.out.println(yae);   // User{age=500, name='Yae'}
        // 4.通过 非public 的有参构造前创建对象
        Constructor<?> constructor2 = userClass.getDeclaredConstructor(String.class);
        constructor2.setAccessible(true);  // 暴破 使用反射访问私有构造器
        Object ei = constructor2.newInstance("Ei");
        System.out.println(ei);   // User{age=0, name='Ei'}
    }
}


class User{
    private int age;
    private String name;

    public User(){};
    public User(String name,int age){
        this.name = name;
        this.age = age;
    };
    private User(String name){
        this.name = name;
    };

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
```

### 反射暴破操作属性

```java
package com.homemylove;

import java.lang.reflect.Field;

public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获取 Student 类的 Class 对象
        Class<?> studentClass = Class.forName("com.homemylove.Student");
        // 获取实例
        Object o = studentClass.newInstance();
        // 获取 age 属性对象
        Field age = studentClass.getField("age");
        age.set(o,18);
        System.out.println(o);
        // 获取 name 属性对象
        Field name = studentClass.getDeclaredField("name");
        name.setAccessible(true);   // 暴破
        name.set(o,"Yae");
        System.out.println(o);
        
        // 如果是静态属性
        Field money = studentClass.getDeclaredField("money");
        money.setAccessible(true);
        money.set(null,100.0);
        System.out.println(money.get(null));
    }
}

class Student{
    public int age;
    private String name;
    private static double money;

    public Student(){}
    public Student(String name){}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
```

### 反射暴破操作方法

1. 根据方法名和参数列表获取Method方法对象：

   Method m = clazz.getDeclaredMethod(方法名，XX.class); //得到本类的任何方法

2. 获取对象：Object o=clazz.newlnstance();

3. 暴破：m.setAccessible(true):

4. 访问：Object returnValue=m.invoke(o,实参列表)；

5. 注意：如果是静态方法，则invoke的参数o,可以写成nul!

---

演示

```java
package com.homemylove;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1. 获取 Teacher 类的 Class 对象
        Class<?> teacherClass = Class.forName("com.home.Teacher");
        // 2. 创建对象
        Object o = teacherClass.newInstance();
        // 3.获取 hi 方法
        Method hi = teacherClass.getMethod("hi");
        hi.invoke(o);   // hi~
        // 4.获取 hello 方法
        Method hello = teacherClass.getDeclaredMethod("hello", String.class);
        hello.setAccessible(true);
        hello.invoke(null,"Ei");  // I'm Yae, hello~,Ei
    }
}

class Teacher{
    private static String name = "Yae";
    
    public Teacher(){}

    public void hi(){
        System.out.println("hi~");
    }
    private static void hello(String name){
        System.out.println("I'm "+ Teacher.name+", hello~," + name);
    }
}
```

