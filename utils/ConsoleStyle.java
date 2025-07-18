package utils;

public class ConsoleStyle {

    public static void printHeader(String text) {
        System.out.println("\n===============================");
        System.out.println(">> " + text.toUpperCase());
        System.out.println("===============================\n");
    }

    public static void printSuccess(String text) {
        System.out.println("[✓] " + text);
    }

    public static void printError(String text) {
        System.out.println("[X] " + text);
    }

    public static void printDivider() {
        System.out.println("----------------------------------------");
    }
}
