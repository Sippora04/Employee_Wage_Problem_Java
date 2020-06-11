import java.util.Random;
public class EmpWage
{  
   static int dailyWage = 0;
   static int EMP_RATE_PER_HOUR = 20;
   static int FULL_TIME_HOURS = 8;
   static int FULL_TIME_ABSENT = 0;
   public static void main(String args[])
   {
      System.out.println("Welcome to Employee Wage Computation/Problem");
      Random random = new Random();
        int empCheck = random.nextInt()%3;
        if(empCheck == 0 )
        {
            System.out.println("Employee is Absent");
            dailyWage = FULL_TIME_ABSENT * EMP_RATE_PER_HOUR;
            System.out.println("Employee dailyWage is "+dailyWage);
            
        }
        else
        {
            System.out.println("Employee is Present");
            dailyWage = FULL_TIME_HOURS * EMP_RATE_PER_HOUR;
            System.out.println("Employee dailyWage is "+dailyWage);
        }
   }
}
