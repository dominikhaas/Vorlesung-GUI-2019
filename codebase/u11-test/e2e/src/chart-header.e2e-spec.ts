import {browser, by, element, logging} from "protractor";
import {ChartHeaderPo} from "./ChartHeaderPo";

describe('Chart Header', () => {


  beforeEach(() => {
    browser.get(browser.baseUrl);
  });

  it('', () => {
    element(by.id('series-input')).sendKeys('series test');
    element(by.id('from-input')).sendKeys('02022019');
    browser.sleep(2000);

    element(by.id('generate-graph')).click();

    let alert = browser.switchTo().alert();

    expect(alert.getText()).toEqual('AppComponent: {"series":"series test","from":"2019-02-02"}');
    alert.accept();

    browser.sleep(2000);
    element(by.id('generate-graph')).click();
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
