
export class Task {
   taskId: number;
   taskName: string;
   timeStamp: number;
   taskType: string; // C = Completed ,N=New , P= Pending

  constructor(idN: number, nameN: string,  timeN: number, taskType: string) {
        this.taskId = idN;
        this.taskName = nameN;
        this.timeStamp = timeN;
        this.taskType = taskType;
  }


}
