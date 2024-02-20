
public class VendingMachine{
    public static void main(String[] args){

        String[][] snacks = {
            {"Chips","1.50"},
            {"Protien Bar", "2.00"},
            {"Cookies", "1.50"},
        };

        System.out.println("Avaiable Snacks;");
        
            for(int i = 0; i<snacks.length;i++){
                System.out.println(snacks[i][0]+"$"+snacks[i][1]);
            }
        }


    }
