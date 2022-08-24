import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {OwnersComponent} from './owners/owners.component';
import {OwnerDetailsComponent} from './owners/owner-details/owner-details.component';

const routes: Routes = [
  { path: '', component: OwnersComponent, pathMatch: 'full'},
  { path: 'owner/:id', component: OwnerDetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
