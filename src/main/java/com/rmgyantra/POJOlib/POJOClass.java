package com.rmgyantra.POJOlib;

public class POJOClass {
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	public POJOClass(String createdBy,String projectName,String status,int teamSize)
	{
		this.createdBy=createdBy;
		this.projectName=projectName;
		this.status=status;
		this.teamSize=teamSize;
	}
	
	public String getcreatedBy()
	{
		return createdBy;
	}
	
	public String getprojectName()
	{
		return projectName;
	}
	
	public String getstatus()
	{
		return status;
	}
	
	public int getteamSize()
	{
		return teamSize;
	}
	
	public void setcreatedBy(String createdBy)
	{
		this.createdBy=createdBy;
	}
	
	public void setprojectName(String projectName)
	{
		this.projectName=projectName;
	}
	
	public void setstatus(String status)
	{
		this.status=status;
	}
	
	public void setteamSize(int teamSize)
	{
		this.teamSize=teamSize;
	}
	
	
}
