package mvcsample.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;


@Entity
@Table(name="members")
@Access(AccessType.FIELD)
public class Member{
	
	public Member(){}
	
	public Member(String first, String last){
		this.first = first;
		this.last = last;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")	
	private Long id;
	
	private String first;
	
	@Size(min=1)
	private String last;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="member")
	private List<Address> addresses = new ArrayList<>();
	
	@Version
    @Column(name = "version")
    private Integer version;	
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


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


	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}


	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", first=" + first + ", last=" + last
				+ ", addresses=" + addresses + ", version=" + version + "]";
	}

	
}