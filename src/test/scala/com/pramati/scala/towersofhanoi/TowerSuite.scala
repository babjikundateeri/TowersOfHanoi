package com.pramati.scala.towersofhanoi

import org.junit.Test
import org.scalatest.Assertions

/**
  * Created by babjik on 22/4/16.
  */
class TowerSuite extends Assertions{

  // creating tower of type Tower[Disk]
  @Test
  def creationOfStack(): Unit = {
    val size: Int = 5
    val tower = Tower(size)

    tower match {
      case d : Tower[Disk] => assert(true)
      case _ => fail("tower is not a type of Tower[Disk]")
    }
  }

  // 
  @Test
  def checkSizeOfStack(): Unit = {
    val size: Int = 5
    val tower = Tower(size)
    assert(tower.size == size)
  }


}
