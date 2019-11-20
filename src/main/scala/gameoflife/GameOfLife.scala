package gameoflife

case class GameOfLife(grid: Array[Array[CellState]]) {
  def cellAt(pos: (Int, Int)): CellState = pos match {
    case pos if pos._1 < 0 || pos._1 >= size() => dead
    case pos if pos._2 < 0 || pos._2 >= size() => dead
    case _ => grid(pos._1)(pos._2)
  }

  def size(): Int = grid.length

  def computeAliveNeighbours(pos: (Int, Int)) : Int ={
    def indices(pos: Int): Array[Int] = {
      Array(-1, 0, 1).map(pos + _)
    }

    val positionsToLookAt = for {
      i <- indices(pos._1)
      j <- indices(pos._2)
      if (i, j) != pos
    } yield (i, j)
    positionsToLookAt.map(p => cellAt(p)).count(_ == alive)
  }
}

object GameOfLife {
  private def create(cellState: CellState, size: Int) =  GameOfLife(Array.fill[Array[CellState]](size)(Array.fill[CellState](size)(cellState)))
  def empty(size: Int = 3): GameOfLife = create(dead, size)
  def full(size: Int = 3): GameOfLife = create(alive, size)
}