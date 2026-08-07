package org.yaml.snakeyaml;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.internal.Logger;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertySubstitute;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

/* JADX INFO: loaded from: classes5.dex */
public class TypeDescription {
    private static final Logger log = Logger.getLogger(TypeDescription.class.getPackage().getName());
    protected BeanAccess beanAccess;
    private transient boolean delegatesChecked;
    private transient Set<Property> dumpProperties;
    protected Set<String> excludes;
    private Class<?> impl;
    protected String[] includes;
    private Map<String, PropertySubstitute> properties;
    private transient PropertyUtils propertyUtils;
    private final Tag tag;
    private final Class<? extends Object> type;

    public Object finalizeConstruction(Object obj) {
        return obj;
    }

    public Object newInstance(String str, Node node) {
        return null;
    }

    public boolean setProperty(Object obj, String str, Object obj2) throws Exception {
        return false;
    }

    public boolean setupPropertyType(String str, Node node) {
        return false;
    }

    public TypeDescription(Class<? extends Object> cls, Tag tag) {
        this(cls, tag, null);
    }

    public TypeDescription(Class<? extends Object> cls, Tag tag, Class<?> cls2) {
        this.properties = Collections.emptyMap();
        this.excludes = Collections.emptySet();
        this.includes = null;
        this.type = cls;
        this.tag = tag;
        this.impl = cls2;
        this.beanAccess = null;
    }

    public TypeDescription(Class<? extends Object> cls, String str) {
        this(cls, new Tag(str), null);
    }

    public TypeDescription(Class<? extends Object> cls) {
        this(cls, new Tag(cls), null);
    }

    public TypeDescription(Class<? extends Object> cls, Class<?> cls2) {
        this(cls, new Tag(cls), cls2);
    }

    public Tag getTag() {
        return this.tag;
    }

    public Class<? extends Object> getType() {
        return this.type;
    }

    @Deprecated
    public void putListPropertyType(String str, Class<? extends Object> cls) {
        addPropertyParameters(str, cls);
    }

    @Deprecated
    public void putMapPropertyType(String str, Class<? extends Object> cls, Class<? extends Object> cls2) {
        addPropertyParameters(str, cls, cls2);
    }

    public void addPropertyParameters(String str, Class<?>... clsArr) {
        if (!this.properties.containsKey(str)) {
            substituteProperty(str, null, null, null, clsArr);
        } else {
            this.properties.get(str).setActualTypeArguments(clsArr);
        }
    }

    public String toString() {
        return "TypeDescription for " + getType() + " (tag='" + getTag() + "')";
    }

    private void checkDelegates() {
        for (PropertySubstitute propertySubstitute : this.properties.values()) {
            try {
                propertySubstitute.setDelegate(discoverProperty(propertySubstitute.getName()));
            } catch (YAMLException unused) {
            }
        }
        this.delegatesChecked = true;
    }

    private Property discoverProperty(String str) {
        PropertyUtils propertyUtils = this.propertyUtils;
        if (propertyUtils == null) {
            return null;
        }
        BeanAccess beanAccess = this.beanAccess;
        if (beanAccess == null) {
            return propertyUtils.getProperty(this.type, str);
        }
        return propertyUtils.getProperty(this.type, str, beanAccess);
    }

    public Property getProperty(String str) {
        if (!this.delegatesChecked) {
            checkDelegates();
        }
        return this.properties.containsKey(str) ? this.properties.get(str) : discoverProperty(str);
    }

    public void substituteProperty(String str, Class<?> cls, String str2, String str3, Class<?>... clsArr) {
        substituteProperty(new PropertySubstitute(str, cls, str2, str3, clsArr));
    }

    public void substituteProperty(PropertySubstitute propertySubstitute) {
        if (Collections.EMPTY_MAP == this.properties) {
            this.properties = new LinkedHashMap();
        }
        propertySubstitute.setTargetType(this.type);
        this.properties.put(propertySubstitute.getName(), propertySubstitute);
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
    }

    public void setIncludes(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            strArr = null;
        }
        this.includes = strArr;
    }

    public void setExcludes(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            HashSet hashSet = new HashSet();
            this.excludes = hashSet;
            Collections.addAll(hashSet, strArr);
            return;
        }
        this.excludes = Collections.emptySet();
    }

    public Set<Property> getProperties() {
        Set<Property> set = this.dumpProperties;
        if (set != null) {
            return set;
        }
        PropertyUtils propertyUtils = this.propertyUtils;
        if (propertyUtils == null) {
            return null;
        }
        if (this.includes != null) {
            this.dumpProperties = new LinkedHashSet();
            for (String str : this.includes) {
                if (!this.excludes.contains(str)) {
                    this.dumpProperties.add(getProperty(str));
                }
            }
            return this.dumpProperties;
        }
        BeanAccess beanAccess = this.beanAccess;
        Set<Property> properties = beanAccess == null ? propertyUtils.getProperties(this.type) : propertyUtils.getProperties(this.type, beanAccess);
        if (this.properties.isEmpty()) {
            if (this.excludes.isEmpty()) {
                this.dumpProperties = properties;
                return properties;
            }
            this.dumpProperties = new LinkedHashSet();
            for (Property property : properties) {
                if (!this.excludes.contains(property.getName())) {
                    this.dumpProperties.add(property);
                }
            }
            return this.dumpProperties;
        }
        if (!this.delegatesChecked) {
            checkDelegates();
        }
        this.dumpProperties = new LinkedHashSet();
        for (PropertySubstitute propertySubstitute : this.properties.values()) {
            if (!this.excludes.contains(propertySubstitute.getName()) && propertySubstitute.isReadable()) {
                this.dumpProperties.add(propertySubstitute);
            }
        }
        for (Property property2 : properties) {
            if (!this.excludes.contains(property2.getName())) {
                this.dumpProperties.add(property2);
            }
        }
        return this.dumpProperties;
    }

    public Object newInstance(Node node) {
        Class<?> cls = this.impl;
        if (cls != null) {
            try {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[0]);
            } catch (Exception e) {
                log.warn(e.getLocalizedMessage());
                this.impl = null;
            }
        }
        return null;
    }
}
