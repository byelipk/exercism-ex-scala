object Hamming {
  /**
    @object Hamming
    @params strand1:String, strand2:String
    @returns count

    For Scala documentation on IndexSeq see: http://www.scala-lang.org/api/current/#scala.collection.IndexedSeq
  **/
  def compute(strand1: String, strand2: String): Int = {
    // Returns Vector((G,A), (G,C), (G,T))
    val collection = strand1.zip(strand2)

    // Evaluates the predicate for each item in the vector and returns the count
    collection.count {
      case (x, y) => x != y
    }
  }
}
