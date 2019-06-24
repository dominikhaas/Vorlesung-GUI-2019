import { AppPage } from './app.po';
import {browser, by, element, logging} from 'protractor';

describe('Login Application', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
    browser.waitForAngularEnabled(true);
    page.navigateTo();
  });

  it('should not allow login initially', () => {
    let loginButton = page.getLoginButton();
    expect(loginButton.getLabel()).toEqual('Log in');

    expect(loginButton.isEnabled()).toEqual(false);
  });

  it('should only allow to login if user and password a present', async () => {


    let loginButton = await page.getLoginButton();
    expect(loginButton.isEnabled()).toEqual(false);

    page.setName("aA");
    expect(loginButton.isEnabled()).toEqual(false);

    page.setPassword("bb");
    expect(loginButton.isEnabled()).toEqual(true);

    page.clearName();
    expect(loginButton.isEnabled()).toEqual(false);

    page.setName("a");
    page.clearPassword();
    expect(loginButton.isEnabled()).toEqual(false);
  });

  it('should clear both inputs if the user clicks on the reset button', () => {
    page.setName("name");
    page.setPassword("pass");
    expect(page.getName()).toEqual('name');

    page.getResetButton().click();

    expect(page.getName()).toEqual('');
    expect(page.getPassword()).toEqual('');

  });


  it('should provide a warning on invalid passwords', () => {
    expect(page.getAlertArea().isVisible()).toBeFalsy();
    page.setName("name");
    page.setPassword("p");
    page.getLoginButton().click();


    expect(page.getAlertArea().isVisible()).toBeTruthy();
    expect(page.getAlertArea().getText()).toEqual('Ungültiges Kennwort!');
  });


  it('should remove the warning on valid passwords', () => {
    page.setName("name");
    page.setPassword("p");
    page.getLoginButton().click();
    expect(page.getAlertArea().isVisible()).toBeTruthy();


    page.setPassword("12345678");
    page.getLoginButton().click();

    expect(page.getAlertArea().isVisible()).toBeFalsy();
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
