import {HeaderModel} from "./HeaderModel";
import {HeaderComponent} from "./header.component";

describe('HeaderModel', () => {
  let component:HeaderComponent;

  beforeEach(() => {
    component = new HeaderComponent();
  });

  it('should inform subscribers', () => {
    spyOn(component.onGenerateGraph, 'emit');
    component.model.series = 'test';

    component.onGenerateGraphClicked();

    expect(component.onGenerateGraph.emit).toHaveBeenCalled();
    expect(component.onGenerateGraph.emit).toHaveBeenCalledWith(component.model);
  });

  it('should inform subscribers - second way', (done) => {
    component.model.series = 'test2';
    component.onGenerateGraph.subscribe(value => {
      expect(value).toEqual(component.model);

      done();
    });

    component.onGenerateGraphClicked();

  });
});
