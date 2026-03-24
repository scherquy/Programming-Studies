package estruturasrepeticao;

public class Fatorial {
    public static void main(String[] args) {
        
        long factorial = (long) 0;
        int value = (int) 0;

        while(value <= 12){
            if(value == 0){
                factorial = (byte) 1;
            }   else{
                    factorial = (long) (factorial * value);
                }

            System.out.printf("\nFactorial of %d = %d", value, factorial);

            value++;
        }

        System.out.printf("\n\n");
    }   
}
