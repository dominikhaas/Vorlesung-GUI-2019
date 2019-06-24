import { Component } from '@angular/core';
import {HeaderModel} from "./header/HeaderModel";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  private _counter: number = 0;

  public onGenerateGraphEvent(model: HeaderModel) {
    alert("AppComponent: " + model);
    this._counter++;
  }
}

