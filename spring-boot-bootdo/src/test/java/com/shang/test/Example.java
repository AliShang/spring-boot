package com.shang.test;

// 计数器
class Counter{
     long count = 0;
 
     public synchronized void add(long value){
       this.count += value;
       System. out.println(Thread. currentThread().getName()+":"+ count);
     }
  }
//计数线程  
class CounterThread extends Thread{
 
     protected Counter counter = null;
 
     public CounterThread(Counter counter){
        this.counter = counter;
     }
 
     public void run() {
	for(int i=0; i<10; i++){
           counter.add(1);
        }
     }
  }
//案例  
  public class Example {
 
    public static void main(String[] args){
      Counter counterA = new Counter();
      Counter counterB = new Counter();
      Thread  threadA = new CounterThread(counterA);
      Thread  threadB = new CounterThread(counterB);
 
      threadA.start();
      threadB.start();
    }
  }