import java.util.ArrayList;
import java.util.Collections;;
/**
 * This class, once completed, should provide a recursive depth first solution
 * to finding the SHORTEST route between two squares on a GameBoard.
 * 
 * @see GameBoard
 * @see GameSquare
 * @author Joe Finney
 */
public class MazeSquare extends GameSquare
{
	private GameBoard board;			// A reference to the GameBoard this square is part of.
	private boolean target;				// true if this square is the target of the search.
	private int x;
	private int y;
	private GameSquare targetSquare;
	private ArrayList<GameSquare> visitedArray = new ArrayList<>();
	private static int shortestCount;	// The shortest path found so far in this search.

	/**
	 * Create a new GameSquare, which can be placed on a GameBoard.
	 * 
	 * @param x the x co-ordinate of this square on the game board.
	 * @param y the y co-ordinate of this square on the game board.
	 * @param board the GameBoard that this square resides on.
	 */
	public MazeSquare(int x, int y, GameBoard board)
	{
		super(x, y);
		this.board = board;
	}

	/**
	 * A method that is invoked when a user clicks on this square.
	 * This defines the end point for the search.
	 * 
	 */	
    public void leftClicked()
	{
		
		this.target = true;

		this.setHighlight(true);
		
		
	}
    
    /**
	 * A method that is invoked when a user clicks on this square.
	 * This defines the start point for the search. 
	 */	
	public void rightClicked()
	{
		MazeSquare.shortestCount = 0;

		this.setHighlight(true);
		x = this.getXLocation();
		y = this.getYLocation();
		findPath(x,y);
		
		System.out.println(" *** COMPLETE: SHORTEST ROUTE " + (MazeSquare.shortestCount == 0 ? "IMPOSSIBLE" : MazeSquare.shortestCount) + " ***");
	}

	public void findPath(int startX, int startY)
	{
		GameSquare current = board.getSquareAt(startX, startY);
		current.setHighlight(true);
		
		
		if(this.target ==true)
			System.out.println("Found");

		else if((current.getWall(0) || board.getSquareAt(startX-1,startY).isHighlighted()==true) == false) //check if left square is avaliable to move to
		{
			shortestCount++;
			findPath(startX-1, startY);
		}
		else if((current.getWall(2) || board.getSquareAt(startX,startY-1).isHighlighted()==true)==false) // check above square availability
		{
			shortestCount++;
			findPath(startX, startY-1);
		}
		else if((current.getWall(1) || board.getSquareAt(startX+1,startY).isHighlighted()==true)==false) //check right square availability
		{
			shortestCount++;
			findPath(startX+1, startY);
		}
		else if((current.getWall(3) || board.getSquareAt(startX,startY+1).isHighlighted()==true)==false) //check below
		{
			shortestCount++;
			findPath(startX, startY+1);
		}
	}

	/**
	 * A method that is invoked when a reset() method is called on GameBoard.
	 * 
	 * @param n An unspecified value that matches that provided in the call to GameBoard reset()
	 */
	public void reset(int n)
	{

	}
}
