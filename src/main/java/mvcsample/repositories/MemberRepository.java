package mvcsample.repositories;

import mvcsample.domain.Member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	@Query(value="select m from Member m", countQuery="select count(m) from Member m")
	Page<Member> findMembers(Pageable pageable);
}
