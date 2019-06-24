import {HeaderModel} from "./HeaderModel";

describe('HeaderModel', () => {
  let headerModel: HeaderModel;

  beforeEach(() => {
    headerModel = new HeaderModel();
  });

  it('should have a json stringify method', () => {
    headerModel.series = 'series';
    headerModel.from = new Date(2019, 5, 19, 12, 30, 0, 0);

    expect(headerModel.toString()).toEqual('{"series":"series","from":"2019-06-19T10:30:00.000Z"}');
  });

});
