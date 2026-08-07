package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import sdk.pendo.io.a0.q;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.c0.d;
import sdk.pendo.io.c0.i;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    private final b<T> a;
    private final List<DateFormat> b;

    public static abstract class b<T extends Date> {
        public static final b<Date> b = new a(Date.class);
        private final Class<T> a;

        class a extends b<Date> {
            a(Class cls) {
                super(cls);
            }

            @Override // external.sdk.pendo.io.gson.internal.bind.DefaultDateTypeAdapter.b
            protected Date a(Date date) {
                return date;
            }
        }

        protected b(Class<T> cls) {
            this.a = cls;
        }

        protected abstract T a(Date date);

        public final u a(int i, int i2) {
            return a(new DefaultDateTypeAdapter<>(this, i, i2));
        }

        public final u a(String str) {
            return a(new DefaultDateTypeAdapter<>(this, str));
        }

        private final u a(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return TypeAdapters.a(this.a, defaultDateTypeAdapter);
        }
    }

    private DefaultDateTypeAdapter(b<T> bVar, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a = (b) sdk.pendo.io.c0.a.a(bVar);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (d.b()) {
            arrayList.add(i.a(i, i2));
        }
    }

    private Date b(sdk.pendo.io.h0.a aVar) throws IOException {
        String strR = aVar.r();
        synchronized (this.b) {
            Iterator<DateFormat> it = this.b.iterator();
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
    public T a(sdk.pendo.io.h0.a aVar) throws IOException {
        if (aVar.t() == sdk.pendo.io.h0.b.NULL) {
            aVar.q();
            return null;
        }
        return (T) this.a.a(b(aVar));
    }

    public String toString() {
        StringBuilder sb;
        String simpleName;
        DateFormat dateFormat = this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            sb = new StringBuilder("DefaultDateTypeAdapter(");
            simpleName = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            sb = new StringBuilder("DefaultDateTypeAdapter(");
            simpleName = dateFormat.getClass().getSimpleName();
        }
        return sb.append(simpleName).append(')').toString();
    }

    private DefaultDateTypeAdapter(b<T> bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a = (b) sdk.pendo.io.c0.a.a(bVar);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.k();
            return;
        }
        DateFormat dateFormat = this.b.get(0);
        synchronized (this.b) {
            str = dateFormat.format(date);
        }
        cVar.d(str);
    }
}
