package com.nimbusds.jose;

import com.box.android.data.datasource.auth.AuthenticationRemoteDataSource;
import com.nimbusds.jose.shaded.jcip.Immutable;
import com.nimbusds.jose.util.JSONStringUtils;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class JOSEObjectType implements Serializable {
    public static final JOSEObjectType JOSE = new JOSEObjectType("JOSE");
    public static final JOSEObjectType JOSE_JSON = new JOSEObjectType("JOSE+JSON");
    public static final JOSEObjectType JWT = new JOSEObjectType(AuthenticationRemoteDataSource.JWT_TOKEN_TYPE_NAME);
    private static final long serialVersionUID = 1;
    private final String type;

    public JOSEObjectType(String str) {
        this.type = (String) Objects.requireNonNull(str);
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.toLowerCase().hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof JOSEObjectType) && this.type.equalsIgnoreCase(((JOSEObjectType) obj).type);
    }

    public String toString() {
        return this.type;
    }

    public String toJSONString() {
        return JSONStringUtils.toJSONString(this.type);
    }
}
