import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
def valid_anagram(s: String, t: String): Boolean =
  if s.length != t.length then return false

  val frequency: mutable.Map[Char, Int] = mutable.HashMap().withDefaultValue(0)
  for (c <- s) do
    frequency.update(c, frequency(c) + 1)
  for (c <- t) do
    frequency.update(c, frequency(c) - 1)

  boundary:
    for (i <- frequency.values) do
      if i != 0 then break(false)
    true
