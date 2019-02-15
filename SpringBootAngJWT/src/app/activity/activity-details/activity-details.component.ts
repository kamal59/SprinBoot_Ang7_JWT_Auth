import { Component, OnInit } from '@angular/core';
import { switchMap } from 'rxjs/operators';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {ActivityService} from '../activity.service';
import { Activity } from '../activity';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-activity-details',
  templateUrl: './activity-details.component.html',
  styleUrls: ['./activity-details.component.css']
})
export class ActivityDetailsComponent implements OnInit {
  activity: Activity;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: ActivityService
  ) { }

  ngOnInit() {
      let id = this.route.snapshot.paramMap.get('id');
      this.service.getActivityDetails(id)  
     .subscribe(data=>{
         this.activity = data;
     },
         err=>{
         this.router.navigateByUrl('/login');
       }
     )
  }

}
