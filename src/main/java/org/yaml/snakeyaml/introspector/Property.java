package org.yaml.snakeyaml.introspector;

import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Property implements Comparable<Property> {
    private final String name;
    private final Class<?> type;

    public abstract Object get(Object obj);

    public abstract Class<?>[] getActualTypeArguments();

    public abstract <A extends Annotation> A getAnnotation(Class<A> cls);

    public abstract List<Annotation> getAnnotations();

    public boolean isReadable() {
        return true;
    }

    public boolean isWritable() {
        return true;
    }

    public abstract void set(Object obj, Object obj2) throws Exception;

    public Property(String str, Class<?> cls) {
        this.name = str;
        this.type = cls;
    }

    public Class<?> getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return getName() + " of " + getType();
    }

    @Override // java.lang.Comparable
    public int compareTo(Property property) {
        return getName().compareTo(property.getName());
    }

    public int hashCode() {
        return getName().hashCode() + getType().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Property) {
            Property property = (Property) obj;
            if (getName().equals(property.getName()) && getType().equals(property.getType())) {
                return true;
            }
        }
        return false;
    }
}
