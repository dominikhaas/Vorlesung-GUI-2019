import {browser, by, element, ElementFinder, Key} from 'protractor';

export class AppPage {

  private nameInput: ElementFinder = element(by.id('nameInput'));
  private passwordInput: ElementFinder = element(by.id('passwordInput'));

  private resetButton: ElementFinder = element(by.id('resetButton'));
  private loginButton: ElementFinder = element(by.id('loginButton'));

  private alertBox: ElementFinder = element(by.css('.alert'));

  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  getTitleText() {
    return element(by.css('app-root h1')).getText() as Promise<string>;
  }

  public getLoginButton() {
    return new Button(this.loginButton);
  }

  public setName(value: string) {
    this.setValueToInput(this.nameInput, value);
  }

  public getName(): Promise<string> {
    return this.nameInput.getAttribute('value') as Promise<string>;
  }

  public setPassword(value: string) {
    this.setValueToInput(this.passwordInput, value);
  }

  public getPassword(): Promise<string> {
    return this.passwordInput.getAttribute('value') as Promise<string>;
  }

  private setValueToInput(element: ElementFinder, value: string) {
    element.clear();
    element.sendKeys(value);
  }

  public async clearName(): Promise<void> {
    this.clearInput(this.nameInput);
  }

  public clearPassword(): void {
    this.clearInput(this.passwordInput);
  }

  private clearInput(inputElement): void {
    inputElement.clear();
    inputElement.sendKeys('a');
    inputElement.sendKeys(Key.BACK_SPACE);
  }

  public getResetButton(): Button {
    return new Button(this.resetButton);
  }

  public getAlertArea(): AlertArea {
    return new AlertArea(this.alertBox);
  }
}


export class Button {
  public constructor(private buttonElement:ElementFinder) {

  }

  public click(): void {
    this.buttonElement.click();
  }

  public getLabel(): Promise<string> {
    return this.buttonElement.getText() as Promise<string>;
  }

  public isEnabled(): Promise<boolean> {
    return this.buttonElement.isEnabled() as Promise<boolean>;
  }
}

export class AlertArea {
  public constructor(private warningElement:ElementFinder) {

  }

  public isVisible(): Promise<boolean> {
    return this.warningElement.isPresent() as Promise<boolean>;
  }

  public getText(): Promise<string> {
    return this.warningElement.getText() as Promise<string>;
  }
}
