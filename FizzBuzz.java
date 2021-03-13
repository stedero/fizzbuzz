public class FizzBuzz {
 
    public static void main(String[] args) {
        Sound sound = new Sound(3, "Fizz", new Sound(5, "Buzz"));
        for (int i = 1; i <= 100; i++) {
            System.out.println(sound.generate(i));
        }
    }
 
    private static class Sound {
        private final int trigger;
        private final String onomatopoeia;
        private final Sound next;
 
        public Sound(int trigger, String onomatopoeia, Sound next) {
            this.trigger = trigger;
            this.onomatopoeia = onomatopoeia;
            this.next = next;
        }
 
        public Sound(int trigger, String sound) {
            this(trigger, sound, null);
        }
 
        public String generate(int i) {
            StringBuilder sb = new StringBuilder();
            generate(sb, i);
            return sb.length() == 0 ? String.valueOf(i) : sb.toString();
        }
 
        private void generate(StringBuilder sb, int i) {
            if (i % trigger == 0)
                sb.append(onomatopoeia);
            if (next != null) 
                next.generate(sb, i);
        }
 
    }
 
}
