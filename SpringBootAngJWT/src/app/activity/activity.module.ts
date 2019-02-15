import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ActivityRoutingModule } from './activity-routing.module';
import { CreateActivityComponent } from './create-activity/create-activity.component';
import { ActivityListComponent } from './activity-list/activity-list.component';
import { ActivityDetailsComponent } from './activity-details/activity-details.component';
import { AuthenticationService} from '../../services/authentication-service';
import { UpdateActivityComponent } from './update-activity/update-activity.component';
@NgModule({
  declarations: [CreateActivityComponent, ActivityListComponent, ActivityDetailsComponent, UpdateActivityComponent],
  imports: [
    CommonModule,
	FormsModule,
    ActivityRoutingModule
  ]
})
export class ActivityModule { }
