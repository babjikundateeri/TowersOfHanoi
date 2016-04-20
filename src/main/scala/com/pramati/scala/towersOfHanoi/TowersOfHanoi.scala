package com.pramati.scala.towersOfHanoi

/**
  * Created by babjik on 19/4/16.
  */
object TowersOfHanoi {



  def main (args: Array[String]) : Unit = {
      val nDisks: Int = getInputFromUser()
      nDisks  match {
        case 0 => {
          println("Try again with valid input")
        }
        case _ => {
          println(s"Proceeding with the count ${nDisks}")
        }
      }
  }

  def getInputFromUser(): Int = {
    print("Enter number of disks to move : ")
    try {
      val nDisks = scala.io.StdIn.readInt()
      nDisks compare 0 match {
        case  1 => {
          return nDisks
        }
        case _ =>
          println("Please enter only Positive numbers")
      }
    } catch {
      case e: NumberFormatException =>
        println ("Invalid number entered " )
      case e: Exception =>
        println(e.getMessage)
    }
    return 0
  }
}
