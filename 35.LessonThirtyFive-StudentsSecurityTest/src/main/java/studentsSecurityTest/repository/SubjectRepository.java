package studentsSecurityTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentsSecurityTest.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
