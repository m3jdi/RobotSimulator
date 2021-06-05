import java.util.ArrayList;

class Robot {

    public int X = -1;
    public int Y = -1;
    
    public String Direction = "None";

    ArrayList<String> ValidDirections = new ArrayList<String>();
    

    public Robot() {
        ValidDirections.add("NORTH");
        ValidDirections.add("WEST");
        ValidDirections.add("EAST");
        ValidDirections.add("SOUTH");

        System.out.println("Robot says: System online. Mobility protocol activated. Bzzz.");
    }
    

    public void ValidPlacement(String candPlace){ // Checks if placement is valid and ignores if not
        
        String[] c = candPlace.split(" ");
        
        if(c.length == 2) { // Has parameters provided
            
            String[] coords = c[1].split(",");

            if(coords.length == 3) { // If placement syntax is correct
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                String dir = coords[2];

                if( (ValidDirections.contains(dir)) && (x < 5) && (y < 5) && (x >= 0) && (y >= 0)) {
                    // place
                    X = x;
                    Y = y;
                    Direction = dir;
                }
            }
        }
    }

    public void ValidMove(){ // Checks if move is valid and ignores if not
        if (Direction.equals("NORTH")) { // Move up vertically
            int y = Y + 1; 
            
            if((y >= 0) && (y < 5)){
                Y = y; // Move
            }
        }
        else if (Direction.equals("EAST")) { // Move up horizontally
            int x = X + 1;

            if((x >= 0) && (x < 5)){
                X = x; // Move
            } 
        }
        else if (Direction.equals("WEST")) { // Move down the horizontally
            int x = X - 1;
            if((x >= 0) && (x < 5)){
                X = x; // Move
            } 
        }
        else if (Direction.equals("SOUTH")) { // Move down vertically
            int y = Y - 1;

            if((y >= 0) && (y < 5)){
                Y = y; // Move
            } 
        }
    }

    public void RotateLeft(){
        if (Direction.equals("NORTH")) { 
            Direction = "WEST"; // Rotate
        }
        else if (Direction.equals("EAST")) { 
            Direction = "NORTH"; // Rotate
        }
        else if (Direction.equals("WEST")) { 
            Direction = "SOUTH"; // Rotate
        }
        else if (Direction.equals("SOUTH")) { 
            Direction = "EAST"; // Rotate
        }

    }

    public void RotateRight(){
        if (Direction.equals("NORTH")) { 
            Direction = "EAST"; // Rotate
        }
        else if (Direction.equals("EAST")) { 
            Direction = "SOUTH"; // Rotate
        }
        else if (Direction.equals("WEST")) { 
            Direction = "NORTH"; // Rotate
        }
        else if (Direction.equals("SOUTH")) { 
            Direction = "WEST"; // Rotate
        }
    }

    public void Command(String inp){
        
        String[] c = inp.split(" ");
        

        if (c[0].equals("PLACE")){ // Place
            ValidPlacement(inp);
        } 
        else if(c[0].equals("MOVE")){ // Move
            ValidMove();
        }
        else if(c[0].equals("LEFT")){ // Rotate left
            RotateLeft();
        }
        else if(c[0].equals("RIGHT")){ // Rotate right
            RotateRight();
        }
        else if(c[0].equals("REPORT")){ // Report
            if(!Direction.equals("None")) {
                System.out.println(X + "," + Y + "," + Direction);
            }
        }
    }
}