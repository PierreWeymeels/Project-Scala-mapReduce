package masterModel

import scala.collection.mutable.HashMap
import workerModel.Worker
import scala.collection.mutable.HashSet
import workerModel.MapWork
import view.StaticDisplay

/**
 * @author Weymeels Pierre
 */
case class TextDistribution(text: String) extends MasterWork {
  
  /**
   * This method distribute the text to the worker.
   * @param wordCounter: WordCounter
   * @return Tuple2[Boolean, HashSet[Worker]]
   */
  def linesDistribution(wordCounter: WordCounter): Tuple2[Boolean, HashSet[Worker]] = {
    var mapShuffleworkers: HashSet[Worker] = new HashSet[Worker]()
    try {
      val lines = text.toLowerCase().split('\n')
      val worker = new Worker(wordCounter);
      mapShuffleworkers.+=(worker)
      for (line <- lines) {
        //ToDo => multiThread (some workers) instead of one worker (main thread) above "for"
        worker.workerWork(MapWork(line))
      }
      return new Tuple2(true, mapShuffleworkers)
    } catch {
      case ex: Exception => {
        StaticDisplay.log("TextDistribution", "Error", ex.getMessage)
        return new Tuple2(false, mapShuffleworkers)
      }
    }
  }

}