package com.dahua.d1

/**
 * kotlin中也使用try{}catch(Exception){}finally{}语句来处理异常捕获
 * 跟其他控制语句一样，也可以作为表达式使用
 */

fun main(args : Array<String>){
    var s = ""
    try {
        s.toInt()
    }catch (e : Exception){
        println(e.message)
    }finally {
        println("over")
    }

    var msg = try {
        s.toInt()
    }catch (e : Exception){
        e.message
    }finally {
        println("over2")
    }
    println(msg)
}