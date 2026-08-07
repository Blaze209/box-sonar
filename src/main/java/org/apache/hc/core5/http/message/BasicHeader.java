package org.apache.hc.core5.http.message;

import java.io.Serializable;
import java.util.Objects;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeader implements Header, Cloneable, Serializable {
    private static final long serialVersionUID = -5427236326487562174L;
    private final String name;
    private final boolean sensitive;
    private final String value;

    public BasicHeader(String str, Object obj) {
        this(str, obj, false);
    }

    public BasicHeader(String str, Object obj, boolean z) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = Objects.toString(obj, null);
        this.sensitive = z;
    }

    @Override // org.apache.hc.core5.http.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // org.apache.hc.core5.http.NameValuePair
    public String getValue() {
        return this.value;
    }

    @Override // org.apache.hc.core5.http.Header
    public boolean isSensitive() {
        return this.sensitive;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(": ");
        if (getValue() != null) {
            sb.append(getValue());
        }
        return sb.toString();
    }

    public BasicHeader clone() throws CloneNotSupportedException {
        return (BasicHeader) super.clone();
    }
}
