cmake_minimum_required(VERSION 3.4.1)
#自己写的主库
add_library(
        qifengjs-lib
        SHARED
        qifengjs-lib.cpp)
#include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include)
target_include_directories(
        qifengjs-lib # 库名
        PRIVATE # 库属性
        ${CMAKE_SOURCE_DIR}/include # 头文件目录
)

#这个方法运行的时候会弹出一个提示第三方库找不到。
#add_library(substrate SHARED IMPORTED)
#set_target_properties(
#        substrate
#        PROPERTIES IMPORTED_LOCATION
#        ${CMAKE_SOURCE_DIR}/../jniLibs/armeabi/libsubstrate.so)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}")
# armeabi 换成 ${CMAKE_ANDROID_ARCH_ABI} 第三方库打包出来。
# 貌似gradle重新构建一下也会打包出来呢
# CMAKE_SOURCE_DIR 当前CMakeLists文件目录
#CMAKE_SOURCE_DIR 和 CMAKE_CURRENT_SOURCE_DIR 有什么区别？

#如果要依赖NDK中的系统库 在这里添加
find_library(
        log-lib
        log)

#这里可以配置多个库名称，就会生成多个so
target_link_libraries(
        qifengjs-lib
        substrate
        ${log-lib})


