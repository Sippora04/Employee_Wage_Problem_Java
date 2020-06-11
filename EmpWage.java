import java.util.Random;
public class EmpWage
{  
   public static void  main(String args[])
   {
    int EMP_RATE_PER_HOUR = 20;    
    int IS_PART_TIME = 1;
    int IS_FULL_TIME = 2;
   
    int empHrs=0;
    int empWage=0;
    System.out.println("Welcome to Employee Wage Computation/Problem");
        double empCheck =Math.floor(Math.random() * 10)%3;
        if(empCheck == IS_PART_TIME )
        {  System.out.println("Part Time");
           empHrs = 4;
        }
        else if (empCheck == IS_FULL_TIME )
        {   System.out.println("Full Time");
            empHrs = 8;
        }
        else 
        {   System.out.println("Absent");
            empHrs = 0;
        }
    
        empWage = empHrs * EMP_RATE_PER_HOUR;
        System.out.println("Employee Wage: "+empWage );
   }
}
