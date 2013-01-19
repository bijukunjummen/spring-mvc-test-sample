package mvcsample.aspect;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface Identifiable{

	static aspect IdentifiableAspect {
		declare parents: mvcsample.domain.* implements Identifiable;
	
    	@Id
    	@GeneratedValue(strategy = GenerationType.AUTO)
    	@Column(name = "id")	
    	private Long Identifiable.id;
    	
        public Long Identifiable.getId() {
    		return id;
    	}

    	public void Identifiable.setId(Long id) {
    		this.id = id;
    	}
	}

}