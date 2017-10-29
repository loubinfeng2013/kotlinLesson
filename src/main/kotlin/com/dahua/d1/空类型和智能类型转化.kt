package com.dahua.d1

/**
 * Created by loubinfeng on 2017/10/29.
 */

/**
 *  空类型保护是kotlin中特有的语言特性
 *  String:字符串类型
 *  String?:字符串可空类型
 *  String类型的变量可以给String?类型的变量赋值，反之无效
 *
 *  空类型保护能大大减低程序空指针崩溃发生的概率
 * */

fun main(args : Array<String>){
    var string1 : String = "aaa"
    var string2 : String? = "bbb"
    //string1 = string2 编译通不过
    //string2 = string1 编译通过
    println(string1.length)
    println(string2?.length)//如果对象是null,调用其方法也是null
    println(string2!!.length)//这种写法表示使用该对象时放弃空类型保护 Exception in thread "main" kotlin.KotlinNullPointerException

    /**
     * kotlin中用is关键字来判断类型是否一致，跟java中的instanceof有相同的作用，但是kotlin比java多做了一步，
     * 当is结果为true时，会将对象实例自动转化，这样我们就省去了强转的工作了
     */
    var p : Person = Man(1,"man")
    if (p is Man)
        println(p.a)
    else if(p is Woman)
        println(p.b)
    /**
     * 虽然kotlin有智能转化的功能，这并不代表不需要强转语法，这要是使用关键字as
     */
    var m : Man = p as Man //编译通过，运行通过
    //var w : Woman = p as Woman //编译通过，运行失败
    var w : Woman? = p as? Woman //当不确定类型时，可使用空类型保护
}

/**
 * 智能类型转化
 */
abstract class Person(var name:String)
class Man(var a:Int,name: String):Person(name)
class Woman(var b:Int,name: String):Person(name)