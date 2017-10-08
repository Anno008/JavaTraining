package springDataJpa.repository;

import javax.security.auth.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
