/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ármin
 */
public class Mob {
    private int health;
    private int xp;
    private int gold;
    private Item drop;
    private String name;
    private double chance;
    private int defense;
    
    public Mob(int h,int x, int g, Item d, String n, double c, int def) {
        this.health = h;
        this.xp = x;
        this.gold = g;
        this.drop = d;
        this.name = n;
        this.chance = c;
        this.defense = def;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public String getName() {
        return name;
    }
    
    public void takeHealth(int number) {
        if (!(health ==0)) {
            this.health-=number;
            if (this.health < 0) {
                this.health = 0;
            }
        }
    }
    
    public void setHealth(int number) {
        health = number;
        
    }
    
    public String toString() {
        return (name + ": " + health + "hp");
    }
    
    public int getXp() {
        return xp;
    }
    
    public int getGold() {
        return gold;
    }
    
    public int getDefense() {
        return defense;
    }
    
    public Item getItem() {
        return drop;
    }
    
    
    
}
