import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/services/authentication-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  mode: number=0;
  
  constructor(
    private authService : AuthenticationService, 
		private router:Router 
  ) { }

  ngOnInit() {
  }

  onRegister(user){
    this.authService.registerUser(user)
			.subscribe(resp=>{
					let jwt = resp.headers.get('Authorization');
				this.authService.saveToken(jwt);
				this.router.navigateByUrl('/tasks');
			},
				err=>{
					this.mode=1;
				}
			)
  }

}
