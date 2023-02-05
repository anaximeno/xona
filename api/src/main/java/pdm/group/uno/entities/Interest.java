package pdm.group.uno.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import pdm.group.uno.helpers.UpdatableEntity;

import javax.persistence.Column;

@Entity
@Table(name = "interests")
public class Interest extends PanacheEntity implements UpdatableEntity<Interest> {
    @Column(length = 100)
    protected String title;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        if (id != null) {
            this.id = id;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void update(Interest entity) {
        setTitle(entity.title);
        persist();
    }
}
