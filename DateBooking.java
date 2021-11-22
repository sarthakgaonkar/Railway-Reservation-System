import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DateBooking
{
  private int year, month, day;

  public DateBooking()
  {
    year = 0;
    month = 0;
    day = 0;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getMonth()
  {
    return month;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getDay()
  {
    return day;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public void enterDate()
    throws InputMismatchException
  {
    Calendar c = Calendar.getInstance();
    Scanner sc = new Scanner(System.in);
    for (;;)
    {
      try
      {
        System.out.println("\fEnter the year in the format YYYY ");
        sc.nextLine();
        year = sc.nextInt();
        System.out.println("Enter the month in the format MM ");
        month = sc.nextInt();
        System.out.println("Enter the day in the format  ");
        day = sc.nextInt();
        System.out.println("Today is: " + c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" +
                           c.get(Calendar.YEAR));
        int current_month = c.get(Calendar.MONTH) + 1;
        int month_difference = month - current_month;
        int current_day = c.get(Calendar.DATE);
        int date_difference = (day - current_day) + month_difference * 30;
        System.out.println("The requested date is: " + day + "/" + month + "/" + year);
        if ((day < 1 || day > 31) || (month < 1 || month > 12) || (year < 0 || year > 2100))
        {
          System.out.println("Please enter a correct day, month and year");
        }
        if ((date_difference > 60) || (date_difference < 0))
        {
          System.out.println("You must enter a date sometime between today and 60 days FROM today, please re-enter the date");
        }
        else
        {
          System.out.println("Please enter your passenger details");
          break;
        }
      }
      catch (NumberFormatException nfe)
      {
        System.out.println("Please enter a valid date");
      }
      catch (InputMismatchException ie)
      {
        System.out.println("Please enter a valid");
      }
    }
  }

}
