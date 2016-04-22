package com.pramati.scala.towersofhanoi

import scala.annotation.tailrec


/**
  * Created by babjik on 19/4/16.
  */
object TowersOfHanoi {

  val towers: Array[Tower[Disk]] = Array(new Tower[Disk], new Tower[Disk], new Tower[Disk]);

  def main (args: Array[String]) : Unit = {
      val nDisks: Int = getInputFromUser()
      nDisks  match {
        case 0 => {
          println("Try again with valid input")
        }
        case _ => {
          towers(0) = Tower(nDisks)

          println("From :" + towers(0))
          println("To   :" + towers(1))
          println("temp :" + towers(2))

          val moves = doTowersOfHanoi(nDisks, 0, 1, 2)

          moves.foreach(println)

          println("From :" + towers(0))
          println("To   :" + towers(1))
          println("temp :" + towers(2))

          println("No of Moves includes " + moves.size)
        }
      }
  }

  /**
    *  if n = 1, move fromStack to toStack
    *  else
    *  move n-1 disks to temp stack
    *  move nth disk to toStack
    *  move n-1 disks from temp stack to toStack
    */
  def doTowersOfHanoi(nDisk:Int, from: Int, to:Int, temp: Int): List[Move] = {

      nDisk match {
        case 1 => {
           val disk = towers(from).top
           towers(from) = towers(from).pop
           towers(to) = towers(to).push(disk)
           List(Move(from, to, disk))
        }
        case _ => {
          // move n-1 disks to temp stack
            val listx = doTowersOfHanoi(nDisk-1, from, temp, to)
          // move nth disk to toStack
            val disk = towers(from).top
            towers(from) = towers(from).pop
            towers(to) = towers(to).push(disk)
            val listy = List(Move(from, to, disk))
          // move n-1 disks from temp stack to toStack
            val listz = doTowersOfHanoi(nDisk-1, temp, to, from)
            listx ::: listy ::: listz
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
