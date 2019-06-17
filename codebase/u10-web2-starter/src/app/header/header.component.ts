import { Component } from '@angular/core';
import {HeaderModel} from "./HeaderModel";


@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  public model = new HeaderModel();

  generateGraph() {
    alert(this.model);
  }
}

