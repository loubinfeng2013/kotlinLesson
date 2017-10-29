package com.dahua.d1

/**
 * Created by loubinfeng on 2017/10/29.
 */

const val BUILD_VAL = "buildVal"//编译期常量

fun main(args : Array<String>) {

    /**
     * 在kotlin中，
     * val用来修饰常量，这个常量并不是编译器常量，可以理解成一个不可变的变量
     * var用来修饰变量
     * 不管是常量，还是变量，都支持类型推导
     */
    val a: String = "a"//声明了一个叫做a的常量，内容为“a”，类型是String
    //a = "a2" 编译错误,常量不能修改
    var b: Int = 1//声明了一个叫做b的变量，内容是1，类型是1
    b = 2//被成功赋值为2
    //b = "b" 变量也不能被赋值成其他类型的值
    var c = false//变量c没有指定类型，但是通过对其赋值，可以推断出事布尔类型，这就是智能推导


}