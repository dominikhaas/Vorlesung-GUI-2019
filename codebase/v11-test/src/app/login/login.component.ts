import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {LoginModel} from "./LoginModel";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  @Output()
  public onLogin: EventEmitter<void> = new EventEmitter();

  public model: LoginModel = new LoginModel();


  login(): void {
    if(this.model.testPassword()) {
      //do real login
      this.onLogin.emit();
    }
  }

  reset() {
    this.model.resetData();
  }
}
