package com.kb.apps
class TowerOfHanoiClass(rods: Array[List[Int]], map: Map[Int,String]) {

  def moveOneDisk(from: Int, to: Int): Unit = {
    //this condition make sure the move is legal and only place where the lists are being modified
    if (rods(to).isEmpty || rods(from).head < rods(to).head) {
      rods(to) ::= rods(from).head // place the element to "to" list
      rods(from) = rods(from).tail // replace the head element of from list
    }
  }

  def moveDisks(from: Int, to: Int, n: Int): Unit = {
    if (n == 1) {
      println("Disk 1 from "+ map(from) + " to " + map(to))
      moveOneDisk(from, to)
    } else {
      val other = 3 - from - to
      moveDisks(from, other, n - 1)
      println("Disk "+ n + " from " + map(from) + " to " + map(to))
      moveOneDisk(from, to)
      moveDisks(other, to, n - 1)
    }
  }
}

object TowerOfHanoiWith {
  def main(args: Array[String]): Unit = {
    try{
     val numOfRods = args(0).toInt
     if(numOfRods ==0 || numOfRods <0 || numOfRods >2147483647)
     {
       println("Please enter number of disks which is greater than 0 and less than 2147483647")
       System.exit(0);
     }
     val rods = Array((1 to numOfRods).toList, Nil, Nil)
     val map = Map[Int,String](0->"A", 1->"B", 2->"C")
    val tohc = new TowerOfHanoiClass(rods, map)
    tohc.moveDisks(0, 2, args(0).toInt)
     }catch{
       case nfe:NumberFormatException =>{         
          println("Please enter valid number of disk")
          System.exit(0);
       }
       case exc:Exception =>{
         println("Error Occured while processing the towers")
         exc.printStackTrace()
       }
    }
  }

}
