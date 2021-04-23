import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
 
public class insurance_sorting {
	//create hashtable object
	static HashTable h = new HashTable(10);

	public static void main(String[] args) {
		try
		{
			//read in csv file
			String strFile = "./insurance.csv";
			//create BufferedReader to read csv file
			BufferedReader br = new BufferedReader( new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;

			//read comma separated file line by line
			while( (strLine = br.readLine()) != null)
			{
				//break comma separated line using ","
				st = new StringTokenizer(strLine, ",");
				while(st.hasMoreTokens())
				{
					//break up data into variables
					String  userID = st.nextToken();
					String first_name = st.nextToken();
		    			String last_name = st.nextToken();
					int version = Integer.parseInt(st.nextToken());
					String insurance_company = st.nextToken();
					
					//insert h object into hashtable
					h.insert(userID, first_name, last_name, version, insurance_company);


					//display csv values for debugging purposes
				
					//System.out.println(userID);
					//System.out.println(first_name);
					//System.out.println(last_name);
					//System.out.println(version);
					//System.out.println(insurance_company);
				}
			}// while
			
			//display table for dubugging purposes 
			//h.displayTable();
			
			//insert into new csv files
			h.insertTable();
			//close buffer reader
			br.close();

			
		}
		catch(Exception e)
		{
			System.out.println("Exception while reading csv file: " + e); 
		}
	}//main
}//class



