import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {Activity} from './activity';
import { AuthenticationService} from '../../services/authentication-service';

@Injectable({
  providedIn: 'root'
})
export class ActivityService {
private host: string= 'http://localhost:8888/activities';
private jwtToken=null;
activity : Activity;
  constructor(
  		private http: HttpClient 
	) { }
	
	getActivities(): Observable<Activity[]>{
				this.jwtToken = localStorage.getItem('token');
				return this.http.get<Activity[]>(this.host+'/searchActivities', {headers : new HttpHeaders({ 'Authorization': this.jwtToken})});
		}

		getActivityDetails(id : string) : Observable<Activity>{
			console.log("in service");
			let params = new HttpParams();
			params = params.append('id', id);
			this.jwtToken = localStorage.getItem('token');
			return  this.http.get<Activity>(this.host+'/activityDetails', {				
				headers : new HttpHeaders({ 'Authorization': this.jwtToken}),
				params : params
			});
		}

		createActivity(pActivity : Activity){
			let params = new HttpParams();
			this.jwtToken = localStorage.getItem('token');
			return  this.http.post<Activity>(this.host+'/saveActivity', pActivity, {				
				headers : new HttpHeaders({ 'Authorization': this.jwtToken})
			});
		}
}
