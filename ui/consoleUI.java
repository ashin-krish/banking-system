
package ui;

public class consoleUI {

    public static void header(String title) {
        System.out.println("\n========================================");
        System.out.println("       " + title.toUpperCase());
        System.out.println("========================================");
    }

    public static void line() {
        System.out.println("----------------------------------------");
    }
}