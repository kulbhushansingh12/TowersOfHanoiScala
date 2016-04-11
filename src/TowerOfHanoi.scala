class TowerOfHanoiClass(rods: Array[List[Int]]) {

  def moveOneDisk(from: Int, to: Int): Unit = {
    //this condition make sure the move is legal and only place where the lists are being modified
    if (rods(to).isEmpty || rods(from).head < rods(to).head) {
      rods(to) ::= rods(from).head // place the element to "to" list
      rods(from) = rods(from).tail // replace the head element of from list
    }
  }

  def moveDisks(from: Int, to: Int, n: Int): Unit = {
    if (n == 1) {
      println("Disk 1 from "+ from + " to " + to);
      moveOneDisk(from, to)
    } else {
      val other = 3 - from - to
      moveDisks(from, other, n - 1)
      println("Disk "+ n + " from " + from + " to " + to);
      moveOneDisk(from, to)
      moveDisks(other, to, n - 1)
    }
  }
}

object TowerOfHanoiWith {
  def main(args: Array[String]): Unit = {
    val rods = Array((1 to args(0).toInt).toList, Nil, Nil)
    val tohc = new TowerOfHanoiClass(rods)
    tohc.moveDisks(0, 2, args(0).toInt)
  }

}