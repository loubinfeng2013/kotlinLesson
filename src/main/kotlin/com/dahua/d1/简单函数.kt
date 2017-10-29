package com.dahua.d1

/**
 * Created by loubinfeng on 2017/10/29.
 */

/**
 * kotlin中的函数申明
 * fun [函数名](参数列表):[返回值类型]{函数体}
 * 也可以是
 * fun [函数名](参数列表) = [表达式]
 *
 * 在kotlin中，函数可以理解成一个类型，跟String，Int一样，可以被赋值，传递
 */
/**
 * add函数就是一个标准的函数，拥有最完整的函数结构
 */
fun add(a: Int, b: Int): Int {
    return a + b
}

/**
 * 可以将函数add简写成fun add2(a: Int, b: Int) = a + b
 */

/**
 * Unit类型可以理解成java中void类型，当没有返回值的时候，Unit作为返回值类型使用,可以省略
 *
 * fun add_print(a: Int, b: Int){
 *  println(a + b)
 *   }
 */
fun add_print(a: Int, b: Int): Unit {
    println(a + b)
}

fun main(args: Array<String>) {
    println(add(1, 2))
    add_print(2, 3)
    /**
     * 也可以做函数直接赋值给变量进行使用
     */
    val add2 = fun(a: Int, b: Int): Int { return a + b }
    println(add2(2,5))
}