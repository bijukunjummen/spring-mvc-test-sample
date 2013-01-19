package mvcsample.aspect;

import java.util.Date;
import javax.persistence.Column;

import mvcsample.annot.Audited;
public interface Auditable {
	static aspect AuditableAspect {
		declare parents: @Audited mvcsample.domain.* implements Auditable ;
		
		@Column(name="created_at")
		private Date Auditable.createdAt;
		
		@Column(name="updated_at")
		private Date Auditable.updatedAt;
		
		public Date Auditable.getCreatedAt(){
			return this.createdAt;
		}
		
		public void Auditable.setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		
		public Date Auditable.getUpdatedAt(){
			return this.updatedAt;
		}
		
		public void Auditable.setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
	}
}
