package hashTable

import org.scalatest.FunSuite
class ValidAnagram242_test extends FunSuite {
  test("Valid anagram") {
    assert(hashTable.ValidAnagram242.isAnagram("aabaa", "aaaab") === true)
    assert(hashTable.ValidAnagram242.isAnagram("aabaa", "aaaaa") === false)
  }
}
