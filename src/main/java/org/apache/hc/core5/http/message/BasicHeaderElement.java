package org.apache.hc.core5.http.message;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.apache.hc.core5.http.HeaderElement;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeaderElement implements HeaderElement {
    private static final NameValuePair[] EMPTY_NAME_VALUE_PAIR_ARRAY = new NameValuePair[0];
    private final String name;
    private final NameValuePair[] parameters;
    private final String value;

    public BasicHeaderElement(String str, String str2, NameValuePair... nameValuePairArr) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
        if (nameValuePairArr != null) {
            this.parameters = nameValuePairArr;
        } else {
            this.parameters = EMPTY_NAME_VALUE_PAIR_ARRAY;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasicHeaderElement(String str, String str2) {
        this(str, str2, null);
    }

    @Override // org.apache.hc.core5.http.HeaderElement
    public String getName() {
        return this.name;
    }

    @Override // org.apache.hc.core5.http.HeaderElement
    public String getValue() {
        return this.value;
    }

    @Override // org.apache.hc.core5.http.HeaderElement
    public NameValuePair[] getParameters() {
        return (NameValuePair[]) this.parameters.clone();
    }

    @Override // org.apache.hc.core5.http.HeaderElement
    public int getParameterCount() {
        return this.parameters.length;
    }

    @Override // org.apache.hc.core5.http.HeaderElement
    public NameValuePair getParameter(int i) {
        return this.parameters[i];
    }

    @Override // org.apache.hc.core5.http.HeaderElement
    public NameValuePair getParameterByName(String str) {
        Args.notNull(str, "Name");
        for (NameValuePair nameValuePair : this.parameters) {
            if (nameValuePair.getName().equalsIgnoreCase(str)) {
                return nameValuePair;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        if (this.value != null) {
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(this.value);
        }
        for (NameValuePair nameValuePair : this.parameters) {
            sb.append("; ");
            sb.append(nameValuePair);
        }
        return sb.toString();
    }
}
