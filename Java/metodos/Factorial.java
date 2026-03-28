package metodos;

public class Factorial {
        
    private long value = 0, result = 0;
    private String formula = "";

    public void setValor(long val){
        value = val;
        long factorial = 1;
        String form = "";

        for(long x=val; x>1; x--){
            factorial = factorial * x;
            form = form + x + " x ";
        }

        form += "1";
        result = factorial;
        formula = form;
    }

    public long getResult(){
        return result;
    }

    public String getFormula(){
        return formula;
    }
}
