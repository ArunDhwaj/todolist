package igt.todolist.igttodolist.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import igt.todolist.igttodolist.model.ToDoTask;

public interface MyTaskRepo extends CrudRepository<ToDoTask, Long>
{
	ToDoTask findByTaskId(int taskId);
	
	@Modifying
    @Query("delete from ToDoTask where Task_id = ?1")
    void delete(Long entityId);
}
