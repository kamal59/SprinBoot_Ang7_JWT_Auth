import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ActivityService {

private host: string= 'http://localhost:8888';
  constructor(
  		jwtService : AuthenticationService,
  		private http: HttpClient 
	) { }
	
	getActivities(){
				if(jwtService.jwtToken == null) jwtService.loadToken();
				return this.http.get(this.host+'/tasks', {headers : new HttpHeaders({ 'Authorization': this.jwtToken})});
		}
}
