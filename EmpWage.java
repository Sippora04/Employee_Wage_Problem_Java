public class EmpWage
{
   public static int totalEmpHours = 0;
   public static int totalSalary = 0;
   public static int totalWorkingDays = 0;
   public static int empHours = 0;
   public static int dailyWage = 0;

   public static final int IS_EMP_FULL_TIME = 1;
   public static final int IS_EMP_PART_TIME = 2;
   public static final int EMP_RATE_PER_HOUR = 20;
   public static final int WORKING_DAYS_IN_MONTH = 20;
   public static final int MAXIMUM_WORK_HOURS = 100;
   public static final int FULL_TIME_HOURS = 8;
   public static final int PART_TIME_HOURS = 4;

   public static int getWorkingHours(int empCheck)
   {
      switch (empCheck)
      {
         case IS_EMP_FULL_TIME:  empHours = FULL_TIME_HOURS ;
                                 break ;
         case IS_EMP_PART_TIME:  empHours = PART_TIME_HOURS ;
                                 break ;
         default: empHours=0  ;
      }
      return empHours;
   }

   public static int getCalculationDailyWage(int empHours)
   {
      dailyWage = empHours * EMP_RATE_PER_HOUR;
      return dailyWage;
   }

   public static void getMonthlyWage()
   {
      int empDailyWage[] = new int[25];
      System.out.println("Day No.		DailyWage		TotalWage");
      while (totalEmpHours < MAXIMUM_WORK_HOURS && totalWorkingDays < WORKING_DAYS_IN_MONTH)
      {
         int empCheck = (int) Math.floor(Math.random() * 10) % 3;
         empHours = getWorkingHours(empCheck);
         totalEmpHours = totalEmpHours + empHours;
         totalWorkingDays++;
         empDailyWage[totalWorkingDays]=getCalculationDailyWage(empHours);
         totalSalary = totalSalary + empDailyWage[totalWorkingDays];
         System.out.println("Day"+totalWorkingDays+"		"+empDailyWage[totalWorkingDays]+"			"+totalSalary);
         if( totalEmpHours > 100 )
           {
               totalEmpHours=totalEmpHours-4;
               totalSalary=totalEmpHours-80;
               System.out.println("Day"+totalWorkingDays+"		"+empDailyWage[totalWorkingDays]+"			"+totalSalary);
               break;
           }
      }
         System.out.println("Total Emp Hrs: "+totalEmpHours );
         System.out.println("Total salary of employee= " + totalSalary);
   }

   public static void main(String args[])
   {
      System.out.println("Welcome to Employee Wage Computation/Problem");
      EmpWage employee=new EmpWage();
      employee.getMonthlyWage();
   }
}
