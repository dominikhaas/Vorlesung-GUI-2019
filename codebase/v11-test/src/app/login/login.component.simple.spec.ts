import {LoginComponent} from './login.component';

describe('LoginComponent simple', () => {
  let component: LoginComponent;
  let modelSpy: any;

  beforeEach(() => {
    component = new LoginComponent();
  });



  it('should reset the model in the reset method', () => {
    let spy: any = spyOn(component.model, 'resetData');

    component.reset();

    expect(spy).toHaveBeenCalled();
  });
});
