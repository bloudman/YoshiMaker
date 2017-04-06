/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoshimaker.global.characters.players;

import org.newdawn.slick.SlickException;

/**
 *
 * @author punpun
 */
public class Yoshi extends Player {
    protected static int 
        WIDTH = 52, 
        HEIGHT = 70;
    protected static float 
        DENSITY = 1f, 
        FRICTION = 0.2f, 
        RESTITUTION = 0f;
    
    private int jumped = 0 ;
    
    /**
     * Yoshi
     * @param x
     * @param y
     * @throws SlickException 
     */
    public Yoshi(int x, int y) throws SlickException {
        //Initialisation
        super("./assets/image1.png");
        //Coordonnées
        setX(x).setY(y).setWidth(WIDTH).setHeight(HEIGHT);
        //Défintion de la physique
        physics
            .at(x, y)
            .hitbox(width/2, height/2)
            .fixtures(DENSITY, FRICTION, RESTITUTION)
            .create();
    }
    
    /**
     * Callback à la touche Q
     */
    @Override
    public void key_q() {
        physics.translate(-10, 0);
    }
    
    /**
     * Callback à la touche D
     */
    @Override
    public void key_d() {
        physics.translate(+10, 0);
    }
    
    /**
     * Callback à la touche Espace
     */
    @Override
    public void key_space() {
        if (jump) {
            jump = false ;
            physics.impulse(0, -40);
        }
    }
}
