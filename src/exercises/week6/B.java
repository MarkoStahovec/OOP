package exercises.week6;

public class B extends A {
	void m() throws MySubexception { // prekladac toto nepovoli
		/* ... */				// klientsky kod (ktory je v triede C) by zavedenim dalsej vynimky, ktora nie je odvodena od uz deklarovanej, bol zneplatneny
	}
}
