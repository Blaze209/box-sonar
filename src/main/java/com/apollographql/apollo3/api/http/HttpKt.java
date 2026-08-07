package com.apollographql.apollo3.api.http;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Http.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¨\u0006\u0005"}, d2 = {PasskeyWebListener.GET_UNIQUE_KEY, "", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "name", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class HttpKt {
    public static final String get(List<HttpHeader> list, String name) {
        String value;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<T> it = list.iterator();
        boolean z = false;
        Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z) {
                    break;
                }
                break;
            }
            Object next = it.next();
            String lowerCase = ((HttpHeader) next).getName().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String lowerCase2 = name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                if (!z) {
                    z = true;
                    obj = next;
                }
            }
            obj = null;
            break;
        }
        HttpHeader httpHeader = (HttpHeader) obj;
        if (httpHeader == null || (value = httpHeader.getValue()) == null) {
            return null;
        }
        return StringsKt.trim((CharSequence) value).toString();
    }
}
