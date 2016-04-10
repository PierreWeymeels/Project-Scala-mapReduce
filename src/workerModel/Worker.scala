package workerModel

import masterModel.WordCounter

/**
 * @author Weymeels Pierre
 */
class Worker(wordCounter: WordCounter){
  private val wCounter: WordCounter = wordCounter
  private var state:String = "noState"
  
  def getState():String = {
    return state
  }
  
  /**
   * This method manage worker works thanks to WorkerWork case class.
   * @param workerStep: WorkerWork
   * @return Any
   */
  def workerWork(workerStep: WorkerWork): Any = workerStep match { 
    case MapWork(line) =>
      state = "MapWork"
      val result = workerStep.asInstanceOf[MapWork].map()
      if (result != null)
        workerWork(SortAndShuffleWork(result))
      else
        state = "Error"

    case SortAndShuffleWork(map) =>
      state = "SortAndShuffleWork"
      if(workerStep.asInstanceOf[SortAndShuffleWork].sortAndShuffle(wCounter))
        state  = "workCompleted"
      else
        state = "Error"

    case ReduceWork(pieceOfMSresult) =>
      state = "ReduceWork"
      if(workerStep.asInstanceOf[ReduceWork].reduce(wCounter))
        state  = "workCompleted"
      else
        state = "Error"
  }
}