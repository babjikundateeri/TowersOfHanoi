package com.pramati.scala.towersOfHanoi

/**
  * Created by babjik on 19/4/16.
  */
object TowersOfHanoi {



  def main (args: Array[String]) : Unit = {
    print("Enter number of disks to move : ")
    try {
        val nDisks = scala.io.StdIn.readInt()
        nDisks compare 0 match {
          case  1 => {

          }

          case _ =>
            println("Please enter only Positive numbers")
        }

    } catch {
      case e: NumberFormatException =>
        println("Invalid number entered")
      case e: Exception =>
        println(e.getMessage)
    }
  }
}
