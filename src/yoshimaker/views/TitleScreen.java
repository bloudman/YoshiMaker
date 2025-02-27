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
import yoshimaker.WindowGame;
import yoshimaker.global.Entity;
import yoshimaker.global.cases.Type;
import yoshimaker.global.characters.ennemies.Boo;
import yoshimaker.global.characters.ennemies.Goomba;
import yoshimaker.global.characters.ennemies.ParaGoomba;
import yoshimaker.global.characters.ennemies.Thwomp;
import yoshimaker.global.characters.players.Player;
import yoshimaker.global.characters.players.Yoshi;
import yoshimaker.global.items.Box;
import yoshimaker.global.items.FireBall;
import yoshimaker.maker.view.Button;
import yoshimaker.maker.view.MenuButtonMaker;
import yoshimaker.physics.Physics;
import yoshimaker.global.items.Item;
import yoshimaker.global.items.Shell;
import yoshimaker.global.items.Switch;
import yoshimaker.physics.Timer;
import yoshimaker.views.camera.Camera;

/**
 *
 * @author punpun
 */
public class TitleScreen extends View {
    private Image logo, background;
    
    private Yoshi testEntity;
    private Yoshi2 testEntity2;
    private boolean test = false;
    private float test2 = 0, test3 = 0, test4 = 0;
    private Map map ;
    private boolean _init = false;

    private TextField counterText;

    public TitleScreen() {
    }


    @Override
    public void init(GameContainer container) throws SlickException {
        background = new Image("./resources/background_yoshi.png");
        Physics.world(0, 100f);
        testEntity = new Yoshi(128, 12*64);
        testEntity2 = new Yoshi2(128+64, 12*64);
        //Box b = new Box(3*64, 4*64);
        //testEntity2 = new Yoshi2(90, 9*64);
        //new Yoshi(70, 9*64);
        Box b = new Box(3*64, 4*64);
        Player.countStar = 3;

      

        //Item testItem = new Item("./resources/cloud_yoshi.png");
        //map = new Map("presentation"); 
        //map.setCase(1, 1, Type.ICE);       
        //map.check();
        //map.saveText("test");
            
           // map = new Map(30,14);            
            /* map.setCase(0, 0, Type.BRICK);
            
        Koopa k = new Koopa(10*64, 8*64);
        Shell s = new Shell(9*64, 8*64);
        
        //FireBall f = new FireBall(4*64, 12*64);
        //Item testItem = new Item("./resources/cloud_yoshi.png");
        //Physics test2 = new Physics();
        //test2.define(BodyType.STATIC).at(0f, 300f).hitbox(500f, 10f).fixtures(0.5f, 0.9f, 0f).create();
            //map.check();
            //map.saveText("test");
            */
            map = new Map(30,14);
            map.y1 = testEntity;
            map.y2 = testEntity2;
//System.out.println(Entity.ENTITIES.size());
            
            //map.setCase(0, 0, Type.BRICK);
            //map.setCase(3, 8, Type.ICE);
            
            map.setCase(1, 9, Type.BRICK);
            map.setCase(2, 9, Type.BRICK);
            map.setCase(3, 9, Type.BRICK);
            map.setCase(4, 9, Type.BRICK);
            new Switch(1*64, 8*64);
            
            
            map.setCase(7, 6, Type.ICE);
            map.setCase(8, 7, Type.ICE);
            map.setCase(9, 7, Type.ICE);
            map.setCase(10, 7, Type.ICE);
            
            map.setCase(11, 7, Type.BRICK);
            map.setCase(11, 8, Type.BRICK);
            map.setCase(11, 9, Type.BRICK);
            map.setCase(11, 10, Type.DOORBRICK);
            map.setCase(11, 11, Type.DOORBRICK);
            map.setCase(11, 12, Type.DOORBRICK);
            
            
            map.setCase(12, 12, Type.BRICK);
            
            
            map.setCase(14, 9, Type.SPRING);
            map.setCase(15, 10, Type.BRICK);
            map.setCase(16, 10, Type.BRICK);
            map.setCase(17, 10, Type.BRICK);
            map.setCase(18, 9, Type.LAVA);
            
            Goomba g = new Goomba(17*64, 8*64);
            ParaGoomba pg = new ParaGoomba(10*64, 10*64);
            Boo boo = new Boo(20*64, 10*64);
            Thwomp t = new Thwomp(20*64, 8*64);
            // ParaGoomba pg = new ParaGoomba(8*64, 10*64);
             new Star(8*64, 6*64);
             new Star(700,50);
             new Star(1000,50);
             //Thwomp t = new Thwomp(16*64, 8*64);

            Koopa k = new Koopa(16*64, 11*64);
            
            
            
            
            //map.setCase(9, 8, Type.EMPTY);
            //map.move(100, 100);

        

        /*map.setCase(0, 0, Type.BRICK);
        map.setCase(3, 8, Type.ICE);
        map.setCase(11, 8, Type.SPRING);
        map.setCase(8, 4, Type.BRICK);
        map.setCase(8, 5, Type.BRICK);
        map.setCase(8, 6, Type.BRICK);
        map.setCase(8, 7, Type.BRICK);
        map.setCase(10, 8, Type.EMPTY);
        map.setCase(9, 8, Type.EMPTY);*/
        //map.move(100, 100);
        //MenuButtonMaker menuMaker = new MenuButtonMaker(container, container.getScreenWidth()-200);

        Entity.setCamera(camera().focus(testEntity).on(map));
        
        Thread tm = new Thread(new Timer());
        tm.start();
       _init = true ;
        //Entity.setCamera(camera().focus(testEntity2).on(map));
}

    @Override
    public void render(GameContainer container, Graphics g) {
        /*
        
        
        
        
        
        //testEntity.draw();
        
        */
        //
        background.draw(0, 00, 4f);
        Entity.drawCamera(container, g);
        Button.drawAll(container, g);

        g.drawString("Il reste : "  + Integer.toString(Player.countStar), Camera.xTop+50.0f, Camera.yTop+50.0f);

    }

    @Override
    public void update(GameContainer container, int delta) {
        Entity.updateAll();
        Physics.update();
        if ((_init)&&(Player.countStar <=0)){
            Player.countStar = 0;
            int a_death = Map.CURRENT.y1.death ;
            int b_death = Map.CURRENT.y2 == null ? -1 : Map.CURRENT.y2.death ;
            Entity.DESTROY();
            try {
                WinView v = new WinView();
                v.a_death = a_death;
                v.b_death = b_death;
                WindowGame.getInstance().view = v;
                WindowGame.getInstance().view.init(WindowGame.getInstance().container);
            } catch (SlickException ex) {  }
            
        }
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

