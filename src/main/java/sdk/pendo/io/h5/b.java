package sdk.pendo.io.h5;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements d {
    private static final Logger b = Logger.getLogger(b.class.getName());

    static class a {
        public sdk.pendo.io.h5.c a;
        List<byte[]> b = new ArrayList();

        a(sdk.pendo.io.h5.c cVar) {
            this.a = cVar;
        }

        public void a() {
            this.a = null;
            this.b = new ArrayList();
        }

        public sdk.pendo.io.h5.c a(byte[] bArr) {
            this.b.add(bArr);
            int size = this.b.size();
            sdk.pendo.io.h5.c cVar = this.a;
            if (size != cVar.e) {
                return null;
            }
            List<byte[]> list = this.b;
            sdk.pendo.io.h5.c cVarA = sdk.pendo.io.h5.a.a(cVar, (byte[][]) list.toArray(new byte[list.size()][]));
            a();
            return cVarA;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.h5.b$b, reason: collision with other inner class name */
    public static final class C0395b implements d.a {
        a a = null;
        private d.a.InterfaceC0396a b;

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
        private static sdk.pendo.io.h5.c b(String str) {
            int i;
            int length = str.length();
            int i2 = 0;
            sdk.pendo.io.h5.c cVar = new sdk.pendo.io.h5.c(Character.getNumericValue(str.charAt(0)));
            int i3 = cVar.a;
            if (i3 < 0 || i3 > d.a.length - 1) {
                return b.a();
            }
            if (5 == i3 || 6 == i3) {
                if (!str.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) || length <= 1) {
                    return b.a();
                }
                StringBuilder sb = new StringBuilder();
                while (true) {
                    i2++;
                    if (str.charAt(i2) == '-') {
                        break;
                    }
                    sb.append(str.charAt(i2));
                }
                cVar.e = Integer.parseInt(sb.toString());
            }
            int i4 = i2 + 1;
            if (length <= i4 || '/' != str.charAt(i4)) {
                cVar.c = "/";
            } else {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    i = i2 + 1;
                    char cCharAt = str.charAt(i);
                    if (',' == cCharAt) {
                        break;
                    }
                    sb2.append(cCharAt);
                    if (i2 + 2 == length) {
                        break;
                    }
                    i2 = i;
                }
                cVar.c = sb2.toString();
                i2 = i;
            }
            int i5 = i2 + 1;
            if (length > i5 && Character.getNumericValue(Character.valueOf(str.charAt(i5)).charValue()) > -1) {
                StringBuilder sb3 = new StringBuilder();
                while (true) {
                    int i6 = i2 + 1;
                    char cCharAt2 = str.charAt(i6);
                    if (Character.getNumericValue(cCharAt2) < 0) {
                        break;
                    }
                    sb3.append(cCharAt2);
                    if (i2 + 2 == length) {
                        i2 = i6;
                        break;
                    }
                    i2 = i6;
                }
                try {
                    cVar.b = Integer.parseInt(sb3.toString());
                } catch (NumberFormatException unused) {
                    return b.a();
                }
            }
            int i7 = i2 + 1;
            if (length > i7) {
                try {
                    str.charAt(i7);
                    cVar.d = new JSONTokener(str.substring(i7)).nextValue();
                } catch (JSONException e) {
                    b.b.log(Level.WARNING, "An error occured while retrieving data from JSONTokener", (Throwable) e);
                    return b.a();
                }
            }
            Logger logger = b.b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("decoded %s as %s", str, cVar));
            }
            return cVar;
        }

        @Override // sdk.pendo.io.h5.d.a
        public void a(String str) {
            d.a.InterfaceC0396a interfaceC0396a;
            sdk.pendo.io.h5.c cVarB = b(str);
            int i = cVarB.a;
            if (5 == i || 6 == i) {
                a aVar = new a(cVarB);
                this.a = aVar;
                if (aVar.a.e != 0 || (interfaceC0396a = this.b) == null) {
                    return;
                }
            } else {
                interfaceC0396a = this.b;
                if (interfaceC0396a == null) {
                    return;
                }
            }
            interfaceC0396a.a(cVarB);
        }

        @Override // sdk.pendo.io.h5.d.a
        public void destroy() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a();
            }
            this.b = null;
        }

        @Override // sdk.pendo.io.h5.d.a
        public void a(byte[] bArr) {
            a aVar = this.a;
            if (aVar == null) {
                throw new RuntimeException("got binary data when not reconstructing a packet");
            }
            sdk.pendo.io.h5.c cVarA = aVar.a(bArr);
            if (cVarA != null) {
                this.a = null;
                d.a.InterfaceC0396a interfaceC0396a = this.b;
                if (interfaceC0396a != null) {
                    interfaceC0396a.a(cVarA);
                }
            }
        }

        @Override // sdk.pendo.io.h5.d.a
        public void a(d.a.InterfaceC0396a interfaceC0396a) {
            this.b = interfaceC0396a;
        }
    }

    public static final class c implements d.b {
        private void b(sdk.pendo.io.h5.c cVar, d.b.a aVar) {
            sdk.pendo.io.h5.a.C0394a c0394aA = sdk.pendo.io.h5.a.a(cVar);
            String strA = a(c0394aA.a);
            ArrayList arrayList = new ArrayList(Arrays.asList(c0394aA.b));
            arrayList.add(0, strA);
            aVar.call(arrayList.toArray());
        }

        @Override // sdk.pendo.io.h5.d.b
        public void a(sdk.pendo.io.h5.c cVar, d.b.a aVar) {
            int i = cVar.a;
            if ((i == 2 || i == 3) && sdk.pendo.io.f5.a.b(cVar.d)) {
                cVar.a = cVar.a == 2 ? 5 : 6;
            }
            Logger logger = b.b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("encoding packet %s", cVar));
            }
            int i2 = cVar.a;
            if (5 == i2 || 6 == i2) {
                b(cVar, aVar);
            } else {
                aVar.call(new String[]{a(cVar)});
            }
        }

        private String a(sdk.pendo.io.h5.c cVar) {
            StringBuilder sb = new StringBuilder("" + cVar.a);
            int i = cVar.a;
            if (5 == i || 6 == i) {
                sb.append(cVar.e);
                sb.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
            }
            String str = cVar.c;
            if (str != null && str.length() != 0 && !"/".equals(cVar.c)) {
                sb.append(cVar.c);
                sb.append(",");
            }
            int i2 = cVar.b;
            if (i2 >= 0) {
                sb.append(i2);
            }
            Object obj = cVar.d;
            if (obj != null) {
                sb.append(obj);
            }
            Logger logger = b.b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("encoded %s as %s", cVar, sb));
            }
            return sb.toString();
        }
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static sdk.pendo.io.h5.c<String> a() {
        return new sdk.pendo.io.h5.c<>(4, "parser error");
    }
}
