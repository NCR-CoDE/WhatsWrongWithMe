package com.example.whatswrongwithme;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EnterpriseFizzBuzzTest {
  
  @Mock
  Listener listener;
  
  EnterpriseFizzBuzz testee;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    testee = new EnterpriseFizzBuzz(listener);
  }
  
  @Test
  public void shouldEchoNumberWhenNotMultipleOfThreeOrFive() {
    assertThat(testee.fizzbuzz(2)).isEqualTo("2");
  }
  
  @Test
  public void shouldFizzFor3() {
    assertThat(testee.fizzbuzz(3)).isEqualTo("fizz");
  }
  
  @Test
  public void shouldFizzFor6() {
    assertThat(testee.fizzbuzz(6)).isEqualTo("fizz");
  }
  
  @Test
  public void shouldBuzzFor5() {
    assertThat(testee.fizzbuzz(5)).isEqualTo("buzz");
  }
  
  @Test
  public void shouldBuzzFor10() {
    assertThat(testee.fizzbuzz(10)).isEqualTo("buzz");
    verify(listener);
  }

  @Test
  public void shouldFizzBuzzWhenMultipleOf3And5() {
    assertThat(testee.fizzbuzz(3 * 5)).isEqualTo("fizzbuzz");
  }
    
}
