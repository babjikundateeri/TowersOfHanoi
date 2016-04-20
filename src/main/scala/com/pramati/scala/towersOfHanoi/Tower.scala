package com.pramati.scala.towersOfHanoi

/**
  * Created by babjik on 19/4/16.
  */

trait A {}

case class Disk(size: Int) extends A
case class Move(from: String, to:String, disk: Disk) {
  override def toString():String = "Moving " + disk +" from " + from + " to " + to
}

case class InvalidMoveException(message: String) extends Exception
case class EmptyTowerException(message:String) extends Exception

class Tower[A <: Disk] {
  def push(elem: A): Tower[A] = {

    try {
      this.top.size < elem.size match {
        case true => {
          throw InvalidMoveException("Disk with size " + elem.size + " cann't be placed over the disk with size " + this.top.size);
        }
        case false => {
          println("do nothing, disk allowed to place..");
        }
      }
    } catch {
      case e: InvalidMoveException => {
        println(e.message)
        throw e
      }
      case e: EmptyTowerException => {
        println("It might be first element to the Tower")
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
