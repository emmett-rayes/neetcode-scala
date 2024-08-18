import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that
 * they add up to target. You may assume that each input would have exactly one solution,
 * and you may not use the same element twice. You can return the answer in any order.
 */
def two_sum(nums: Array[Int], target: Int): Array[Int] =
  val complement = mutable.HashMap[Int, Int]()
  boundary:
    for (n, i) <- nums.zipWithIndex do
      if complement.contains(n) then break(Array(i, complement(n))) else
        complement(target - n) = i
    Array()
