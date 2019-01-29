import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {Activity} from './activity';
import { AuthenticationService} from '../../services/authentication-service';

@Injectable({
  providedIn: 'root'
})
export class ActivityService {
private host: string= 'http://localhost:8888/activities';
private jwtToken=null;
  constructor(
  		private jwtService : AuthenticationService,
  		private http: HttpClient 
	) { }
	
	getActivities(): Observable<Activity[]>{
				this.jwtToken = localStorage.getItem('token');
				return this.http.get<Activity[]>(this.host+'/searchActivities', {headers : new HttpHeaders({ 'Authorization': this.jwtToken})});
		}
}
