package compararstrings;

public class CompararStrings {
    public static void main(String[] args) {
        
        String name1 = "João";
        String name2 = "João";
        String name3 = new String("João");

        String result = (name1.equals(name3)) ? "igual" : "diferente";

        System.out.printf("\n%s\n\n", result);

    }
}
