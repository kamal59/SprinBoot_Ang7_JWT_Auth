import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // <== add the imports!
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TasksComponent } from './tasks/tasks.component';
import { NewTaskComponent } from './new-task/new-task.component';
import { RegistrationComponent } from './registration/registration.component';
import { AuthenticationService} from '../services/authentication-service';
import {ActivityModule} from './activity/activity.module';
import { HeaderComponent } from './header/header.component';
import { DashBoardComponent } from './dash-board/dash-board.component'
import { AdministrationModule } from './administration/administration.module';

 
@NgModule({
  declarations: [ 
    AppComponent,
    LoginComponent,
    TasksComponent,
    NewTaskComponent, 
    RegistrationComponent, HeaderComponent, DashBoardComponent
  ],
  imports: [    
    BrowserModule,
    AppRoutingModule,           
	  FormsModule,                                
    HttpClientModule,
    ActivityModule,
    AdministrationModule
  ],     
  providers: [AuthenticationService],    
  bootstrap: [AppComponent],
              
})
export class AppModule { }      
