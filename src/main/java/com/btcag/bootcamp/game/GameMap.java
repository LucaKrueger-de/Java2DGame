package com.btcag.bootcamp.game;


import com.btcag.bootcamp.game.objects.GameObject;
import com.btcag.bootcamp.game.objects.tiles.Air;
import com.btcag.bootcamp.game.objects.tiles.Block;
import com.btcag.bootcamp.game.objects.tiles.Dot;
import com.btcag.bootcamp.game.objects.tiles.Tile;

import java.awt.*;

public class GameMap extends GameObject {
    private static final int[][] DEFAULT_MAP = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 2, 1},
            {1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 0, 2, 2, 2, 0, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1},
            {1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1},
            {1, 2, 2, 2, 1, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 1, 2, 2, 2, 1},
            {1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
            {1, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1},
            {1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1},
            {1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1},
            {1, 2, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 2, 1},
            {1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1},
            {1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1},
            {1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1},
            {1, 2, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 2, 1},
            {1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private final int tileSize;

    private final Tile[][] tiles;


    public GameMap(int tileSize) {
        this.tileSize = tileSize;
        tiles = new Tile[DEFAULT_MAP.length][DEFAULT_MAP[0].length];

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                tiles[y][x] = switch (DEFAULT_MAP[y][x]) {
                    case 1 -> new Block(x, y);
                    case 2 -> new Dot(x, y);
                    default -> new Air(x, y);
                };


            }

        }
    }

    @Override
    public void render(Graphics2D g, int tileSize) {
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.render(g, tileSize);
            }
        }
    }

    public boolean isFree(int x, int y) {

        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return false;
        }
        return !(tiles[y][x] instanceof Block);

    }

    public int getWidth() {
        return tiles[0].length;

    }

    public int getHeight() {
        return tiles.length;
    }


    public int getTileSize() {
        return tileSize;
    }
}

