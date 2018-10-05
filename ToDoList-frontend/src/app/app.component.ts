import {Component, OnInit} from '@angular/core';
import {Task} from './task';
import {AppService} from './service/app-service.service';
import {TaskServService} from './service/task-serv.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css'],
})

export class AppComponent implements OnInit {
  title = 'toDo list';
  flag = 1;
  toDoTaskCount = 1;
  completedTaskCount = 0;
  pendingTaskCount = 0;
  Tasks: Task[] = [];
  dTask: Task[] = [];
  pendingTask: Task[] = [];
  taskId = 1;

  taskText = '';
  msg: string;
  errMsg: string;
  totalTaskToComplete: number;
  completedTaskLength: number;
  pendingTaskLength: number;
  today: number;
  // alreadyAddedTask: string;
  NEW_TASK = 'N';
  PENDING_TASK = 'P';
  COMPLETED_TASK = 'C';

  constructor(private appService: AppService, private http: HttpClient) {
  }

  addTask(msg: string) {
    if (msg.length === 0) {

      this.errMsg = 'Task is not clear';
    } else if (this.duplicateTask(msg) && this.flag) {
      this.errMsg = 'Task is already in the list';
    } else {
      this.today = Date.now();
      console.log('Before toDoTaskCount::==>' + this.toDoTaskCount);

      this.Tasks.push(new Task(this.toDoTaskCount, msg, this.today, this.NEW_TASK));
      this.errMsg = '';
      this.taskText = '';
      this.totalTaskToComplete = this.Tasks.length;
      console.log('After1 toDoTaskCount::==>' + this.toDoTaskCount);

      console.log('Add TASKS array::' + JSON.stringify(this.Tasks));
    }
    console.log('After2 toDoTaskCount::==>' + this.toDoTaskCount);

    this.appService.addTask(new Task(this.toDoTaskCount, msg, this.today, this.NEW_TASK));
    this.toDoTaskCount += 1;

  }

  duplicateTask(msg: string): number {

    for (let i = 0; i < this.Tasks.length; i++) {
      if (msg === this.Tasks[i].taskName) {
        return 1;
      }
    }
    return 0;
  }

  markAsComplete(task: Task) {
    this.addDTask(task);
    this.deleteTask(task);
  }

  markAsPending(task: Task) {
    this.addPendingTask(task);
    this.deleteTask(task);
  }

  editTask(task: Task) {
    this.taskText = task.taskName;
    this.deleteTask(task);
    this.totalTaskToComplete = this.Tasks.length;
  }


  deleteTask(task: Task) {
    this.Tasks = this.Tasks.filter(Tasks => Tasks.taskId !== task.taskId);
    this.totalTaskToComplete = this.Tasks.length;
    // this.appService.deleteTask(task.taskId);

  }

  reset() {
    this.taskText = '';
  }

  dismiss() {
    this.errMsg = '';
    this.taskText = '';
  }

  addAnyWay(msg: string) {
    if (msg.length === 0) {
      msg = 'Nothing to do';
    }
    this.flag = 0;
    this.addTask(msg);
    this.taskText = '';
  }

  addDTask(task: Task) {
    this.dTask.push(new Task(task.taskId, task.taskName, Date.now(), this.COMPLETED_TASK));
    this.msg = task.taskName;
    this.completedTaskLength = this.dTask.length;
    this.appService.updateTask(new Task(task.taskId, task.taskName, Date.now(), this.COMPLETED_TASK));
  }

  deleteDTask(task: Task) {
    this.dTask = this.dTask.filter(dTask => dTask.taskId !== task.taskId);
    this.completedTaskLength = this.dTask.length;
    this.appService.deleteTask(task.taskId);

  }

  addPendingTask(task: Task) {
    this.pendingTask.push(new Task(task.taskId, task.taskName, Date.now(), this.PENDING_TASK));
    this.msg = task.taskName;
    this.pendingTaskLength = this.pendingTask.length;
    this.appService.updateTask(new Task(task.taskId, task.taskName, Date.now(), this.PENDING_TASK));

  }

  deletePendingTask(task: Task) {
    this.pendingTask = this.pendingTask.filter(pendingTask => pendingTask.taskId !== task.taskId);
    this.pendingTaskLength = this.pendingTask.length;
    this.appService.deleteTask(task.taskId);
  }

  ngOnInit() {
    /*this.addTask('Buy daily items from new-market');
    this.addTask('Registration for current semester');
    this.addDTask(new Task(this.completedTaskCount, 'this is Completed task', Date.now(), this.COMPLETED_TASK));
    this.addPendingTask(new Task(this.completedTaskCount, 'this is Pending task', Date.now(), this.PENDING_TASK));
*/
  }


}

