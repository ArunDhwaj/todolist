import { Injectable } from '@angular/core';
import {Task} from '../task';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const headers = new HttpHeaders({'Content-Type': 'application/json'});
headers.append('Content-Type', 'application/json');


@Injectable()
export class AppService {
  private baseURL = 'http://localhost:9090';

  constructor(private http: HttpClient) { }

  addTask(taskModel: Task) {
    console.log('Service MSG ####--' + JSON.stringify(taskModel));
    this.http.post(this.baseURL + '/saveToDoTask', taskModel, {
      headers: headers
    })
      .subscribe(data => {
        console.log(JSON.stringify(data))
      }, error => {
        console.log(JSON.stringify(error));
      });
  }

  updateTask(taskModel: Task) {

    this.http.put(this.baseURL + '/updateToDoTask', taskModel, { headers: headers}).subscribe(data => {
      console.log(JSON.stringify(data))
    }, error => {
      console.log(JSON.stringify(error));
    });
  }
  deleteTask(taskId: number) {
    this.http.delete(this.baseURL + '/deleteToDoTask/' + taskId, { headers: headers}).subscribe(data => {
      console.log(JSON.stringify(data))
    }, error => {
      console.log(JSON.stringify(error));
    });

  }
}
