package external.sdk.pendo.io.gson.internal.sql;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import sdk.pendo.io.a0.q;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.h0.b;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    static final u b = new u() { // from class: external.sdk.pendo.io.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // sdk.pendo.io.a0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
            Class<? super T> clsA = aVar.a();
            if (clsA == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat a;

    private SqlDateTypeAdapter() {
        this.a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Date a(sdk.pendo.io.h0.a aVar) throws IOException {
        java.util.Date date;
        if (aVar.t() == b.NULL) {
            aVar.q();
            return null;
        }
        String strR = aVar.r();
        try {
            synchronized (this) {
                date = this.a.parse(strR);
            }
            return new Date(date.getTime());
        } catch (ParseException e) {
            throw new q("Failed parsing '" + strR + "' as SQL Date; at path " + aVar.h(), e);
        }
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.k();
            return;
        }
        synchronized (this) {
            str = this.a.format((java.util.Date) date);
        }
        cVar.d(str);
    }
}
