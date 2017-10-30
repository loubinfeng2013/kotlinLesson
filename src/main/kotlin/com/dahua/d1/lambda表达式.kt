package com.dahua.d1

/**
 * lambda表达式就是匿名函数，只不过进一步的简写，kotlin内部定义来许多常用的高级函数
 * filter函数用来过滤
 * map函数用来批量处理
 * forEach函数用来遍历
 */

fun main(args: Array<String>) {
    val array = arrayOf("aa", "bb", "cc", "abc", "bc")
    /**
     * 第一步，过滤元素里面含"a"
     * 第二步，将所有元素改成大写
     * 第三步，打印所有元素
     */
    array.filter { it.contains("a") }.map { it.toUpperCase() }.forEach { println(it) }

    /**
     * filter函数的定义
     *
     * public inline fun <T> Array<out T>.filter(predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList<T>(), predicate)
    }

    这是一个Array类的扩展内联函数，它的入参接受一个T类型返回一个Boolean类型，函数返回一个List T类型
     */

    /**
     * map函数的定义
     *
     * public inline fun <T, R> Iterable<T>.map(transform: (T) -> R): List<R> {
    return mapTo(ArrayList<R>(collectionSizeOrDefault(10)), transform)
    }

    这是Iterable类的扩展内联函数，它的入参接受一个T类型,返回一个R类型，函数返回一个List R类型
     */

    /**
     * foreach函数的定义
     *
     * public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit {
    for (element in this) action(element)
    }

    这同样是一个Iterable类的扩展内联函数，它的入参接受一个T类型，返回一个Unit类型,函数返回一个Unit类型，所以foreach函数要放在最后面
     */

    var s = Student("lili",20)
    s.filter { it.age > 15 }?.todo { println("${it.name}-${it.age}") }
    s.filter { it.age > 20 }?.todo { println("${it.name}-${it.age}") }
}

class Student(var name:String, var age:Int){
    fun filter(action:(Student)->Boolean):Student?{
        return if(action(this)){ this }else{ null }
    }

    fun todo(action:(Student)->Unit):Unit{
        action.invoke(this)
    }
}