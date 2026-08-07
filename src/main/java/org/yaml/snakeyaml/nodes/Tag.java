package org.yaml.snakeyaml.nodes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.util.UriEncoder;

/* JADX INFO: loaded from: classes5.dex */
public final class Tag {
    public static final Tag BINARY;
    public static final Tag BOOL;
    public static final Tag COMMENT;
    private static final Map<Tag, Set<Class<?>>> COMPATIBILITY_MAP;
    public static final Tag FLOAT;
    public static final Tag INT;
    public static final Tag MAP;
    public static final Tag MERGE;
    public static final Tag NULL;
    public static final Tag OMAP;
    public static final Tag PAIRS;
    public static final String PREFIX = "tag:yaml.org,2002:";
    public static final Tag SEQ;
    public static final Tag SET;
    public static final Tag STR;
    public static final Tag TIMESTAMP;
    public static final Tag YAML;
    public static final Set<Tag> standardTags;
    private boolean secondary;
    private final String value;

    static {
        Tag tag = new Tag("tag:yaml.org,2002:yaml");
        YAML = tag;
        Tag tag2 = new Tag("tag:yaml.org,2002:merge");
        MERGE = tag2;
        Tag tag3 = new Tag("tag:yaml.org,2002:set");
        SET = tag3;
        Tag tag4 = new Tag("tag:yaml.org,2002:pairs");
        PAIRS = tag4;
        Tag tag5 = new Tag("tag:yaml.org,2002:omap");
        OMAP = tag5;
        Tag tag6 = new Tag("tag:yaml.org,2002:binary");
        BINARY = tag6;
        Tag tag7 = new Tag("tag:yaml.org,2002:int");
        INT = tag7;
        Tag tag8 = new Tag("tag:yaml.org,2002:float");
        FLOAT = tag8;
        Tag tag9 = new Tag("tag:yaml.org,2002:timestamp");
        TIMESTAMP = tag9;
        Tag tag10 = new Tag("tag:yaml.org,2002:bool");
        BOOL = tag10;
        Tag tag11 = new Tag("tag:yaml.org,2002:null");
        NULL = tag11;
        Tag tag12 = new Tag("tag:yaml.org,2002:str");
        STR = tag12;
        Tag tag13 = new Tag("tag:yaml.org,2002:seq");
        SEQ = tag13;
        Tag tag14 = new Tag("tag:yaml.org,2002:map");
        MAP = tag14;
        HashSet hashSet = new HashSet(15);
        standardTags = hashSet;
        hashSet.add(tag);
        hashSet.add(tag2);
        hashSet.add(tag3);
        hashSet.add(tag4);
        hashSet.add(tag5);
        hashSet.add(tag6);
        hashSet.add(tag7);
        hashSet.add(tag8);
        hashSet.add(tag9);
        hashSet.add(tag10);
        hashSet.add(tag11);
        hashSet.add(tag12);
        hashSet.add(tag13);
        hashSet.add(tag14);
        COMMENT = new Tag("tag:yaml.org,2002:comment");
        HashMap map = new HashMap();
        COMPATIBILITY_MAP = map;
        HashSet hashSet2 = new HashSet();
        hashSet2.add(Double.class);
        hashSet2.add(Float.class);
        hashSet2.add(BigDecimal.class);
        map.put(tag8, hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add(Integer.class);
        hashSet3.add(Long.class);
        hashSet3.add(BigInteger.class);
        map.put(tag7, hashSet3);
        HashSet hashSet4 = new HashSet();
        hashSet4.add(Date.class);
        try {
            hashSet4.add(Class.forName("java.sql.Date"));
            hashSet4.add(Class.forName("java.sql.Timestamp"));
        } catch (ClassNotFoundException unused) {
        }
        COMPATIBILITY_MAP.put(TIMESTAMP, hashSet4);
    }

    public Tag(String str) {
        this.secondary = false;
        if (str == null) {
            throw new NullPointerException("Tag must be provided.");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Tag must not be empty.");
        }
        if (str.trim().length() != str.length()) {
            throw new IllegalArgumentException("Tag must not contain leading or trailing spaces.");
        }
        this.value = UriEncoder.encode(str);
        this.secondary = !str.startsWith(PREFIX);
    }

    public Tag(Class<? extends Object> cls) {
        this.secondary = false;
        if (cls == null) {
            throw new NullPointerException("Class for tag must be provided.");
        }
        this.value = PREFIX + UriEncoder.encode(cls.getName());
    }

    public boolean isSecondary() {
        return this.secondary;
    }

    public String getValue() {
        return this.value;
    }

    public boolean startsWith(String str) {
        return this.value.startsWith(str);
    }

    public String getClassName() {
        if (this.secondary) {
            throw new YAMLException("Invalid tag: " + this.value);
        }
        return UriEncoder.decode(this.value.substring(PREFIX.length()));
    }

    public String toString() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Tag) {
            return this.value.equals(((Tag) obj).getValue());
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean isCompatible(Class<?> cls) {
        Set<Class<?>> set = COMPATIBILITY_MAP.get(this);
        if (set != null) {
            return set.contains(cls);
        }
        return false;
    }

    public boolean matches(Class<? extends Object> cls) {
        return this.value.equals(PREFIX + cls.getName());
    }

    public boolean isCustomGlobal() {
        return (this.secondary || standardTags.contains(this)) ? false : true;
    }
}
