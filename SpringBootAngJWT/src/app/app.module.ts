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
import {ActivityModule} from './activity/activity.module'

 
@NgModule({
  declarations: [ 
    AppComponent,
    LoginComponent,
    TasksComponent,
    NewTaskComponent, 
    RegistrationComponent
  ],
  imports: [    
    BrowserModule,
    AppRoutingModule,           
	FormsModule,                                
    HttpClientModule,
	ActivityModule
  ],     
  providers: [AuthenticationService],    
  bootstrap: [AppComponent],
              
})
export class AppModule { }      
