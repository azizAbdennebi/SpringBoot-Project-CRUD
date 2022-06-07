import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { project } from '../models/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectServiceService {

  constructor(private http:HttpClient) { }

  getProjects():Observable<project[]>{
    return(this.http.get<project[]>("http://localhost:8090/projectApi/getProjects"));
  }
}
