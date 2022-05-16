package asciicharsequence;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    protected byte[] seq;

    public AsciiCharSequence(byte[] seq) {
        this.seq = seq.clone();
    }

    @Override
    public int length() {
        return seq.length;
    }

    @Override
    public char charAt(int index) {
        return (char)seq[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(seq, start, end));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (byte val : seq) {
            builder.append((char)val);
        }

        return builder.toString();
    }
}