package workerModel

import scala.collection.mutable.MutableList
import view.StaticDisplay

/**
 * @author Weymeels Pierre
 */
case class MapWork(line: String) extends WorkerWork { 
  
  /**
   * This method map one line of the main text.
   * @return MutableList[(String, Int)]
   */
  def map(): MutableList[(String, Int)] = {
    var output = MutableList[(String, Int)]()
    try {
      val words = line.split(Array('-','(',')', ',', '.', ' ')).filter { x => x.size > 3 }
      for (word <- words) {
        output.+=((word -> 1));
      }
      return output
    } catch {
      case ex: Exception => {
        StaticDisplay.log("MapWork","Error",ex.getMessage)
        return null;
      }

    }
  }

}