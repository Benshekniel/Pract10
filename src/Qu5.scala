object LetterCountApp {
  def countLetterOccurrences(words: List[String]): Int = {
    // Step 1: Transform the list of words into their lengths
    val lengths = words.map(_.length)

    // Step 2: Use reduce to calculate the total count of letter occurrences
    val totalLetters = lengths.reduce(_ + _)

    totalLetters
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val totalLetterCount = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $totalLetterCount")
  }
}
