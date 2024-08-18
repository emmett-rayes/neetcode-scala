import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
def contains_duplicate(nums: Array[Int]): Boolean =
  val seen = mutable.HashSet[Int]()
  boundary:
    for n <- nums do
      if seen.contains(n) then break(true) else
        seen.add(n)
    false
