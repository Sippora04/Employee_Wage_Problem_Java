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

   public static int getCalculationDailyWage(int empHours,int EMP_RATE_PER_HOUR )
   {
      dailyWage = empHours * EMP_RATE_PER_HOUR;
      return dailyWage;
   }

   public static void getMonthlyWage(String company,int EMP_RATE_PER_HOUR,int WORKING_DAYS_IN_MONTH,int MAXIMUM_WORK_HOURS )
   {
      int empDailyWage[] = new int[25];
      int totalWorkingDays = 0;
      System.out.println("Day No.		DailyWage	TotalWage");
      while (totalEmpHours < MAXIMUM_WORK_HOURS && totalWorkingDays < WORKING_DAYS_IN_MONTH)
      {
         int empCheck = (int) Math.floor(Math.random() * 10) % 3;
         empHours = getWorkingHours(empCheck);
         totalEmpHours += empHours;
         totalWorkingDays++;
         empDailyWage[totalWorkingDays]=getCalculationDailyWage(empHours,EMP_RATE_PER_HOUR);
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
      EmpWage employee1=new EmpWage();
      EmpWage employee2=new EmpWage();
      employee1.getMonthlyWage("Vishal Mega Mart",20,4,30);
      employee2.getMonthlyWage("Big Bazaar",15,5,25);
   }
}

/*
OUTPUT:
$ java EmpWage

Welcome to Employee Wage Computation/Problem

Day No.         DailyWage       TotalWage
Day1            0               0
Day2            160             160
Day3            80              240
Day4            160             400

Total salary of an employee of Vishal Mega Mart Company is 400

Day No.         DailyWage       TotalWage
Day1            0               400
Day2            120             520

Total salary of an employee of Big Bazaar Company is 520
*/
