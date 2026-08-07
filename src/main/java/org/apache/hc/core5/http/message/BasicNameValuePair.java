package org.apache.hc.core5.http.message;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import java.util.Objects;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.LangUtils;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BasicNameValuePair implements NameValuePair, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public BasicNameValuePair(String str, String str2) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
    }

    @Override // org.apache.hc.core5.http.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // org.apache.hc.core5.http.NameValuePair
    public String getValue() {
        return this.value;
    }

    public String toString() {
        if (this.value == null) {
            return this.name;
        }
        StringBuilder sb = new StringBuilder(this.name.length() + 1 + this.value.length());
        sb.append(this.name);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.value);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BasicNameValuePair) {
            BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
            if (this.name.equalsIgnoreCase(basicNameValuePair.name) && Objects.equals(this.value, basicNameValuePair.value)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, TextUtils.toLowerCase(this.name)), this.value);
    }
}
