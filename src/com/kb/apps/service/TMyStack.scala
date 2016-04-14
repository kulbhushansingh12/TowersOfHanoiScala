package com.kb.apps.service

trait TMyStack[Int] {
  def push(x:scala.Int):Unit
  
  def pop():scala.Int
  
  def isEmpty:Boolean
  
  def peek:scala.Int
}
