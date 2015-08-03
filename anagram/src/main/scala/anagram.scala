
class Anagram(val text: String) {

  val word = new Word(text)

  def matches(s: Seq[String]): Seq[String] = {
    new WordCollection(s).matchesFor(word).toList
  }
}

class WordCollection(val sequence: Seq[String]) {
  val words = sequence.map(s => new Word(s)).toSet

  def matchesFor(word: Word) = {
    words.filter(w => w.isEqual(word)).map(w => w.text)
  }
}

class Word(val text: String) {
  type Occurrences = List[(Char, Int)]

  val textLower = downcase(text)

  val occurences = wordOccurrences

  def wordOccurrences: Occurrences = charCount(textLower).sorted

  def downcase(w: String)  = w.toLowerCase()

  def histogram(w: String) = w.groupBy(c => c)

  def charCount(w: String) = histogram(w).map(i => (i._1, i._2.size)).toList

  def isEqual(that: Word) = {
    if (this.textLower == that.textLower) {
      false
    } else {
      this.occurences == that.occurences
    }
  }

  override def equals(w: Any) = w match {
    case that: Word => this.textLower == that.textLower
    case _ => false
  }
}
