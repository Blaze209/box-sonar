package com.apollographql.apollo3.api.http;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"valueOf", "", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "name", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class HttpHeaders {
    public static final String valueOf(List<HttpHeader> list, String name) {
        Object next;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsKt.equals(((HttpHeader) next).getName(), name, true));
        HttpHeader httpHeader = (HttpHeader) next;
        if (httpHeader != null) {
            return httpHeader.getValue();
        }
        return null;
    }
}
