package com.example.whatswrongwithme;

public class CompoundListener implements Listener {
  
  private final Iterable<Listener> children;
  
  public CompoundListener(Iterable<Listener> children) {
    this.children = children; 
  }

  @Override
  public void receive(String thing) {
    for ( Listener each : children ) {
      each.receive(thing);
    }
  }

}
