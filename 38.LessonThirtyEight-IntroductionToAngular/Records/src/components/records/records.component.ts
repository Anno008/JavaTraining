import { Component } from '@angular/core';
import { Record } from '../../models/Record';

@Component({
  selector: 'app-records-component',
  templateUrl: './records.component.html',
  styleUrls: ['./records.component.css']
})
export class AppRecordsComponent {
  records: Record[] = [];
  constructor() {
    const r1 = new Record(
      {
        author: 'Tom',
        imageUrl: 'http://piq.codeus.net/static/media/userpics/piq_32996_400x400.png',
        price: 55,
        title: 'Zelda',
        styles: []
      });
    const r2 = new Record(
      {
        author: 'Bob',
        imageUrl: 'http://piq.codeus.net/static/media/userpics/piq_32996_400x400.png',
        price: 55,
        title: 'Bobby',
        styles: []
      });
    const r3 = new Record(
      {
        author: 'Tom',
        imageUrl: 'http://www.artemiss-contemporary.com/wp-content/gallery/thierry-bisch/lapin-rose.jpg',
        price: 55,
        title: 'Tommy',
        styles: []
      });

    this.records.push(r1);
    this.records.push(r2);
    this.records.push(r3);
  }
}
