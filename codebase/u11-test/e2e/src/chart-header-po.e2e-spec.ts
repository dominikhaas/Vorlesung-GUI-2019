import {browser, by, element, logging} from "protractor";
import {ChartHeaderPo} from "./ChartHeaderPo";

describe('Chart Header', () => {

  let chartHeader: ChartHeaderPo;


  beforeEach(() => {
    chartHeader = new ChartHeaderPo();
    chartHeader.navigateTo();
  });

  it('', () => {
    chartHeader.setSeriesInput('series test');
    chartHeader.setFromInput( '02022000');

    chartHeader.generateGraph();

    expect(chartHeader.getAlertText()).toEqual('AppComponent: {"series":"series test","from":"2000-02-02"}');
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
