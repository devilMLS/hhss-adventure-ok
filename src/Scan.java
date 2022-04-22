
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Merik
 */
public class Scan {
    //Scan in north, south, east and west assigning them with numbers
    public static final int N = 0;
    public static final int E = 1;
    public static final int S = 2;
    public static final int W = 3;

    //Setting instance varibles needed for the program
    private String name;
    private BufferedImage[] image;
    private boolean[] canMove;
    private String[] moveName;
    private String[] nextDirection;

    public Scan(Scanner input) {
        //gets the room name
        this.name = input.nextLine();
        this.canMove = new boolean[4];
        this.moveName = new String [4];
        this.nextDirection = new String [4];
        this.image = new BufferedImage[4];
        //gets all other information in lines
        for(int i = 0; i < this.canMove.length; i++){
            String direction = input.next();
            String fileImage = input.next();
            boolean move = input.nextBoolean();
            String newDirection = null;
            String nextName = null;
            if(!move){
            nextName = input.next();
            newDirection = input.nextLine().trim();
            }else{
                input.nextLine().trim();
        }
            switch (direction) {
                case "N":
                    this.canMove[Scan.N] = move;
                    this.moveName[Scan.N] = nextName;
            {
                try {
                    this.image[Scan.N] = ImageIO.read(new File(fileImage));
                } catch (IOException ex) {
                    Logger.getLogger(Scan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    this.nextDirection[Scan.N] = newDirection;
                    break;
                case "E":
                    this.canMove[Scan.E] = move;
                    this.moveName[Scan.E] = nextName;
            {
                try {
                    this.image[Scan.E] = ImageIO.read(new File(fileImage));
                } catch (IOException ex) {
                    Logger.getLogger(Scan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    this.nextDirection[Scan.E] = newDirection;
                    break;
                case "S":
                    this.canMove[Scan.S] = move;
                    this.moveName[Scan.S] = nextName;
            {
                try {
                    this.image[Scan.S] = ImageIO.read(new File(fileImage));
                } catch (IOException ex) {
                    Logger.getLogger(Scan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    this.nextDirection[Scan.S] = newDirection;
                    break;
                case "W":
                    this.canMove[Scan.W] = move;
                    this.moveName[Scan.W] = nextName;
            {
                try {
                    this.image[Scan.W] = ImageIO.read(new File(fileImage));
                } catch (IOException ex) {
                    Logger.getLogger(Scan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    this.nextDirection[Scan.W] = newDirection;
                    break;
            }
        }
    }
    //Returns the room name at that position
    public String getName() {
        return this.name;
    }
    //Returns the image at that position
    public BufferedImage getImage(int direction) {
        return this.image[direction];
    }
    //Returns if that room allows for forward movement
    public boolean canMove(int direction) {
        return this.canMove[direction];
    }
    //Returns the the name of the next room when moving forward
    public String getNextRoomName(int direction) {
        return this.moveName[direction];
    }
    //Returns the the direction when moving forward
    public String getNextDirection(int direction) {
        return this.nextDirection[direction];
    }
}
