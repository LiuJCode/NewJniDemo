JNI注册native方法：
注册native大概总结下就是JAVA类中的native方法在CPP/C中生成对应的方法。
1.静态注册
    生成的方法都是以包名、类名、方法名组成，其之间的点用下划线代替，包名、类名、方法名都必须与java文件中声明的native方法完全一致。
    比如：extern "C" JNIEXPORT jstring JNICALL Java_com_qxt_myapp_MainActivity_stringFromJNI(JNIEnv* env, jobject  ) {
           std::string hello = "Hello from C++";
           return env->NewStringUTF(hello.c_str());
       }
2.动态注册
    本demo使用的是静态方式
    参考地址：https://blog.csdn.net/u013564742/article/details/86530791

创建JNI工程，new->new Project->Select a Project templet 选择最后的Native C++
实现步骤：
1.先写C++层代码实现
    (1).建立一个demo.h文件，声明C++要实现的函数（头文件）
    (2).建立demo.cpp文件，实现C++具体代码逻辑（该文件引用并实现头文件定义的函数）
    (创建一个新的C++类，会默认.h和.cpp文件一起创建，一个是头文件，一个是实现文件)
2.创建Demo-lib.cpp文件
    这个文件主要是用来实现java层的Native方法（JNI代码），java层调用C层的桥梁，官方推荐命名为xx-lib.
3.修改CMakeLists.txt
    （1）新增一个add_library代码块（直接复制好了）,替换库名字
    （2）再在target_link_libraries中添加这个库的名称即可
4.添加java native方法接口
    创建一个接口类，定义Native方法
5.编写JNI函数
    意思就是说第4项定义的java Native方法需要转换成JNI函数。
    （1）.可以按照cd参考格式在（第2项文件）中手写，（大概格式是包名+方法名）
    （2）.通过命令生成.h文件，再复制到（第2项）创建的文件中。
        a.AS在Terminal控制台，进入定义的Demo.java的Native文件目录
        b.执行 ‘javac Demo.java’,(如果报错证明类中有中文，可以去除中文)
        c.执行完后，目录下会生成Demo.class
        d.切回到工程的java目录，执行‘javah -classpath . -jni 包名+文件名’ 生成.h文件
            (比如：javah -classpath . -jni com.my.myjni.jni.Demo)
        e.将生成的.h文件内容复制到（第二项创建的文件中），这时候Demo.java中的方法名称不再是红色（表示生成的方法和配置正确） (需要make Project 一下才能不显示红色)
6.实现JNI函数调用C++函数实现逻辑
    (1).在JNI层次（第二项创建的文件）引入C++逻辑类 （demo.cpp）
    (2).修改生成的jni函数的参数，跟java层的Native方法参数一致
7.在Android中调用Native方法即可。


JNI学习demo,学习如何配置工程