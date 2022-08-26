import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Parser {
    String ulaz = "";
    LinkedList<String> input = new LinkedList<>(); //Derived from ulaz
    String readInput = ""; //used in parser functions
    Boolean breakeRecursion = false;

    Parser(String ulaz){
        this.ulaz = ulaz;

        var charArray = ulaz.toCharArray();
        for(var temp: charArray){
            input.add(Character.toString(temp));
        }
        input.add("$");
        input.add("$");
    }

    void GlavniPorgram(){


            readInput = input.getFirst();
            readInput = input.removeFirst();

            if(readInput.equals("$") == false) {
                S();

            } else{
            System.out.println("NE");
            return;
        }

        if(readInput.equals("$") == false || input.getFirst().equals("$") == false || breakeRecursion == true){
            System.out.print("\n");
            System.out.print("NE" + "\n");

        }else{
            System.out.print("\n");
            System.out.print("DA" + "\n");
        }
    }

    void S(){

        if(breakeRecursion){
            return;
        }

        System.out.print("S");

        if (readInput.equals("a")) {
            readInput = input.getFirst();
            readInput = input.removeFirst();
            A();
            B();
            return;
        }

        else if (readInput.equals("b")) {

            readInput = input.getFirst();
            readInput = input.removeFirst();
            B();
            A();
            return;
        }

//        System.out.println("NE");
        breakeRecursion = true;
        return;
    }

    void A(){


        if(breakeRecursion){
            return;
        }

        System.out.print("A");

        if(readInput.equals("b")){
            readInput = input.getFirst();
            readInput = input.removeFirst();
            C();
            return;
        }

        else if(readInput.equals("a")){
//            System.out.print("A");
            readInput = input.getFirst();
            readInput = input.removeFirst();
            return;
        }


        breakeRecursion = true;
        return;
    }

    void B(){

        if(breakeRecursion){
            return;
        }

        else if(readInput.equals("c")){
            System.out.print("B");
            readInput = input.getFirst();
            readInput = input.removeFirst();

            if(readInput.equals("c") == false){
//                System.out.println("NE");
                breakeRecursion = true;
                return;
            }

            readInput = input.getFirst();
            readInput = input.removeFirst();



            S();

            if(readInput.equals("b") == false){
//                System.out.println("NE");
                return;
            }

            readInput = input.getFirst();
            readInput = input.removeFirst();

            if(readInput.equals("c") == false){
//                System.out.println("NE");
                breakeRecursion = true;
                return;
            }

            readInput = input.getFirst();
            readInput = input.removeFirst();

            return;
        }


        System.out.print("B");
        return; //Epsilon


//        breakeRecursion = true;
//        return;
    }

    void C(){

        if(breakeRecursion){
            return;
        }
        System.out.print("C");

        A();
        A();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = new FileWriter("./output.txt");


        String s; // Read file
        s = reader.readLine();

        Parser autmat = new Parser(s);

        autmat.GlavniPorgram();

        writer.close();

    }
}
