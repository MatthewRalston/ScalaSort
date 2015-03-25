package MatthewRalston.mergesorting

import annotation.tailrec
import java.io._


class Mergesort(i: Int) {

  def run(input: List[List[Int]]): List[List[Int]] = {
    val n = input.length / 2
    if (n == 0) {
      input
    } else {
      val (left, right) = input splitAt (n)
      merge(run(left), run(right), Nil)
    }
  }
  @tailrec
  private def merge(
    left: List[List[Int]],
    right: List[List[Int]],
    sortedPrefix: List[List[Int]]
  ): List[List[Int]] =
    (left, right) match {
      case (Nil, right) => appendReversed(sortedPrefix, right)
      case (left, Nil) => appendReversed(sortedPrefix, left)
      case (x +: xtail, y +: ytail) =>
        if (x(i) < y(i)) merge(xtail, right, x +: sortedPrefix)
        else merge(left, ytail, y +: sortedPrefix)
    }

  @tailrec
  private def appendReversed(
    left: List[List[Int]],
    right: List[List[Int]]
  ): List[List[Int]] = left match {
    case Nil => right
    case head :: tail => appendReversed(tail, head :: right)
  }
}
