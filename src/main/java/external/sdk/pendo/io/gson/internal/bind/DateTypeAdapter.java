package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import sdk.pendo.io.a0.q;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.c0.d;
import sdk.pendo.io.c0.i;
import sdk.pendo.io.h0.b;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final u b = new u() { // from class: external.sdk.pendo.io.gson.internal.bind.DateTypeAdapter.1
        @Override // sdk.pendo.io.a0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };
    private final List<DateFormat> a;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (d.b()) {
            arrayList.add(i.a(2, 2));
        }
    }

    private Date b(sdk.pendo.io.h0.a aVar) throws IOException {
        String strR = aVar.r();
        synchronized (this.a) {
            Iterator<DateFormat> it = this.a.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(strR);
                } catch (ParseException unused) {
                }
            }
            try {
                return sdk.pendo.io.e0.a.a(strR, new ParsePosition(0));
            } catch (ParseException e) {
                throw new q("Failed parsing '" + strR + "' as Date; at path " + aVar.h(), e);
            }
        }
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Date a(sdk.pendo.io.h0.a aVar) throws IOException {
        if (aVar.t() != b.NULL) {
            return b(aVar);
        }
        aVar.q();
        return null;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.k();
            return;
        }
        DateFormat dateFormat = this.a.get(0);
        synchronized (this.a) {
            str = dateFormat.format(date);
        }
        cVar.d(str);
    }
}
