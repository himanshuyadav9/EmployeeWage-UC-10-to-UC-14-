



import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


interface EmpWage
        {
        	void addCompany(final String name,final int empRate, final int numOfWorkingDays, final int maxHrsInMonth  );
        	 void computeEmpWage();
        	int getTotalWageByCompanyName(final String name);
        }
        public class EmployeeWageUC14 implements EmpWage {
		
		private List<Company> companies;
        private Map<String,Integer> companyWages;     
		
		public  EmployeeWageUC14() {
			companies = new ArrayList<Company>();
			companyWages= new HashMap<String,Integer>();
			
		}
		
		public static void main(String[] args) {
			System.out.println("Starting...");
			final EmployeeWageUC14 empBuilder = new EmployeeWageUC14();
			empBuilder.addCompany("LIC", 20, 20, 100);
			empBuilder.addCompany("SBI", 20, 18, 110);

			empBuilder.computeEmpWage();
			
			final int totalWage = empBuilder.getTotalWageByCompanyName("LIC");
			System.out.println("Total Emp Wage for LIC: " + totalWage);
			
			//overriding get total wage by company name method to get wage by company name
		}
		@Override
		public int getTotalWageByCompanyName(final String name) {
			final int totalWage = companyWages.get(name);
			return totalWage;
			
		}
		
		//implementing interface methods by overriding them
	    //addCompany taking parameters from company
		
         @Override
		public void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth){
			System.out.println("company name : "+ name);
			companies.add(new Company(name, empRate, numOfWorkingDays, maxHrsInMonth));
			
		}
         
       //computeEmpWage method iterating company objects and assigning total Wage 
         // taking parameter from company and @return from total wage

         @Override
		public void computeEmpWage(){

			System.out.println("Caling computeEmpWage --->");
			for(int i = 0; i< companies.size(); i++){
				final Company company= companies.get(i);
				final int totalWage = computeEmpWage(company);
				company.setTotalEmpWage(totalWage);
				companyWages.put(company.getName(), totalWage);
			}
			System.out.println("company and total Employee Wage " + companyWages.toString());
		}
      // calculate total employee wages
      // @param taking from the Company by name
      // @return total employee wages to calculate the wage by Company name in computeEmpWage
         
		private int computeEmpWage(final Company company) {
			System.out.println("company name : " + company.getName());
			int totalWage = 0;
			int totalEmpHrs = 0;
			int totalWorkingDays = 0;
			while(totalEmpHrs < company.getMaxHrsInMonth() && totalWorkingDays< company.getNumOfWorkingDays()){
				totalWorkingDays++;

				final int empHrs = getEmpHrs();
				final int empWage = empHrs*company.getEmpRate();
				totalEmpHrs+=empHrs;
				totalWage+=empWage;
			}
			return totalWage;
		}
		
	//  Getting employee hours. 
	//  @return employee hrs to use in Calculating Employee Wages

		public int getEmpHrs() {

			final int isFullTime = 1;
			final int isPartTime = 2;
			int empHrs = 0;

			//get random value
			final double randomValue = Math.floor(Math.random()*10)%3;

			switch((int)randomValue) {

				case isFullTime:
					empHrs = 8;
					break;
				case isPartTime:
					empHrs = 4;
					break;
				default:
					break;
			}
			return empHrs;
		}

		
	}
     
        
        
	class Company {

		private String name;
		private int empRate;
		private int numOfWorkingDays;
		private int maxHrsInMonth;
		private int totalEmpWage;

		public Company(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth){
			this.name = name;
			this.empRate = empRate;
			this.numOfWorkingDays = numOfWorkingDays;
			this.maxHrsInMonth = maxHrsInMonth;
		}

		public String getName(){
			return this.name;
		}

		public int getEmpRate(){
			return this.empRate;
		}

		public int getNumOfWorkingDays(){
			return this.numOfWorkingDays;
		}

		public int getMaxHrsInMonth(){
			return this.maxHrsInMonth;
		}

		public void setTotalEmpWage(final int totalEmpWage){
			this.totalEmpWage=totalEmpWage;
		}
		
		public void setName(final String name) {
		   this.name=name;
		}
		@Override
		public String toString(){
			return name+" "+ totalEmpWage;
		}

	}



