export class Record {
    public title: string;
    public imageUrl: string;
    public styles: string[];
    public author: string;
    public price: number;

    constructor(recordCfg: Record) {
        this.title = recordCfg.title;
        this.imageUrl = recordCfg.imageUrl;
        this.styles = recordCfg.styles;
        this.author = recordCfg.author;
        this.price = recordCfg.price;
    }
}
