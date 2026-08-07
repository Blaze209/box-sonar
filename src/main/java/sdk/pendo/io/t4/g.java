package sdk.pendo.io.t4;

import android.view.View;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.l;

/* JADX INFO: loaded from: classes5.dex */
public class g {
    private static final sdk.pendo.io.q3.h<sdk.pendo.io.t4.a, sdk.pendo.io.t4.a> a = new a();
    private static final sdk.pendo.io.q3.h<sdk.pendo.io.t4.b, sdk.pendo.io.t4.b> b = new b();

    class a implements sdk.pendo.io.q3.h<sdk.pendo.io.t4.a, sdk.pendo.io.t4.a> {
        a() {
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.t4.a apply(sdk.pendo.io.t4.a aVar) {
            switch (c.a[aVar.ordinal()]) {
                case 1:
                    return sdk.pendo.io.t4.a.DESTROY;
                case 2:
                    return sdk.pendo.io.t4.a.STOP;
                case 3:
                    return sdk.pendo.io.t4.a.PAUSE;
                case 4:
                    return sdk.pendo.io.t4.a.STOP;
                case 5:
                    return sdk.pendo.io.t4.a.DESTROY;
                case 6:
                    throw new e("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + aVar + " not yet implemented");
            }
        }
    }

    class b implements sdk.pendo.io.q3.h<sdk.pendo.io.t4.b, sdk.pendo.io.t4.b> {
        b() {
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.t4.b apply(sdk.pendo.io.t4.b bVar) {
            switch (c.b[bVar.ordinal()]) {
                case 1:
                    return sdk.pendo.io.t4.b.DETACH;
                case 2:
                    return sdk.pendo.io.t4.b.DESTROY;
                case 3:
                    return sdk.pendo.io.t4.b.DESTROY_VIEW;
                case 4:
                    return sdk.pendo.io.t4.b.STOP;
                case 5:
                    return sdk.pendo.io.t4.b.PAUSE;
                case 6:
                    return sdk.pendo.io.t4.b.STOP;
                case 7:
                    return sdk.pendo.io.t4.b.DESTROY_VIEW;
                case 8:
                    return sdk.pendo.io.t4.b.DESTROY;
                case 9:
                    return sdk.pendo.io.t4.b.DETACH;
                case 10:
                    throw new e("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + bVar + " not yet implemented");
            }
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[sdk.pendo.io.t4.b.values().length];
            b = iArr;
            try {
                iArr[sdk.pendo.io.t4.b.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[sdk.pendo.io.t4.b.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[sdk.pendo.io.t4.b.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[sdk.pendo.io.t4.b.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[sdk.pendo.io.t4.b.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[sdk.pendo.io.t4.b.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[sdk.pendo.io.t4.b.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[sdk.pendo.io.t4.b.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[sdk.pendo.io.t4.b.DESTROY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[sdk.pendo.io.t4.b.DETACH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[sdk.pendo.io.t4.a.values().length];
            a = iArr2;
            try {
                iArr2[sdk.pendo.io.t4.a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[sdk.pendo.io.t4.a.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[sdk.pendo.io.t4.a.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[sdk.pendo.io.t4.a.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[sdk.pendo.io.t4.a.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[sdk.pendo.io.t4.a.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public static <T> d<T> a(j<sdk.pendo.io.t4.a> jVar) {
        return f.a((j) jVar, (sdk.pendo.io.q3.h) a);
    }

    public static <T> d<T> a(View view) {
        sdk.pendo.io.u4.a.a(view, "view == null");
        return f.a(j.a((l) new h(view)));
    }
}
