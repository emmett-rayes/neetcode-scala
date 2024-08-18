import scala.util.boundary
import scala.util.boundary.break

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
def valid_palindrome(s: String): Boolean =
  var l = 0
  var r = s.length - 1
  boundary:
    while l <= r do
      if !s(l).isLetterOrDigit then
        l += 1
      else if !s(r).isLetterOrDigit then
        r -= 1
      else if s(l).toLower != s(r).toLower then
        break(false)
      else
        l += 1
        r -= 1
    true
