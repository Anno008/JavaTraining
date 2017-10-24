class StudentsOffice {
    constructor() {
        this.students = [];
        this.subjects = [];
        this.exams = [];
    }

    addStuednt(student) {
        this.students.push(student);
    }

    addSubject(subject) {
        this.subjects.push(subject);
    }

    takeAnExam(studentIndex, exam) {
        const student = this.students[studentIndex];
        if (student === undefined) {
            console.log(`Student with the provided index of: ${studentIndex} doesn't exist`);
            return;
        }
        student.addExam(exam);
    }

    invalidateAnExam(studentIndex, examIndex) {
        const student = this.students[studentIndex];
        if (student === undefined) {
            console.log(`Student with the provided index of: ${studentIndex} doesn't exist`);
            return;
        }
        if (student.exams.length > 0) {
            student.exams.splice(examIndex, 1);
        }
    }

    getStudentsInfo() {
        return this.students.map(s => `${s}`);
    }

    getStudentInfoByAverageGrade() {
        return this.students.sort((s1, s2) => s1.average > s2.average);
    }

    getStudentsByHigherThanAvgGrade(grade) {
        return this.students.filter(s => s.average > grade);
    }
}