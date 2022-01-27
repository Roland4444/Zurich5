package ch.roland.util

import scala.collection.mutable
class Checker {
  var dictionary = new mutable.HashMap[Character, Boolean]
  def Checker() =
       initDict()

  def isnumber(input: String): Boolean =
    if (input.length < 1) return false
    for (i <- 0 until input.length) {
      if (dictionary.get(input.charAt(i)) == null) return false
    }
    true



  def checkdigit(input: Char): Boolean =
    var result = false
    result = input match {
      case '0' => true
      case '1' => true
      case '2' => true
      case '3' => true
      case '4' => true
      case '5' => true
      case '6' => true
      case '7' => true
      case '8' => true
      case '9' => true
      case _ => false
    }
    result


  def initDict(): Unit =
    this.dictionary.put('.', true)
    this.dictionary.put('0', true)
    this.dictionary.put('1', true)
    this.dictionary.put('2', true)
    this.dictionary.put('3', true)
    this.dictionary.put('4', true)
    this.dictionary.put('5', true)
    this.dictionary.put('6', true)
    this.dictionary.put('7', true)
    this.dictionary.put('8', true)
    this.dictionary.put('9', true)


}
