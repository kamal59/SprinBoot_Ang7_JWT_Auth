import { Component, OnInit } from '@angular/core';
import { Activity } from '../activity';
import { ActivityService } from '../activity.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-activity',
  templateUrl: './create-activity.component.html',
  styleUrls: ['./create-activity.component.css']
})
export class CreateActivityComponent implements OnInit {
  activity : Activity;
  constructor(
    private router: Router,
    private service: ActivityService
  ) {}

  ngOnInit() {
  }

  onSaveActivity(pActivity : Activity){
    this.service.createActivity(pActivity)  
    .subscribe(data=>{
        this.activity = data;
        this.router.navigate(['activities']);
    },
        err=>{
        this.router.navigateByUrl('/login');
      }
    )
  }
}
