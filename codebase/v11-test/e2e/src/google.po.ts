import {browser, by, element, ElementFinder, protractor} from 'protractor';

export class GooglePo {
  private queryField = element(by.name('q'));


  navigateTo() {
    return browser.get('http://www.google.de') as Promise<any>;
  }

  getSearchButton() {
    return new Button(element.all(by.name('btnK')).get(1));
  }

  public setSearchText(query: string): void {
    this.queryField.sendKeys(query);
  }

  removeSearchSuggestions() {
    this.queryField.sendKeys(protractor.Key.ESCAPE);
  }

  public getSearchResults() {
    let searchResulElements = element.all(by.css('.r'));

    //we have to use reduce instead of map
    return searchResulElements.reduce(
      (array, element) => {
        return array.concat(new SearchResult(element));
      }, []) as Promise<SearchResult[]>;
  }


}

export class SearchResult {

  public constructor(private searchResultelement:ElementFinder) {

  }

  public click(): void {
    this.searchResultelement.click();
  }

  public getHeadlineText(): Promise<string> {
    return this.searchResultelement.element(by.tagName('h3')).getText() as Promise<string>;
  }

}

export class Button {
  public constructor(private buttonElement:ElementFinder) {

  }

  public click(): void {
    this.buttonElement.click();
  }

  public getLabel(): Promise<string> {
    return this.buttonElement.getAttribute('value') as Promise<string>;
  }
}
