import java.io.FileWriter;
import java.io.IOException;

public class HashTable {
	/*
	 * this class creates the node 
	 */
		public class Node {  
			String userID;
			String first_name; 
			String last_name;
			int version;
			String insurance_company;
			Node nextNode; 
	/*
	 * 		this is the node constructor. it creates the node
	 * @param name this is the name for the country 
			 * @param gdpPerCapita this is the GDP per Capita for the country
	 */
		public Node(String userID, String first_name, String last_name, int version, String insurance_company) { 
			this.userID = userID;
			this.first_name = first_name;
			this.last_name = last_name;  
			this.version = version;  
			this.insurance_company = insurance_company;    
			} 
	 /*
	  * this method prints the node
	  */
		public void printNode() {  
			System.out.printf("insurance: " + insurance_company + " " + "First Name: " + first_name);  
			}
			
		}
		

		
		 private linkList[] hashArray;
		 private int arraysize;
		/*
		 * this constructor creates the hash table and linked list
		 */
		public HashTable(int size)
		{
		arraysize = size;
		hashArray = new linkList[arraysize];
		for(int j = 0; j < arraysize; j++)
		{
			hashArray[j] = new linkList();
		}
		
		
		}
	/*
	 * this method creates the index with unicode from the country name
	 * @param name this is the name for the country 
		
	 */
		public int hashFunc(String name)
		{
			int sum = 0;
			int index = 0;
	 
				 char [] chars = name.toCharArray();
				 for (int i = 0; i < name.length(); i++)
				 {
					 char ch = chars[i];
					 int u = ch;
					 
					 sum = sum + u;
					 
					 
				 }
				 index = sum % 10;
				 return index; 
				 
		}
		/*
		 * this method inserts the node into the hash tree
		 * @param name this is the name for the country 
			 * @param gdpPerCapita this is the GDP per Capita for the country
		 */
		public void insert(String userID, String first_name, String last_name, int version, String insurance_company)
		{
			Node newNode = new Node(userID, first_name, last_name, version, insurance_company);
			int hashVal = hashFunc(insurance_company);
			hashArray[hashVal].insertEnd(newNode);	
		}
					
		public void displayTable()
		{
			
		
			System.out.println("Hash Table Content: ");
			for(int j=0; j < 10; j++)
			{
				//System.out.print(j + ". ");
				hashArray[j].displaylist();
			}
				
		}

		public void insertTable() throws IOException
		{
			for(int j=0; j<10; j++)
			{
				
				hashArray[j].sortList();
				hashArray[j].checkID();
				hashArray[j].insertList();
			}
		}
		
		
		
		
		
	
		 class linkList {
		
			private Node first;
			private Node last;
			
			public linkList() {
				first = null;
				last = null;
				
			}
			public boolean isEmpty()
			{
				return first == null;
			}
			

			public void insertEnd(Node d)          //insert at end of list
			{
				
				if( isEmpty() )                    //if empty list
				{
					first = d;
					
				}
				else
				{

						last.nextNode = d;                   //old last --> newLink
						last = d;
											 // newLin <-- last 
				}	
				last = d;  
			}
			
			
			/*
			 * this method prints the node in the hash tree
			 */		
			public void displaylist()
			{
				
				Node current = first;
				if(current == null)
				{
					//System.out.println("\tEmpty");
				}
				
				while(current != null)
				{
					current.printNode();
					current = current.nextNode;
				}
				System.out.println("");
			}

			public void insertList() throws IOException
			{
				Node current = first;
				
				if(current != null)
				{
					//System.out.println(current);
					String filename = first.insurance_company;
					//System.out.println(filename);
					FileWriter csvWriter = new FileWriter(filename+".csv");
					while(current != null)
				{
					//System.out.println(current.userID);
					csvWriter.append(current.userID);
					
					csvWriter.append(",");
					//System.out.println(current.first_name);
					csvWriter.append(current.first_name);
					
					csvWriter.append(",");
					//System.out.println(current.last_name);
					csvWriter.append(current.last_name);
					
					csvWriter.append(",");
					//System.out.println(current.version);
					String Sversion = Integer.toString(current.version);
					csvWriter.append(Sversion);
					
					csvWriter.append(",");
					//System.out.println(current.insurance_company);
					csvWriter.append(current.insurance_company);
					
					csvWriter.append("\n");
					current = current.nextNode;	
				}
				csvWriter.close();
				}
			}

			public void checkID()
			{
				Node current = first; 
				if(current != null)
				{
					Node index = current.nextNode;
					while(index != null)
					{
						String str1 = current.userID;
						String str2 = index.userID; 
						int compare = str1.compareTo(str2);
						Boolean comp = str1.equalsIgnoreCase(str2);
						System.out.println(compare);
						System.out.println(comp);
						System.out.println("Current: " + current.userID);
						System.out.println("Index: " + index.userID);

						if(comp == true)
						{
							System.out.println("MADE IT HERE!");
							if(current.version > index.version)
							{
								System.out.println("Current Version is more new");
								delete(index.userID, index.version);
							}
							else
							{
								System.out.println("Index Version is more new");
								delete(current.userID, current.version);
							}
						}
						index = index.nextNode;
					}
				}
			}


			public void sortList()
			{
		  
				// Node current will point to head
				Node current = first, index = null;
		  
				String tempID;
				String tempFirst;
				String tempLast;
				int tempVersion;
				String tempInsurance;
		  
				if (first == null) {
					return;
				}
				else {
					while (current != null) {
						// Node index will point to node next to
						// current
						index = current.nextNode;
		  
						while (index != null) {
							// If current node's data is greater
							// than index's node data, swap the data
							// between them
							int compare = current.last_name.compareTo(index.last_name);
							if (compare > 0) {
								tempID = current.userID;
								tempFirst = current.first_name;
								tempLast = current.last_name;
								tempVersion = current.version;
								tempInsurance = current.insurance_company;
								current.userID = index.userID;
								current.first_name = index.first_name;
								current.last_name = index.last_name;
								current.version = index.version;
								current.insurance_company = index.insurance_company;
								index.userID = tempID;
								index.first_name = tempFirst;
								index.last_name = tempLast;
								index.version = tempVersion;
								index.insurance_company = tempInsurance;

							}
							if(compare == 0)
							{
								int fcompare = current.first_name.compareTo(index.first_name);
								if(fcompare > 0)
								{
									tempID = current.userID;
									tempFirst = current.first_name;
									tempLast = current.last_name;
									tempVersion = current.version;
									tempInsurance = current.insurance_company;
									current.userID = index.userID;
									current.first_name = index.first_name;
									current.last_name = index.last_name;
									current.version = index.version;
									current.insurance_company = index.insurance_company;
									index.userID = tempID;
									index.first_name = tempFirst;
									index.last_name = tempLast;
									index.version = tempVersion;
									index.insurance_company = tempInsurance;

								}
							}
		  
							index = index.nextNode;
						}
						current = current.nextNode;
					}
				}
			}



			public void delete(String userID, int version)
		{
			Node previous = null;
			Node current = first;
			
			while(current != null && current.version != (version) && current.userID != userID)
			{
				
				previous = current;
				current = current.nextNode;
			}
			if(previous == null)
			{
				first = first.nextNode;
			}
			else
			{
				previous.nextNode = current.nextNode;
			}
			
		}


		}
	}
