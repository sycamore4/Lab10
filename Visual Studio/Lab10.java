import java.util.Random;
import java.util.Scanner;
public class Lab10 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Q1();
        Q2();
        Q3();
        Q4();
        scan.close();}

    public static void Q1() {
        double a, b, r, circum = 0, area = 0;// declared all of the variables at the start of the function
        String input = "";
        while (true) {
            System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");
            input = scan.nextLine();
            if (input.equals("q")) {
                return;}
            if (input.equals("square")) {
                System.out.println("Enter the length of side a: ");
                a = Double.parseDouble(scan.nextLine());
                circum =  a * 4;  // found circumference and area inside if statements to save unnecessary prints
                area =  a * a;}
            else if (input.equals("rectangle")) {
                System.out.println("Enter the length of side a: ");
                a = Double.parseDouble(scan.nextLine());
                System.out.println("Enter the length of side b: ");
                b = Double.parseDouble(scan.nextLine());
                circum = (2 * a + 2 * b);
                area = a * b;}
            else if (input.equals("circle")) {
                System.out.println("Enter the radius: ");
                r = Double.parseDouble(scan.nextLine());
                circum = Math.PI * r * 2;
                area = Math.PI * r * r;}
            else{
                System.out.println("Invalid Entry");
                continue;}
        System.out.println("The circumference of the " + input + " is: " + circum); // added print statements outside of if & else if statments
        System.out.println("The area of the " + input + " is: " + area);}
}
    public static void Q2() {
        String array [] = {"Janurary","Feburary","March","April","May","June","July","August","September","October","November","December"};
        System.out.println("Q2: Enter the current day (1-31): "); // I gave each month it's own spot in the array so I could call it later 
        String day = scan.nextLine();
        int num = Integer.parseInt(day);
        String lastNum = "" + day.charAt(day.length()-1); // found the last digit of the day so I knew what suffix to add
        int num1 = Integer.parseInt(lastNum); 
        System.out.println("Enter the current month: (1-12)");
        int num2 = Integer.parseInt(scan.nextLine());
        if (num2==2){ // first of all checked the month to make sure there were the right amount of days in the month
            if(num>0 && num<30){ // included the 29th of Feburary as years were not specified
                if(num1==1){
                    System.out.print("You selected " + num +"st of ");}
                else if (num1 == 2){
                    System.out.print("You selected " + num + "nd of ");}
                else if (num1 == 3){
                    System.out.print("You selected " + num + "rd of ");}
                else if (num1 > 3 ){
                    System.out.print("You selected " + num + "th of ");}
                System.out.println("February");} // since only one month has 29 days, this one is guarenteed to be Feburary
            else{
                System.out.println("Invalid Day");}}
        else if (num2==4 || num2==6 || num2==9 || num2==11){ // these two lines check that the day is less than there is in April, June, September and November
            if(num>0 && num<31){
                if (num1==1){
                    System.out.print("You selected " + num +"st of ");}
                else if (num1 == 2){
                    System.out.print("You selected " + num + "nd of ");}
                else if (num1 == 3){
                    System.out.print("You selected " + num + "rd of ");}
                else if (num1 > 3 || num1 ==0){
                    System.out.print("You selected " + num + "th of ");}
                for(int mnths = 11; mnths>=0; mnths--){ // this is a for loop to count backwards through the array until it finds which index+1 is equal to the month number
                    if(mnths+1 == num2){
                        System.out.println(array[mnths]);}}} // this prints the content of the array[mnths] when it finds the correct index
            else{
                System.out.println("Invalid Day");}}
        else if (num2==1 || num2==3 || num2==5 || num2==7 || num2==8 || num2==10 || num2==12){
            if(num>0 && num<32){ // This else if does the same for Janurary, March, May, July, August, October, December
                if (num1==1){
                    System.out.print("You selected " + num +"st of ");}
                else if (num1 == 2){
                    System.out.print("You selected " + num + "nd of ");}
                else if (num1 == 3){
                    System.out.print("You selected " + num + "rd of ");}
                else if (num1 > 3 || num1 ==0){
                    System.out.print("You selected " + num + "th of ");}
                for(int mnths = 11; mnths>=0; mnths--){
                    if(mnths+1 == num2){
                        System.out.println(array[mnths]);}}} // This improved use of if/if else saves nearly 50 needless lines
            else{
                System.out.println("Invalid Day");}}}

public static void Q3() {
    System.out.println("Q3: Enter how many numbers you want to check for primality: ");
    int n = Integer.parseInt(scan.nextLine());
    int counter = 0;
    for (int i = 0; i < n; i++) {
        if (i < 2) // for this question I just fixed the indentation and got rid of unnecessary elses
            continue;
            boolean check = true;
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                check = false;
                break;}} // the else statements here did not add anything and just took up room
            if (check == true) {
                counter++;}}
    System.out.println("There are: " + counter + " primes between 0 and " + n);
    }

    public static void Q4() {
        boolean start = false;
        boolean loop = false; // for this question, i added a new option to the start screen for settings,
        Random rng = new Random(); // so people can tweak the numbers of their game
        int enemyHP = 100;
        int attackNo = 0;
        int weapon = 20;
        int armor = 12; // i assigned each of the alterable numbers its own variable
        int crit = 20;
        int standardBuff = 5;
        boolean buff = false;
        String next;
        boolean doAttack = false;
        boolean check2 = false;
        boolean settings = false;
        while(!loop){ 
            while(!start){ // i changed the first menu to be in a loop that can be called several times 
                System.out.println("Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack or \"S\" to change settings. Kill the enemy to win!");
                System.out.println("Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
                System.out.println("Q4: Your damage is 2-16 (2d8)");
                start = true;}
            while (!check2) { // the input section was also put in a while loop so that the game will continue
                next = scan.nextLine();
                check2 = true;
                switch (next) {
                    case "A", "a":
                        doAttack = true;
                        break;
                    case "B", "b":
                        buff = true;
                        System.out.println("Buffing! +" + standardBuff +" to your next attack roll and damage");
                        check2=false;
                        break;
                    case "S", "s": // here is the input for engaging the settings loop
                        settings=true;
                        break;
                    default:
                        System.out.println("Invalid input");
                        check2 = false;}}
            if (settings){
                boolean settingCtrl = false;
                while(!settingCtrl){ // here i lay out a way to run settings again and again so that when the player alters one setting, it brings you back to the setting screen,
                    System.out.println("In settings you can change different game mechanics to make the game harder or easier");// not the main menu
                    System.out.println("To change weapon, type \"W\". To change enemy's armor, type \"E\". ");
                    System.out.println("To increase character skill (Crit Chance), type \"C\". To change your power attack force (buff), type \"P\". ");
                    System.out.println("Please type \"Q\" to quit settings or one of the above keys to continue:");
                    next = scan.nextLine();
                    switch (next) {
                        case "W", "w":
                            boolean wSettings = true; // this alters the possible damage done by changing the random number to go up as far as 40 or as low as 1
                            while(wSettings){
                                System.out.println("To change your weapon, you can choose any number between 1 and 40.");
                                System.out.println("The standard is 20, so 40 will double it and 1 will make it do 5% of the base damage.");
                                System.out.println("Please enter your number:");
                                int weapMulti = scan.nextInt();
                                if(weapMulti>0 && weapMulti<41){
                                    weapon = weapMulti;
                                    wSettings=false;
                                    break;}
                                else{
                                    System.out.println(weapMulti + " is an invalid weapon choice, please select a number between 1 and 40");}}
                            break;
                        case "E", "e": // this does the same for enemy armor
                            boolean eSettings = true;
                            while(eSettings){
                                System.out.println("To change the enemy's armor, you can choose any number between 1 and 24.");
                                System.out.println("The standard is 12, so 24 will double it and 1 will make it do 8.33% of the base protection.");
                                System.out.println("Please enter your number:");
                                int enemyArmor = scan.nextInt();
                                if(enemyArmor>0 && enemyArmor<25){
                                    armor = enemyArmor;
                                    eSettings=false;
                                    break;}
                                else{
                                    System.out.println(enemyArmor + " is an invalid armor choice, please select a number between 1 and 24");}}
                            break;
                        case "C", "c": // this does the same for critical chance
                            boolean cSettings = true;
                            while(cSettings){
                                System.out.println("To change your skill and alter your crit chance, you can choose any number between 10 and 20.");
                                System.out.println("The standard is 20, so 10 will make it double as likely to get a critical hit.");
                                System.out.println("Please enter your number:");
                                int newCrit = scan.nextInt();
                                if(newCrit>9 && newCrit<21){
                                    crit = newCrit;
                                    cSettings=false;
                                    break;}
                                else{
                                    System.out.println(newCrit + " is an invalid crit number, please select a number between 10 and 20");}}
                            break;
                        case "P", "p": // this alters the number behind the buff
                            boolean pSettings = true;
                            while(pSettings){
                                System.out.println("To change your power attack force to alter your buff, you can choose any number between -5 and 15.");
                                System.out.println("The standard is 5, so 15 will make it double as deadly and -5 will add decrease damage dealt.");
                                System.out.println("Please enter your number:");
                                int newBuff = scan.nextInt();
                                if(newBuff>-6 && newBuff<16){
                                    standardBuff = newBuff;
                                    pSettings=false;
                                    break;}
                                else{
                                    System.out.println(newBuff + " is an invalid buff number, please select a number between -5 and 15");}}
                            break;
                        case "Q", "q": // this brings the user back to the main menu by disengaging the settings loops and setting the main menu loops to true
                            settingCtrl = true;
                            settings = false;
                            start = false;
                            check2 = false;
                            break;
                        default:
                            System.out.println("Invalid input");
                            settingCtrl = false;}}}
            if (doAttack){
                attackNo++;
                int attackRoll = rng.nextInt(weapon) + 1;
                int damage = 0; // in this part of the code, i changed the numbers frpm being hardcoded to instead work off my variables that can be changed in settings
                System.out.print("You rolled: " + attackRoll);
                if(buff) {
                    attackRoll += standardBuff;
                    System.out.print(" + " + standardBuff + " (buff active)\n");}
                else {
                    System.out.println();}
                if (attackRoll >= armor) {
                    damage = rng.nextInt(8) + 1;
                    damage += rng.nextInt(8) + 1;
                    if(buff) {
                        damage += standardBuff;}
                    if (attackRoll >= crit || (buff && attackRoll == crit + standardBuff)) {
                        damage *= 2;
                        System.out.print("Critical hit! ");}
                    System.out.print("You dealt " + damage + " damage");
                    if(buff) {
                        System.out.print(" (buffed attack)");}
                    enemyHP -= damage;
                    System.out.println("\nEnemy HP: " + Math.max(0, enemyHP));}
                else {
                    System.out.println("Miss");}
                check2=false;
                buff = false;
                if (enemyHP <= 0) {
                    System.out.println("Enemy died in " + attackNo + " turns");
                    scan.close();
                    loop=true;} // this turns off the loop that powers the whole game when the enemy is dead
            }
        }
    }
}
