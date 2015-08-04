class Phrase(text: String) {

  val splitPhrase = text.split("""(\s+|,)""")

  val cleanPhrase = splitPhrase map { w =>
    w.toLowerCase.replaceAll("""[^\w']""", "")
  }

  val filteredPhrase = cleanPhrase filter (w => w.isEmpty == false)

  def wordCount: Map[String, Int] = {
    filteredPhrase.foldLeft(Map[String, Int]()) { (m, k) =>
      if (m.getOrElse(k, false) != false) m + (k -> (m(k) + 1))
      else m + (k -> 1)
    }
  }
}
