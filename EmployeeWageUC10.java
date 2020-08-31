public class EmployeeWageUC10 {
		
		private int noOfCompany = 0;
		private Company [] companies;

		public EmployeeWageUC10() {
			companies = new Company[5]; // storing companies in array
		}

		public static void main(String[] args) {
			System.out.println("Starting...");
			final EmployeeWageUC10 empBuilder = new EmployeeWageUC10();
			empBuilder.addCompany("LIC", 20, 20, 100);
			empBuilder.addCompany("SBI", 20, 18, 110);

			empBuilder.computeEmpWage();
		}
		

		public void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth){
			System.out.println("company name : "+ name);
			companies[noOfCompany] = new Company(name, empRate, numOfWorkingDays, maxHrsInMonth);
			noOfCompany++;
		}
		//computeEmpWage method iterating array  company objects and assigning total Wage 
        // taking parameter from company and @return from total wage

		private void computeEmpWage(){

			System.out.println("Calling computeEmpWage --->");
			for(int i = 0; i< noOfCompany; i++){
				final int totalWage = computeEmpWage(companies[i]);
				companies[i].setTotalEmpWage(totalWage);
				System.out.println(companies[i]);
			}

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

	
	 // CompanyEmpWage 
	 
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

		@Override
		public String toString(){
			return "Total emp wage for company: "+name+" is "+ totalEmpWage;
		}
}
