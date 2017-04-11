/**
 * Matthew Allen Phillips.
 * 10 April 2017
 * FizzBuzzOOP.java
 */

package model;

/**
 * This program demostrates the classic FizzBuzz
 * problem with a clean Object-Oriented approach.
 * 
 * @author Matt Phillips
 * @version 10 April 2017
 */
public class FizzBuzzOOP {

	public static void main(final String... args) {
		Sound sound = new Sound(3, "Fizz", new Sound(5, "Buzz"));
		for (int i = 0; i <= 100; i++) {
			System.out.println(sound.generate(i));
		}
	}
	
	/**
	 * Defines a single sound by its numerical
	 * trigger and its onomatopeia, tied together.
	 */
	private static class Sound {
		
		private final int trigger;
		private final String onomatopeia;
		private final Sound next;
		
		public Sound(final int trigger, final String onomatopeia,
				final Sound next) {
			this.trigger = trigger;
			this.onomatopeia = onomatopeia;
			this.next = next;
		}
		
		public Sound(final int trigger, final String onomatopeia) {
			this(trigger, onomatopeia, null);
		}
		
		public String generate(final int i) {
			StringBuilder sb = new StringBuilder();
			generate(sb, i);
			return sb.length() == 0 ? String.valueOf(i) : sb.toString();
		}
		
		public void generate(StringBuilder sb, final int i) {
			if (i % trigger == 0)
				sb.append(onomatopeia);
			if (next != null)
				next.generate(sb, i);
		}
	}
}
