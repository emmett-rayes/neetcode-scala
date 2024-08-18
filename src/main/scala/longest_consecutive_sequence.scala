import scala.collection.mutable

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */
def longest_consecutive_sequence(nums: Array[Int]): Int =
  val elements = mutable.HashSet[Int]()
  for (n <- nums) do
    elements.add(n)

  val sequence = mutable.HashMap[Int, Int]()
  for (n <- nums if !sequence.contains(n)) do
    var m = n
    while elements.contains(m) && !sequence.contains(m) do
      m += 1

    if !elements.contains(m) then
      m -= 1

    val len = m - n + 1
    val offset = sequence.getOrElse(m, 1)
    for (i <- 0 until len) do
      sequence(n + i) = len - i + offset - 1

  var longest = 0
  for (l <- sequence.values) do
    longest = math.max(longest, l)
  longest
