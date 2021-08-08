package ir.maktab56.ToDo.base.domain;

public class BaseEntity<ID> {

    private ID id;
    private Boolean isDeleted;
    
    public BaseEntity(ID id) {
		this.setId(id);
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
