
export class TaskModel {
   // id: number;
  taskName: string;
   timeStamp: number;
   taskType: string; // C = Completed ,N=New , P= Pending

  constructor( nameN: string,  timeN: number, taskType: string) {
        this.taskName = nameN;
        this.timeStamp = timeN;
        this.taskType = taskType;
  }


}
