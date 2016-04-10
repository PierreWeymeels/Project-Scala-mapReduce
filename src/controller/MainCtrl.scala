package controller

import masterModel.WordCounter

/**
 * @author Weymeels Pierre
 */
class MainCtrl(txt:String) {
  private val worldCounter : WordCounter = new WordCounter(txt)
  worldCounter.start()
  
}