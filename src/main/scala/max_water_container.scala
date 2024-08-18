
/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]). Find two lines that together with the x-axis form a container,
 * such that the container contains the most water. Return the maximum amount of water a container can store.
 */
def max_water_container(height: Array[Int]): Int =
  var l = 0
  var r = height.length - 1
  var max_area = 0
  while l < r do
    val area = (r - l) * math.min(height(r), height(l))
    max_area = math.max(max_area, area)
    if height(l) < height(r) then l += 1 else r -= 1
  max_area
