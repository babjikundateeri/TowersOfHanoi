package com.pramati.scala.towersOfHanoi

/**
  * Created by babjik on 19/4/16.
  */

case class Disk(size: Int) {
  override  def toString() = "[Disk(" + size + ")]"
}
case class Move(from: String, to:String, disk: Disk) {
  override def toString():String = "Moving " + disk +" from " + from + " to " + to
}

class Tower [A]{
  def top: A = sys.error("No disks are present in tower")
  def pop: Tower[A] = sys.error("No disks are present in tower")
  override  def toString(): String = ""

  def push[Disk] : Tower[A] = {

  }
}
