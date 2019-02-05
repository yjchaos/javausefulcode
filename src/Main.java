public class Main {

    public static void main(String[] args) {
        char[] chars = Character.toChars(0x1D546);
        System.out.println(chars);
    }

    static final int tableSizeFor(int cap) {
        // String s = "\uD834\uDF06";
        // String s1 = "\uD835\uDD46";
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }

}
