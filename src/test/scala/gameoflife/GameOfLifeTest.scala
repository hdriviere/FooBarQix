package gameoflife

import gameoflife.GameOfLife._
import org.scalatest.FunSuite

class GameOfLifeTest extends FunSuite{
  test("Empty world return 0 neighbours") {
    assert(empty == 0)
  }

  test("Full world return 8 neighbours") {
    assert(full == 8)
  }

  test("Full world return 3 neighbours at a conner position"){
    assert(full.countNeighbours(0,0) == 3)
  }
}
