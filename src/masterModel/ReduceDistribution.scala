package masterModel

import scala.collection.mutable.HashMap
import scala.collection.mutable.MutableList
import workerModel.Worker
import scala.collection.mutable.HashSet
import workerModel.ReduceWork
import view.StaticDisplay

/**
 * @author Weymeels Pierre
 */
case class ReduceDistribution(mapAndShuffleResult: HashMap[String, MutableList[Int]]) extends MasterWork {
  
  /**
   * This method distribute the main map and shuffle result to the worker.
   * @param wordCounter: WordCounter
   * @return Tuple2[Boolean, HashSet[Worker]]
   */
  def reduceDistribution(wordCounter: WordCounter): Tuple2[Boolean, HashSet[Worker]] = {
    var reduceWorkers: HashSet[Worker] = new HashSet[Worker]()
    try {
      val worker = new Worker(wordCounter);
      reduceWorkers.+=(worker)
      for (key <- mapAndShuffleResult.keySet) {
        val list = mapAndShuffleResult.get(key).toList.apply(0)
        val tuple2: Tuple2[String, MutableList[Int]] = Tuple2[String, MutableList[Int]](key, list)
        //ToDo => multiThread (some workers) instead of one worker (main thread) above "for"
        worker.workerWork(ReduceWork(tuple2))
      }
      return new Tuple2(true, reduceWorkers)
    } catch {
      case ex: Exception => {
        StaticDisplay.log("ReduceDistribution", "Error", ex.getMessage)
        return new Tuple2(false, reduceWorkers)
      }
    }
  }
}
  
  
