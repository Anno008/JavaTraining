class Student {
    constructor(name, surname) {
        this.name = name;
        this.surname = surname;
        this.exams = [];
        this.average = 0;
    }

    addExam(exam) {
        this.exams.push(exam);
        this.updateAverage();
    }

    deleteExam(examIndex) {
        this.exams.splice(examIndex, 1);
        this.updateAverage();
    }

    updateAverage(){
        let grade = 0;
        this.exams.forEach((exam) => grade += exam.grade);
        this.average = grade / this.exams.length;
    }

    toString() {
        return `Student: ${this.name} ${this.surname}, with an average grade of: ${this.average}`;
    }

}