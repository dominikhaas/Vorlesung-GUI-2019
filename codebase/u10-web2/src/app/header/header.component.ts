import {Component, EventEmitter, Output} from '@angular/core';
import {HeaderModel} from "./HeaderModel";


@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {


  private model: HeaderModel = new HeaderModel();

  @Output()
  private onGenerateGraph = new EventEmitter<HeaderModel>();

  public onGenerateGraphClicked(): void {
    this.onGenerateGraph.emit(this.model);
  }
}


