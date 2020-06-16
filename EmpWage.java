import java.util.*;
public class EmpWage implements EmpWageInterface
{   
   int empHours = 0;
   private Map<String, Integer> companyWageMap;
   private final ArrayList<CompanyEmpWage> companyArray;
   private int numofCompany=0;
   
   public EmpWage()
   {
    companyArray = new ArrayList<>();
    companyWageMap = new HashMap<>();
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
	System.out.println(" Company: " + companyArray.get(i).company + " :  Employee Wage : " + companyArray.get(i).totalSalary);
        int oldWage = 0;
        System.out.println("Day     DailyWage       Total Wage");
	for (int j=0; j < companyArray.get(i).dailyWage.size(); j++ )
        {
            System.out.println("Day: " + j +"       "+(companyArray.get(i).dailyWage.get(j)-oldWage)+"          "+companyArray.get(i).dailyWage.get(j));
            oldWage = companyArray.get(i).dailyWage.get(j);
	}
      } 
   }
   
   public void wagePerCompany()
    {
        Set set= companyWageMap.entrySet();
	Iterator itr=set.iterator();
        while(itr.hasNext())
        {
            Map.Entry entry=(Map.Entry)itr.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
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
         companyWageMap.put(company.company, totalSalary );
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

/*
OUTPUT:

Welcome to Employee Wage Computation/Problem

 Company: Vishal Mart : Employee Wage :480
Day     DailyWage       Total Wage
Day: 0       80          80
Day: 1       160         240
Day: 2       80          320
Day: 3       160         480
 Company: BigBazaar : Employee Wage :120
Day     DailyWage       Total Wage
Day: 0       60          60
Day: 1       60          120
Day: 2       0           120
Day: 3       0           120
Day: 4       0           120
 Company: City Style : Employee Wage :2400
Day     DailyWage       Total Wage
Day: 0       120         120
Day: 1       0           120
Day: 2       240         360
Day: 3       240         600
Day: 4       0           600
Day: 5       0           600
Day: 6       0           600
Day: 7       120         720
Day: 8       0           720
Day: 9       240         960
Day: 10      120         1080
Day: 11      0           1080
Day: 12      240         1320
Day: 13      240         1560
Day: 14      240         1800
Day: 15      0           1800
Day: 16      0           1800
Day: 17      240         2040
Day: 18      120         2160
Day: 19      240         2400
 Company: City Style : Employee Wage :192
Day     DailyWage       Total Wage
Day: 0       48          48
Day: 1       0           48
Day: 2       48          96
Day: 3       0           96
Day: 4       96          192

*/
