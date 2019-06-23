import {browser, by, element, protractor} from "protractor";
import {GooglePo} from "./google.po";

describe('Google Search Page Test Simple', () => {

  function sleep() {
    return browser.sleep(1);
  }

  beforeEach(() => {
    browser.waitForAngularEnabled(false);
  });

  it('should find wikipedia as second entry on a search for "hello world"', async () => {
    browser.get("http://google.de");

    let queryField = element(by.name('q'));
    let button = element.all(by.name('btnK')).get(1);

    sleep();
    queryField.sendKeys("hello world");

    browser.sleep(500);
    queryField.sendKeys(protractor.Key.ESCAPE);

    browser.sleep(500);
    let text = button.getAttribute('value');
    expect(text).toEqual('Google-Suche');

    sleep();
    button.click();

    let searchResultElement = element.all(by.css('.r')).get(1);
    let searchResultHeadline = searchResultElement.element(by.tagName('h3'));

    expect(searchResultHeadline.getText()).toEqual('Hallo-Welt-Programm – Wikipedia');

    sleep();
    searchResultHeadline.click();


    expect(browser.getCurrentUrl()).toEqual('https://de.wikipedia.org/wiki/Hallo-Welt-Programm');
    expect(browser.getTitle()).toEqual('Hallo-Welt-Programm – Wikipedia');
    sleep();
  })

});
