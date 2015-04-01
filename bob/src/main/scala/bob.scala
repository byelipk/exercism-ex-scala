class Bob {
  def hey(comment: String): String = comment match {
    case c if isShouting(c) => "Whoa, chill out!"
    case c if isAsking(c) => "Sure."
    case c if isSilent(c) => "Fine. Be that way!"
    case _ => "Whatever."
  }

  private def isShouting(comment: String): Boolean = {
    val upper = comment.toUpperCase
    val lower = comment.toLowerCase

    comment == upper && upper != lower
  }

  private def isAsking(comment: String): Boolean = {
    comment.endsWith("?")
  }

  private def isSilent(comment: String): Boolean = {
    comment.trim == ""
  }
}
