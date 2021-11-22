import java.util.InputMismatchException;
import java.util.Scanner;

public class Details
{
  private String train;
  private Passenger p[];
  private int passenger;
  private int fare;

  public Details()
  {
    train = "";
    p = new Passenger[6];
    passenger = 1;
    fare = 0;
  }
  public String getTrain()
  {
    return train;
  }

  public void setTrain(String train)
  {
    this.train = train;
  }

  public Passenger[] getP()
  {
    return p;
  }

  public void setP(Passenger p[])
  {
    this.p = p;
  }

  public int getPassenger()
  {
    return passenger;
  }

  public void setPassenger(int passenger)
  {
    this.passenger = passenger;
  }

  public int getFare()
  {
    return fare;
  }

  public void setFare(int fare)
  {
    this.fare = fare;
  }

  public void input()
    throws InputMismatchException
  {
    for (int i = 0; i < 6; i++)
    {
      p[i] = new Passenger();
    }
    Scanner sc = new Scanner(System.in);
    fare = 0;
    int detailscompleted = 0;
    while (detailscompleted == 0)
    {
      try
      {
        System.out.println("\f\fEnter the name of the train- ");
        train = sc.nextLine();
        System.out.println("Six Passengers may be booked per ticket- ");
        System.out.println("Enter the number of passengers- ");
        passenger = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < Math.min(passenger, 6); i++)
        {
          System.out.print("Enter the name of Person " + (i + 1) + ": ");
          p[i].setName(sc.nextLine());
        }
        for (int i = 0; i < Math.min(passenger, 6); i++)
        {
          System.out.print("Enter the age of Person " + (i + 1) + ": ");
          System.out.print("");
          p[i].setAge(sc.nextInt());
          sc.nextLine();
        }
        try
        {
          for (int i = 0; i < Math.min(passenger, 6); i++)
          {
            System.out.print("Enter the gender of Person " + (i + 1) + ": ");
            p[i].setGender(sc.nextLine().charAt(0));
          }
        }
        catch (StringIndexOutOfBoundsException siboe)
        {

        }
        for (int i = 0; i < Math.min(passenger, 6); i++)
        {
          if (p[i].getAge() < 13)
          {
            fare = fare + 250;
          }
          else
          {
            fare = fare + 380;
          }
        }
        System.out.println("Your fare will cost Rs. " + fare);
        detailscompleted = 1;
      }
      catch (InputMismatchException I_m_e)
      {
        System.out.println("Please enter valid input");
      }
    }
  }

  

}
