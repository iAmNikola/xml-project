import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PInputFormPageComponent } from './pages/p/p-input-form-page/p-input-form-page.component';

const routes: Routes = [
  { path: 'p-input', component: PInputFormPageComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
