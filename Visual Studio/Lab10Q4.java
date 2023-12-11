import java.util.Random;
import java.util.Scanner;
public class Lab10Q4 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Q4();}
    public static void Q4() {
        boolean start = false;
        boolean loop = false;
        Random rng = new Random();
        int enemyHP = 100;
        int attackNo = 0;
        int weapon = 20;
        int armor = 12;
        int crit = 20;
        int standardBuff = 5;
        boolean buff = false;
        String next;
        boolean doAttack = false;
        boolean check2 = false;
        boolean settings = false;
        while(!loop){
            while(!start){
                System.out.println("Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack or \"S\" to change settings. Kill the enemy to win!");
                System.out.println("Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
                System.out.println("Q4: Your damage is 2-16 (2d8)");
                start = true;}
            while (!check2) {
                next = scan.nextLine();
                check2 = true;
                switch (next) {
                    case "A", "a":
                        doAttack = true;
                        break;
                    case "B", "b":
                        buff = true;
                        System.out.println("Buffing! +5 to your next attack roll and damage");
                        break;
                    case "S", "s":
                        settings=true;
                        break;
                    default:
                        System.out.println("Invalid input");
                        check2 = false;}}
            if (settings){
                boolean settingCtrl = false;
                while(!settingCtrl){
                    System.out.println("In settings you can change different game mechanics to make the game harder or easier");
                    System.out.println("To change weapon, type \"W\". To change enemy's armor, type \"E\". ");
                    System.out.println("To increase character skill (Crit Chance), type \"C\". To change your power attack force (buff), type \"P\". ");
                    System.out.println("Please type \"Q\" to quit settings or one of the above keys to continue:");
                    next = scan.nextLine();
                    switch (next) {
                        case "W", "w":
                            boolean wSettings = true;
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
                        case "E", "e":
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
                        case "C", "c":
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
                                    System.out.println(newCrit + " is an invalid crit number, please select a number between 10 and 20");}
                            break;}
                        case "P", "p":
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
                                    System.out.println(newBuff + " is an invalid buff number, please select a number between -5 and 15");}
                            break;}
                        case "Q", "q":
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
                int damage = 0;
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
                    loop=true;}
            }
        }
    }
}
