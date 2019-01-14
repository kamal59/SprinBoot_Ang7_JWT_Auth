import { Component, OnInit } from '@angular/core';
import { AuthenticationService} from '../../services/authentication-service';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {
task;
mode: number=1;
  constructor(private  authService : AuthenticationService) { }

  ngOnInit() {
  }
  
  onSaveTask(task){
  		this.authService.saveTask(task)
			.subscribe(resp=>{
				this.task=resp;
			},err=>{
				this.mode=0;
			})
  }

}
