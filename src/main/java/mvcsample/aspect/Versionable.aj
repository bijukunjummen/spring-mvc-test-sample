package mvcsample.aspect;

import javax.persistence.Column;
import javax.persistence.Version;
import mvcsample.annot.Versioned;

public interface Versionable {
	
	static aspect VersionableAspect {
		declare parents: @Versioned  mvcsample.domain.* implements Versionable;
		
		@Version
	    @Column(name = "version")
	    private Integer Versionable.version;	
		
		public Integer Versionable.getVersion() {
			return this.version;
		}
		
		public void Versionable.setVersion(Integer version) { 
			this.version = version;
		}
	
	}
}
