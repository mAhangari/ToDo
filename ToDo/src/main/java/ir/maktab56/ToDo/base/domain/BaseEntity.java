package ir.maktab56.ToDo.base.domain;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity<ID> {
	
	@Id
	@GeneratedValue
    private ID id;
	@Column(name = "is-deleted", columnDefinition = "TINYINT(1)")
    private Boolean isDeleted;
    
    public BaseEntity(ID id, Boolean isDeleted) {
		this.setId(id);
		this.setDeleted(isDeleted);
	}

	public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
