package workerModel

import scala.collection.mutable.MutableList
import masterModel.WordCounter
import view.StaticDisplay

/**
 * @author Weymeels Pierre
 */
case class SortAndShuffleWork(map: MutableList[(String, Int)]) extends WorkerWork {
  
  /**
   * This method set the main map and shuffle result 
   * with the the his map result.
   * @param wordCounter: WordCounter
   * @return Boolean
   */
  def sortAndShuffle(wordCounter: WordCounter) : Boolean = {
    try {
      for (tuple2 <- map) 
        wordCounter.setMapAndShuffleResult(tuple2._1,tuple2._2)
      return true  
    } catch {
      case ex: Exception => {
        StaticDisplay.log("SortAndShuffleWork", "Error", ex.getMessage)
        return false
      }
    }
  }
}
