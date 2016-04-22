package com.pramati.scala.towersofhanoi

import org.scalatest.FunSuite

/**
  * Created by babjik on 22/4/16.
  */
class TowerSuite extends FunSuite{

  test("creating tower of type Tower[Disk]") {
    val size: Int = 5
    val tower = Tower(size)
    tower match {
      case d : Tower[Disk] => assert(true)
      case _ => fail("tower is not a type of Tower[Disk]")
    }
  }

  test("pop is invoked on a non-empty tower") {
    val tower = Tower(0)
    intercept [IllegalAccessException] {
      tower.pop
    }
  }

  test("top is invoked on a non-empty tower") {
    val tower = Tower(0)
    intercept [IllegalAccessException] {
      tower.pop
    }
  }

  test ("testing for push larger disk on smaller") {
    var tower = Tower(5)
    intercept[IllegalStateException] {
      tower.push(Disk(10))
    }
  }

  test ("checking the size is properly created or not") {
    val size: Int = 5
    val tower = Tower(size)
    assert(tower.size == size)
  }

  test ("checking size after incremental pushing elements") {
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


}
