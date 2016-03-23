package com.example.whatswrongwithme;

public class EnterpriseFizzBuzz {
  
  private final Listener listener;
  
  public EnterpriseFizzBuzz(Listener listener) {
    this.listener = listener;
  }
  
  public String fizzbuzz(int number) {
    String result = fizzOrBuzz(number);
    listener.receive(result);
    return result;
  }
  
  private String fizzOrBuzz(int number) {
    if (isFizz(number) && isBuzz(number)) {
      return "fizzbuzz";
    }
    
    if (isBuzz(number)) {
      return "buzz";
    }
    
    if (isFizz(number)) {
      return "fizz";
    }
    
    return "" + number;
  }

  private boolean isFizz(int number) {
    return number % 3 == 0;
  }
  
  private boolean isBuzz(int number) {
    return number % 5 == 0;
  }
  
}
