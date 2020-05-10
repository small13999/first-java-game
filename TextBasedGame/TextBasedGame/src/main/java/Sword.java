

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ármin
 */
public class Sword {
    private int baseDamage;
    private int damage;
    private String name;
    private int enchant;
    private boolean isOwned;
    private int enchantModifier;
    
    public Sword(int baseDamage, String name, int enchant, int enchantModifier) {
        this.baseDamage = baseDamage;
        this.damage = baseDamage + enchant*enchantModifier;
        this.name = name;
        this.enchant = enchant;
        this.enchantModifier = enchantModifier;
    }
    
    public int getDamage() {
        return this.damage;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getEnchant() {
        return this.enchant;
    }
    
    public int getEnchantMod() {
        return this.enchantModifier;
    }
    
    public int getBaseDamage() {
        return this.baseDamage;
    }
    
    
    public void equip() {
        Character.player.setSword(this);
    }
    
    public String toString() {
        return (name + " +" + enchant + ". Current Damage: "  + damage + ". Bonus damage per enchant level: " + enchantModifier);
    }
    
}
