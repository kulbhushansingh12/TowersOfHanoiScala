object Sheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet");$skip(10); 
  val x=5;System.out.println("""x  : Int = """ + $show(x ));$skip(31); 
  def increase(i: Int) = i + 1;System.out.println("""increase: (i: Int)Int""");$skip(14); val res$0 = 
  increase(x);System.out.println("""res0: Int = """ + $show(res$0));$skip(52); 
  val map = Map[Int,String](0->"A", 1->"B", 2->"C");System.out.println("""map  : scala.collection.immutable.Map[Int,String] = """ + $show(map ));$skip(18); 
  println(map(0))}
}
