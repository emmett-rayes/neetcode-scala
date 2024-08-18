import scala.util.boundary
import scala.util.boundary.break

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, incremented by one as an array [index1, index2] of length 2.
 * There is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 */
def two_sum_sorted(numbers: Array[Int], target: Int): Array[Int] =
  var l = 0
  var r = numbers.length - 1
  boundary:
    while l < r do
      val sum = numbers(l) + numbers(r)
      if sum < target then
        l += 1
      else if sum > target then
        r -= 1
      else
        break(Array(l + 1, r + 1))
    Array()
