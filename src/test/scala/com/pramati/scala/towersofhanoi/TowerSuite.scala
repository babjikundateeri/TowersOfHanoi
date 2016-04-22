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

  //  checking the size is properly created or not
  @Test
  def checkSizeOfStack(): Unit = {
    val size: Int = 5
    val tower = Tower(size)
    assert(tower.size == size)
  }

  // creating a empty tower, access the top to check exception
  @Test
  def checkingTopOfEmptyTower(): Unit = {
    val tower = Tower(0)
    assert(tower.size == 0)
    intercept[IllegalAccessException] {
      println(tower.top)
    }
  }

  // creating a empty tower and Pop to check exception
  @Test
  def checkingPopOfEmptyTower(): Unit = {
    val tower = Tower(0)
    assert(tower.size == 0)
    intercept[IllegalAccessException] {
      println(tower.pop)
    }
  }

  // checking size after incremental pushing elements
  @Test
  def checkSizeOnPushAndPop(): Unit = {
    var tower = Tower(0)
    assert(tower.size == 0)

    tower = tower.push(Disk(10))
    assert(tower.size == 1)

    tower = tower.push(Disk(9))
    assert(tower.size == 2)

    assert(tower.top == Disk(9))

    tower = tower.pop
    assert(tower.size == 1)
  }

  //testing for push larger disk on smaller
  @Test
  def testForPush(): Unit ={
    var tower = Tower(5)
    intercept[IllegalStateException] {
      tower.push(Disk(10))
    }
  }


}
