import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */
def top_k_frequent(nums: Array[Int], k: Int): Array[Int] =
  val frequency: mutable.Map[Int, Int] = mutable.Map().withDefaultValue(0)
  for (n <- nums) do
    frequency.update(n, frequency(n) + 1)

  var max_freq: Option[Int] = None
  for (f <- frequency.values) do
    max_freq = max_freq match
      case None => Some(f)
      case Some(v) => if f > v then Some(f) else Some(v)

  val histogram: Array[mutable.HashSet[Int]] = Array.fill(max_freq.get)(mutable.HashSet())
  for ((n, f) <- frequency) do
    histogram(f - 1).add(n)

  val result: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer.empty
  boundary:
    for (s <- histogram.reverseIterator) do
      for (n <- s) do
        result.append(n)
        if result.size >= k then break()

  result.toArray
