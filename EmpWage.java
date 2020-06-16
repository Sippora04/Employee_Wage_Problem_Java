
import java.util.*;

public class EmpWage
{
   public static int empHours = 0;
   public static final int IS_EMP_FULL_TIME = 1;
   public static final int IS_EMP_PART_TIME = 2;
   
   private final ArrayList<CompanyEmpWage> companyArray;
   private int numofCompany=0;
   
   public EmpWage()
   {
    companyArray = new ArrayList<>();
   }
   
   public void addCompanyEmployee(String company, int empRatePerHour, int workingDaysInMonth, int maximunWorkHours)
    {
        CompanyEmpWage comp = new CompanyEmpWage( company, empRatePerHour, workingDaysInMonth, maximunWorkHours);
        companyArray.add(comp);
        numofCompany++;
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

   public void getCalculationDailyWage()
   {    
      for (int i=0; i< numofCompany; i++)
      { 
        System.out.println("Employee " + getMonthlyWage( companyArray.get(i)) );
      } 
   }
   
   public int getMonthlyWage(CompanyEmpWage company )
   {
      int totalEmpHours = 0, dailyWage = 0, totalSalary = 0, totalWorkingDays = 0;
//    System.out.println("\nDay No.		DailyWage	TotalWage");
      while (totalEmpHours < company.maximunWorkHours && totalWorkingDays < company.workingDaysInMonth )
      {
         int empCheck = (int) Math.floor(Math.random() * 10) % 3;
         empHours = getWorkingHours(empCheck);
         dailyWage = company.empRatePerHour * empHours;
         totalSalary = totalSalary + dailyWage;
         totalEmpHours += empHours;
         totalWorkingDays++;
       //calculatingDailyWage = getCalculationDailyWage();
       //totalSalary = totalSalary + calculatingDailyWage;
       //System.out.println("Day"+totalWorkingDays+"		"+totalSalary);
         if( totalEmpHours > company.maximunWorkHours )
           {
               return company.empRatePerHour * company.maximunWorkHours;
           }
         
        }
//       System.out.println("Total Emp Hrs: "+totalEmpHours );
//       System.out.println("\nTotal salary of an employee of " + company + " Company is " + totalSalary + " \n " );
         return totalSalary;
    }

   public static void main(String args[])
   {
      System.out.println("\nWelcome to Employee Wage Computation/Problem\n");
      EmpWage employeeWage = new EmpWage();
      employeeWage.addCompanyEmployee("Vishal Mart", 20, 4, 30 );
      employeeWage.addCompanyEmployee("BigBazaar", 15, 5, 25 );
      employeeWage.addCompanyEmployee("City Style", 30, 20 ,100 );
      employeeWage.getCalculationDailyWage();
   }
}
