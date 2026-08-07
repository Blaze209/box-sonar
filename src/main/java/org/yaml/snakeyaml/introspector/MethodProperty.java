package org.yaml.snakeyaml.introspector;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.util.ArrayUtils;

/* JADX INFO: loaded from: classes5.dex */
public class MethodProperty extends GenericProperty {
    private final PropertyDescriptor property;
    private final boolean readable;
    private final boolean writable;

    private static Type discoverGenericType(PropertyDescriptor propertyDescriptor) {
        Method readMethod = propertyDescriptor.getReadMethod();
        if (readMethod != null) {
            return readMethod.getGenericReturnType();
        }
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod == null) {
            return null;
        }
        Type[] genericParameterTypes = writeMethod.getGenericParameterTypes();
        if (genericParameterTypes.length > 0) {
            return genericParameterTypes[0];
        }
        return null;
    }

    public MethodProperty(PropertyDescriptor propertyDescriptor) {
        super(propertyDescriptor.getName(), propertyDescriptor.getPropertyType(), discoverGenericType(propertyDescriptor));
        this.property = propertyDescriptor;
        this.readable = propertyDescriptor.getReadMethod() != null;
        this.writable = propertyDescriptor.getWriteMethod() != null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public void set(Object obj, Object obj2) throws Exception {
        if (!this.writable) {
            throw new YAMLException("No writable property '" + getName() + "' on class: " + obj.getClass().getName());
        }
        this.property.getWriteMethod().invoke(obj, obj2);
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Object get(Object obj) {
        try {
            this.property.getReadMethod().setAccessible(true);
            return this.property.getReadMethod().invoke(obj, new Object[0]);
        } catch (Exception e) {
            throw new YAMLException("Unable to find getter for property '" + this.property.getName() + "' on object " + obj + ":" + e);
        }
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public List<Annotation> getAnnotations() {
        if (isReadable() && isWritable()) {
            return ArrayUtils.toUnmodifiableCompositeList(this.property.getReadMethod().getAnnotations(), this.property.getWriteMethod().getAnnotations());
        }
        if (isReadable()) {
            return ArrayUtils.toUnmodifiableList(this.property.getReadMethod().getAnnotations());
        }
        return ArrayUtils.toUnmodifiableList(this.property.getWriteMethod().getAnnotations());
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        A a = isReadable() ? (A) this.property.getReadMethod().getAnnotation(cls) : null;
        return (a == null && isWritable()) ? (A) this.property.getWriteMethod().getAnnotation(cls) : a;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public boolean isWritable() {
        return this.writable;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public boolean isReadable() {
        return this.readable;
    }
}
