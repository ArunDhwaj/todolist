package igt.todolist.igttodolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @file: ToDoTask.java
 * @author: Arun Dhwaj
 * @date: 6th Oct, 2018
 * @purpose: Creating ToDoTask class 
 */

@Entity
@Table(name = "ToDoTask")
public class ToDoTask 
{
	/////////////////////////////////////////////////
    // Class properties - 6th Oct'2018 - Start //////  
	 
	private static final long serialVersionUID = -1009157732242241112L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
    @Column(name = "taskId")
	private int taskId;    
    
    @Column(name = "taskName")
	private String taskName;
    
    @Column(name = "timeStamp")
	private long timeStamp;
    
    @Column(name = "taskType")
	private String taskType;
    
    
    public ToDoTask()
	{
    	//
	}
	
	/////////////////////////////////////////////////
    // Getters setters - 6th Oct'2018 - Start ///////
    
    public int getTaskId() 
    {
		return taskId;
	}
	
    public void setTaskId(int taskId) 
    {
		this.taskId = taskId;
	}

    public long getId() 
    {
		return id;
	}
	
    public void setId(long id) 
    {
		this.id = id;
	}
 
	public String getTaskName() 
	{
		return taskName;
	}
	
	public void setTaskName(String taskName) 
	{
		this.taskName = taskName;
	}
	
	public long getTimeStamp() 
	{
		return timeStamp;
	}
	
	public void setTimeStamp(long timeStamp) 
	{
		this.timeStamp = timeStamp;
	}
	
	public String getTaskType() 
	{
		return taskType;
	}
	
	public void setTaskType(String taskType) 
	{
		this.taskType = taskType;
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + taskId;
		result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
		result = prime * result + ((taskType == null) ? 0 : taskType.hashCode());
		result = prime * result + (int) (timeStamp ^ (timeStamp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoTask other = (ToDoTask) obj;
		if (id != other.id)
			return false;
		if (taskId != other.taskId)
			return false;
		if (taskName == null) 
		{
			if (other.taskName != null)
				return false;
		} 
		else if (!taskName.equals(other.taskName))
			return false;
		if (taskType == null) 
		{
			if (other.taskType != null)
				return false;
		} 
		else if (!taskType.equals(other.taskType))
			return false;
		if (timeStamp != other.timeStamp)
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "ToDoTask [id=" + id + ", taskId=" + taskId + ", taskName=" + taskName + ", timeStamp=" + timeStamp
				+ ", taskType=" + taskType + "]";
	}
}
