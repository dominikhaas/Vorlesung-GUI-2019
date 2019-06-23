export class LoginModel {
  public user: string;
  public password: string;
  public isValidPassword: boolean = true;

  public resetData(): void {
    this.user =  null;
    this.password = null;
    this.isValidPassword = true;
  }

  public testPassword(): boolean {
    this.isValidPassword = this.checkIsValidPassword();
    return this.isValidPassword;
  }


  private checkIsValidPassword() {
    return this.password && this.password.length >= 8;
  }

  get isLoginDisabled():boolean {
    return !this.password || !this.user ||
      this.password.length == 0 || this.user.length == 0;
  }
}
