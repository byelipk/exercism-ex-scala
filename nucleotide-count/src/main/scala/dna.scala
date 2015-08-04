class DNA(val string: String) {

  val dnaString   = SafeDNA.filter(string, DNADefaults.strand)
  val histogram   = dnaString.groupBy(c => c).map(m => (m._1 -> m._2.size))

  val nucleotideCounts  = DNADefaults.histogram ++ histogram
  def count(char: Char) = SafeDNA.count(char, nucleotideCounts)
}

// A, C, G, T
object DNADefaults {
  def strand    = List('A', 'C', 'G', 'T')
  def histogram = Map('A' -> 0, 'T' -> 0, 'C' -> 0, 'G' -> 0)
}

object SafeDNA {
  def filter(string: String, strand: List[Char]) = {
    string.filter { c =>
      if (strand.contains(c)) {
        true
      } else {
        throw new IllegalArgumentException
      }
    }
  }

  def count(char: Char, nucleotides: Map[Char, Int]) = {
    nucleotides.getOrElse(char, { throw new IllegalArgumentException })
  }
}
