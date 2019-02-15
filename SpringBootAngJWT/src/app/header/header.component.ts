import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/services/authentication-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  connectedUser : string = "Sign In";
  isConnected : boolean;
  constructor(
    private authService : AuthenticationService,
    private router:Router
  ) { }

  ngOnInit() {
    this.authService.getLoggedInName.subscribe(name => this.changeName(name));
  }

  private changeName(name: string): void {
    this.connectedUser = name;
    this.isConnected = name ==="Sign In"? false : true;
    console.log(this.isConnected);
  }

  onLogout(){
    this.authService.logout();
    this.router.navigateByUrl('/login');
  }
}
