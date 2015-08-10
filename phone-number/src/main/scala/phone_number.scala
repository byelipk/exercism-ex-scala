class PhoneNumber(val string: String) {
  val cleanNumber   = new CleanNumber(string).clean
  val number        = new ValidatedNumber(cleanNumber).validate
  val areaCode      = new AreaCode(number).compute
  val prefix        = new Prefix(number).compute
  val lineNumber    = new LineNumber(number).compute

  override def toString = s"($areaCode) $prefix-$lineNumber"
}

class AreaCode(val string: String) {
  def compute = string.slice(0,3)
}

class Prefix(val string: String) {
  def compute = string.slice(3,6)
}

class LineNumber(val string: String) {
  def compute = string.slice(6,10)
}

class CleanNumber(val string: String) {
  def clean = string.replaceAll("[.|(|)| |-]", "")
}

class ValidatedNumber(val string: String) {
  def validate = {
    if (string.size > 10) {
      if (string(0) == '1') string.replaceAll("^1", "")
      else Default.invalidNumber
    } else if (string.size < 10) {
      Default.invalidNumber
    } else {
      string
    }
  }
}

object Default {
  val invalidNumber = "0000000000"
}
