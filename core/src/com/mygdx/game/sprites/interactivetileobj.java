package com.mygdx.game.sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by ROHIT on 9/14/2018.
 */

public abstract class interactivetileobj {
    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;


    protected Fixture fixture;

    public interactivetileobj(World world,TiledMap map,Rectangle bounds){
        this.world=world;
        this.map=map;
        this.bounds=bounds;

        BodyDef bodyDef=new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bodyDef.type= BodyDef.BodyType.StaticBody;
        bodyDef.position.set((bounds.getX()+bounds.getWidth()/2)/ mario.PPM,(bounds.getY()+bounds.getHeight()/2)/mario.PPM);

        body=world.createBody(bodyDef);

        shape.setAsBox(bounds.getWidth()/2/mario.PPM,bounds.getHeight()/2/mario.PPM);
        fdef.shape=shape;
        fixture=body.createFixture(fdef);




    }


    public abstract void onHeadhit();



}