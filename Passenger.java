public class Passenger
{
  private String name;
  private int age;
  private char gender;

  public Passenger()
  {
    name = "Pottyman Bandhu";
    age = 0;
    gender = 'M';
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public char getGender()
  {
    return gender;
  }

  public void setGender(char gender)
  {
    this.gender = gender;
  }
}
