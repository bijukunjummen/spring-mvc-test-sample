package mvcsample.dao;

import java.util.List;

import mvcsample.domain.Member;

public interface MemberDao extends BaseDao<Long, Member>{
    List<Member> findAll(int firstResult, int maxResults);
    Long countMembers();
}
