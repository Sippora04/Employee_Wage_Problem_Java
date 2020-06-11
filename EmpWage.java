public class EmpWage
{  
   public static final int EMP_RATE_PER_HOUR = 20;    
   public static final int IS_PART_TIME = 1;
   public static final int IS_FULL_TIME = 2; 
   public static void  main(String args[])
   {
    int empHrs=0;
    int empWage=0;
    System.out.println("Welcome to Employee Wage Computation/Problem");
        int empCheck = (int) Math.floor(Math.random() * 10)%3;
        switch (empCheck)
        {
         case IS_PART_TIME: System.out.println("Partime");
                            empHrs = 4;
                            break;
        
         case IS_FULL_TIME: System.out.println("Fulltime");
                            empHrs = 8;
                            break;
         default: System.out.println("Absent");
                  empHrs = 0;
        }
        empWage = empHrs * EMP_RATE_PER_HOUR;
        System.out.println("Employee Wage: " + empWage );
   }
}
