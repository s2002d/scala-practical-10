class Qq5 {

  
  def countLetterOccurrences(words: List[String]): Int = {
    words
      .map(word => word.length)  
      .reduce(_ + _)             
  }
}

object Main extends App {
  
  val qq5 = new Qq5()

  
  val words = List("apple", "banana", "cherry", "date")

  
  val totalOccurrences = qq5.countLetterOccurrences(words)
  println("Total count of letter occurrences: " + totalOccurrences)
}
