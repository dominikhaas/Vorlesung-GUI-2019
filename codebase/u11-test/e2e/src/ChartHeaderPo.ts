import {browser, by, element, ElementFinder, Key} from "protractor";

export class ChartHeaderPo {
  private seriesInput = element(by.id('series-input'));
  private fromInput = element(by.id('from-input'));
  private generateGraphButton = element(by.id('generate-graph'));

  public navigateTo(): void {
    browser.get(browser.baseUrl);
  }

  public setSeriesInput(value: string): void {
    this.setValue(this.seriesInput, value);
  }

  public setFromInput(value: string): void {
    this.setValue(this.fromInput, value);
  }

  public generateGraph(): void {
    this.generateGraphButton.click();
  }

  public getAlertText(): Promise<string> {
    let alert = browser.switchTo().alert();
    let text = alert.getText();
    alert.accept();
    return text as Promise<string>;
  }

  public acceptAlert() {
    return browser.switchTo().alert().accept();
  }

  private  setValue(inputElement: ElementFinder, value: string) {
    this.clearInput(inputElement);
    inputElement.sendKeys(value);
  }

  private clearInput(inputElement): void {
    inputElement.clear();
    inputElement.sendKeys('a');
    inputElement.sendKeys(Key.BACK_SPACE);
  }
}
