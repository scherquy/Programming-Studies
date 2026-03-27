package vetores;

public class MouthAndDaysOfYear {
    public static void main(String[] args) {
        
        String mouth[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int x=0; x<mouth.length; x++){
            System.out.printf("\n%s tem %d dias", mouth[x], days[x]);
        }

        System.out.printf("\n\n");
    }
}
