package external.sdk.pendo.io.gson.internal.sql;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.sql.Timestamp;
import java.util.Date;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
    static final u b = new u() { // from class: external.sdk.pendo.io.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // sdk.pendo.io.a0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
            if (aVar.a() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.a((Class) Date.class));
            }
            return null;
        }
    };
    private final TypeAdapter<Date> a;

    private SqlTimestampTypeAdapter(TypeAdapter<Date> typeAdapter) {
        this.a = typeAdapter;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Timestamp a(sdk.pendo.io.h0.a aVar) {
        Date dateA = this.a.a(aVar);
        if (dateA != null) {
            return new Timestamp(dateA.getTime());
        }
        return null;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Timestamp timestamp) {
        this.a.a(cVar, timestamp);
    }
}
