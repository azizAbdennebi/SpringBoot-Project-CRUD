import { project } from './../models/project';
import { Component, OnInit } from '@angular/core';
import { ProjectServiceService } from '../services/project-service.service';
// import { async } from '@angular/core/testing';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  data: project[] | undefined;
  constructor(private service: ProjectServiceService) {}

  ngOnInit(): void {
    this.service.getProjects().subscribe(async (response: project[]) => {
      if (response != null) {
        this.data = response;
        console.log(this.data);
      } else {
        console.error('response NULL');
      }
    });
  }
}
