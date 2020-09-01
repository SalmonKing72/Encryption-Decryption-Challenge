import java.nio.charset.StandardCharsets;
import java.util.*;

class AsciiCharSequence implements CharSequence{
    private byte[] chars;

    public AsciiCharSequence(byte[] chars) {
        this.chars = chars;
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int i) {
        return (char) chars[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(this.chars, i, i1));
    }

    @Override
    public String toString() {
        return new String(this.chars, StandardCharsets.US_ASCII);
    }

    public byte[] getChars() {
        return chars;
    }

    public void setChars(byte[] chars) {
        this.chars = chars;
    }
}
