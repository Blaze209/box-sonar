package com.pspdfkit.internal;

import android.content.Context;
import android.view.OrientationEventListener;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public final class ht {
    public final Context a;
    public a b;
    public long c = 0;
    public long d = 0;
    public int e = 1;
    public int f = 1;
    public b g;

    public class a extends OrientationEventListener {
        public a(Context context) {
            super(context, 2);
        }

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int i) {
            int i2;
            if (i <= 20 || i >= 340) {
                i2 = 1;
            } else if (Math.abs(i - 180) <= 20) {
                i2 = 2;
            } else if (Math.abs(i - 90) <= 20) {
                i2 = 4;
            } else {
                i2 = Math.abs(i + (-270)) <= 20 ? 3 : 0;
            }
            if (i2 == 0) {
                return;
            }
            ht htVar = ht.this;
            if (i2 != htVar.e) {
                htVar.d = 0L;
                htVar.c = 0L;
                htVar.e = i2;
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (htVar.d == 0) {
                htVar.d = jCurrentTimeMillis;
            }
            htVar.c = (jCurrentTimeMillis - htVar.d) + htVar.c;
            htVar.d = jCurrentTimeMillis;
            ht htVar2 = ht.this;
            if (htVar2.c > 1500) {
                if (i2 == 3) {
                    if (htVar2.f != 0) {
                        PdfLog.d("Nutri.OrientationDetect", "switch to SCREEN_ORIENTATION_LANDSCAPE", new Object[0]);
                        ht htVar3 = ht.this;
                        htVar3.f = 0;
                        b bVar = htVar3.g;
                        if (bVar != null) {
                            ((f70) bVar).a(i2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    if (htVar2.f != 1) {
                        PdfLog.d("Nutri.OrientationDetect", "switch to SCREEN_ORIENTATION_PORTRAIT", new Object[0]);
                        ht htVar4 = ht.this;
                        htVar4.f = 1;
                        b bVar2 = htVar4.g;
                        if (bVar2 != null) {
                            ((f70) bVar2).a(i2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i2 == 2) {
                    if (htVar2.f != 9) {
                        PdfLog.d("Nutri.OrientationDetect", "switch to SCREEN_ORIENTATION_REVERSE_PORTRAIT", new Object[0]);
                        ht htVar5 = ht.this;
                        htVar5.f = 9;
                        b bVar3 = htVar5.g;
                        if (bVar3 != null) {
                            ((f70) bVar3).a(i2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i2 != 4 || htVar2.f == 8) {
                    return;
                }
                PdfLog.d("Nutri.OrientationDetect", "switch to SCREEN_ORIENTATION_REVERSE_LANDSCAPE", new Object[0]);
                ht htVar6 = ht.this;
                htVar6.f = 8;
                b bVar4 = htVar6.g;
                if (bVar4 != null) {
                    ((f70) bVar4).a(i2);
                }
            }
        }
    }

    public interface b {
    }

    public ht(Context context) {
        this.a = context;
    }

    public final void a() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.disable();
        }
    }

    public final void b() {
        if (this.b == null) {
            this.b = new a(this.a);
        }
        this.b.enable();
    }
}
