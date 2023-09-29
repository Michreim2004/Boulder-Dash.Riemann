import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Erde extends Actor
{
    public void act()
    {
        if (isTouching(Player.class)) {
            getWorld().removeObject(this);
        }
    }
}
