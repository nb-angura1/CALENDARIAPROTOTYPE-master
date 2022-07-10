public class Padder {
    public static String rightPadding(String input, char ch, int L){
        // First right pad the string
        // with space up to length L
                 String result =String.format("%" + (-L) + "s", input)

                // Then replace all the spaces
                // with the given character ch
                .replace(' ', ch);
                 return result;
    }
}

