public class EmpWage
{
    
   public static final int IS_EMP_FULL_TIME = 1;
   public static final int IS_EMP_PART_TIME = 2;
   private int numOfCompany = 0;
   private CompanyEmpWage[] companyEmpWageArray;
   
   public EmpWage() 
   {
        companyEmpWageArray = new CompanyEmpWage[5];
   }
   
    private void addCompanyEmpWage( String company, int empRatePerHour, int workingDaysInMonth, int maximunWorkHours )
    {
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage( company, empRatePerHour, workingDaysInMonth, maximunWorkHours );
        numOfCompany++;
    }
    
    private void getMonthlyWage()
    {
        for(int i = 0; i< numOfCompany; i++) 
        {
            companyEmpWageArray[i].setTotalEmpWage(this.getMonthlyWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
    }
    
   private int getMonthlyWage( CompanyEmpWage companyEmpWage )
   {
     int totalEmpHours = 0, empHours = 0;
     int totalWorkingDays = 0;
     while (totalEmpHours <= companyEmpWage.maximunWorkHours && totalWorkingDays < companyEmpWage.workingDaysInMonth )
        {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck)
            {
                case IS_EMP_FULL_TIME:  empHours = 8 ;
                                        break ;
                case IS_EMP_PART_TIME:  empHours = 4 ;
                                        break ;
                default: empHours=0  ;
            }
            totalEmpHours += empHours;
            
            System.out.println("Day " + totalWorkingDays + " EmpHours= "+ empHours);
        }
        return totalEmpHours * companyEmpWage.empRatePerHour; 
   }

   public static void main(String args[])
   {
      System.out.println("\nWelcome to Employee Wage Computation/Problem");
      EmpWage empwage = new EmpWage();
      empwage.addCompanyEmpWage("VMART",20,2,10);
      empwage.addCompanyEmpWage("BigBazaar",10,4,20);
      empwage. getMonthlyWage();
   }
}

/*
Welcome to Employee Wage Computation/Problem
Day 1 EmpHours= 4
Day 2 EmpHours= 8
Total Emp Wage for Company: VMART is: 240
Day 1 EmpHours= 4
Day 2 EmpHours= 4
Day 3 EmpHours= 0
Day 4 EmpHours= 8
Total Emp Wage for Company: BigBazaar is: 160
*/
