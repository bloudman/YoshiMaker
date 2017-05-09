/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoshimaker.views;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.gui.TextField;
import yoshimaker.global.characters.ennemies.Koopa;
import yoshimaker.global.characters.players.Yoshi2;
import yoshimaker.global.items.Shell;
import yoshimaker.global.items.Star;
import yoshimaker.map.Map;
import org.newdawn.slick.*;
import yoshimaker.global.Entity;
import yoshimaker.global.cases.Type;
import yoshimaker.global.characters.ennemies.Boo;
import yoshimaker.global.characters.players.Player;
import yoshimaker.global.characters.players.Yoshi;
import yoshimaker.global.items.Box;
import yoshimaker.global.items.FireBall;
import yoshimaker.physics.Physics;
<<<<<<< HEAD
import yoshimaker.global.items.Item;
import yoshimaker.global.items.Shell;
import yoshimaker.physics.Timer;
=======
import yoshimaker.views.camera.Camera;
>>>>>>> a8bf5c52ed69b0db0f0a57abb6ddee0639ba807d

/**
 *
 * @author punpun
 */
public class TitleScreen extends View {
    private Image logo, background;
    private Image[] clouds;
    private double[] clouds_x, clouds_y;
    private Yoshi testEntity;
    private Yoshi2 testEntity2;
    private boolean test = false;
    private float test2 = 0, test3 = 0, test4 = 0;
    private Map map ;

    private TextField counterText;

    public TitleScreen() {
        clouds = new Image[5];
        clouds_x = new double[5];
        clouds_y = new double[5];
        clouds_y[0] = 10; clouds_x[0] = 10;
        clouds_y[1] = 75; clouds_x[1] = 300;
        clouds_y[2] = 50; clouds_x[2] = 600;
        clouds_y[3] = 100; clouds_x[3] = 750;
        clouds_y[4] = 85; clouds_x[4] = 450;
    }


    @Override
    public void init(GameContainer container) throws SlickException {
        background = new Image("./resources/background_yoshi.png");
        /*logo = new Image("./resources/logo_yoshi.png");
        clouds[0] = new Image("./resources/cloud_yoshi.png");
        clouds[1] = new Image("./resources/cloud_yoshi.png");
        clouds[2] = new Image("./resources/cloud_yoshi.png");
        clouds[3] = new Image("./resources/cloud_yoshi.png");
        clouds[4] = new Image("./resources/cloud_yoshi.png");
        */
        Physics.world(0, 100f);
        //testEntity = new Yoshi(64, 9*64);
        testEntity2 = new Yoshi2(90, 9*64);
        Box b = new Box(3*64, 4*64);

       // Goomba g = new Goomba(7*64, 7*64);
       // ParaGoomba pg = new ParaGoomba(8*64, 10*64);
       // Boo boo = new Boo(4*64, 10*64);
       // Thwomp t = new Thwomp(16*64, 8*64);
        //Goomba g = new Goomba(7*64, 12*64);
        //ParaGoomba pg = new ParaGoomba(8*64, 10*64);
        Boo boo = new Boo(4*64, 10*64);
        new Star(50,50);
        new Star(50,50);
        new Star(50,50);


        //Thwomp t = new Thwomp(16*64, 8*64);

        Koopa k = new Koopa(10*64, 8*64);
        Shell s = new Shell(9*64, 8*64);
        
        FireBall f = new FireBall(4*64, 12*64);

        //Item testItem = new Item("./resources/cloud_yoshi.png");

        //Physics test2 = new Physics();
        //test2.define(BodyType.STATIC).at(0f, 300f).hitbox(500f, 10f).fixtures(0.5f, 0.9f, 0f).create();
        map = new Map("test"); 
        map.setCase(1, 1, Type.ICE);       
            //map.check();
            //map.saveText("test");
            
            //map = new Map(30,14);
            //System.out.println(Entity.ENTITIES.size());
            
            /* map.setCase(0, 0, Type.BRICK);
            map.setCase(2, 8, Type.ICE);
            map.setCase(3, 8, Type.ICE);
            map.setCase(11, 8, Type.SPRING);
            map.setCase(8, 4, Type.BRICK);
            map.setCase(8, 5, Type.BRICK);
            map.setCase(8, 6, Type.BRICK);
            map.setCase(8, 7, Type.BRICK);
            map.setCase(10, 8, Type.EMPTY);
            map.setCase(9, 8, Type.EMPTY);*/
            //map.move(100, 100);

        

<<<<<<< HEAD
        map.setCase(0, 0, Type.BRICK);
        map.setCase(2, 8, Type.ICE);
        map.setCase(3, 8, Type.ICE);
        map.setCase(11, 8, Type.SPRING);
        map.setCase(8, 4, Type.BRICK);
        map.setCase(8, 5, Type.BRICK);
        map.setCase(8, 6, Type.BRICK);
        map.setCase(8, 7, Type.BRICK);
        map.setCase(10, 8, Type.EMPTY);
        map.setCase(9, 8, Type.EMPTY);
        //map.move(100, 100);

        Entity.setCamera(camera().focus(testEntity).on(map));
        
        Thread tm = new Thread(new Timer());
        tm.start();
        
=======
        Entity.setCamera(camera().focus(testEntity2).on(map));
>>>>>>> a8bf5c52ed69b0db0f0a57abb6ddee0639ba807d
}

    @Override
    public void render(GameContainer container, Graphics g) {
        /*
        for (int i = 0; i < clouds.length; i++) {
            clouds[i].draw((int)clouds_x[i], (int)clouds_y[i], 1.4f);
        }
        
        
        
        
        //testEntity.draw();
        
        */
        //map.draw(container, g);
        background.draw(0, 00, 4f);
        Entity.drawCamera(container, g);

        g.drawString("Il reste : "  + Integer.toString(Player.countStar), Camera.xTop+50.0f, Camera.yTop+50.0f);

    }

    @Override
    public void update(GameContainer container, int delta) {
        Entity.updateAll();
        Physics.update();
        if(Player.countStar <=0){
            Player.countStar = 0;
            System.out.println("Fin du jeu");
        }
        /*
        for (int i = 0; i < clouds.length; i++) {
            clouds_x[i] += delta*0.05;
            if (clouds_x[i] > 850) { clouds_x[i] = -150; }
        }*/
    }

    @Override
    public void controller(Input input) {
        Player.controller(input);
    }

    @Override
    public void controller(int key, char c, boolean type) {
        Player.controller(key, c, type);
    }
}

