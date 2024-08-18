import scala.collection.mutable

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order. An Anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all the original letters exactly once.
 */
def group_anagrams(strs: Array[String]): List[List[String]] =
  val frequencies = mutable.HashMap[Map[Char, Int], mutable.ArrayBuffer[String]]()

  for str <- strs do
    val freq = mutable.HashMap[Char, Int]().withDefaultValue(0)
    for c <- str do
      freq(c) += 1

    val m = freq.toMap
    if frequencies.contains(m) then
      frequencies(m).append(str)
    else
      frequencies(m) = mutable.ArrayBuffer(str)

  frequencies.values.collect(array => array.toList).toList
