class Phrase(phrase: String) {

  def wordCount: Map[String, Int] = {
    val emptyMap = Map[String, Int]()

    phrase.split("""(\s+|,)""").map { s =>
      s.toLowerCase.replaceAll("""[^\w']""", "")
    }.filter { s =>
      s.isEmpty == false
    }.foldLeft(emptyMap) { (m, k) =>
      if (m.getOrElse(k, false) != false) m + (k -> (m(k) + 1))
      else m + (k -> 1)
    }
  }
}
