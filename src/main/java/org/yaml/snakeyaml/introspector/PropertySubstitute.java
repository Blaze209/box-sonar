package org.yaml.snakeyaml.introspector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.internal.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class PropertySubstitute extends Property {
    private static final Logger log = Logger.getLogger(PropertySubstitute.class.getPackage().getName());
    private Property delegate;
    private Field field;
    private boolean filler;
    protected Class<?>[] parameters;
    private transient Method read;
    private final String readMethod;
    protected Class<?> targetType;
    private transient Method write;
    private final String writeMethod;

    public PropertySubstitute(String str, Class<?> cls, String str2, String str3, Class<?>... clsArr) {
        super(str, cls);
        this.readMethod = str2;
        this.writeMethod = str3;
        setActualTypeArguments(clsArr);
        this.filler = false;
    }

    public PropertySubstitute(String str, Class<?> cls, Class<?>... clsArr) {
        this(str, cls, null, null, clsArr);
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Class<?>[] getActualTypeArguments() {
        Property property;
        Class<?>[] clsArr = this.parameters;
        return (clsArr != null || (property = this.delegate) == null) ? clsArr : property.getActualTypeArguments();
    }

    public void setActualTypeArguments(Class<?>... clsArr) {
        if (clsArr != null && clsArr.length > 0) {
            this.parameters = clsArr;
        } else {
            this.parameters = null;
        }
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public void set(Object obj, Object obj2) throws Exception {
        Method method = this.write;
        if (method != null) {
            if (!this.filler) {
                method.invoke(obj, obj2);
                return;
            }
            if (obj2 != null) {
                if (obj2 instanceof Collection) {
                    Iterator it = ((Collection) obj2).iterator();
                    while (it.hasNext()) {
                        this.write.invoke(obj, it.next());
                    }
                    return;
                }
                if (obj2 instanceof Map) {
                    for (Map.Entry entry : ((Map) obj2).entrySet()) {
                        this.write.invoke(obj, entry.getKey(), entry.getValue());
                    }
                    return;
                }
                if (obj2.getClass().isArray()) {
                    int length = Array.getLength(obj2);
                    for (int i = 0; i < length; i++) {
                        this.write.invoke(obj, Array.get(obj2, i));
                    }
                    return;
                }
                return;
            }
            return;
        }
        Field field = this.field;
        if (field != null) {
            field.set(obj, obj2);
            return;
        }
        Property property = this.delegate;
        if (property != null) {
            property.set(obj, obj2);
        } else {
            log.warn("No setter/delegate for '" + getName() + "' on object " + obj);
        }
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Object get(Object obj) {
        try {
            Method method = this.read;
            if (method != null) {
                return method.invoke(obj, new Object[0]);
            }
            Field field = this.field;
            if (field != null) {
                return field.get(obj);
            }
            Property property = this.delegate;
            if (property != null) {
                return property.get(obj);
            }
            throw new YAMLException("No getter or delegate for property '" + getName() + "' on object " + obj);
        } catch (Exception e) {
            throw new YAMLException("Unable to find getter for property '" + getName() + "' on object " + obj + ":" + e);
        }
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public List<Annotation> getAnnotations() {
        Annotation[] annotations;
        Method method = this.read;
        if (method != null) {
            annotations = method.getAnnotations();
        } else {
            Field field = this.field;
            annotations = field != null ? field.getAnnotations() : null;
        }
        return annotations != null ? Arrays.asList(annotations) : this.delegate.getAnnotations();
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        Method method = this.read;
        if (method != null) {
            return (A) method.getAnnotation(cls);
        }
        Field field = this.field;
        if (field != null) {
            return (A) field.getAnnotation(cls);
        }
        return (A) this.delegate.getAnnotation(cls);
    }

    public void setTargetType(Class<?> cls) {
        Class<?>[] clsArr;
        if (this.targetType != cls) {
            this.targetType = cls;
            String name = getName();
            Class<?> superclass = cls;
            while (true) {
                if (superclass == null) {
                    break;
                }
                for (Field field : superclass.getDeclaredFields()) {
                    if (field.getName().equals(name)) {
                        int modifiers = field.getModifiers();
                        if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                            field.setAccessible(true);
                            this.field = field;
                            break;
                        }
                        break;
                    }
                }
                superclass = superclass.getSuperclass();
            }
            if (this.field == null) {
                Logger logger = log;
                if (logger.isLoggable(Logger.Level.WARNING)) {
                    logger.warn(String.format("Failed to find field for %s.%s", cls.getName(), getName()));
                }
            }
            String str = this.readMethod;
            if (str != null) {
                this.read = discoverMethod(cls, str, new Class[0]);
            }
            String str2 = this.writeMethod;
            if (str2 != null) {
                this.filler = false;
                Method methodDiscoverMethod = discoverMethod(cls, str2, getType());
                this.write = methodDiscoverMethod;
                if (methodDiscoverMethod != null || (clsArr = this.parameters) == null) {
                    return;
                }
                this.filler = true;
                this.write = discoverMethod(cls, this.writeMethod, clsArr);
            }
        }
    }

    private Method discoverMethod(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (str.equals(method.getName())) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != clsArr.length) {
                        continue;
                    } else {
                        boolean z = true;
                        for (int i = 0; i < parameterTypes.length; i++) {
                            if (!parameterTypes[i].isAssignableFrom(clsArr[i])) {
                                z = false;
                            }
                        }
                        if (z) {
                            method.setAccessible(true);
                            return method;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        Logger logger = log;
        if (!logger.isLoggable(Logger.Level.WARNING)) {
            return null;
        }
        logger.warn(String.format("Failed to find [%s(%d args)] for %s.%s", str, Integer.valueOf(clsArr.length), this.targetType.getName(), getName()));
        return null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public String getName() {
        String name = super.getName();
        if (name != null) {
            return name;
        }
        Property property = this.delegate;
        if (property != null) {
            return property.getName();
        }
        return null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Class<?> getType() {
        Class<?> type = super.getType();
        if (type != null) {
            return type;
        }
        Property property = this.delegate;
        if (property != null) {
            return property.getType();
        }
        return null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public boolean isReadable() {
        if (this.read != null || this.field != null) {
            return true;
        }
        Property property = this.delegate;
        return property != null && property.isReadable();
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public boolean isWritable() {
        if (this.write != null || this.field != null) {
            return true;
        }
        Property property = this.delegate;
        return property != null && property.isWritable();
    }

    public void setDelegate(Property property) {
        this.delegate = property;
        String str = this.writeMethod;
        if (str == null || this.write != null || this.filler) {
            return;
        }
        this.filler = true;
        this.write = discoverMethod(this.targetType, str, getActualTypeArguments());
    }
}
