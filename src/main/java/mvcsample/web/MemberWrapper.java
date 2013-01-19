package mvcsample.web;

import java.util.List;

import mvcsample.domain.Member;

public class MemberWrapper {
	private List<Member> members;

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
}
