package com.example.whatswrongwithme;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.mockito.Mockito;

public class CompoundListenerTest {
  
  @Test
  public void shouldNotifyAllChildrenWhenSingleListener() {
    Listener listener = Mockito.mock(Listener.class);
    CompoundListener testee = makeTesteeWithListners(listener);
    
    testee.receive("foo");
    
    verify(listener).receive("foo");
  }
  
  @Test
  public void shouldNotifyAllChildrenWhenMultipleListeners() {
    Listener listener = Mockito.mock(Listener.class);
    Listener listenerTwo = Mockito.mock(Listener.class);
    CompoundListener testee = makeTesteeWithListners(listener, listenerTwo);
    
    testee.receive("foo");
    
    verify(listener).receive("foo");
  }
  
  @Test
  public void shouldHandleNotificationWithoutErrorWhenNoChildren() {
    CompoundListener testee = new CompoundListener(Collections.<Listener>emptyList());
    try {
      testee.receive("foo");
    } catch(Exception ex) {
      fail("Did not expect an exception");
    }
  }
  
  private final CompoundListener makeTesteeWithListners(Listener ... listeners) {
    return  new CompoundListener(Arrays.asList(listeners));
  }
}
