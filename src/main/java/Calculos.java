public class Calculos {

    public static double totalObtido(){
        double total;
        total = Controller.mbValor() + Controller.cashValor() + Controller.otherValor();
        return total;
    }

    public static double desvio(){
        double desv;
        double totalPrev;
        double totalObt;

        totalObt = totalObtido();
        totalPrev = Controller.totalPrev();

        desv = totalPrev - totalObt;

        return desv;
    }
}
