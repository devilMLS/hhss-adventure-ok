
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Merik
 */
public class Assemble {

    private ArrayList<Scan> rooms;
    private Scan currentRoom;
    
    public Assemble (String fileName){
        this.rooms = new ArrayList<>();
        Scanner input = null;
        try{
            input = new Scanner(new File(fileName));
        }catch(Exception e){
            e.printStackTrace();
        }
        String currentRoomName = input.nextLine();
        String currentRoomDirection = input.nextLine();
        while(input.hasNext()){
            Scan r = new Scan(input);
            this.rooms.add(r);
            
        }
        this.currentRoom = findRoom(currentRoomName);
    }
    
    private Scan findRoom(String name){
        for(Scan r: this.rooms){
            if(r.getName().equals(name)){
                return r;
            }
        }
        // room not found
        return null;
    }
    
    public boolean canMove(int direction) {
        return this.currentRoom.canMove(direction);
    }
    
    public int move(int direction) {
        if (canMove(direction)) {
            String newRoomName = this.currentRoom.getNextRoomName(direction);
            System.out.println(newRoomName);
            this.currentRoom = findRoom(newRoomName);
        }
        throw new IndexOutOfBoundsException("You cannot move. The path is blocked.");
    }
    
    /**
     * gets the image for a room
     * @param roomDirection the number associated with a room
     * @returns an image of the room roomDirection is associated with
     */
    public BufferedImage getImage(int direction) {
        return this.currentRoom.getImage(direction);
    }
}
