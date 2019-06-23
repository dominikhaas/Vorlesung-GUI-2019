import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <div>
      <login (onLogin)="onLogin()"></login>
      <div class="status">
        Logged in for {{_times}} times.
      </div>
    </div>
    
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public _times: number = 0;

  onLogin() {
    this._times++;
  }
}
