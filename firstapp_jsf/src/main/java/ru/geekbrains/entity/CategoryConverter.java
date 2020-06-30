/**
 * @author Ostrovskiy Dmitriy
 * @created 24.06.2020
 * CategoryConverter
 * @version v1.0
 */

package ru.geekbrains.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@ManagedBean(name = "categoryConverterBean")
@FacesConverter(value = "categoryConverter")
public class CategoryConverter implements Converter {

    @PersistenceContext(unitName = "ds")
    // I include this because you will need to
    // lookup  your entities based on submitted values
    private transient EntityManager em;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return em.find(Category.class, new Long(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Category) value).getId().toString();
    }
}
