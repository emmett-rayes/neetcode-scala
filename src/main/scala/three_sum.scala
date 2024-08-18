import scala.collection.mutable

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */
def three_sum(nums: Array[Int]): List[List[Int]] =

  def two_sum(target: Int, excluded: Int): List[List[Int]] =
    val complements = mutable.HashMap[Int, Int]()
    val results = mutable.HashSet[List[Int]]()
    for (n, i) <- nums.zipWithIndex if i != excluded do
      if complements.contains(n) then
        val j = complements(n)
        results.add(List(i, j))
      else
        complements(target - n) = i
    results.toList

  val results = mutable.HashSet[List[Int]]()
  for (n, k) <- nums.zipWithIndex do
    for list <- two_sum(-n, k) do
      val i = list(0)
      val j = list(1)
      val sorted = Array(nums(i), nums(j), nums(k)).sorted
      results.add(sorted.toList)
  results.toList
