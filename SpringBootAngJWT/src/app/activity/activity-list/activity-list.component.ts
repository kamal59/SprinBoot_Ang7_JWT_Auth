import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import {Activity} from '../activity';
import{ActivityService} from '../activity.service';

@Component({
  selector: 'app-activity-list',
  templateUrl: './activity-list.component.html',
  styleUrls: ['./activity-list.component.css']
})
export class ActivityListComponent implements OnInit {
 activities : Activity[];
  constructor(
		private service: ActivityService,
		private router:Router
  ) { }

  ngOnInit() {		
		this.service.getActivities()
		  .subscribe(data=>{
		  		this.activities = data;
		  },
		  		err=>{
					this.router.navigateByUrl('/login');
				}
		  )
	}

}
