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
import { ActivityComponent } from './activity/activity.component';
import { ActivityDetailsComponent } from './activity-details/activity-details.component';
import { ActivityListComponent } from './activity-list/activity-list.component';
import { CreateActivityComponent } from './create-activity/create-activity.component';


 
@NgModule({
  declarations: [ 
    AppComponent,
    LoginComponent,
    TasksComponent,
    NewTaskComponent, 
    RegistrationComponent, ActivityComponent, ActivityDetailsComponent, ActivityListComponent, CreateActivityComponent
  ],
  imports: [    
    BrowserModule,
    AppRoutingModule,           
	FormsModule,                                
    HttpClientModule 
  ],     
  providers: [],    
  bootstrap: [AppComponent]             
})
export class AppModule { }      
