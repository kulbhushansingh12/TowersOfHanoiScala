object Sheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x=5                                         //> x  : Int = 5
  def increase(i: Int) = i + 1                    //> increase: (i: Int)Int
  increase(x)                                     //> res0: Int = 6
  val map = Map[Int,String](0->"A", 1->"B", 2->"C")
                                                  //> map  : scala.collection.immutable.Map[Int,String] = Map(0 -> A, 1 -> B, 2 ->
                                                  //|  C)
  println(map(0))                                 //> A
}