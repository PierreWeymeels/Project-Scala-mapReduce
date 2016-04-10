package masterModel

import scala.collection.mutable.MutableList
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet
import workerModel.Worker
import workerModel.SortAndShuffleWork
import workerModel.MapWork
import workerModel.ReduceWork
import view.StaticDisplay

/**
 * @author Weymeels Pierre
 */
class WordCounter(newText: String) {
  private val text = newText
  private var mapAndShuffleResult: HashMap[String, MutableList[Int]] = HashMap[String, MutableList[Int]]()
  private var reduceResult: HashMap[String, Int] = HashMap[String, Int]()

  //ACCESSORS---------------------------------------------ToDo => change these ones for multiThreading
  def getMapAndShuffleResult(): HashMap[String, MutableList[Int]] = {
    return mapAndShuffleResult
  }
  def setMapAndShuffleResult(key: String, value: Int) {
    if (mapAndShuffleResult.contains(key)) {
      var listOfThisKey: MutableList[Int] = mapAndShuffleResult.get(key).toList.apply(0)
      listOfThisKey.+=(value)
    } else
      mapAndShuffleResult.+=((key, MutableList(value)))
  }

  def getReduceResult(): HashMap[String, Int] = {
    return reduceResult
  }
  def setReduceResult(key: String, amount: Int) {
    reduceResult.+=((key, amount))
  }
  //------------------------------------------------------------------------------

  /**
   * Launch the map reduce work.
   */
  def start() {
    StaticDisplay.show(text)
    val (resultTD, mapShuffleworkers): Tuple2[Boolean, HashSet[Worker]] =
      masterWork(TextDistribution(text))
    if (resultTD) {
      /*while(!endAllFirstWork(mapShuffleworkers)){// for multiThread 
        //wait ToDo for multiThread 
      }*/
      if(mapShuffleworkers.head.getState() == "workCompleted"){// for monoThread (main)
        StaticDisplay.showMapShu(mapAndShuffleResult)
        val (resultRD, reduceWorkers): Tuple2[Boolean, HashSet[Worker]] =
          masterWork(ReduceDistribution(mapAndShuffleResult))
        if (resultRD) {
          /*while(!endAllFirstWork(reduceWorkers)){//for multiThread 
            //wait ToDo 
          }*/
          if(reduceWorkers.head.getState() == "workCompleted")// for monoThread (main)
            StaticDisplay.showReduce(reduceResult)
        }
      }
    }
  }

  /**
   * This method manage master works thanks to MasterWork case class.
   * @param masterStep: MasterWork
   * @return Tuple2[Boolean, HashSet[Worker]]
   */
  private def masterWork(masterStep: MasterWork): Tuple2[Boolean, HashSet[Worker]] = masterStep match {
    case TextDistribution(text) =>
      masterStep.asInstanceOf[TextDistribution].linesDistribution(this)

    case ReduceDistribution(mapAndShuffleResult) =>
      masterStep.asInstanceOf[ReduceDistribution].reduceDistribution(this)
  }

}    
    