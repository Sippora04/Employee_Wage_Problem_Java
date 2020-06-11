
import java.util.Random;

class EmpWage
{   public static void main (String args[])
    {   int Attendance=0;
        System.out.println("Welcome to Employee Wage Computation Problem");
        Random random = new Random();
        int empCheck = random.nextInt()%3;
        if(empCheck == Attendance )
        {
            System.out.println("Employee is Absent");
        }
		  else
        {
            System.out.println("Employee is Present");
        }
    }
}
