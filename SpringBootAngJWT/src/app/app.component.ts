import { Component, OnInit } from '@angular/core';
import { AuthenticationService} from '../services/authentication-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  title = 'SpringBootAngJWT';
  connectedUser : string;
  constructor (
    private authService : AuthenticationService, 
    private router:Router
  ){}
  
  ngOnInit(): void {
    this.connectedUser = this.authService.getConnectedUser();
  }
	onLogout(){
			this.authService.logout();
			this.router.navigateByUrl('/login');
	}
}
