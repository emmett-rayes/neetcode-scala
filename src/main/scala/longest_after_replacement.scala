import scala.collection.mutable

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it
 * to any other uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing
 * the above operations.
 */
def longest_after_replacement(s: String, k: Int): Int =
  val frequency = mutable.HashMap[Char, Int]().withDefaultValue(0)
  var longest = 0
  var l = 0
  for ((c, r) <- s.zipWithIndex) do
    frequency(c) += 1
    while (r - l + 1) - frequency.values.max > k do
      frequency(s(l)) -= 1
      l += 1
    longest = math.max(longest, r - l + 1)
  longest
