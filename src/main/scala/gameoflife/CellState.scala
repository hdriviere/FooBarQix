package gameoflife

sealed trait CellState

case object alive extends CellState

case object dead extends CellState

object CellState {
  def nextState(state: CellState, nbNeighbours: Int): CellState = {
    (state, nbNeighbours) match {
      case (_, 3) => alive
      case (alive, 2) => alive
      case _ => dead
    }
  }
}
