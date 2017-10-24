class Subject {
    constructor(name, espb) {
        this.name = name;
        this.espb = espb;
    }

    toString() {
        return `Subject: ${this.name} carries: ${this.espb} espb points`;
    }
}