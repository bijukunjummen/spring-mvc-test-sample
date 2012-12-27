package mvcsample.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import mvcsample.domain.Member;

@Repository
public class JpaMemberDao extends JpaDao<Long, Member> implements MemberDao{

	public JpaMemberDao(){
		super(Member.class);
	}
	@Override
	public List<Member> findAll(int firstResult, int maxResults) {
		TypedQuery<Member> query = this.entityManager.createQuery("select m from Member m", Member.class);
		return query.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	@Override
	public Long countMembers() {
		TypedQuery<Long> query = this.entityManager.createQuery("select count(m) from Member m", Long.class);
		return query.getSingleResult();
	}
}
