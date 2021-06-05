import org.junit.Test;
import static org.junit.Assert.*;


public class Tests {


    @Test
    public void Placement1() { // Checks if valid placement works
        Robot r = new Robot();
        r.ValidPlacement("PLACE 1,3,NORTH"); 

        assertEquals(1, r.X);
        assertEquals(3, r.Y);
        assertEquals("NORTH", r.Direction); 

    }
    
    @Test
    public void Placement2() { // Checks if invalid placement horizontally is ignored
        Robot r = new Robot(); 
        r.ValidPlacement("PLACE -1,0,NORTH"); 

        assertEquals(-1, r.X);
        assertEquals(-1, r.Y);
        assertEquals("None", r.Direction); 

    }
    
    @Test
    public void Placement3() { // Checks if invalid placement vertically is ignored
        Robot r = new Robot(); 
        r.ValidPlacement("PLACE 0,-1,NORTH"); 

        assertEquals(-1, r.X);
        assertEquals(-1, r.Y);
        assertEquals("None", r.Direction); 

    }
    @Test
    public void Placement4() { // Checks if invalid placement horizontally is ignored
        Robot r = new Robot(); 
        r.ValidPlacement("PLACE 5,0,WEST"); 

        assertEquals(-1, r.X);
        assertEquals(-1, r.Y);
        assertEquals("None", r.Direction); 

    }

    @Test
    public void Placement5() { // Checks if invalid placement vertically is ignored
        Robot r = new Robot(); 
        r.ValidPlacement("PLACE 0,5,SOUTH"); 

        assertEquals(-1, r.X);
        assertEquals(-1, r.Y);
        assertEquals("None", r.Direction); 

    }
    
    @Test
    public void Placement6() { // Checks if invalid placement directionwise is ignored
        Robot r = new Robot(); 
        r.ValidPlacement("PLACE 1,3,SOUTHWEST"); 

        assertEquals(-1, r.X);
        assertEquals(-1, r.Y);
        assertEquals("None", r.Direction); 

    }
    
    @Test
    public void Move1() { // Checks if valid Move works
        Robot r = new Robot(); 
        r.ValidPlacement("PLACE 4,2,NORTH"); 
        r.ValidMove();

        assertEquals(4, r.X);
        assertEquals(3, r.Y);
        assertEquals("NORTH", r.Direction); 

    }
    
    @Test
    public void Move2() { // Checks if invalid Move is ignored
        Robot r = new Robot(); 
        r.ValidPlacement("PLACE 4,4,NORTH"); 
        r.ValidMove();

        assertEquals(4, r.X);
        assertEquals(4, r.Y);
        assertEquals("NORTH", r.Direction); 

    }

    @Test
    public void Rotate1() { // Checks if left rotation works
        Robot r = new Robot(); 
        r.ValidPlacement("PLACE 3,1,NORTH"); 
        r.RotateRight();

        assertEquals(3, r.X);
        assertEquals(1, r.Y);
        assertEquals("EAST", r.Direction); 

    }

        @Test
    public void Rotate2() { // Checks if right rotation works
        Robot r = new Robot(); 
        r.ValidPlacement("PLACE 3,1,NORTH"); 
        r.RotateLeft();

        assertEquals(3, r.X);
        assertEquals(1, r.Y);
        assertEquals("WEST", r.Direction); 

    }

    public static void main(String[] args) {
        
        Tests t = new Tests(); // Initiating Test object

        // Run test suite
        
        t.Placement1();
        t.Placement2();
        t.Placement3();
        t.Placement4();
        t.Placement5();
        t.Placement6();
        
        t.Move1();
        t.Move2();

        t.Rotate1();
        t.Rotate2();

    }
}