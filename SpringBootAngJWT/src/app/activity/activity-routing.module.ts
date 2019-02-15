import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateActivityComponent } from './create-activity/create-activity.component';
import { ActivityListComponent } from './activity-list/activity-list.component';
import { ActivityDetailsComponent } from './activity-details/activity-details.component';
import { UpdateActivityComponent } from './update-activity/update-activity.component';

const activityRoutes: Routes = [
{path:'activities', component : ActivityListComponent},
{path:'activities/viewActivityDetails/:id', component : ActivityDetailsComponent},
{path:'activities/createActivity', component : CreateActivityComponent},
{path:'activities/updateActivity', component : UpdateActivityComponent}

	];

@NgModule({
  imports: [RouterModule.forChild(activityRoutes)],
  exports: [RouterModule]
})
export class ActivityRoutingModule { }
