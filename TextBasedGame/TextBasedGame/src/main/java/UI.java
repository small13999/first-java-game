
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ármin
 */
public class UI {
    private final Scanner scanner;
    
    public UI(Scanner scanner) {
        this.scanner = scanner;
        
    }
    
    public void start() {
        
        System.out.println("Welcome to the text based game v1");
        System.out.println("The goal of this game is to kill animals, get gold, xp, and loot, level up, buy new swords, enchant your swords, and kill stronger monsters!");
        System.out.println("Each level gives you 1 extra damage. Each defense of an enemy reduces your damage dealt to them by 1.");
        System.out.println("Use loot to enchant your swords, each mob drops items with a 10% chance.");
        System.out.println("Start menu");
        System.out.println("Start game - 1");
        System.out.println("Exit - 2");
        int command = Integer.valueOf(scanner.nextLine());
        if (command == 1) {
            System.out.println("This is the main game, you can navigate from here");
            this.game();
            
        }
    }
    
    public void game() {
        System.out.println("------Main Menu------");
        System.out.println("Fight - 1");
        System.out.println("Shop - 2");
        System.out.println("Enchant - 3");
        System.out.println("Character and inventory - 4");
        
        
        String command = scanner.nextLine();
        
        if (command.equals("1")) {
            this.fightMenu();
        } else if (command.equals("2")) {
            this.shop();
        } else if (command.equals("3")) {
            this.enchant();
        } else if (command.equals("4")) {
            this.character();
        } else {
            System.out.println("Unknown command. Please choose a valid command");
            this.game();
        }
        
        
    }
    
    public void fightMenu() {
        System.out.println("1 - Mouse: 10 hp, 1 xp, 1 gold, 0 def. Can drop: Leather");
        System.out.println("2 - Dog: 25 hp, 3 xp, 2 gold, 1 def. Can drop: Bone");
        System.out.println("3 - Wolf: 80 hp, 5 xp, 4 gold, 3 def. Can drop: Fangs");
        System.out.println("4 - Bear: 200 hp, 10 xp, 7 gold, 5 def. Can drop: Bear Skin");
        System.out.println("5 - Elephant: 500 hp, 20 xp, 15 gold, 8 def. Can drop: Elephant Trunk");
        System.out.println("6 - Boss of the Forest: 3000 hp, 100 xp, 100 gold, 15 def. Can drop: Golden Crown");
        System.out.println("0 - Back to the Menu");
        String command = scanner.nextLine();
        if (command.equals("0")) {
            this.game();
        } else if (command.equals("1")) {
            //item name, hp, xp, gold, mob name, drop chance, def
            this.fightMob("Leather", 10, 1, 1, "Mouse", 0.1, 0);
        } else if (command.equals("2")) {
            this.fightMob("Bone", 25, 3, 3, "Dog", 0.1, 1);
        } else if (command.equals("3")) {
            this.fightMob("Fangs", 80, 5, 7, "Wolf", 0.1, 3);
        } else if (command.equals("4")) {
            this.fightMob("Bear Skin", 200, 10, 15, "Bear", 0.1,5);
        } else if (command.equals("5")) {
            this.fightMob("Elephant Trunk", 500, 20, 30, "Elephant", 0.1, 8);
        } else if (command.equals("6")) {
            this.fightMob("Golden Crown", 3000, 100, 100, "Boss of the Forest", 0.1, 15);
        } else {
            System.out.println("Unknown command. Please enter a valid command");
            this.fightMenu();
        }
        
    }
    
    public void shop() {
        System.out.println("Welcome to the shop! Here you can buy new swords. Current balance: " + Character.player.getGold() + " Gold");
        Sword wsword = new Sword(1, "Wooden Sword", 0,1);
        String wswords = "Wooden Sword";
        Sword ssword = new Sword(3, "Stone Sword", 0,2);
        String sswords = "Stone Sword";
        Sword isword = new Sword(10, "Iron Sword", 0,5);
        String iswords = "Iron Sword";
        Sword stsword = new Sword(30, "Steel Sword", 0,10);
        String stswords = "Steel Sword";
        Sword gsword = new Sword(50, "Gemstone Sword", 0,20);
        String gswords = "Gemstone Sword";
        if (Character.player.ownsSword(wswords)) {
            System.out.println("1 - Wooden Sword +0. Damage: 1 Bonus damage per enchant level: 1 Already owned");
        } else {
            System.out.println("1 -  Wooden Sword +0. Damage: 1 Bonus damage per enchant level: 1 Cost: 10 Gold ");   
        }
        if (Character.player.ownsSword(sswords)) {
            System.out.println("2 - Stone Sword +0. Damage: 3 Bonus damage per enchant level: 2 Already owned");
        } else {
            System.out.println("2 -  Stone Sword +0. Damage: 3 Bonus damage per enchant level: 2 Cost: 75 Gold ");   
        }
        if (Character.player.ownsSword(iswords)) {
            System.out.println("3 - Iron Sword +0. Damage: 10 Bonus damage per enchant level: 5 Already owned");
        } else {
            System.out.println("3 -  Iron Sword +0. Damage: 10 Bonus damage per enchant level: 5 Cost: 250 Gold ");   
        }
        if (Character.player.ownsSword(stswords)) {
            System.out.println("4 - Steel Sword +0. Damage: 30 Bonus damage per enchant level: 10 Already owned");
        } else {
            System.out.println("4 -  Steel Sword +0. Damage: 30 Bonus damage per enchant level: 10 Cost: 1000 Gold ");   
        }
        if (Character.player.ownsSword(gswords)) {
            System.out.println("5 - Gemstone Sword +0. Damage: 50 Bonus damage per enchant level: 20 Already owned");
        } else {
            System.out.println("5 -  Gemstone Sword +0. Damage: 50 Bonus damage per enchant level: 20 Cost: 3000 Gold ");   
        }
        System.out.println("0 - Back to the menu");
        String command = scanner.nextLine();
        if (command.equals("1")) {
            this.buySword(wsword, wswords, 10);
        } else if(command.equals("0")) {
            this.game();
        } else if (command.equals("2")) {
            this.buySword(ssword, sswords, 75);
        } else if (command.equals("3")) {
            this.buySword(isword, iswords, 250);
        } else if (command.equals("4")) {
            this.buySword(stsword, stswords, 1000);
        } else if (command.equals("5")) {
            this.buySword(gsword, gswords, 3000);
        }
        
    }
    
    public void buySword(Sword sword,String ssword, int price) {
        if (Character.player.ownsSword(ssword)) {
                System.out.println("You already own this sword!");
                this.shop();
            }
            if (Character.player.takeGold(price)) {
                System.out.println("Purchase successful! Remaining gold: " + Character.player.getGold());
                Character.player.setSword(sword);
                Character.player.addOwnedSword(ssword);
                this.game();
            } else {
                System.out.println("You don't have enough gold!");
                this.game();
            }
    }
    
    
    public void enchant() {
        System.out.println("Welcome to the enchanter! Here you can enchant your swords");
        String name = Character.player.getSwordName();
        int damage = Character.player.getSwordBaseDamage();
        int enchant = Character.player.getSwordEnchant();
        int enchantMod = Character.player.getSwordEnchantMod();
        String item = "";
        if (name.equals("Wooden Sword")) {
            item = ("Leather");
        }
        if (name.equals("Stone Sword")) {
            item = ("Bone");
        }
        if (name.equals("Iron Sword")) {
            item = ("Fangs");
        }
        if (name.equals("Steel Sword")) {
            item = ("Bear Skin");
        }
        if (name.equals("Gemstone Sword")) {
            item = ("Elephant Trunk");
        }
        if (name.equals("Hands")) {
            System.out.println("You can't enchant your hands! Come back when you have a sword");
            this.wait(1000);
            this.game();
        }
        System.out.println("1 - Enchant your sword: " + Character.player.getSword() + " Cost: " + (enchant + 1) + " " + item + ".");
        System.out.println("0 - Back to the Menu");
        String command = scanner.nextLine();
        if (command.equals("0")) {
            this.game();
        } else if (command.equals("1")) {
            if (Character.player.getInventory().getItemCount(item) >= (enchant + 1)) {
                Character.player.getInventory().takeItem(item, (enchant+1));
                enchant++;
                Sword sword = new Sword(damage, name, (enchant), enchantMod);
                System.out.println("Sword successfully enchanted! New damage of your sword: " + sword.getDamage());
                Character.player.setSword(sword);
                wait(1000);
                this.game();
                
                
            }
        }
        
        
    }
    
    public void character() {
        System.out.println("Current level: " + Character.player.getLevel() + ". XP to next level: " + Character.player.getXp() + "/" + Character.player.getXpNext());
        System.out.println("Gold: " + Character.player.getGold());
        System.out.println("1 - Swords");
        System.out.println("2 - Items");
        System.out.println("0 - Back to the Menu");
        String command = scanner.nextLine();
        if (command.equals("0")) {
            this.game();
        } else if (command.equals("1")) {
            this.swords();
        } else if (command.equals("2")) {
            this.items();
        } else {
            System.out.println("Unknown command. Please choose a valid command");
            this.character();
        }
        
    }
    
    public void swords() {
        System.out.println("Current sword: " + Character.player.getSword());
        System.out.println("0 - Back to the Menu");
        String command = scanner.nextLine();
        if (command.equals("0")) {
            this.game();
        }
        
    }
    
    public void items() {
        boolean s = false;
        if (Character.player.getInventory().getItemCount("Leather") > 0) {
            System.out.println("Leather: " + Character.player.getInventory().getItemCount("Leather"));
            s = true;
        }
        if (Character.player.getInventory().getItemCount("Bone") > 0) {
            System.out.println("Bone: " + Character.player.getInventory().getItemCount("Bone"));
            s = true;
        }
        if (Character.player.getInventory().getItemCount("Fangs") > 0) {
            System.out.println("Fangs: " + Character.player.getInventory().getItemCount("Fangs"));
            s = true;
        }
        if (Character.player.getInventory().getItemCount("Bear Skin") > 0) {
            System.out.println("Bear Skin: " + Character.player.getInventory().getItemCount("Bear Skin"));
            s = true;
        }
        if (Character.player.getInventory().getItemCount("Elephant Trunk") > 0) {
            System.out.println("Elephant Trunk: " + Character.player.getInventory().getItemCount("Elephant Trunk"));
            s = true;
        }
        if (Character.player.getInventory().getItemCount("Golden Crown") > 0) {
            System.out.println("Golden Crown: " + Character.player.getInventory().getItemCount("Golden Crown"));
            s = true;
        }
        if (s == false) {
            System.out.println("You have no items!");
        }
        System.out.println("0 - Back to the menu");
        String command = scanner.nextLine();
        if (command.equals("0")) {
            this.game();
        }
    }
    
    public void fight(Mob mob, int j) {
        int health = mob.getHealth();
        
        for (int i = 0; i < j; i++) {
            mob.setHealth(health);
            System.out.println("You are now fighting " + mob);
            this.wait(500);
            while(mob.getHealth() > 0) {
                mob.takeHealth(Character.player.getLevel() + Character.player.getSwordDamage() - mob.getDefense());
                if (mob.getHealth() == 0) {
                    System.out.println(mob.getName() + " successfully defeated! Remaining " + mob.getName() + ": " + (j-(i+1)));
                    Character.player.addGold(mob.getGold());
                    Character.player.addXp(mob.getXp());
                    if (this.randomItemDrop()) {
                        System.out.println(mob.getName() + " dropped " + mob.getItem().getName() + "!");
                        Character.player.getInventory().addItem(mob.getItem().getName());
                    }
                    break;
                } else {
                    this.wait(500);
                    System.out.println("You hit " + mob.getName() + " for " + (Character.player.getLevel() + Character.player.getSwordDamage() - mob.getDefense()) + " hp. Remaining hp: " + mob.getHealth());
                }
            }
        }
        
        this.fightMenu();
        
    }
    
    public int fitInput(int number) {
        if (number <= 0) {
            return 1;
        } else if (number > 10) {
            return 10;
        }
        else return number;
    }
    
    public void wait(int number) {
        try {
         TimeUnit.MILLISECONDS.sleep(number);   
         }
         catch(InterruptedException ex)
         {
         }
        
    }
    
    public boolean randomItemDrop() {
        Random rand = new Random();
        return rand.nextInt(10) == 5;
    }
    
    public void fightMob(String name, int h,int x, int g, String n, double c, int def) {
        Item item = new Item(name);
        Mob mob = new Mob(h,x,g,item,n,c,def);
        if ((Character.player.getLevel() + Character.player.getSwordDamage()) <= mob.getDefense()) {
                System.out.println("Your damage is too low, you will never be able to kill " + mob.getName()+ ". Please choose another enemy" );
                this.wait(1000);
                this.fightMenu();
            }
            System.out.println("Fight how many times? Min 1, Max 10");
            int a = Integer.valueOf(scanner.nextLine());
            this.fight(mob,fitInput(a));
        
    }
}
