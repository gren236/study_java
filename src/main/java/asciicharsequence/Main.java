package asciicharsequence;

public class Main {
    public static void main(String[] args) {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Sequence - " + answer.toString());//Hello!
        System.out.println("Size - " + answer.length());//6
        System.out.println("First symbol - " + answer.charAt(1));//e
        System.out.println("Subsequence - " + answer.subSequence(1, 5));//ello
        // check for private field encapsulation
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    }
}
