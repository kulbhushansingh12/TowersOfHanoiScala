package com.kb.apps
import scala.collection.mutable.Stack
import com.kb.app.util.MyStackListImpl

class TowerOfHanoiClass(towers: Array[MyStackListImpl[Int]], map: Map[Int, String]) {

  def moveOneDisk(from: Int, to: Int): Unit = {
    if (!towers(from).isEmpty) {
      //This defines the valid move
      if (towers(to).isEmpty || towers(from).peek < towers(to).peek) {
        towers(to).push(towers(from).pop()) //add the popped element with the the top element of from stack
      }
    }
  }

  def moveDisks(from: Int, to: Int, n: Int): Unit = {
    if (n == 1) {
      println("Disk 1 from " + map(from) + " to " + map(to))
      moveOneDisk(from, to)
    } else {
      val other = 3 - from - to
      moveDisks(from, other, n - 1)
      println("Disk " + n + " from " + map(from) + " to " + map(to))
      moveOneDisk(from, to)
      moveDisks(other, to, n - 1)
    }
  }
}

object TowerOfHanoiWith {
  def main(args: Array[String]): Unit = {
    try {
      val numOfRods = args(0).toInt
      if (numOfRods == 0 || numOfRods < 0 || numOfRods > 2147483647) {
        println("Please enter number of disks which is greater than 0 and less than 2147483647")
        System.exit(0);
      }
      val towers = createArrayOfStacks(numOfRods)
      //val rods = Array((1 to numOfRods).toList, Nil, Nil)
      val map = Map[Int, String](0 -> "A", 1 -> "B", 2 -> "C")
      val tohc = new TowerOfHanoiClass(towers, map)
      println("Tower From "+towers(0))
      println("Tower To "+towers(2))
      tohc.moveDisks(0, 2, args(0).toInt)
      println("Tower From "+towers(0))
      println("Tower To "+towers(2))
    } catch {
      case nfe: NumberFormatException => {
        println("Please enter valid number of disk")
        System.exit(0);
      }
      case exc: Exception => {
        println("Error Occured while processing the towers")
        exc.printStackTrace()
      }
    }
  }
  def createArrayOfStacks(num: Int): Array[MyStackListImpl[Int]] = {
    val stk1: MyStackListImpl[Int] = new MyStackListImpl[Int]
    val stk2: MyStackListImpl[Int] = new MyStackListImpl[Int]
    val stk3: MyStackListImpl[Int] = new MyStackListImpl[Int]
    println("created stack "+num)
    var x = 0
    for (x <- num to 1 by -1) {
      stk1.push(x.asInstanceOf[scala.Int])
    }
    
    Array(stk1, stk2, stk3)
  }

}
