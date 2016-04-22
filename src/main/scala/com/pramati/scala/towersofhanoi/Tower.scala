package com.pramati.scala.towersofhanoi

/**
  * Created by babjik on 19/4/16.
  */

trait IDisk {}     // to define higher type

case class Disk(size: Int) extends IDisk     // disk of type A
case class Move(from: Int, to:Int, disk: Disk) {          // Move is to store the steps of process
  override def toString():String = "Moving " + disk +" from tower " + from + " to tower " + to
}

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

    Tower.this.size.toInt > 0 match {
      case false => {}
      case true => {
        this.top.size < elem.size match {
          case true => throw new IllegalStateException("Disk with size " + elem.size + " cann't be placed over the disk with size " + this.top.size)
          case false => {}
        }
      }
    }

    new Tower[A] {
      override def size: Int =  Tower.this.size + 1
      override def top: Disk = elem
      override def pop: Tower[A] = Tower.this
      override def toString(): String = elem.toString() + " " + Tower.this.toString()
    }
  }
  def size: Int = 0
  def top: Disk = throw new IllegalAccessException("No Disks are in Tower for top ")
  def pop: Tower[A] = throw new IllegalAccessException("No Disks are in Tower to pop")
  override def toString(): String = ""
}


object Tower {
  def apply(x: Int):Tower[Disk] = {
    def go(n: Int) :Tower[Disk] = {
      n compare x match {
        case 1 => {
          // should return from looping
          return new Tower[Disk]
        }
        case _ => {
          return go(n+1).push(Disk(n))
        }
      }
    }
    go(1)
  }
}
