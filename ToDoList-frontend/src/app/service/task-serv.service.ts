import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Task} from '../task';


@Injectable()
export class TaskServService {
  private baseURL = 'http://localhost:9090';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }


  create(task: Task[]): Promise<Task> {
    console.log('STEP1:INSIDE create');
   // const headers = new HttpHeaders({'Content-Type': 'text/uri-list'});
    return this.http.put(this.baseURL, JSON.stringify(task), {headers: this.headers}).toPromise()
      .then(res => console.log('####RESPONSE::' + res.toString())).catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Error', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
