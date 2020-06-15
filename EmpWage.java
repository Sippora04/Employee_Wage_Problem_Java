public class EmpWage
{
   public static int totalEmpHours = 0;
   public static int totalSalary = 0;
// public static int totalWorkingDays = 0;
   public static int empHours = 0;
   public static int dailyWage = 0;

   public static final int IS_EMP_FULL_TIME = 1;
   public static final int IS_EMP_PART_TIME = 2;
// public static final int EMP_RATE_PER_HOUR = 20;
// public static final int WORKING_DAYS_IN_MONTH = 20;
// public static final int MAXIMUM_WORK_HOURS = 100;
// public static final int FULL_TIME_HOURS = 8;
// public static final int PART_TIME_HOURS = 4;
   private final String company;
   private final int empRatePerHour;
   private final int workingDaysInMonth;
   private final int maximunWorkHours;
   
   public EmpWage( String company, int empRatePerHour, int workingDaysInMonth, int maximunWorkHours )
   {
    this.company = company;
    this.empRatePerHour = empRatePerHour;
    this.workingDaysInMonth = workingDaysInMonth;
    this.maximunWorkHours = maximunWorkHours;
   }

   public int getWorkingHours(int empCheck)
   {
      switch (empCheck)
      {
         case IS_EMP_FULL_TIME:  empHours = 8 ;
                                 break ;
         case IS_EMP_PART_TIME:  empHours = 4 ;
                                 break ;
         default: empHours=0  ;
      }
      return empHours;
   }

   public int getCalculationDailyWage(int empHours,int empRatePerHour )
   {
      dailyWage = empHours * empRatePerHour;
      return dailyWage;
   }

   public void getMonthlyWage()
   {
      int empDailyWage[] = new int[25];
      int totalWorkingDays = 0;
      System.out.println("\nDay No.		DailyWage	TotalWage");
      while (totalEmpHours < maximunWorkHours && totalWorkingDays < workingDaysInMonth )
      {
         int empCheck = (int) Math.floor(Math.random() * 10) % 3;
         empHours = getWorkingHours(empCheck);
         totalEmpHours += empHours;
         totalWorkingDays++;
         empDailyWage[totalWorkingDays]=getCalculationDailyWage(empHours,empRatePerHour);
         totalSalary = totalSalary + empDailyWage[totalWorkingDays];
         System.out.println("Day"+totalWorkingDays+"		"+empDailyWage[totalWorkingDays]+"		"+totalSalary);
         if( totalEmpHours > 100 )
           {
               System.out.println("100 cross");
               totalEmpHours=totalEmpHours-4;
               totalSalary=totalEmpHours-80;
					System.out.println("Day"+totalWorkingDays+"     "+empDailyWage[totalWorkingDays]+"     "+totalSalary);
               break;
           }
      }
//       System.out.println("Total Emp Hrs: "+totalEmpHours );
         System.out.println("\nTotal salary of an employee of " + company + " Company is " + totalSalary + " \n " );
   }

   public static void main(String args[])
   {
      System.out.println("\nWelcome to Employee Wage Computation/Problem\n");
      EmpWage vMart = new EmpWage("VMart", 20, 4, 30 );
      EmpWage bigBazaar = new EmpWage("BigBazaar", 15, 5, 25 );
      vMart.getMonthlyWage();
      bigBazaar.getMonthlyWage();
   }
}

/*
OUTPUT:
$ java EmpWage

Welcome to Employee Wage Computation/Problem


Day No.         DailyWage       TotalWage
Day1            160             160
Day2            0               160
Day3            160             320
Day4            80              400

Total salary of an employee of VMart Company is 400


Day No.         DailyWage       TotalWage
Day1            0               400
Day2            120             520

Total salary of an employee of BigBazaar Company is 520

*/
