import {LoginModel} from "./LoginModel";

describe('LoginModel', () => {
  let model: LoginModel;
  beforeEach(() => {
    model = new LoginModel();
  });

  it('should create', () => {
    expect(model).toBeTruthy();
  });

  it('should clear all fields on reset', () => {
    model.user = 'user';
    model.password = 'password';

    model.resetData();

    expect(model.user).toBeNull();
    expect(model.password).toBeNull();
  })
});
