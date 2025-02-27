/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoshimaker.global.characters.ennemies;

import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.contacts.Contact;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import yoshimaker.global.Entity;
import yoshimaker.global.cases.Type;
import yoshimaker.global.characters.players.Player;
import yoshimaker.map.Map;

/**
 *
 * @author punpun
 */
public class Goomba extends Ennemy {

    private Animation walkingL,walkingR;
    private int where = getX();
    private int mouvement =2 ;
    private Animation sens;
    
     public Goomba(int x, int y) throws SlickException {
        //Initialisation
        super(WALKING.getSprite(0, 0));
        this.walkingL = new Animation(WALKING, 0, 0, 1, 0, true, 1, true);
        this.walkingR = new Animation(RETURN,0 ,0 ,1 ,0, true ,1 ,true);
        sens = walkingR;
        this.sprite = sens;
        sprite.setSpeed(0.01f);   
        sprite.start();
        //Coordonnées
        setX(x).setY(y).setWidth(WIDTH).setHeight(HEIGHT);
        //Défintion de la physique
        physics
            .at(x, y)
            .hitbox(width/2, height/2-10)
            .fixtures(DENSITY, FRICTION, RESTITUTION)
            .data(this)
            .create();
        killable = true ;
    }
    
     @Override
     public Entity update(){
        if (destroyed) { return this ; }
        setX((int) physics.x()).setY((int) physics.y());
        if (physics.getBody() == null) { return this; }
            physics.moveX(mouvement);
            this.sprite = sens;
        if( getX() < where-300 ){
            sens = walkingR;
            sprite.setSpeed(0.01f);   
            mouvement = 2;         
        }else if( getX() > where+300 ){ 
            sens = walkingL;
            sprite.setSpeed(0.01f);    
            mouvement =-2;
        }
        if (Map.CURRENT == null) { return this ; }
        if (Map.CURRENT.whatIs(getX()+getHeight()+75, getY()) != Type.EMPTY ){  
            sens = walkingL;
                    sprite.setSpeed(0.01f);   
            mouvement = -2;            
        }       
        if(Map.CURRENT.whatIs(getX()+getHeight()-75, getY()) != Type.EMPTY ) { 
            sens = walkingR;
                    sprite.setSpeed(0.01f);   

            mouvement = 2;
        }          
        return this;
    }  
       
    protected static int 
        WIDTH = 52, 
        HEIGHT = 70;
    protected static float 
        DENSITY = 1f, 
        FRICTION = 0.7f, 
        RESTITUTION = 0f;
    
    private int jumped = 0 ;
    private Animation walking;
    
    protected static SpriteSheet WALKING;
    protected static SpriteSheet RETURN;
    static {
        //Initalisation
        try {
            WALKING = new SpriteSheet("./assets/goombas.png", 64, 64, 0);
            RETURN = new SpriteSheet("./assets/goombasRetourner.png",64,64,0);
        } catch (Exception ignore) { }
    }
}
