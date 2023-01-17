import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainFunction {

	public static void MainFunction() {
		System.out.println("Select one of the options:");
		System.out.println("1.Fetch data and insert into");
		System.out.println("2.Updat table by Id");
		System.out.println("3.delete table by Id");
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		 
		   
		// TODO Auto-generated method stub
		
		boolean MenuExit = true;
		boolean subMenuExit = true;
		
		while( MenuExit ) {
			Scanner sc = new Scanner(System.in);
			
		
		do {
			
			MainFunction();
			int SubMenue1 = sc.nextInt();
			switch(SubMenue1) {
			case 1:
				API2Data fetchObj2=new API2Data();
				fetchObj2.getData();
				 break;
			case 2:
				UpdateTable updateObj=new UpdateTable();
				updateObj.UpdateFunction();
				break;
				
			case 3:
				DeleteData deleteObj=new DeleteData();
				deleteObj.deleteFunction();
				break;	
				
    
            
		}
			}while(true);

	}
		 MenuExit =false;
}}

		


