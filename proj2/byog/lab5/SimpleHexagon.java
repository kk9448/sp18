package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

public class SimpleHexagon {
    TERenderer ter;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    TETile[][] world;
    private int size;


//    public static void main(String[] args) {
//        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
//        addHexagon(4,20);
//    }
/**
 * Y
 * -
 * -
 * -
 * --------------- X
 * */
     SimpleHexagon(int s){
         ter = new TERenderer();
         ter.initialize(WIDTH, HEIGHT);
         world =new TETile[WIDTH][HEIGHT];
         size = s;
    }
        /** bad way */
//    void draw(int count) {
//
//        for (int x = 0; x < WIDTH; x += 1) {
//            for (int y = 0; y < HEIGHT; y += 1) {
//                world[x][y] = Tileset.NOTHING;
//            }
//        }
//
//        int k = 0;
//        Random r = new Random(1000);
//        for (int i = 0; i < 2 * size; i++) {
//            if (i < size) {
//                count -= 1;
//                for (int j = 0; j < size + k; j++) {
//                    world[count + j][i] = Tileset.FLOWER;
////                    world[count + j][i] = TETile.colorVariant(Tileset.FLOWER,200,200,200,r);
//                }
//                k = k + 2;
//            } else {
//                k -= 2;
//                for (int j = 0; j < size + k; j++) {
//                    world[count + j][i] = Tileset.FLOWER;
////                    world[count + j][i] = TETile.colorVariant(Tileset.FLOWER,200,200,200,r);
//                }
//                count += 1;
//            }
//
//        }
//        show();
//     }
        /** good way */





     void show() {
         ter.renderFrame(world);
     }

}
