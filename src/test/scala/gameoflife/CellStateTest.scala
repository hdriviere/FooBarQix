package gameoflife

import gameoflife.CellState.nextState
import org.scalatest.FunSuite

class CellStateTest extends FunSuite {

  test("Any live cell with no live neighbours dies, as if by underpopulation.") {
    assert(nextState(alive, 0) == dead)
  }

  test("Any live cell with one live neighbours dies, as if by underpopulation.") {
    assert(nextState(alive, 1) == dead)
  }

  test("Any live cell with two live neighbours lives on to the next generation.") {
    assert(nextState(alive, 2) == alive)
  }

  test("Any live cell with three live neighbours lives on to the next generation.") {
    assert(nextState(alive, 3) == alive)
  }

  test("Any live cell with more than three live neighbours dies, as if by overpopulation.") {
    assert(nextState(alive, 4) == dead)
  }

  test("Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.") {
    assert(nextState(dead, 3) == alive)
  }

  test("Any dead cell with nbNeighbors different than 3 remains dead") {
    assert(nextState(dead, 2) == dead)
  }
}

