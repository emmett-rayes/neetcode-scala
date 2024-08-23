import scala.collection.mutable

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * A substring is a contiguous non-empty sequence of characters within a string.
 */
def longest_substring(s: String): Int =
  val seen = mutable.HashMap[Char, Int]()
  var max_len = 0
  var l = 0
  for ((c, r) <- s.zipWithIndex) do
    if seen.contains(c) && seen(c) >= l then
      l = seen(c) + 1
    seen(c) = r
    max_len = math.max(max_len, r - l + 1)
  max_len
