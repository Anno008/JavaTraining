import { RecordsPage } from './app.po';

describe('records App', function() {
  let page: RecordsPage;

  beforeEach(() => {
    page = new RecordsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
