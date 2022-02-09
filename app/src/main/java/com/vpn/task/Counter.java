package com.vpn.task;

public class Counter {

   int min, max, startValue, step;

   public Counter(int min, int max, int startValue, int step){
      this.min = min;
      this.max = max;
      this.startValue = startValue;
      this.step = step;
   }

   public int plus(int nowValue){
      if(nowValue+step>max&&nowValue+step<min){
         return nowValue;
      }
      return nowValue+step;
   }


   public int reset(){
      return 0;
   }


}
