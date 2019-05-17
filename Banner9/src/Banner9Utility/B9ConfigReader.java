package Banner9Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class B9ConfigReader 
{
	
	Properties pro;
	
	public B9ConfigReader()
	{
		
     try
     {
    
		File src=new File("C:\\Selenium\\Banner9\\Configuration\\B9Config.Property");
		 FileInputStream fis=new FileInputStream(src);
		 pro=new Properties();
		 pro.load(fis);
	} 
     catch (Exception e) {
		
    	 System.out.println("Exception is =="+e.getMessage());
	
	}
	 
	}
	
	
	//HUBURL
	
		public String getHUBURL()
		{
			String path=pro.getProperty("HUBURL");
			return path;
		}
	
		
		//APP Central Username and Password
		public String getAPPQAUSERNAME()
		{
			String path=pro.getProperty("appqausername");
			return path;
		}
		
		
		public String getAPPQAPASSWORD()
		{
			String path=pro.getProperty("appqapassword");
			return path;
		}
		
		//Oracle
		public String getQAUSERNAMEoracle()
		{
			String path=pro.getProperty("b9oracleusername");
			return path;
		}
		
		public String getQAPASSWORDoracle()
		{
			String path=pro.getProperty("b9oraclqapassword");
			return path;
		}
		
		
		//Oracle term
				public String getQAUSERNAMEoracleTerm()
				{
					String path=pro.getProperty("b9oracleusernameTerm");
					return path;
				}
				
				public String getQAPASSWORDoracleTerm()
				{
					String path=pro.getProperty("b9oraclqapasswordTerm");
					return path;
				}
				
		
		
		//Banner Central Username and Password
				public String getB9QAUSERNAME()
				{
					String path=pro.getProperty("b9qausernames");
					return path;
				}
				
				
				public String getB9QAPASSWORD()
				{
					String path=pro.getProperty("b9qapasswords");
					return path;
				}
				
				public String getB92QAUSERNAME()
				{
					String path=pro.getProperty("b9qausername");
					return path;
				}
				
				
				public String getB92QAPASSWORD()
				{
					String path=pro.getProperty("b9qapassword");
					return path;
				}
				
				public String getB93QAUSERNAME()
				{
					String path=pro.getProperty("b9qausername2");
					return path;
				}
				
				
				public String getB93QAPASSWORD()
				{
					String path=pro.getProperty("b9qapassword2");
					return path;
				}
		
		
		//SQL
		
		public String getQAUSERNAME()
		{
			String path=pro.getProperty("b9qausername");
			return path;
		}
		
		
		public String getQAPASSWORD()
		{
			String path=pro.getProperty("b9qapassword");
			return path;
		}
				
		
		
		public String getSSBQAUSERNAME()
		{
			String path=pro.getProperty("b9ssbqausername");
			return path;
		}
		
		
		public String getSSBQAPASSWORD()
		{
			String path=pro.getProperty("b9ssbqapassword");
			return path;
		}
		
		
		public String getQAPASSWORD2()
		{
			String path=pro.getProperty("qapassword2");
			return path;
		}
		
		
		
		
	//Webdrivers
	
	public String getFFDriver()
	{
		String path=pro.getProperty("FFDriver");
		return path;
	}
	
	
	public String getChromeDriver()
	{
		String path=pro.getProperty("ChromeDriver");
		return path;
	}
	
	
	public String getIEDriver()
	{
		String path=pro.getProperty("IEDriver");
		return path;
	}
	
	
	//URLs
	
     public String getBanner9Prod()
	{
		return pro.getProperty("B9_PROD_URL");
	}
     
     public String getBanner9Stage()
 	{
 		return pro.getProperty("B9_STAGE_URL");
 	}
     
     
     public String getBanner9Test()
 	{
 		return pro.getProperty("B9_TEST_URL");
 	}
     
     public String getBanner9Dev()
  	{
  		return pro.getProperty("B9_DEV_URL");
  	}
     
     public String getAPPUrlDev()
  	{
  		return pro.getProperty("APP_DEV_URL");
  	}
     
     
     // Application Navigator
     
  // Application Navigator URLs
  	
     public String getAppNavTest()
	{
		return pro.getProperty("B9_AppNav_Test");
	}
     
     public String getAppNavProd()
 	{
 		return pro.getProperty("B9_AppNav_Prod");
 	}
     
     public String getAppNavStage()
   	{
   		return pro.getProperty("B9_AppNav_Stage");
   	}
     
     public String getAppNavCamp()
  	{
  		return pro.getProperty("B9_AppNav_Camp");
  	}
     
     public String getAppNavDev()
  	{
  		return pro.getProperty("B9_AppNav_Dev");
  	}  
     
     public String getAppNavYoda()
   	{
   		return pro.getProperty("B9_AppNav_Yoda");
   	}  
     
     public String getAppNavMNTH()
   	{
   		return pro.getProperty("B9_AppNav_MNTH");
   	}  
     
     
     // SSB URLs
   	//Test
     public String getSSBGenTest()
	{
		return pro.getProperty("SSBGenTest");
	}
     
     public String getSSBFacTest()
 	{
 		return pro.getProperty("SSBFacTest");
 	}
      
     public String getSSBStuTest()
 	{
 		return pro.getProperty("SSBStuTest");
 	}
      
     public String getSSBEmpTest()
 	{
 		return pro.getProperty("SSBEmpTest");
 	}
      
     public String getSSBFinTest()
 	{
 		return pro.getProperty("SSBFinTest");
 	}
     
     public String getSSBStuRegTest()
  	{
  		return pro.getProperty("SSBStuRegTest");
  	}
      
   //Stage
     public String getSSBGenStage()
	{
		return pro.getProperty("SSBGenStage");
	}
     
     public String getSSBFacStage()
 	{
 		return pro.getProperty("SSBFacStage");
 	}
      
     public String getSSBStuStage()
 	{
 		return pro.getProperty("SSBStuStage");
 	}
      
     public String getSSBEmpStage()
 	{
 		return pro.getProperty("SSBEmpStage");
 	}
      
     public String getSSBFinStage()
 	{
 		return pro.getProperty("SSBFinStage");
 	}
      
     public String getSSBStuRegStage()
 	{
 		return pro.getProperty("SSBStuRegStage");
 	}

      
     
     //Excel file path
     
     public String getExcelLoop()
   	{
   		return pro.getProperty("ExcelLoop");
   	}
     
     public String getExcelPath()
   	{
   		return pro.getProperty("ExcelPath");
   	}
     
     
     public String getExcelPathfromscript()
    	{
    		return pro.getProperty("ExcelPathfromscript");
    	}
     
     public String getExcelPathFinance()
 	{
 		return pro.getProperty("ExcelPathFinance");
 	}
     
     public String getAPEXPasswordReset()
  	{
  		return pro.getProperty("APEXPasswordReset");
  	}
     
     public String getSSB()
  	{
  		return pro.getProperty("SSBData");
  	}
     
     
     
     
     //
     
     public String getLandPGTitle()
 	{
 		String path=pro.getProperty("LandingPGTile");
 		return path;
 	}
	
     public String getLeft_Nova_link_and_logo()
  	{
  		String path=pro.getProperty("Left_Nova_link_and_logo");
  		return path;
  	}
     
     
     public String getFooter()
   	{
   		String path=pro.getProperty("Footer");
   		return path;
   	}
     
     public String getSearchField()
    	{
    		String path=pro.getProperty("SearchField");
    		return path;
    	}
     
     
     public String getGiving_to_NSU_TOP_link()
 	{
 		String path=pro.getProperty("Giving_to_NSU_TOP_link");
 		return path;
 	}
     
     
     public String getAlumni_TOP_link()
  	{
  		String path=pro.getProperty("Alumni_TOP_link");
  		return path;
  	}
     
     
     public String getSelect_a_college_TOP_link()
   	{
   		String path=pro.getProperty("Select_a_TOP_college");
   		return path;
   	}
     
     
     public String getWhy_NSU_MID_link()
    	{
    		String path=pro.getProperty("Why_NSU_MID_link");
    		return path;
    	}
     
     
     public String getGraduate_and_professional_MID_link()
 	{
 		String path=pro.getProperty("Graduate_and_professional_MID_link");
 		return path;
 	}
     
     
     public String getUndergraduate_mid_link()
  	{
  		String path=pro.getProperty("Undergraduate_mid_link");
  		return path;
  	}
     
     
     
     public String getAlumni_MID_link()
   	{
   		String path=pro.getProperty("Alumni_MID_link");
   		return path;
   	}
     
     
     public String getVisit_Campus_MID_link()
    	{
    		String path=pro.getProperty("Visit_Campus_MID_link");
    		return path;
    	}
     
     
     public String getUndergraduate_HOVER_link()
 	{
 		String path=pro.getProperty("Undergraduate_HOVER_link");
 		return path;
 	}
  
     
     public String getGraduate_and_professional_HOVER_link()
  	{
  		String path=pro.getProperty("Graduate_and_professional_HOVER_link");
  		return path;
  	}
     
     
     
     public String getAcadedmics_HOVER_link()
   	{
   		String path=pro.getProperty("Acadedmics_HOVER_link");
   		return path;
   	}
     
     
     
     public String getStudent_Life_HOVER_link()
   	{
   		String path=pro.getProperty("Student_Life_HOVER_link");
   		return path;
   		
	}
   	
   		public String getResearch_HOVER_link()
   	   	{
   	   		String path=pro.getProperty("Research_HOVER_link");
   	   		return path;
     
   	}
     
   		
   		public String getCommunity_HOVER_link()
   	   	{
   	   		String path=pro.getProperty("Community_HOVER_link");
   	   		return path;
   		
   		
   	   	}
     
	

	
	public String getAbout_NSU_HOVER_link()
  	{
  		String path=pro.getProperty("About_NSU_HOVER_link");
  		return path;
	
	
     
     
	}
	
	
	public String getFacebook_link()
  	{
  		String path=pro.getProperty("Facebook_link");
  		return path;
	
	
     
     
	}
	
	public String getYoutube_link()
  	{
  		String path=pro.getProperty("Youtube_link");
  		return path;
	
	
     
     
	}
	
	
	public String getLinkedin_link()
  	{
  		String path=pro.getProperty("Linkedin_link");
  		return path;
	
  		
  		
     
     
  	}
	
	public String getGoogleplus_link()
  	{
  		String path=pro.getProperty("Googleplus_link");
  		return path;
	 		    
     
  	}
	
	
	public String getNovase_link()
  	{
  		String path=pro.getProperty("Novase_link");
  		return path;
	 		    
     
  	}
	
	public String getPinterest_link()
  	{
  		String path=pro.getProperty("Pinterest_link");
  		return path;
	 		    
     
  	}
	
	
	public String getInstagram_link()
  	{
  		String path=pro.getProperty("Instagram_link");
  		return path;
	 		    
     
  	}
	
	
	public String getUndergraduate_TOP_link()
  	{
  		String path=pro.getProperty("Undergraduate_TOP_link");
  		return path;
	 		    
     
  	}
	
	
	public String getSearch_button()
  	{
  		String path=pro.getProperty("Search_button");
  		return path;
	 		    
     
  	}
	
	
	public String getSort_by_date_search()
  	{
  		String path=pro.getProperty("Sort_by_date_search");
  		return path;
	 		    
     
  	}
	
	public String getFooter_toggle_search()
  	{
  		String path=pro.getProperty("Footer_toggle_search");
  		return path;
	 		    
     
  	}
	
	
	public String getApply_now_main_page_button()
  	{
  		String path=pro.getProperty("Apply_now_main_page_button");
  		return path;
	 		    
     
  	}
	
	
	
	public String getUndergrad_request_button()
  	{
  		String path=pro.getProperty("Undergrad_request_button");
  		return path;
	 		    
     
  	}
	
	public String getCreate_Undergrad_Request_button()
  	{
  		String path=pro.getProperty("Create_Undergrad_Request_button");
  		return path;
	 		    
     
  	}
	
	
	public String getFirst_name_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("First_name_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	public String getMiddle_name_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Middle_name_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getLast_name_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Last_name_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getEmail_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Email_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getConfirm_Email_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Confirm_Email_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	public String getConfirm_street1_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Confirm_street1_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getConfirm_street2_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Confirm_street2_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	
	
	public String getConfirm_city_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Confirm_city_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	public String getConfirm_state_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Confirm_state_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getConfirm_zip_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Confirm_zip_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getConfirm_international_phone_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Confirm_international_phone_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getPreferred_phone_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Preferred_phone_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	public String getCell_phone_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Cell_phone_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	public String getAccept_Text_Messages_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Accept_Text_Messages_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	public String getSelf_Identity_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Self_Identity_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	public String getProgram_Type_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Program_Type_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getProgram_of_study_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Program_of_study_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	public String getCampus_location_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Campus_location_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	public String getCampus_entry_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Campus_entry_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getBirthday_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Birthday_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getUS_citizen_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("US_citizen_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getHow_did_you_learn_about_NSU_field()
  	{
  		String path=pro.getProperty("How_did_you_learn_about_NSU_field");
  		return path;
	 		    
     
  	}
	
	
	public String getPassword_field()
  	{
  		String path=pro.getProperty("Password_field");
  		return path;
	 		    
     
  	}
	
	public String getConfirm_password_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Confirm_password_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getPassword_question_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Password_question_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	public String getPassword_answer_field_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Password_answer_field_undergrad_applyonline");
  		return path;
	 		    
     
  	}

	public String getSubmit_button_undergrad_applyonline()
  	{
  		String path=pro.getProperty("Submit_button_undergrad_applyonline");
  		return path;
	 		    
     
  	}
	
	
	//
	
	public String getSearch_button_mobile_responsive()
  	{
  		String path=pro.getProperty("Search_button_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getGiving_to_NSU_mobile_responsive()
  	{
  		String path=pro.getProperty("Giving_to_NSU_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getMenu_mobile_responsive()
  	{
  		String path=pro.getProperty("Menu_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getAbout_NSU_mobile_responsive()
  	{
  		String path=pro.getProperty("About_NSU_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getCommunity_mobile_responsive()
  	{
  		String path=pro.getProperty("Community_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getResearch_mobile_responsive()
  	{
  		String path=pro.getProperty("Research_mobile_responsive");
  		return path;
	 		    
     
  	}
	
		
	public String getStudent_life_mobile_responsive()
  	{
  		String path=pro.getProperty("Student_life_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getAcademics_mobile_responsive()
  	{
  		String path=pro.getProperty("Academics_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getGradudate_and_professional_mobile_responsive()
  	{
  		String path=pro.getProperty("Gradudate_and_professional_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getUndergraduate_mobile_responsive()
  	{
  		String path=pro.getProperty("Undergraduate_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getWhy_NSU_mobile_responsive()
  	{
  		String path=pro.getProperty("Why_NSU_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getGraduate_amd_professional_mobile_responsive()
  	{
  		String path=pro.getProperty("Graduate_amd_professional_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getVisit_campus_mobile_responsive()
  	{
  		String path=pro.getProperty("Visit_campus_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getAlumni_mobile_responsive()
  	{
  		String path=pro.getProperty("Alumni_mobile_responsive");
  		return path;
	 		    
     
  	}
	
	public String getApply_now_mobile_responsive()
  	{
  		String path=pro.getProperty("Apply_now_mobile_responsive");
  		return path;
	 		    
     
  	}
	

public String getFirst_name_undergrad_applyonline_responsive()
	{
		String path=pro.getProperty("First_name_undergrad_applyonline_responsive");
		return path;
 		    
 
	}

public String getLast_name_undergrad_applyonline_responsive()
{
	String path=pro.getProperty("Last_name_undergrad_applyonline_responsive");
	return path;
		    

}

public String getMiddle_name_undergrad_applyonline_responsive()
{
	String path=pro.getProperty("Middle_name_undergrad_applyonline_responsive");
	return path;
		    

}

public String getApply_now_request_info_1st()
{
	String path=pro.getProperty("Apply_now_request_info_1st");
	return path;
		    

}
	
	
	
}
	





