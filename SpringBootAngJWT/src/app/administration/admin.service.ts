import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService  {
  private host: string= 'http://localhost:8888/';
  private jwtToken=null;
  private users : User[];
  constructor(
    private http: HttpClient
  ) { }

  getUsers(): Observable<User[]>{
    this.jwtToken = localStorage.getItem('token');
    return this.http.get<User[]>(this.host+'getUsersList', {headers : new HttpHeaders({ 'Authorization': this.jwtToken})});
  }
}
