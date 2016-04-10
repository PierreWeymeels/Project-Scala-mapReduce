package view

import scala.collection.mutable.HashMap
import scala.collection.mutable.MutableList


/**
 * @author Weymeels Pierre
 */
object StaticDisplay {
  
  /**
   * This method display info to helps for debug the program.
   * @param tag String
   * @param msgtype String
   * @param msg String
   */
  def log(tag:String,msgtype:String,msg:String){
    println("||LOG=> Tag : "+tag+" | Msgtype : "+msgtype+" | Msg : "+msg+" ||")
  }
  
  /**
   * This method display the text.
   * @param msg String
   */
  def show(msg:String){
    println(msg)
    println("")
  }
  
  /**
   * This method display the main map and shuffle result.
   * @param mapAndShuResult MutableList[Int]]
   */
  def showMapShu(mapAndShuResult:HashMap[String, MutableList[Int]]){
    var nbOnLine = 0;
    println("||||||||||||||||||||||||||||| Post map and shuffle result ||||||||||||||||||||||||||||||||||||||||")
    for(key <- mapAndShuResult.keySet){
      print("|WORD: "+key+" , LIST: (")//+mapAndShuResult.get(key).get+"|") 
      
      for(elem <- mapAndShuResult.get(key).get){
        print(elem+" ")
      }
      print(") |")
      nbOnLine = nbOnLine + 1
      if(nbOnLine.%(3) == 0){
        println("")   
      }
    }
    println("")  
    println("") 
  }
  
  /**
   * This method display the main reduce result.
   * @param reduceResult:HashMap[String, Int]
   */
  def showReduce(reduceResult:HashMap[String, Int]){
    var nbOnLine = 0;
    println("||||||||||||||||||||||||||||| Post reduce result ||||||||||||||||||||||||||||||||||||||||")   
    for(key <- reduceResult.keySet){
      print("|Word: "+key+" , nb: "+reduceResult.get(key).get+"|")
      nbOnLine = nbOnLine + 1
      if(nbOnLine.%(3) == 0){
        println("")   
      }
    }
    println("")    
    println("") 
  }
}