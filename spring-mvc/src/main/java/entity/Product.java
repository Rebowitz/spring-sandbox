package entity;

import org.apache.solr.client.solrj.beans.Field;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Product")
public class Product extends AbstractEntity {

	private static final long serialVersionUID = 1L;

    @Field
    @NotNull
    @NotEmpty
    private String name;

    @Field
    private String description;

    @NotNull
    @Field
    @Enumerated(EnumType.STRING)
    private Color color;

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (getId() ^ (getId() >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (getId() != other.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [id=" + getId() + ", name=" + name + ", description=" + description + "]";
    }

}
