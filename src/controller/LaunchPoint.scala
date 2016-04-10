package controller

/**
 * @author Weymeels Pierre
 */
object LaunchPoint {

	def main(args: Array[String]){
    		
   val txt : String = ("MapReduce is a programming model and an associated implementation for processing and generating \n"  
	   + "large data sets with a parallel, distributed algorithm on a cluster. Conceptually similar approaches \n"  
	   + "have been very well known since 1995 with the Message Passing Interface standard having reduce and \n" 
	   + "scatter operations. \n" 
     + "A MapReduce program is composed of a Map() procedure (method) that performs filtering and sorting (such as \n"  
     + "sorting students by first name into queues, one queue for each name) and a Reduce() method that performs a summary \n"  
     + "operation (such as counting the number of students in each queue, yielding name frequencies). The MapReduce System \n"  
     + "(also called infrastructure or framework) orchestrates the processing by marshalling the distributed servers, \n"  
     + "running the various tasks in parallel, managing all communications and data transfers between the various parts of \n"  
     + "the system, and providing for redundancy and fault tolerance. \n" 
     + "The model is inspired by the map and reduce functions commonly used in functional programming,[6] although \n"  
     + "their purpose in the MapReduce framework is not the same as in their original forms. The key contributions \n"  
     + "of the MapReduce framework are not the actual map and reduce functions, but the scalability and fault-tolerance \n"  
     + "achieved for a variety of applications by optimizing the execution engine once. As such, a single-threaded \n"  
     + "implementation of MapReduce will usually not be faster than a traditional implementation, \n"  
     + "any gains are usually only seen with multi-threaded implementations. The use of this model is beneficial \n"  
     + "only when the optimized distributed shuffle operation (which reduces network communication cost) and fault \n"  
     + "tolerance features of the MapReduce framework come into play. Optimizing the communication cost is essential \n"  
     + "to a good MapReduce algorithm. \n" 
     + "MapReduce libraries have been written in many programming languages, with different levels of optimization. \n" 
     + "A popular open-source implementation that has support for distributed shuffles is part of Apache Hadoop. \n" 
     + "The name MapReduce originally referred to the proprietary Google technology, but has since been genericized. \n" 
     + "By 2014, Google were no longer using MapReduce as a Big Data processing model, and development on Apache \n"  
     + "Mahout had moved on to more capable and less disk-oriented mechanisms that incorporated full map and reduce capabilities.")
    
	  new MainCtrl(txt)
  }
}