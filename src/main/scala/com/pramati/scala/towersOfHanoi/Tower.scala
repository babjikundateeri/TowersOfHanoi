package com.pramati.scala.towersOfHanoi

/**
  * Created by babjik on 19/4/16.
  */

trait A {}     // to define higher type

case class Disk(size: Int) extends A     // disk of type A
case class Move(from: Int, to:Int, disk: Disk) {          // Move is to store the steps of process
  override def toString():String = "Moving " + disk +" from " + from + " to " + to
}

case class InvalidMoveException(message: String) extends Exception  // Internal Exceptions
case class EmptyTowerException(message:String) extends Exception

/**
  * @tparam A @Tower with the type A
  *
  *  1. Immutable data structure
  *  2. While Push should check for the condition (i.e. Larger disk can not be placed over Smaller disk)
  *  3. can remove only one disk at one step
  *  4. can push only once disk to tower at one step
  */

class Tower[A <: Disk] {
  def push(elem: A): Tower[A] = {

    try {
      this.top.size < elem.size match {
        case true => {
          throw InvalidMoveException("Disk with size " + elem.size + " cann't be placed over the disk with size " + this.top.size);
        }
        case false => {
          // We can proceed with the move
          //println("do nothing, disk allowed to place..");
        }
      }
    } catch {
      case e: InvalidMoveException => {
        println(e.message)
        throw e
      }
      case e: EmptyTowerException => {
        // where we insert first disk to the tower, top will result this exception
        //println("It might be first element to the Tower")
      }
    }

    new Tower[A] {
      override def top: Disk = elem
      override def pop: Tower[A] = Tower.this
      override def toString(): String = elem.toString() + " " + Tower.this.toString()
    }
  }
  def top: Disk = throw EmptyTowerException("No Disks are in Tower for top ")
  def pop: Tower[A] = throw EmptyTowerException("No Disks are in Tower to pop")
  override def toString(): String = ""
}
