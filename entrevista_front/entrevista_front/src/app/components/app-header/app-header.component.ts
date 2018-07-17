import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './app-header.component.html'
})
export class AppHeaderComponent { 
  nombres=null;
  constructor(){
    
    this.nombres=localStorage.getItem("nombres")?localStorage.getItem("nombres"):""
  }
}
