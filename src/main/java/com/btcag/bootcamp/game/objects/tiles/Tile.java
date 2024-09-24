package com.btcag.bootcamp.game.objects.tiles;

import com.btcag.bootcamp.game.objects.GameObject;

public abstract class Tile extends GameObject {
    protected final int x;

    protected final int y;


    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
