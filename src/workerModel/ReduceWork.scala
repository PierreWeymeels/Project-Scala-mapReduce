package workerModel

import scala.collection.mutable.MutableList
import scala.collection.mutable.HashSet
import masterModel.WordCounter
import view.StaticDisplay

/**
 * @author Weymeels Pierre
 */
case class ReduceWork(pieceOfMSresult: Tuple2[String, MutableList[Int]]) extends WorkerWork {
  
  /**
   * This method reduce one pieceOfMSresult of the main map and shuffle result and
   * set the main reduce result with his result.
   * @param wordCounter: WordCounter
   * @return Boolean
   */
  def reduce(wordCounter: WordCounter) : Boolean = {
    try {
      val key: String = pieceOfMSresult._1
      var sum = 0
      for (elem <- pieceOfMSresult._2)
        sum = sum + elem
      wordCounter.setReduceResult(key.toUpperCase(), sum)
      return true
    } catch {
      case ex: Exception => {
        StaticDisplay.log("ReduceWork", "Error", ex.getMessage)
        return false
      }
    }
  }
}