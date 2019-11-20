package gameoflife

import gameoflife.GameOfLife._
import org.scalatest.FunSuite

class GameOfLifeTest extends FunSuite{
  test("Empty world return 0 neighbours") {
    assert(empty().computeAliveNeighbours((1,1)) == 0)
  }

  test("Full world return 8 neighbours") {
    assert(full().computeAliveNeighbours((1,1)) == 8)
  }

  test("Full world return 3 neighbours at a conner position"){
    assert(full().computeAliveNeighbours((0,0)) == 3)
  }
}
