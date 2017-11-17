package com.dahua.d2

/**
 * koltin提供来一个init的初始化函数来供我们编译一些初始化的代码，在类实例创建时自动调用
 */
class A {
    var name: String

    var age :Int = 10

    init {
        this.name = "123"
        println("init-${name}")
    }
}

/**
 * kotlin的init函数将在构造函数之前调用
 */
class B{
    init {
        println("init")
    }

    constructor(){
        println("constructor")
    }
}

/**
 * kotlin的类默认会有一个无参的构造防范，也可以自己重载构造方法
 */
class C{
    var name:String = ""

    var age:Int = 0

    constructor(){
        println("no params")
    }

    constructor(name:String){
        this.name = name
    }

    constructor(name: String,age:Int){
        this.name = name
        this.age = age
    }
}

/**
 * 当构造函数跟在类名后面，那这个构造函数被称为主构造函数，如果主构造函数没有注解修饰可以直接省略constructor关键字
 * class D constructor(var name: String,var age: Int)
 */
class D(var name: String,var age: Int)

/**
 * 如果类有一个主构造函数，无论有无参数，每个次构造函数需要直接或间接委托给主构造函数，用this关键字
 */
class E(){
    var name:String = "1"
    var age:Int = 1

    constructor(name: String):this(){
        this.name = name
    }

    constructor(age: Int):this(){
        this.age = age
    }
}

fun main(vararg args:String){
    //var a : A = A()
    var b : B = B()

}