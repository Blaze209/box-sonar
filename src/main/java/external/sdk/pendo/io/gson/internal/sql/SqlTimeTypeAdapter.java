package external.sdk.pendo.io.gson.internal.sql;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import sdk.pendo.io.a0.q;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.h0.b;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
final class SqlTimeTypeAdapter extends TypeAdapter<Time> {
    static final u b = new u() { // from class: external.sdk.pendo.io.gson.internal.sql.SqlTimeTypeAdapter.1
        @Override // sdk.pendo.io.a0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
            Class<? super T> clsA = aVar.a();
            if (clsA == Time.class) {
                return new SqlTimeTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat a;

    private SqlTimeTypeAdapter() {
        this.a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Time a(sdk.pendo.io.h0.a aVar) throws IOException {
        Time time;
        if (aVar.t() == b.NULL) {
            aVar.q();
            return null;
        }
        String strR = aVar.r();
        try {
            synchronized (this) {
                time = new Time(this.a.parse(strR).getTime());
            }
            return time;
        } catch (ParseException e) {
            throw new q("Failed parsing '" + strR + "' as SQL Time; at path " + aVar.h(), e);
        }
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Time time) throws IOException {
        String str;
        if (time == null) {
            cVar.k();
            return;
        }
        synchronized (this) {
            str = this.a.format((Date) time);
        }
        cVar.d(str);
    }
}
