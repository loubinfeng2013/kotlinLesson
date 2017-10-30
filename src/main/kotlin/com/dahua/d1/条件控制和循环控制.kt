package com.dahua.d1
/**
 * 条件语句是用来控制流程
 * 条件表达式是用来赋值
 */

fun main(args : Array<String>){
    /**
     * if条件语句
     */
    if(args.size == 0)
        println("no args")
    else
        println("args's number is ${args.size}")

    /**
     * if条件表达式
     */
    var toast : String = if (args.size == 0){ "no args"}else{ "args's number is ${args.size}"}
    println(toast)

    /**
     * 总结：kotlin中用if关键字做条件控制，跟java的不同点就是可以作为条件表达式使用，在函数式编程中很方便
     */

    /**
     * when条件语句
     */
    when(args[0]){
        is String -> println("is String")
        "1" -> println("args[0] is 1")
        in arrayOf("1","2") -> println("args[0] in ['1','2']")
        else -> println("no message")
    }

    /**
     * when条件表达式
     */
    var msg = when(args[0]){
        is String -> "is String"
        "1" -> "args[0] is 1"
        in arrayOf("1","2") -> "args[0] in ['1','2']"
        else -> "no message"
    }
    println(msg)
    /**
     * 总结：kotlin中用when关键字来替代switch，而且是switch的加强版，灵活度很高
     */

    /**
     * 循环语句，一般情况下，我们用for...in语句迭代对象,也可以用while,do...while语句，使用方法跟java一样。
     * 除此之外，kotlin内置了foreach等高阶函数来帮助迭代
     */
    var array = intArrayOf(1,2,3,4,5,6,7,8,9)
    for (i in array){
        println("$i")
    }

    println("-----------")
    /**
     * for...in语句的工作原理,遍历的是不是对象本身，而是对象内部的迭代器，只要循环的对象有iterator方法，
     * 并返回一个正常的迭代器就能使用for...in遍历,其实for...in就是一个操作符重载
     */
    val myArray : MyIntArray = MyIntArray()
    myArray.add(2)
    myArray.add(4)
    myArray.add(6)
    myArray.add(8)
    myArray.add(1)
    for (i in myArray){
        println("$i")
    }
}

/**
 * 自定义IntArray，内部用一个可变的list存储对象，操作符重写，返回一个MyIterator对象，用于迭代
 */
class MyIntArray{

    private val list : MutableList<Int> = mutableListOf()

    fun add(i:Int){
        list.add(i)
    }

    fun remove(i: Int){
        list.remove(i)
    }

    operator fun iterator():MyIterator{
        return MyIterator(list.iterator())
    }
}

/**
 * 自定义迭代器，只是做一层包装，内部用的还是IntArray的迭代器
 */
class MyIterator(var iterator: Iterator<Int>){
    operator fun next(): Int{
        return iterator.next()
    }

    operator fun hasNext(): Boolean{
        return iterator.hasNext()
    }
}