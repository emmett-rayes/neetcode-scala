import scala.collection.mutable

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
def product_except_self(nums: Array[Int]): Array[Int] =
  val result = mutable.ArrayBuffer.fill(nums.length)(1)

  var prefix = 1
  for ((n, i) <- nums.zipWithIndex.dropRight(1)) do
    prefix = prefix * n
    result(i + 1) *= prefix

  var postfix = 1
  for ((n, i) <- nums.zipWithIndex.reverse.dropRight(1)) do
    postfix = postfix * n
    result(i - 1) *= postfix

  result.toArray
