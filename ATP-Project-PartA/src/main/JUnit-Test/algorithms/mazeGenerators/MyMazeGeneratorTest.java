package algorithms.mazeGenerators;

import org.junit.jupiter.api.Test;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class MyMazeGeneratorTest {


    @Test
    void testRunTime() {
        MyMazeGenerator mg = new MyMazeGenerator();
        long checkTime = mg.measureAlgorithmTimeMillis(1000,1000);
        boolean test = checkTime < 1000;
        assertTrue(test);
        if (test)
            System.out.println("testRunTime Passed!");
        else
            System.out.println("RunTime test Failed! \n"
                    +"Finished in: " + checkTime);
    }
    @Test
    void testStartPosition(){
        MyMazeGenerator mg = new MyMazeGenerator();
        Maze m = mg.generate(1000,1000);
        Position st = m.getStartPosition();
        boolean test = 'S' == m.getCharAt(st.getRowIndex(),st.getColumnIndex());
        //assertTrue(test);
        if (test)
            System.out.println("StartPosition test Passed!");
        else
            System.out.println("StartPosition test Failed! \n" +
                    "char at startPosition: " + m.getCharAt(st.getRowIndex(),st.getColumnIndex())
                    + "startPosition: " + st);
    }

    @Test
    void testGoalPosition(){
        MyMazeGenerator mg = new MyMazeGenerator();
        Maze m = mg.generate(1000,1000);
        Position gp = m.getGoalPosition();
        boolean test = 'E' == m.getCharAt(gp.getRowIndex(),gp.getColumnIndex());
        //assertTrue(test);
        if (test)
            System.out.println("GoalPosition test Passed!");
        else
            System.out.println("GoalPosition test Failed! \n" +
                    "char at goalPosition: " + m.getCharAt(gp.getRowIndex(),gp.getColumnIndex())
                    + "goalPosition: " + gp);
    }


}