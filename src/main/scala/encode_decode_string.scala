import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 */

def encode(strs: Array[String]): String =
  val result: StringBuilder = StringBuilder()
  for (s <- strs) do
    result.append(s.length + "#" + s)
  result.mkString

def decode(s: String): Array[String] =
  val result: mutable.ArrayBuffer[String] = ArrayBuffer()
  var i = 0
  var ll = 0
  while i < s.length do
    if s(i) != '#' then
      i += 1
      ll += 1
    else
      val len = s.slice(i - ll, i).toInt
      val word = s.slice(i + 1, i + 1 + len)
      result.append(word)
      i = i + 1 + len
      ll = 0
  result.toArray
