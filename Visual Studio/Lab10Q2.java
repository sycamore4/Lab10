import java.util.Scanner;
public class Lab10Q2 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Q2();}
    public static void Q2() {
        String array [] = {"Janurary","Feburary","March","April","May","June","July","August","September","October","November","December"};
        System.out.println("Q2: Enter the current day (1-31): ");
        String day = scan.nextLine();
        int num = Integer.parseInt(day);
        String lastNum = "" + day.charAt(day.length()-1);
        int num1 = Integer.parseInt(lastNum);
        System.out.println("Enter the current month: (1-12)");
        int num2 = Integer.parseInt(scan.nextLine());
        if (num2==2){
            if(num>0 && num<30){
                if(num1==1){
                    System.out.print("You selected " + num +"st of ");}
                else if (num1 == 2){
                    System.out.print("You selected " + num + "nd of ");}
                else if (num1 == 3){
                    System.out.print("You selected " + num + "rd of ");}
                else if (num1 > 3 ){
                    System.out.print("You selected " + num + "th of ");}
                System.out.println("February");
            }}
        else if (num2==4 || num2==6 || num2==9 || num2==11){
            if(num>0 && num<31){
                if (num1==1){
                    System.out.print("You selected " + num +"st of ");}
                else if (num1 == 2){
                    System.out.print("You selected " + num + "nd of ");}
                else if (num1 == 3){
                    System.out.print("You selected " + num + "rd of ");}
                else if (num1 > 3 ){
                    System.out.print("You selected " + num + "th of ");}
                for(int mnths = 11; mnths>=0; mnths--){
                    if(mnths+1 == num2){
                        System.out.println(array[mnths]);}}
            }}
        else if (num2==1 || num2==3 || num2==5 || num2==7 || num2==8 || num2==10 || num2==12){
            if(num>0 && num<32){
                if (num1==1){
                    System.out.print("You selected " + num +"st of ");}
                else if (num1 == 2){
                    System.out.print("You selected " + num + "nd of ");}
                else if (num1 == 3){
                    System.out.print("You selected " + num + "rd of ");}
                else if (num1 > 3 ){
                    System.out.print("You selected " + num + "th of ");}
                for(int mnths = 11; mnths>=0; mnths--){
                    if(mnths+1 == num2){
                        System.out.println(array[mnths]);}}
                }}
    }
}
