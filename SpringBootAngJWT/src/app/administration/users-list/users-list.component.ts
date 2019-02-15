import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {
  users : User[];
  
  constructor(
    private router:Router,
    private adminService : AdminService
  ) { }

  ngOnInit() {
   this.adminService.getUsers()
    .subscribe(data => {
      this.users = data;
    },
    err=>{
      this.router.navigateByUrl('/login');
    });
  }

}
