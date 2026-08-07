package com.nimbusds.jose;

import com.nimbusds.jose.shaded.jcip.Immutable;
import com.nimbusds.jose.util.JSONStringUtils;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public class Algorithm implements Serializable {
    public static final Algorithm NONE = new Algorithm("none", Requirement.REQUIRED);
    private static final long serialVersionUID = 1;
    private final String name;
    private final Requirement requirement;

    public Algorithm(String str, Requirement requirement) {
        this.name = (String) Objects.requireNonNull(str);
        this.requirement = requirement;
    }

    public Algorithm(String str) {
        this(str, null);
    }

    public final String getName() {
        return this.name;
    }

    public final Requirement getRequirement() {
        return this.requirement;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Algorithm) && toString().equals(obj.toString());
    }

    public final String toString() {
        return this.name;
    }

    public final String toJSONString() {
        return JSONStringUtils.toJSONString(this.name);
    }

    public static Algorithm parse(String str) {
        if (str == null) {
            return null;
        }
        return new Algorithm(str);
    }
}
