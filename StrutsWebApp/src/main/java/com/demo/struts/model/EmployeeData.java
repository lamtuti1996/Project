package com.demo.struts.model;

import java.util.ArrayList;

public class EmployeeData {

    private String id;
    private String userName;
    private String emailId;

   
    
    public EmployeeData(String Id, String userName, String emailId)
    {
        this.id = Id;
        this.userName = userName;
        this.emailId = emailId;
    }

    public EmployeeData() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList loadData()
    {
        ArrayList userList = new ArrayList();
        userList.add(new EmployeeData("001","Mathanlal sait","mathanlal@candidjava.com"));
        userList.add(new EmployeeData("002","Anburaj","anburaj@candidjava.com"));
        userList.add(new EmployeeData("003","Vignesh","vignesh@candidjava.com"));
        userList.add(new EmployeeData("004","Antony","antony@candidjava.com"));
        userList.add(new EmployeeData("005","Gopukumar","gobu@candidjava.com"));
        userList.add(new EmployeeData("006","Kalaimani","kalaimani@candidjava.com"));
        userList.add(new EmployeeData("007","karthika","karthika@candidjava.com"));
        userList.add(new EmployeeData("008","deepa","deepa@candidjava.com"));
        userList.add(new EmployeeData("009","Prabhu","praphu@candidjava.com"));
        userList.add(new EmployeeData("010","karupia","karupia@candidjava.com"));
        userList.add(new EmployeeData("011","Bala","bala@candidjava.com"));
        userList.add(new EmployeeData("012","Mahesh","mahesh@candidjava.com"));
        userList.add(new EmployeeData("012","Rajendran","rajendran@candidjava.com"));
        return userList;
    }

    /**
     * @return the tvShow
     */
    public String getId() {
        return id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }
 
}
