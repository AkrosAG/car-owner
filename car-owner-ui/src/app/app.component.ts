import { Component } from '@angular/core';
import { BreadcrumbItem } from './breadcrumbs/breadcrumbs.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'car-owner-ui';
  
  testBreadcrumbs: Array<BreadcrumbItem> = [
    { displayName: 'Home', url: '/', active: true},
    { displayName: 'Category 1', url: '/category-1', active: true},
    { displayName: 'Category 1-1', url: '/category-1-1', active: false},
  ]
}
