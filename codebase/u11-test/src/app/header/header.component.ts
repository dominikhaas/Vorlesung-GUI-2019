import {Component, EventEmitter, Output} from '@angular/core';
import {HeaderModel} from "./HeaderModel";


@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {


  public model: HeaderModel = new HeaderModel();

  @Output()
  public onGenerateGraph = new EventEmitter<HeaderModel>();

  public onGenerateGraphClicked(): void {
    this.onGenerateGraph.emit(this.model);
  }
}


