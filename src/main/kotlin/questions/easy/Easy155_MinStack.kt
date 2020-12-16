package questions.easy

import java.util.*

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) // return -3
    minStack.pop()
    println(minStack.top()) // return 0
    println(minStack.getMin()) // return -2
}

// Time complexity: O(1)
// Space complexity: O(n), being n the amount of inserted elements
class MinStack {
    private val s1 = Stack<Int>()
    private val s2 = Stack<Int>()

    fun push(x: Int) {
        s1.add(x)
        if (s2.isEmpty()) s2.add(x)
        else s2.add(Math.min(x, s2.peek()))
    }

    fun pop() {
        s1.pop()
        s2.pop()
    }

    fun top() = s1.peek()

    fun getMin() = s2.peek()

}
