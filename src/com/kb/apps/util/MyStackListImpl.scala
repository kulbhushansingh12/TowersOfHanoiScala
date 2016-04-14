package com.kb.app.util

import com.kb.apps.service.TMyStack

class MyStackListImpl[Int] extends TMyStack[Int]{
  private class Node(val data:scala.Int, val next:Node)
  private var top:Node = null 
  private var size:scala.Int = 0
   def push(x:scala.Int)={
    if(top==null||top.data > x.asInstanceOf[scala.Int]){
     top= new Node(x,top)
     size=size+1
    }else{
      throw new Exception("Invalid Move, you cannot move larger disk on smaller disk")
    }
   }
 
  def pop():scala.Int = {
    if(size!=0){
      val temp:scala.Int = top.data
      top = top.next
      size=size-1
      temp
    }else{
      throw new Exception("Initialize the stack ")
    }
  }
  
  def isEmpty:Boolean = top==null
  
  def peek:scala.Int = top.data
  
  def length:scala.Int = size
}

