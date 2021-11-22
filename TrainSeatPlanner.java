
public class TrainSeatPlanner
{
  private char seats_plan[][];
  private int j;

  public TrainSeatPlanner()
  {
    seats_plan = new char[10][5];
    j = 0;
    for (int r = 0; r < 10; r++)
    {
      for (int c = 0; c < 5; c++)
      {
        seats_plan[r][c] = 'E';
      }
    }
  }
  public char[][] getSeats_plan()
  {
    return seats_plan;
  }

  public void setSeats_plan(char seats_plan[][])
  {
    this.seats_plan = seats_plan;
  }

  public int getJ()
  {
    return j;
  }

  public void setJ(int j)
  {
    this.j = j;
  }

  public void displaySeats()
  {
    System.out.println("\f***********************Vacant Seats are marked by E**********Taken Seats are marked by O*********************");
    System.out.println("*************************************************************************************************************");
    for (int r = 0; r < 10; r++)
    {
      for (int c = 0; c < 5; c++)
      {
        System.out.print(" " + seats_plan[r][c] + " ");
      }
      System.out.println();
    }

  }

  public void check(int r, int c)
  {
    j = 0;
    boolean flag = false;
    r = r - 1;
    c = c - 1;
    if (seats_plan[r][c] == 'E')
    {
      seats_plan[r][c] = 'O';
      j = c;
      System.out.println("Your seat has been booked");
    }
    else if (seats_plan[r][c] == 'O')
    {
      for (j = 0; j < 5; j++)
      {
        if (seats_plan[r][j] == 'E')
        {
          seats_plan[r][j] = 'O';
          System.out.println("As the selected seat is taken, you have been given an alternative seat at " + (r + 1) +
                             " " + (j + 1));
          flag = true;
          break;
        }

      }
      if (flag == false)
      {
        System.out.println("Sorry this row is full, please try another one");
      }
    }
  }

}
