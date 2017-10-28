import org.scalatest.FunSuite
class ValidAnagram_242 extends FunSuite {
  test("Valid anagram") {
    assert(hashTable.Solution.isAnagram("aabaa", "aaaab") === true)
    assert(hashTable.Solution.isAnagram("aabaa", "aaaaa") === false)
  }
}
