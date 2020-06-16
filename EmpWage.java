import java.util.*;
public class EmpWage implements EmpWageInterface
{   
   int empHours = 0;
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

   public int getWorkingHours(int empCheck )
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
        getMonthlyWage(companyArray.get(i));
	System.out.println(" Company: " + companyArray.get(i).company + " Employee Wage :" + companyArray.get(i).totalSalary);
        int oldWage = 0;
        System.out.println("Day         Wage         Total Wage");
	for (int j=0; j < companyArray.get(i).dailyWage.size(); j++ )
        {
            System.out.println("Day: " + j +"      "+(companyArray.get(i).dailyWage.get(j)-oldWage)+"       "+companyArray.get(i).dailyWage.get(j));
            oldWage = companyArray.get(i).dailyWage.get(j);
	}
      } 
   }
   
   public int getMonthlyWage( CompanyEmpWage company )
   {  
      int totalEmpHours = 0, totalSalary = 0, totalWorkingDays = 0;
      ArrayList<Integer> dailyWageArray = new ArrayList<>();
      while (totalEmpHours < company.maximunWorkHours && totalWorkingDays < company.workingDaysInMonth )
      {
         int empCheck = (int) Math.floor(Math.random() * 10) % 3;
         empHours = getWorkingHours(empCheck );
         int dailyWage = 0;
         dailyWage = company.empRatePerHour * empHours;
         totalSalary = totalSalary + dailyWage;
         dailyWageArray.add(totalSalary);
         totalEmpHours += empHours;
         ++totalWorkingDays;
         
        }
         if( totalEmpHours > company.maximunWorkHours )
         {
            company.getTotalWage(totalSalary);
         }   
         company.storeDailyWage(dailyWageArray);
         company.getTotalWage(totalSalary);
       return 0;
    }

   public static void main(String args[])
   {
      System.out.println("\nWelcome to Employee Wage Computation/Problem\n");
      EmpWage employeeWage = new EmpWage();
      employeeWage.addCompanyEmployee("Vishal Mart", 20, 4, 30 );
      employeeWage.addCompanyEmployee("BigBazaar", 15, 5, 25 );
      employeeWage.addCompanyEmployee("City Style", 30, 20 ,100 );
      employeeWage.addCompanyEmployee("City Style", 12, 5 ,10 );
      employeeWage.getCalculationDailyWage();
   }
}
