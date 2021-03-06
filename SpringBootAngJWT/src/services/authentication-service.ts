import {Injectable, Output, EventEmitter} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';


		
@Injectable()
export class AuthenticationService{

	private host: string= 'http://localhost:8888';
	private jwtToken=null;
	private roles:Array<any>;
	private connectedUser : string;
	@Output() getLoggedInName: EventEmitter<any> = new EventEmitter();
		
	constructor(
		private http: HttpClient 
	){	}


	saveToken(jwt:string){
		this.jwtToken = jwt;
		localStorage.setItem('token', jwt);
		let jwtHelper = new JwtHelperService();
		this.roles = jwtHelper.decodeToken(this.jwtToken).roles; 
		this.connectedUser = jwtHelper.decodeToken(this.jwtToken).sub;
		this.getLoggedInName.emit(this.connectedUser);
	}
	
	loadToken(){
		this.jwtToken=localStorage.getItem('token');
	}

	login(user){
		return this.http.post(this.host+'/login', user,{observe: 'response'}); 
	} 

	logout(){
		this.jwtToken = null;
		localStorage.removeItem('token');
		this.getLoggedInName.emit('Sign In');
	}

	getTasks(){
			if(this.jwtToken == null) this.loadToken();
			return this.http.get(this.host+'/tasks', {headers : new HttpHeaders({ 'Authorization': this.jwtToken})});
	}
	
	isAdmin(){
			for(let r of this.roles){
				
				if(r.authority=='ADMIN') 
					return true;
			}
			return false;
		
	}
	
	saveTask(task){
		return this.http.post(this.host+'/tasks', task, {headers : new HttpHeaders({ 'authorization': this.jwtToken})});
			
	}

	registerUser(user){
		return this.http.post(this.host+'/register', user,{observe: 'response'}); 
	}
}