import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateActivityComponent } from './create-activity/create-activity.component';
import { ActivityListComponent } from './activity-list/activity-list.component';
import { ActivityDetailsComponent } from './activity-details/activity-details.component';

const activityRoutes: Routes = [
{path:'activities', component : ActivityListComponent},
{path:'viewActivityDetails/:id', component : ActivityDetailsComponent},
{path:'createActivity', component : CreateActivityComponent}
	];

@NgModule({
  imports: [RouterModule.forChild(activityRoutes)],
  exports: [RouterModule]
})
export class ActivityRoutingModule { }
