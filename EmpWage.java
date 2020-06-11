public class EmpWage
{  
   public static final int EMP_RATE_PER_HOUR = 20;
   public static final int NUM_OF_WORKING_DAYS=20;
   public static final int IS_PART_TIME = 1;
   public static final int IS_FULL_TIME = 2;
   public static final int MAX_HRS_IN_MONTH = 100;
   
   public static void  main(String args[])
   {
    int empHrs=0,totalEmpHrs=0,totalWorkingDays=0,totalEmpWage=0;
    System.out.println("Welcome to Employee Wage Computation/Problem");
        while ( totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS)
        {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10)%3;
            switch (empCheck)
            {
            case IS_PART_TIME: empHrs = 4;
                               break;
        
             case IS_FULL_TIME: empHrs = 8;
                                break;
            default: empHrs = 0;
            }
           totalEmpHrs+=empHrs;
           System.out.println("Day "+ totalWorkingDays + " Employee Hour: " + empHrs );
           if ( totalEmpHrs > 100 )
           {
               System.out.println("100 cross");
               totalEmpHrs=totalEmpHrs-4;
               totalEmpWage=totalEmpHrs-80;
               System.out.println("TotalEmpHrs: "+ totalEmpHrs);
               break;
           }
        }
        totalEmpWage= totalEmpHrs * EMP_RATE_PER_HOUR;
        System.out.println("Total Emp Hour is:" + totalEmpHrs + " Total Emp Wage is:" + totalEmpWage);
    }
}
