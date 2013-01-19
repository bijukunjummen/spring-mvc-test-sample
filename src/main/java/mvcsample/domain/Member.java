package mvcsample.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import mvcsample.annot.Audited;
import mvcsample.annot.Versioned;


@Entity
@Table(name="members")
@Access(AccessType.FIELD)
@Versioned
@Audited
public class Member extends BaseDomain{
	
	public Member(){}
	
	public Member(String first, String last){
		this.first = first;
		this.last = last;
	}
	
	private String first;
	
	@Size(min=1)
	private String last;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="member")
	private List<Address> addresses = new ArrayList<>();
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Member [ first=" + first + ", last=" + last
				+ ", addresses=" + addresses  + "]";
	}

	
}