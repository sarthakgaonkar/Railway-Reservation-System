import java.util.Calendar;
import java.util.Scanner;

public class SeatBooking
  extends DateBooking
{
  private int row, column;

  public SeatBooking()
  {
    row = 0;
    column = 0;
  }
  public int getRow()
  {
    return row;
  }

  public void setRow(int row)
  {
    this.row = row;
  }

  public int getColumn()
  {
    return column;
  }

  public void setColumn(int column)
  {
    this.column = column;
  }

  public void displayTicket()
  {
    Calendar c = Calendar.getInstance();
    Scanner sc = new Scanner(System.in);
    TrainSeatPlanner tsp = new TrainSeatPlanner();
    int num_of_seats;
    int seatsrow[] = new int[6];
    int seatscolumn[] = new int[6];
    for (;;)
    {
      for (int i = 0; i < 6; i++)
      {
        seatsrow[i] = 0;
        seatscolumn[i] = 0;
      }
      Details det = new Details();
      enterDate();
      det.input();
      System.out.println("Please have one look at the seating to book your tickets");
      tsp.displaySeats();
      for (num_of_seats = 1; num_of_seats <= Math.min(det.getPassenger(), 6); num_of_seats++)
      {
        try
        {
          System.out.println("\nEnter the row number of the seat you want to book- ");
          row = sc.nextInt();
          System.out.println("\nEnter the column number of the seat you want to book- ");
          column = sc.nextInt();
          if (row > 10 || row < 1 || column > 5 || column < 1)
          {
            System.out.println("Please enter row value between 1 and 10 and column value between 1 and 5");
            num_of_seats--;
            continue;
          }
          tsp.check(row, column);
          seatsrow[num_of_seats - 1] = row;
          seatscolumn[num_of_seats - 1] = ((tsp.getJ()) + 1);
        }
        catch (NumberFormatException nfe)
        {
          System.out.println("Please enter a valid ");
          num_of_seats = num_of_seats - 1;
        }
      }
      System.out.println("\fYour Ticket Is Being Displayed");
      System.out.println("_________________________________________________________________");
      System.out.println("NAME " + "\t\t" + " AGE " + "\t" + " GENDER" + "\t" + " SEAT NO.(ROW,COLUMN)");
      for (int i = 0; i < num_of_seats - 1; i++)
      {
        System.out.println("");
        if (det.getP()[i].getName() != null && det.getP()[i].getAge() != 0 && det.getP()[i].getGender() != '\u0000')
          System.out.println(det.getP()[i].getName() + "\t" + det.getP()[i].getAge() + "\t\t" +
                             det.getP()[i].getGender() + "\t\t" + seatsrow[i] + "," + seatscolumn[i]);
      }
      System.out.println("_________________________________________________________________");
      System.out.println("Train: " + det.getTrain());
      System.out.println("Date of Journey : " + getDay() + "/" + getMonth() + "/" + getYear());
      System.out.println("=================================================================");
      System.out.println(" HAVE A HAPPY JOURNEY AND SAFE TRAVELS! PLEASE BOOK WITH US AGAIN!");
      System.out.println("_________________________________________________________________");
      System.out.println("Do you want to continue(y/n)?");
      sc.nextLine();
      String ch = sc.nextLine();
      if (ch.equalsIgnoreCase("n"))
      {
        break;
      }
    }
  }

}
