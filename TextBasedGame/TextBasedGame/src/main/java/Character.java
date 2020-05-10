
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ármin
 */
public class Character {
    private int level;
    private int xp;
    private int gold;
    private Inventory inv;
    private Sword sword;
    private int xpNext = 10;
    private ArrayList<String> ownedSwords;
    
    public Character() {
        this.gold = 0;
        this.xp = 0;
        this.level = 1;
        this.inv = new Inventory();
        this.sword = new Sword(0, "Hands", 0,1);
        this.ownedSwords = new ArrayList<>();
        
    }
    public static Character player = new Character();
    
    public void setSword(Sword sword) {
        this.sword = sword;
    }

    public Sword getSword() {
        return this.sword;
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getSwordEnchant() {
        return sword.getEnchant();
    }
    
    public int getSwordEnchantMod() {
        return sword.getEnchantMod();
    }
    
    public int getSwordBaseDamage() {
        return sword.getBaseDamage();
    }
    
    public String getSwordName() {
        return sword.getName();
    }
    
    public int getSwordDamage() {
        return sword.getDamage();
    }
    
    public void addGold(int number) {
        gold+=number;
    }
    
    public int getXpNext() {
        return xpNext;
    }
    
    public Inventory getInventory() {
        return this.inv;
    }
    
    public void addXp(int number) {
        xp+=number;
        if (xp >= xpNext) {
            int saved = xp - xpNext;
            this.levelUp();
            xp = 0;
            xp+=saved;
        }
    }
    
    public int getGold() {
        return gold;
    }
    
    public boolean takeGold(int number) {
        if(number <= gold) {
            gold-=number;
            return true;
        }
        return false;
    }
    
    public int getXp() {
        return xp;
    }
    
    public void levelUp() {
    level++;
    xpNext+=10*(level-1);
        System.out.println("You have leveled up to level " + level + "! XP needed for level " + (level+1) + ": " + xpNext);
        
    }
    
    public void addOwnedSword(String sword) {
        this.ownedSwords.add(sword);
    }
    
    public boolean ownsSword(String sword) {
        return this.ownedSwords.contains(sword);
    }
    
    
    
}
