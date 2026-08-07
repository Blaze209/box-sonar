package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.collection.SparseArrayCompat;
import androidx.media3.common.PlaybackException;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.MediaWindowType;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.annotations.note.AuthorState;
import com.pspdfkit.annotations.sound.AudioEncoding;
import com.pspdfkit.utils.EdgeInsets;
import com.pspdfkit.utils.PdfLog;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bh {
    /* JADX WARN: Code duplicated, block: B:209:0x0540  */
    /* JADX WARN: Code duplicated, block: B:210:0x0542 A[Catch: all -> 0x0619, TryCatch #0 {, blocks: (B:4:0x0007, B:5:0x0013, B:7:0x0019, B:53:0x007b, B:227:0x05c5, B:229:0x05cb, B:233:0x05d7, B:57:0x0087, B:62:0x0095, B:64:0x0099, B:60:0x0091, B:65:0x00a1, B:66:0x00d1, B:67:0x00d2, B:72:0x00e0, B:74:0x00e4, B:70:0x00dc, B:75:0x00ec, B:76:0x011c, B:77:0x011d, B:82:0x012b, B:84:0x012f, B:86:0x013f, B:90:0x015e, B:80:0x0127, B:91:0x016b, B:92:0x019b, B:93:0x019c, B:98:0x01aa, B:100:0x01ae, B:102:0x01bb, B:103:0x01cc, B:105:0x01d3, B:106:0x01de, B:96:0x01a6, B:107:0x01eb, B:108:0x021b, B:109:0x021c, B:114:0x022a, B:116:0x022e, B:118:0x0232, B:120:0x0238, B:122:0x023c, B:124:0x0242, B:126:0x0246, B:128:0x0251, B:130:0x025c, B:132:0x0267, B:112:0x0226, B:133:0x029b, B:134:0x02cb, B:135:0x02cc, B:140:0x02da, B:143:0x02df, B:147:0x02fd, B:138:0x02d6, B:148:0x0308, B:149:0x0338, B:150:0x0339, B:155:0x0347, B:157:0x034b, B:159:0x035b, B:163:0x03a4, B:153:0x0343, B:164:0x03b1, B:165:0x03e1, B:166:0x03e2, B:171:0x03f0, B:173:0x03f4, B:174:0x03ff, B:176:0x0405, B:178:0x041e, B:183:0x0449, B:184:0x0460, B:187:0x046a, B:188:0x0472, B:169:0x03ec, B:190:0x0482, B:191:0x04b2, B:192:0x04b3, B:198:0x04c6, B:200:0x04d5, B:201:0x04e4, B:203:0x04ed, B:204:0x04fa, B:195:0x04c1, B:205:0x0507, B:206:0x0537, B:207:0x0538, B:212:0x0546, B:214:0x054a, B:216:0x0573, B:210:0x0542, B:217:0x0577, B:218:0x05a7, B:219:0x05a8, B:224:0x05b6, B:226:0x05ba, B:222:0x05b2, B:234:0x05e6, B:235:0x0616), top: B:241:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x054a A[Catch: all -> 0x0619, TryCatch #0 {, blocks: (B:4:0x0007, B:5:0x0013, B:7:0x0019, B:53:0x007b, B:227:0x05c5, B:229:0x05cb, B:233:0x05d7, B:57:0x0087, B:62:0x0095, B:64:0x0099, B:60:0x0091, B:65:0x00a1, B:66:0x00d1, B:67:0x00d2, B:72:0x00e0, B:74:0x00e4, B:70:0x00dc, B:75:0x00ec, B:76:0x011c, B:77:0x011d, B:82:0x012b, B:84:0x012f, B:86:0x013f, B:90:0x015e, B:80:0x0127, B:91:0x016b, B:92:0x019b, B:93:0x019c, B:98:0x01aa, B:100:0x01ae, B:102:0x01bb, B:103:0x01cc, B:105:0x01d3, B:106:0x01de, B:96:0x01a6, B:107:0x01eb, B:108:0x021b, B:109:0x021c, B:114:0x022a, B:116:0x022e, B:118:0x0232, B:120:0x0238, B:122:0x023c, B:124:0x0242, B:126:0x0246, B:128:0x0251, B:130:0x025c, B:132:0x0267, B:112:0x0226, B:133:0x029b, B:134:0x02cb, B:135:0x02cc, B:140:0x02da, B:143:0x02df, B:147:0x02fd, B:138:0x02d6, B:148:0x0308, B:149:0x0338, B:150:0x0339, B:155:0x0347, B:157:0x034b, B:159:0x035b, B:163:0x03a4, B:153:0x0343, B:164:0x03b1, B:165:0x03e1, B:166:0x03e2, B:171:0x03f0, B:173:0x03f4, B:174:0x03ff, B:176:0x0405, B:178:0x041e, B:183:0x0449, B:184:0x0460, B:187:0x046a, B:188:0x0472, B:169:0x03ec, B:190:0x0482, B:191:0x04b2, B:192:0x04b3, B:198:0x04c6, B:200:0x04d5, B:201:0x04e4, B:203:0x04ed, B:204:0x04fa, B:195:0x04c1, B:205:0x0507, B:206:0x0537, B:207:0x0538, B:212:0x0546, B:214:0x054a, B:216:0x0573, B:210:0x0542, B:217:0x0577, B:218:0x05a7, B:219:0x05a8, B:224:0x05b6, B:226:0x05ba, B:222:0x05b2, B:234:0x05e6, B:235:0x0616), top: B:241:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0572  */
    /* JADX WARN: Code duplicated, block: B:221:0x05b0  */
    /* JADX WARN: Code duplicated, block: B:222:0x05b2 A[Catch: all -> 0x0619, TryCatch #0 {, blocks: (B:4:0x0007, B:5:0x0013, B:7:0x0019, B:53:0x007b, B:227:0x05c5, B:229:0x05cb, B:233:0x05d7, B:57:0x0087, B:62:0x0095, B:64:0x0099, B:60:0x0091, B:65:0x00a1, B:66:0x00d1, B:67:0x00d2, B:72:0x00e0, B:74:0x00e4, B:70:0x00dc, B:75:0x00ec, B:76:0x011c, B:77:0x011d, B:82:0x012b, B:84:0x012f, B:86:0x013f, B:90:0x015e, B:80:0x0127, B:91:0x016b, B:92:0x019b, B:93:0x019c, B:98:0x01aa, B:100:0x01ae, B:102:0x01bb, B:103:0x01cc, B:105:0x01d3, B:106:0x01de, B:96:0x01a6, B:107:0x01eb, B:108:0x021b, B:109:0x021c, B:114:0x022a, B:116:0x022e, B:118:0x0232, B:120:0x0238, B:122:0x023c, B:124:0x0242, B:126:0x0246, B:128:0x0251, B:130:0x025c, B:132:0x0267, B:112:0x0226, B:133:0x029b, B:134:0x02cb, B:135:0x02cc, B:140:0x02da, B:143:0x02df, B:147:0x02fd, B:138:0x02d6, B:148:0x0308, B:149:0x0338, B:150:0x0339, B:155:0x0347, B:157:0x034b, B:159:0x035b, B:163:0x03a4, B:153:0x0343, B:164:0x03b1, B:165:0x03e1, B:166:0x03e2, B:171:0x03f0, B:173:0x03f4, B:174:0x03ff, B:176:0x0405, B:178:0x041e, B:183:0x0449, B:184:0x0460, B:187:0x046a, B:188:0x0472, B:169:0x03ec, B:190:0x0482, B:191:0x04b2, B:192:0x04b3, B:198:0x04c6, B:200:0x04d5, B:201:0x04e4, B:203:0x04ed, B:204:0x04fa, B:195:0x04c1, B:205:0x0507, B:206:0x0537, B:207:0x0538, B:212:0x0546, B:214:0x054a, B:216:0x0573, B:210:0x0542, B:217:0x0577, B:218:0x05a7, B:219:0x05a8, B:224:0x05b6, B:226:0x05ba, B:222:0x05b2, B:234:0x05e6, B:235:0x0616), top: B:241:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:226:0x05ba A[Catch: all -> 0x0619, TryCatch #0 {, blocks: (B:4:0x0007, B:5:0x0013, B:7:0x0019, B:53:0x007b, B:227:0x05c5, B:229:0x05cb, B:233:0x05d7, B:57:0x0087, B:62:0x0095, B:64:0x0099, B:60:0x0091, B:65:0x00a1, B:66:0x00d1, B:67:0x00d2, B:72:0x00e0, B:74:0x00e4, B:70:0x00dc, B:75:0x00ec, B:76:0x011c, B:77:0x011d, B:82:0x012b, B:84:0x012f, B:86:0x013f, B:90:0x015e, B:80:0x0127, B:91:0x016b, B:92:0x019b, B:93:0x019c, B:98:0x01aa, B:100:0x01ae, B:102:0x01bb, B:103:0x01cc, B:105:0x01d3, B:106:0x01de, B:96:0x01a6, B:107:0x01eb, B:108:0x021b, B:109:0x021c, B:114:0x022a, B:116:0x022e, B:118:0x0232, B:120:0x0238, B:122:0x023c, B:124:0x0242, B:126:0x0246, B:128:0x0251, B:130:0x025c, B:132:0x0267, B:112:0x0226, B:133:0x029b, B:134:0x02cb, B:135:0x02cc, B:140:0x02da, B:143:0x02df, B:147:0x02fd, B:138:0x02d6, B:148:0x0308, B:149:0x0338, B:150:0x0339, B:155:0x0347, B:157:0x034b, B:159:0x035b, B:163:0x03a4, B:153:0x0343, B:164:0x03b1, B:165:0x03e1, B:166:0x03e2, B:171:0x03f0, B:173:0x03f4, B:174:0x03ff, B:176:0x0405, B:178:0x041e, B:183:0x0449, B:184:0x0460, B:187:0x046a, B:188:0x0472, B:169:0x03ec, B:190:0x0482, B:191:0x04b2, B:192:0x04b3, B:198:0x04c6, B:200:0x04d5, B:201:0x04e4, B:203:0x04ed, B:204:0x04fa, B:195:0x04c1, B:205:0x0507, B:206:0x0537, B:207:0x0538, B:212:0x0546, B:214:0x054a, B:216:0x0573, B:210:0x0542, B:217:0x0577, B:218:0x05a7, B:219:0x05a8, B:224:0x05b6, B:226:0x05ba, B:222:0x05b2, B:234:0x05e6, B:235:0x0616), top: B:241:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:254:0x0577 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:0x05e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0081  */
    /* JADX WARN: Code duplicated, block: B:56:0x0084  */
    public static final synchronized SparseArrayCompat<Object> a(k3 k3Var, yg ygVar, Set<Integer> set) {
        SparseArrayCompat<Object> sparseArrayCompat;
        Object obj;
        String str;
        Object obj2;
        RectF rectF;
        Integer numValueOf;
        Iterator it;
        boolean z = true;
        Object obj3 = null;
        int i = 0;
        sparseArrayCompat = new SparseArrayCompat<>(0, 1, null);
        Iterator<Integer> it2 = set.iterator();
        while (it2.hasNext()) {
            int iIntValue = it2.next().intValue();
            if (iIntValue == 2 || iIntValue == 3 || iIntValue == 4 || iIntValue == 5 || iIntValue == 6) {
                z = z;
                obj = k3Var.a.get(iIntValue);
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof String)) {
                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(String.class).getSimpleName()).toString());
                }
                str = (String) obj;
                if (str != null) {
                    sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.a(str)));
                }
            } else if (iIntValue != 9) {
                int i2 = -1;
                if (iIntValue == 15) {
                    z = z;
                    Object objEmptyList = CollectionsKt.emptyList();
                    Object obj4 = k3Var.a.get(iIntValue);
                    if (obj4 != null) {
                        if (!(obj4 instanceof List)) {
                            throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(List.class).getSimpleName()).toString());
                        }
                        objEmptyList = obj4;
                    }
                    List list = (List) objEmptyList;
                    int size = list.size();
                    int[] iArr = new int[size];
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        iArr[i3] = ((Number) list.get(i3)).intValue();
                    }
                    int i4 = 4;
                    ygVar.a(4, size, 4);
                    int i5 = size - 1;
                    while (-1 < i5) {
                        int i6 = iArr[i5];
                        ygVar.d(i4, 0);
                        ygVar.b(i6);
                        i5--;
                        i4 = 4;
                    }
                    sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.b()));
                } else if (iIntValue == 100) {
                    Object obj5 = k3Var.a.get(iIntValue);
                    if (obj5 == null) {
                        obj5 = null;
                    } else if (!(obj5 instanceof List)) {
                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(List.class).getSimpleName()).toString());
                    }
                    List list2 = (List) obj5;
                    if (list2 != null) {
                        int size3 = list2.size();
                        int[] iArr2 = new int[size3];
                        Iterator it3 = list2.iterator();
                        int i7 = 0;
                        while (it3.hasNext()) {
                            int i8 = i7 + 1;
                            List list3 = (List) it3.next();
                            ygVar.a(12, list3.size(), 4);
                            int size4 = list3.size() + i2;
                            if (size4 >= 0) {
                                while (true) {
                                    int i9 = size4 - 1;
                                    PointF pointF = (PointF) list3.get(size4);
                                    float f = pointF.x;
                                    float f2 = pointF.y;
                                    it = it3;
                                    ygVar.d(4, 12);
                                    ygVar.a(0.0f);
                                    ygVar.a(f2);
                                    ygVar.a(f);
                                    ygVar.a.capacity();
                                    if (i9 < 0) {
                                        break;
                                    }
                                    size4 = i9;
                                    it3 = it;
                                }
                            } else {
                                it = it3;
                            }
                            int iB = ygVar.b();
                            ygVar.d(1);
                            ygVar.b(0, iB);
                            iArr2[i7] = ygVar.a();
                            i7 = i8;
                            it3 = it;
                            i2 = -1;
                        }
                        z = true;
                        ygVar.a(4, size3, 4);
                        for (int i10 = size3 - 1; -1 < i10; i10--) {
                            ygVar.a(iArr2[i10]);
                        }
                        sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.b()));
                    } else {
                        z = true;
                    }
                } else if (iIntValue == 1001 || iIntValue == 4000) {
                    z = z;
                    obj = k3Var.a.get(iIntValue);
                    if (obj == null) {
                        obj = null;
                    } else if (!(obj instanceof String)) {
                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(String.class).getSimpleName()).toString());
                    }
                    str = (String) obj;
                    if (str != null) {
                        sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.a(str)));
                    }
                } else {
                    if (iIntValue == 5001) {
                        Object obj6 = k3Var.a.get(iIntValue);
                        if (obj6 == null) {
                            obj6 = null;
                        } else if (!(obj6 instanceof List)) {
                            throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(List.class).getSimpleName()).toString());
                        }
                        List list4 = (List) obj6;
                        if (list4 != null) {
                            ygVar.a(32, list4.size(), 4);
                            int size5 = list4.size() - 1;
                            if (size5 >= 0) {
                                while (true) {
                                    int i11 = size5 - 1;
                                    fx fxVar = (fx) list4.get(size5);
                                    float f3 = fxVar.a;
                                    float f4 = fxVar.b;
                                    float f5 = fxVar.c;
                                    float f6 = fxVar.d;
                                    float f7 = fxVar.e;
                                    float f8 = fxVar.f;
                                    float f9 = fxVar.g;
                                    float f10 = fxVar.h;
                                    List list5 = list4;
                                    ygVar.d(4, 32);
                                    ygVar.a(f10);
                                    ygVar.a(f9);
                                    ygVar.a(f8);
                                    ygVar.a(f7);
                                    ygVar.a(f6);
                                    ygVar.a(f5);
                                    ygVar.a(f4);
                                    ygVar.a(f3);
                                    ygVar.a.capacity();
                                    if (i11 >= 0) {
                                        size5 = i11;
                                        list4 = list5;
                                    }
                                }
                            }
                            sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.b()));
                        }
                    } else if (iIntValue == 7002 || iIntValue == 8002) {
                        z = z;
                        obj = k3Var.a.get(iIntValue);
                        if (obj == null) {
                            obj = null;
                        } else if (!(obj instanceof String)) {
                            throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(String.class).getSimpleName()).toString());
                        }
                        str = (String) obj;
                        if (str != null) {
                            sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.a(str)));
                        }
                    } else if (iIntValue != 9001) {
                        if (iIntValue != 11002) {
                            if (iIntValue != 26 && iIntValue != 27) {
                                if (iIntValue != 102) {
                                    if (iIntValue != 103) {
                                        if (iIntValue != 3000) {
                                            if (iIntValue != 3001) {
                                                if (iIntValue != 6001 && iIntValue != 6002) {
                                                    switch (iIntValue) {
                                                        case 22:
                                                            z = z;
                                                            obj2 = k3Var.a.get(iIntValue);
                                                            if (obj2 == null) {
                                                                obj2 = null;
                                                            } else if (!(obj2 instanceof RectF)) {
                                                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(RectF.class).getSimpleName()).toString());
                                                            }
                                                            rectF = (RectF) obj2;
                                                            if (rectF != null) {
                                                                float f11 = rectF.left;
                                                                float f12 = rectF.bottom;
                                                                float f13 = rectF.right;
                                                                float f14 = rectF.top;
                                                                ygVar.d(4, 16);
                                                                ygVar.a(f14);
                                                                ygVar.a(f13);
                                                                ygVar.a(f12);
                                                                ygVar.a(f11);
                                                                numValueOf = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                                            } else {
                                                                numValueOf = null;
                                                            }
                                                            sparseArrayCompat.put(iIntValue, numValueOf);
                                                            break;
                                                    }
                                                }
                                            } else {
                                                Object obj7 = k3Var.a.get(iIntValue);
                                                if (obj7 == null) {
                                                    obj7 = obj3;
                                                } else if (!(obj7 instanceof p)) {
                                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(p.class).getSimpleName()).toString());
                                                }
                                                p pVar = (p) obj7;
                                                if (pVar != null) {
                                                    sparseArrayCompat.put(iIntValue, d.a(pVar, ygVar));
                                                }
                                            }
                                        } else {
                                            Object obj8 = k3Var.a.get(iIntValue);
                                            if (obj8 == null) {
                                                obj8 = obj3;
                                            } else if (!(obj8 instanceof Action)) {
                                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Action.class).getSimpleName()).toString());
                                            }
                                            Action action = (Action) obj8;
                                            if (action != null) {
                                                sparseArrayCompat.put(iIntValue, d.a(action, ygVar));
                                            }
                                        }
                                    } else {
                                        Object obj9 = k3Var.a.get(iIntValue);
                                        if (obj9 == null) {
                                            obj9 = obj3;
                                        } else if (!(obj9 instanceof List)) {
                                            throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(List.class).getSimpleName()).toString());
                                        }
                                        List list6 = (List) obj9;
                                        if (list6 != null) {
                                            ygVar.a(8, list6.size(), 4);
                                            int size6 = list6.size() - 1;
                                            if (size6 >= 0) {
                                                while (true) {
                                                    int i12 = size6 - 1;
                                                    PointF pointF2 = (PointF) list6.get(size6);
                                                    float f15 = pointF2.x;
                                                    float f16 = pointF2.y;
                                                    ygVar.d(4, 8);
                                                    ygVar.a(f16);
                                                    ygVar.a(f15);
                                                    ygVar.a.capacity();
                                                    if (i12 >= 0) {
                                                        size6 = i12;
                                                    }
                                                }
                                            }
                                            sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.b()));
                                        }
                                    }
                                } else {
                                    Object obj10 = k3Var.a.get(102);
                                    if (obj10 == null) {
                                        obj10 = obj3;
                                    } else if (!(obj10 instanceof List)) {
                                        throw new IllegalArgumentException(("Property with key 102 is not a " + Reflection.getOrCreateKotlinClass(List.class).getSimpleName()).toString());
                                    }
                                    List list7 = (List) obj10;
                                    if (list7 != null) {
                                        int size7 = list7.size();
                                        short[] sArr = new short[size7];
                                        int size8 = list7.size();
                                        for (int i13 = i; i13 < size8; i13++) {
                                            sArr[i13] = (short) ((LineEndType) list7.get(i13)).ordinal();
                                        }
                                        ygVar.a(2, size7, 2);
                                        for (int i14 = size7 - 1; -1 < i14; i14--) {
                                            short s = sArr[i14];
                                            ygVar.d(2, i);
                                            ygVar.a(s);
                                        }
                                        sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.b()));
                                    }
                                }
                            }
                            z = z;
                            obj = k3Var.a.get(iIntValue);
                            if (obj == null) {
                                obj = null;
                            } else if (!(obj instanceof String)) {
                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(String.class).getSimpleName()).toString());
                            }
                            str = (String) obj;
                            if (str != null) {
                                sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.a(str)));
                            }
                        } else {
                            Object obj11 = k3Var.a.get(iIntValue);
                            if (obj11 == null) {
                                obj11 = null;
                            } else if (!(obj11 instanceof Scale)) {
                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Scale.class).getSimpleName()).toString());
                            }
                            Scale scale = (Scale) obj11;
                            if (scale != null) {
                                String str2 = scale.fromDescription;
                                int iA = str2 != null ? ygVar.a(str2) : i;
                                String str3 = scale.toDescription;
                                int iA2 = str3 != null ? ygVar.a(str3) : i;
                                Scale.UnitFrom unitFrom = scale.unitFrom;
                                Short shValueOf = unitFrom != null ? Short.valueOf((short) unitFrom.ordinal()) : null;
                                shValueOf.getClass();
                                short sShortValue = shValueOf.shortValue();
                                Scale.UnitTo unitTo = scale.unitTo;
                                Short shValueOf2 = unitTo != null ? Short.valueOf((short) unitTo.ordinal()) : null;
                                shValueOf2.getClass();
                                short sShortValue2 = shValueOf2.shortValue();
                                float valueFrom = scale.getValueFrom();
                                float valueTo = scale.getValueTo();
                                ygVar.d(6);
                                ygVar.b(5, iA2);
                                ygVar.b(4, iA);
                                ygVar.a(3, valueTo);
                                ygVar.a(2, valueFrom);
                                ygVar.a(1, sShortValue2);
                                ygVar.a(0, sShortValue);
                                sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.a()));
                            }
                        }
                        z = z;
                    } else {
                        Object obj12 = k3Var.a.get(iIntValue);
                        if (obj12 == null) {
                            obj12 = null;
                        } else if (!(obj12 instanceof JSONObject)) {
                            throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(JSONObject.class).getSimpleName()).toString());
                        }
                        JSONObject jSONObject = (JSONObject) obj12;
                        if (jSONObject != null) {
                            try {
                                int iA3 = ygVar.a(jSONObject.toString(0));
                                ygVar.d(1);
                                ygVar.b(0, iA3);
                                sparseArrayCompat.put(iIntValue, Integer.valueOf(ygVar.a()));
                            } catch (JSONException e) {
                                PdfLog.d("Nutri.FlatbuffWrite", e, "Can't serialize annotation custom data to string", new Object[0]);
                            }
                        }
                    }
                    z = true;
                }
            } else {
                z = z;
                obj2 = k3Var.a.get(iIntValue);
                if (obj2 == null) {
                    obj2 = null;
                } else if (!(obj2 instanceof RectF)) {
                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(RectF.class).getSimpleName()).toString());
                }
                rectF = (RectF) obj2;
                if (rectF != null) {
                    float f17 = rectF.left;
                    float f18 = rectF.bottom;
                    float f19 = rectF.right;
                    float f110 = rectF.top;
                    ygVar.d(4, 16);
                    ygVar.a(f110);
                    ygVar.a(f19);
                    ygVar.a(f18);
                    ygVar.a(f17);
                    numValueOf = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                } else {
                    numValueOf = null;
                }
                sparseArrayCompat.put(iIntValue, numValueOf);
            }
            if (sparseArrayCompat.indexOfKey(iIntValue) < 0 || sparseArrayCompat.get(iIntValue) == null) {
                sparseArrayCompat.put(iIntValue, 0);
                i = 0;
                obj3 = null;
            } else {
                obj3 = null;
                i = 0;
            }
        }
        return sparseArrayCompat;
    }

    public static final synchronized int b(k3 k3Var, yg ygVar) {
        k3Var.getClass();
        Set<Integer> setC = k3Var.c();
        SparseArrayCompat<Object> sparseArrayCompatA = a(k3Var, ygVar, setC);
        ygVar.d(78);
        ygVar.c();
        Iterator<Integer> it = setC.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue == 0 || iIntValue == 1) {
                Unit unit = Unit.INSTANCE;
            } else if (iIntValue == 2) {
                if (k3Var.a(iIntValue)) {
                    Object obj = sparseArrayCompatA.get(iIntValue);
                    obj.getClass();
                    ygVar.b(48, ((Integer) obj).intValue());
                }
                Unit unit2 = Unit.INSTANCE;
            } else if (iIntValue == 3) {
                if (k3Var.a(iIntValue)) {
                    Object obj2 = sparseArrayCompatA.get(iIntValue);
                    obj2.getClass();
                    ygVar.b(43, ((Integer) obj2).intValue());
                }
                Unit unit3 = Unit.INSTANCE;
            } else if (iIntValue == 4) {
                if (k3Var.a(iIntValue)) {
                    Object obj3 = sparseArrayCompatA.get(iIntValue);
                    obj3.getClass();
                    ygVar.b(45, ((Integer) obj3).intValue());
                }
                Unit unit4 = Unit.INSTANCE;
            } else if (iIntValue == 5) {
                if (k3Var.a(iIntValue)) {
                    Object obj4 = sparseArrayCompatA.get(iIntValue);
                    obj4.getClass();
                    ygVar.b(44, ((Integer) obj4).intValue());
                }
                Unit unit5 = Unit.INSTANCE;
            } else if (iIntValue != 6) {
                Integer numValueOf = null;
                Object obj5 = null;
                Object obj6 = null;
                Integer numValueOf2 = null;
                Integer numValueOf3 = null;
                Object obj7 = null;
                Integer numValueOf4 = null;
                Object obj8 = null;
                Long lValueOf = null;
                Integer numValueOf5 = null;
                Integer numValueOf6 = null;
                Integer numValueOf7 = null;
                Integer numValueOf8 = null;
                Integer numValueOf9 = null;
                Integer numValueOf10 = null;
                Object obj9 = null;
                Integer numValueOf11 = null;
                Long lValueOf2 = null;
                Integer numValueOf12 = null;
                Object obj10 = null;
                if (iIntValue != 7) {
                    if (iIntValue == 3000) {
                        if (k3Var.a(iIntValue)) {
                            Object obj11 = sparseArrayCompatA.get(iIntValue);
                            obj11.getClass();
                            ygVar.b(12, ((Integer) obj11).intValue());
                        }
                        Unit unit6 = Unit.INSTANCE;
                    } else if (iIntValue == 3001) {
                        if (k3Var.a(iIntValue)) {
                            Object obj12 = sparseArrayCompatA.get(iIntValue);
                            obj12.getClass();
                            ygVar.b(13, ((Integer) obj12).intValue());
                        }
                        Unit unit7 = Unit.INSTANCE;
                    } else if (iIntValue == 4000) {
                        Object obj13 = k3Var.d().get(iIntValue);
                        if (obj13 != null) {
                            if (!(obj13 instanceof String)) {
                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(String.class).getSimpleName()).toString());
                            }
                            obj5 = obj13;
                        }
                        if (obj5 != null) {
                            Object obj14 = sparseArrayCompatA.get(iIntValue);
                            obj14.getClass();
                            ygVar.b(14, ((Integer) obj14).intValue());
                        }
                        Unit unit8 = Unit.INSTANCE;
                    } else if (iIntValue == 4001) {
                        Object obj15 = Boolean.FALSE;
                        Object obj16 = k3Var.d().get(iIntValue);
                        if (obj16 != null) {
                            if (!(obj16 instanceof Boolean)) {
                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Boolean.class).getSimpleName()).toString());
                            }
                            obj15 = obj16;
                        }
                        boolean zBooleanValue = ((Boolean) obj15).booleanValue();
                        if (ygVar.l || zBooleanValue) {
                            ygVar.d(1, 0);
                            ByteBuffer byteBuffer = ygVar.a;
                            int i = ygVar.b - 1;
                            ygVar.b = i;
                            byteBuffer.put(i, zBooleanValue ? (byte) 1 : (byte) 0);
                            ygVar.c(56);
                        }
                        Unit unit9 = Unit.INSTANCE;
                    } else if (iIntValue == 6001) {
                        if (k3Var.a(iIntValue)) {
                            Object obj17 = sparseArrayCompatA.get(iIntValue);
                            obj17.getClass();
                            ygVar.b(47, ((Integer) obj17).intValue());
                        }
                        Unit unit10 = Unit.INSTANCE;
                    } else if (iIntValue != 6002) {
                        long jOrdinal = 0;
                        switch (iIntValue) {
                            case 7:
                                break;
                            case 8:
                                Object obj18 = k3Var.d().get(iIntValue);
                                if (obj18 == null) {
                                    obj18 = null;
                                } else if (!(obj18 instanceof Date)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Date.class).getSimpleName()).toString());
                                }
                                Date date = (Date) obj18;
                                if (date != null) {
                                    long jM14954constructorimpl = ULong.m14954constructorimpl(date.getTime() / ((long) 1000));
                                    ygVar.d(8, 8);
                                    ygVar.a(jM14954constructorimpl);
                                    numValueOf10 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                }
                                if (numValueOf10 == null) {
                                    continue;
                                } else {
                                    ygVar.c(50, numValueOf10.intValue());
                                    Unit unit11 = Unit.INSTANCE;
                                }
                                break;
                            case 9:
                                Object obj19 = k3Var.d().get(iIntValue);
                                if (obj19 == null) {
                                    obj19 = null;
                                } else if (!(obj19 instanceof RectF)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(RectF.class).getSimpleName()).toString());
                                }
                                RectF rectF = (RectF) obj19;
                                if (rectF != null) {
                                    float f = rectF.left;
                                    float f2 = rectF.bottom;
                                    float f3 = rectF.right;
                                    float f4 = rectF.top;
                                    ygVar.d(4, 16);
                                    ygVar.a(f4);
                                    ygVar.a(f3);
                                    ygVar.a(f2);
                                    ygVar.a(f);
                                    numValueOf9 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                }
                                if (numValueOf9 == null) {
                                    continue;
                                } else {
                                    ygVar.c(7, numValueOf9.intValue());
                                    Unit unit12 = Unit.INSTANCE;
                                }
                                break;
                            case 10:
                                Object obj20 = k3Var.d().get(iIntValue);
                                if (obj20 == null) {
                                    obj20 = null;
                                } else if (!(obj20 instanceof Integer)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                }
                                Integer num = (Integer) obj20;
                                if (num != null) {
                                    int iM14875constructorimpl = UInt.m14875constructorimpl(num.intValue());
                                    ygVar.d(4, 4);
                                    ygVar.b(iM14875constructorimpl);
                                    numValueOf8 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                }
                                if (numValueOf8 == null) {
                                    continue;
                                } else {
                                    ygVar.c(15, numValueOf8.intValue());
                                    Unit unit13 = Unit.INSTANCE;
                                }
                                break;
                            case 11:
                                Object obj21 = k3Var.d().get(iIntValue);
                                if (obj21 == null) {
                                    obj21 = null;
                                } else if (!(obj21 instanceof Integer)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                }
                                Integer num2 = (Integer) obj21;
                                if (num2 != null) {
                                    int iM14875constructorimpl2 = UInt.m14875constructorimpl(num2.intValue());
                                    ygVar.d(4, 4);
                                    ygVar.b(iM14875constructorimpl2);
                                    numValueOf7 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                }
                                if (numValueOf7 == null) {
                                    continue;
                                } else {
                                    ygVar.c(17, numValueOf7.intValue());
                                    Unit unit14 = Unit.INSTANCE;
                                }
                                break;
                            case 12:
                                Object obj22 = k3Var.d().get(iIntValue);
                                if (obj22 == null) {
                                    obj22 = null;
                                } else if (!(obj22 instanceof Float)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Float.class).getSimpleName()).toString());
                                }
                                Float f5 = (Float) obj22;
                                if (f5 != null) {
                                    float fFloatValue = f5.floatValue();
                                    ygVar.d(4, 4);
                                    ygVar.a(fFloatValue);
                                    numValueOf6 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                }
                                if (numValueOf6 == null) {
                                    continue;
                                } else {
                                    ygVar.c(21, numValueOf6.intValue());
                                    Unit unit15 = Unit.INSTANCE;
                                }
                                break;
                            case 13:
                                Object obj23 = k3Var.d().get(iIntValue);
                                if (obj23 == null) {
                                    obj23 = null;
                                } else if (!(obj23 instanceof Integer)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                }
                                Integer num3 = (Integer) obj23;
                                if (num3 != null) {
                                    int iM14875constructorimpl3 = UInt.m14875constructorimpl(num3.intValue());
                                    ygVar.d(4, 4);
                                    ygVar.b(iM14875constructorimpl3);
                                    numValueOf5 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                }
                                if (numValueOf5 == null) {
                                    continue;
                                } else {
                                    ygVar.c(16, numValueOf5.intValue());
                                    Unit unit16 = Unit.INSTANCE;
                                }
                                break;
                            case 14:
                                Object obj24 = k3Var.d().get(iIntValue);
                                if (obj24 == null) {
                                    obj24 = null;
                                } else if (!(obj24 instanceof BorderStyle)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(BorderStyle.class).getSimpleName()).toString());
                                }
                                Enum r6 = (Enum) obj24;
                                Short shValueOf = r6 != null ? Short.valueOf((short) r6.ordinal()) : null;
                                if (shValueOf == null) {
                                    continue;
                                } else {
                                    ygVar.a(24, shValueOf.shortValue());
                                    Unit unit17 = Unit.INSTANCE;
                                }
                                break;
                            case 15:
                                Object obj25 = sparseArrayCompatA.get(iIntValue);
                                obj25.getClass();
                                ygVar.b(23, ((Integer) obj25).intValue());
                                Unit unit18 = Unit.INSTANCE;
                                continue;
                            case 16:
                                Object obj26 = k3Var.d().get(iIntValue);
                                if (obj26 == null) {
                                    obj26 = null;
                                } else if (!(obj26 instanceof EnumSet)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(EnumSet.class).getSimpleName()).toString());
                                }
                                EnumSet enumSet = (EnumSet) obj26;
                                if (enumSet != null) {
                                    if (enumSet.isEmpty()) {
                                        lValueOf = 0L;
                                    } else {
                                        Iterator it2 = enumSet.iterator();
                                        it2.getClass();
                                        while (it2.hasNext()) {
                                            Enum r7 = (Enum) it2.next();
                                            r7.getClass();
                                            jOrdinal |= (long) (1 << r7.ordinal());
                                        }
                                        lValueOf = Long.valueOf(jOrdinal);
                                    }
                                }
                                if (lValueOf == null) {
                                    continue;
                                } else {
                                    ygVar.a(51, ULong.m14954constructorimpl(lValueOf.longValue()));
                                    Unit unit19 = Unit.INSTANCE;
                                }
                                break;
                            case 17:
                                Object obj27 = 0;
                                Object obj28 = k3Var.d().get(iIntValue);
                                if (obj28 != null) {
                                    if (!(obj28 instanceof Integer)) {
                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                    }
                                    obj27 = obj28;
                                }
                                ygVar.a(67, ((Number) obj27).intValue());
                                Unit unit20 = Unit.INSTANCE;
                                continue;
                            case 18:
                                if (k3Var.a(iIntValue)) {
                                    Object obj29 = 0;
                                    Object obj30 = k3Var.d().get(iIntValue);
                                    if (obj30 != null) {
                                        if (!(obj30 instanceof Integer)) {
                                            throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                        }
                                        obj29 = obj30;
                                    }
                                    ygVar.a(2, ((Number) obj29).intValue());
                                }
                                Unit unit21 = Unit.INSTANCE;
                                continue;
                            case 19:
                                Object obj31 = k3Var.d().get(iIntValue);
                                if (obj31 != null) {
                                    if (!(obj31 instanceof AuthorState)) {
                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(AuthorState.class).getSimpleName()).toString());
                                    }
                                    obj8 = obj31;
                                }
                                Enum r13 = (Enum) obj8;
                                AuthorState authorState = AuthorState.NONE;
                                authorState.getClass();
                                ygVar.a(68, (short) (r13 != null ? r13.ordinal() : authorState.ordinal()));
                                Unit unit22 = Unit.INSTANCE;
                                continue;
                            case 20:
                                if (k3Var.a(iIntValue)) {
                                    Object obj32 = sparseArrayCompatA.get(iIntValue);
                                    obj32.getClass();
                                    ygVar.b(4, ((Integer) obj32).intValue());
                                }
                                Unit unit23 = Unit.INSTANCE;
                                continue;
                            case 21:
                                if (k3Var.a(iIntValue)) {
                                    Object obj33 = sparseArrayCompatA.get(iIntValue);
                                    obj33.getClass();
                                    ygVar.b(66, ((Integer) obj33).intValue());
                                }
                                Unit unit24 = Unit.INSTANCE;
                                continue;
                            case 22:
                                Object obj34 = k3Var.d().get(iIntValue);
                                if (obj34 == null) {
                                    obj34 = null;
                                } else if (!(obj34 instanceof RectF)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(RectF.class).getSimpleName()).toString());
                                }
                                RectF rectF2 = (RectF) obj34;
                                if (rectF2 != null) {
                                    float f6 = rectF2.left;
                                    float f7 = rectF2.bottom;
                                    float f8 = rectF2.right;
                                    float f9 = rectF2.top;
                                    ygVar.d(4, 16);
                                    ygVar.a(f9);
                                    ygVar.a(f8);
                                    ygVar.a(f7);
                                    ygVar.a(f6);
                                    numValueOf4 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                }
                                if (numValueOf4 == null) {
                                    continue;
                                } else {
                                    ygVar.c(8, numValueOf4.intValue());
                                    Unit unit25 = Unit.INSTANCE;
                                }
                                break;
                            case 23:
                                Object obj35 = k3Var.d().get(iIntValue);
                                if (obj35 == null) {
                                    obj35 = null;
                                } else if (!(obj35 instanceof BlendMode)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(BlendMode.class).getSimpleName()).toString());
                                }
                                Enum r8 = (Enum) obj35;
                                Short shValueOf2 = r8 != null ? Short.valueOf((short) r8.ordinal()) : null;
                                if (shValueOf2 == null) {
                                    continue;
                                } else {
                                    ygVar.a(22, shValueOf2.shortValue());
                                    Unit unit26 = Unit.INSTANCE;
                                }
                                break;
                            case 24:
                                Object obj36 = k3Var.d().get(iIntValue);
                                if (obj36 == null) {
                                    obj36 = null;
                                } else if (!(obj36 instanceof BorderEffect)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(BorderEffect.class).getSimpleName()).toString());
                                }
                                Enum r9 = (Enum) obj36;
                                Short shValueOf3 = r9 != null ? Short.valueOf((short) r9.ordinal()) : null;
                                if (shValueOf3 == null) {
                                    continue;
                                } else {
                                    ygVar.a(25, shValueOf3.shortValue());
                                    Unit unit27 = Unit.INSTANCE;
                                }
                                break;
                            case 25:
                                Object obj37 = k3Var.d().get(iIntValue);
                                if (obj37 != null) {
                                    if (!(obj37 instanceof Float)) {
                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Float.class).getSimpleName()).toString());
                                    }
                                    obj7 = obj37;
                                }
                                Float f10 = (Float) obj7;
                                if (f10 == null) {
                                    continue;
                                } else {
                                    ygVar.a(26, f10.floatValue());
                                    Unit unit28 = Unit.INSTANCE;
                                }
                                break;
                            case 26:
                                if (k3Var.a(iIntValue)) {
                                    Object obj38 = sparseArrayCompatA.get(iIntValue);
                                    obj38.getClass();
                                    ygVar.b(40, ((Integer) obj38).intValue());
                                }
                                Unit unit29 = Unit.INSTANCE;
                                continue;
                            case 27:
                                if (k3Var.a(iIntValue)) {
                                    Object obj39 = sparseArrayCompatA.get(iIntValue);
                                    obj39.getClass();
                                    ygVar.b(41, ((Integer) obj39).intValue());
                                }
                                Unit unit30 = Unit.INSTANCE;
                                continue;
                            case 28:
                                Object obj40 = k3Var.d().get(iIntValue);
                                if (obj40 == null) {
                                    obj40 = null;
                                } else if (!(obj40 instanceof Float)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Float.class).getSimpleName()).toString());
                                }
                                Float f11 = (Float) obj40;
                                if (f11 != null) {
                                    float fFloatValue2 = f11.floatValue();
                                    ygVar.d(4, 4);
                                    ygVar.a(fFloatValue2);
                                    numValueOf3 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                }
                                if (numValueOf3 == null) {
                                    continue;
                                } else {
                                    ygVar.c(75, numValueOf3.intValue());
                                    Unit unit31 = Unit.INSTANCE;
                                }
                                break;
                            case 29:
                                Object obj41 = k3Var.d().get(iIntValue);
                                if (obj41 == null) {
                                    obj41 = null;
                                } else if (!(obj41 instanceof Float)) {
                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Float.class).getSimpleName()).toString());
                                }
                                Float f12 = (Float) obj41;
                                if (f12 != null) {
                                    float fFloatValue3 = f12.floatValue();
                                    ygVar.d(4, 4);
                                    ygVar.a(fFloatValue3);
                                    numValueOf2 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                }
                                if (numValueOf2 == null) {
                                    continue;
                                } else {
                                    ygVar.c(76, numValueOf2.intValue());
                                    Unit unit32 = Unit.INSTANCE;
                                }
                                break;
                            case 2000:
                                Object obj42 = Boolean.FALSE;
                                Object obj43 = k3Var.d().get(iIntValue);
                                if (obj43 != null) {
                                    if (!(obj43 instanceof Boolean)) {
                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Boolean.class).getSimpleName()).toString());
                                    }
                                    obj42 = obj43;
                                }
                                boolean zBooleanValue2 = ((Boolean) obj42).booleanValue();
                                if (ygVar.l || zBooleanValue2) {
                                    ygVar.d(1, 0);
                                    ByteBuffer byteBuffer2 = ygVar.a;
                                    int i2 = ygVar.b - 1;
                                    ygVar.b = i2;
                                    byteBuffer2.put(i2, zBooleanValue2 ? (byte) 1 : (byte) 0);
                                    ygVar.c(54);
                                }
                                Unit unit33 = Unit.INSTANCE;
                                continue;
                            case PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED /* 5001 */:
                                Object obj44 = sparseArrayCompatA.get(iIntValue);
                                obj44.getClass();
                                ygVar.b(9, ((Integer) obj44).intValue());
                                Unit unit34 = Unit.INSTANCE;
                                continue;
                            case 9001:
                                if (k3Var.a(iIntValue)) {
                                    Object obj45 = sparseArrayCompatA.get(iIntValue);
                                    obj45.getClass();
                                    ygVar.b(5, ((Integer) obj45).intValue());
                                }
                                Unit unit35 = Unit.INSTANCE;
                                continue;
                            case 11001:
                                Object obj46 = k3Var.d().get(iIntValue);
                                if (obj46 != null) {
                                    if (!(obj46 instanceof MeasurementPrecision)) {
                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(MeasurementPrecision.class).getSimpleName()).toString());
                                    }
                                    obj6 = obj46;
                                }
                                Integer numA = zg.a((MeasurementPrecision) obj6, ygVar);
                                if (numA == null) {
                                    continue;
                                } else {
                                    ygVar.c(74, numA.intValue());
                                    Unit unit36 = Unit.INSTANCE;
                                }
                                break;
                            case 11002:
                                if (k3Var.a(iIntValue)) {
                                    Object obj47 = sparseArrayCompatA.get(iIntValue);
                                    obj47.getClass();
                                    ygVar.b(73, ((Integer) obj47).intValue());
                                }
                                Unit unit37 = Unit.INSTANCE;
                                continue;
                            case 12001:
                                Object obj48 = Boolean.FALSE;
                                Object obj49 = k3Var.d().get(iIntValue);
                                if (obj49 != null) {
                                    if (!(obj49 instanceof Boolean)) {
                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Boolean.class).getSimpleName()).toString());
                                    }
                                    obj48 = obj49;
                                }
                                if (((Boolean) obj48).booleanValue()) {
                                    ygVar.d(1, 1);
                                    ByteBuffer byteBuffer3 = ygVar.a;
                                    int i3 = ygVar.b - 1;
                                    ygVar.b = i3;
                                    byteBuffer3.put(i3, (byte) 1);
                                    ygVar.c(77, ygVar.a.capacity() - ygVar.b);
                                }
                                Unit unit38 = Unit.INSTANCE;
                                continue;
                            default:
                                switch (iIntValue) {
                                    case 100:
                                        Object obj50 = sparseArrayCompatA.get(iIntValue);
                                        obj50.getClass();
                                        ygVar.b(11, ((Integer) obj50).intValue());
                                        Unit unit39 = Unit.INSTANCE;
                                        break;
                                    case 101:
                                        Object objValueOf = Float.valueOf(0.0f);
                                        Object obj51 = k3Var.d().get(iIntValue);
                                        if (obj51 != null) {
                                            if (!(obj51 instanceof Float)) {
                                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Float.class).getSimpleName()).toString());
                                            }
                                            objValueOf = obj51;
                                        }
                                        ygVar.a(20, ((Number) objValueOf).floatValue());
                                        Unit unit40 = Unit.INSTANCE;
                                        break;
                                    case 102:
                                        Object obj52 = sparseArrayCompatA.get(iIntValue);
                                        obj52.getClass();
                                        ygVar.b(36, ((Integer) obj52).intValue());
                                        Unit unit41 = Unit.INSTANCE;
                                        break;
                                    case 103:
                                        Object obj53 = sparseArrayCompatA.get(iIntValue);
                                        obj53.getClass();
                                        ygVar.b(10, ((Integer) obj53).intValue());
                                        Unit unit42 = Unit.INSTANCE;
                                        break;
                                    case 104:
                                        Object obj54 = (byte) 0;
                                        Object obj55 = k3Var.d().get(iIntValue);
                                        if (obj55 != null) {
                                            if (!(obj55 instanceof Byte)) {
                                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Byte.class).getSimpleName()).toString());
                                            }
                                            obj54 = obj55;
                                        }
                                        ygVar.a(38, ((Number) obj54).byteValue());
                                        Unit unit43 = Unit.INSTANCE;
                                        break;
                                    case 105:
                                        Object obj56 = (byte) 0;
                                        Object obj57 = k3Var.d().get(iIntValue);
                                        if (obj57 != null) {
                                            if (!(obj57 instanceof Byte)) {
                                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Byte.class).getSimpleName()).toString());
                                            }
                                            obj56 = obj57;
                                        }
                                        ygVar.a(39, ((Number) obj56).byteValue());
                                        Unit unit44 = Unit.INSTANCE;
                                        continue;
                                    default:
                                        switch (iIntValue) {
                                            case 1000:
                                                Object obj58 = 0;
                                                Object obj59 = k3Var.d().get(iIntValue);
                                                if (obj59 != null) {
                                                    if (!(obj59 instanceof Integer)) {
                                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                                    }
                                                    obj58 = obj59;
                                                }
                                                ygVar.a(55, (byte) ((Number) obj58).intValue());
                                                Unit unit45 = Unit.INSTANCE;
                                                break;
                                            case 1001:
                                                if (k3Var.a(iIntValue)) {
                                                    Object obj60 = sparseArrayCompatA.get(iIntValue);
                                                    obj60.getClass();
                                                    ygVar.b(29, ((Integer) obj60).intValue());
                                                }
                                                Unit unit46 = Unit.INSTANCE;
                                                break;
                                            case 1002:
                                                Object objValueOf2 = Float.valueOf(0.0f);
                                                Object obj61 = k3Var.d().get(iIntValue);
                                                if (obj61 != null) {
                                                    if (!(obj61 instanceof Float)) {
                                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Float.class).getSimpleName()).toString());
                                                    }
                                                    objValueOf2 = obj61;
                                                }
                                                ygVar.a(30, ((Number) objValueOf2).floatValue());
                                                Unit unit47 = Unit.INSTANCE;
                                                break;
                                            default:
                                                switch (iIntValue) {
                                                    case 1004:
                                                        Object obj62 = k3Var.d().get(iIntValue);
                                                        if (obj62 == null) {
                                                            obj62 = null;
                                                        } else if (!(obj62 instanceof Integer)) {
                                                            throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                                        }
                                                        Integer num4 = (Integer) obj62;
                                                        if (num4 != null) {
                                                            int iM14875constructorimpl4 = UInt.m14875constructorimpl(num4.intValue());
                                                            ygVar.d(4, 4);
                                                            ygVar.b(iM14875constructorimpl4);
                                                            numValueOf11 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                                        }
                                                        if (numValueOf11 != null) {
                                                            ygVar.c(19, numValueOf11.intValue());
                                                            Unit unit48 = Unit.INSTANCE;
                                                        }
                                                        break;
                                                    case 1005:
                                                        Object obj63 = (byte) 0;
                                                        Object obj64 = k3Var.d().get(iIntValue);
                                                        if (obj64 != null) {
                                                            if (!(obj64 instanceof Byte)) {
                                                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Byte.class).getSimpleName()).toString());
                                                            }
                                                            obj63 = obj64;
                                                        }
                                                        ygVar.a(32, ((Number) obj63).byteValue());
                                                        Unit unit49 = Unit.INSTANCE;
                                                        break;
                                                    case 1006:
                                                        Object obj65 = (byte) 0;
                                                        Object obj66 = k3Var.d().get(iIntValue);
                                                        if (obj66 != null) {
                                                            if (!(obj66 instanceof Byte)) {
                                                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Byte.class).getSimpleName()).toString());
                                                            }
                                                            obj65 = obj66;
                                                        }
                                                        ygVar.a(31, ((Number) obj65).byteValue());
                                                        Unit unit50 = Unit.INSTANCE;
                                                        break;
                                                    case 1007:
                                                        Object obj67 = k3Var.d().get(iIntValue);
                                                        if (obj67 != null) {
                                                            if (!(obj67 instanceof EdgeInsets)) {
                                                                throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(EdgeInsets.class).getSimpleName()).toString());
                                                            }
                                                            obj9 = obj67;
                                                        }
                                                        EdgeInsets edgeInsets = (EdgeInsets) obj9;
                                                        if (edgeInsets != null) {
                                                            ygVar.c(35, a(edgeInsets, ygVar));
                                                            Unit unit51 = Unit.INSTANCE;
                                                        }
                                                        break;
                                                    default:
                                                        switch (iIntValue) {
                                                            case 7000:
                                                                Object objValueOf3 = Integer.valueOf(MediaWindowType.USE_ANNOTATION_RECTANGLE.ordinal());
                                                                Object obj68 = k3Var.d().get(iIntValue);
                                                                if (obj68 != null) {
                                                                    if (!(obj68 instanceof Integer)) {
                                                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                                                    }
                                                                    objValueOf3 = obj68;
                                                                }
                                                                ygVar.a(63, ((Number) objValueOf3).intValue());
                                                                Unit unit52 = Unit.INSTANCE;
                                                                break;
                                                            case PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED /* 7001 */:
                                                                Object obj69 = k3Var.d().get(iIntValue);
                                                                if (obj69 == null) {
                                                                    obj69 = null;
                                                                } else if (!(obj69 instanceof EnumSet)) {
                                                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(EnumSet.class).getSimpleName()).toString());
                                                                }
                                                                EnumSet enumSet2 = (EnumSet) obj69;
                                                                if (enumSet2 != null) {
                                                                    if (enumSet2.isEmpty()) {
                                                                        lValueOf2 = 0L;
                                                                    } else {
                                                                        Iterator it3 = enumSet2.iterator();
                                                                        it3.getClass();
                                                                        while (it3.hasNext()) {
                                                                            Enum r10 = (Enum) it3.next();
                                                                            r10.getClass();
                                                                            jOrdinal |= (long) (1 << r10.ordinal());
                                                                        }
                                                                        lValueOf2 = Long.valueOf(jOrdinal);
                                                                    }
                                                                }
                                                                if (lValueOf2 != null) {
                                                                    ygVar.a(64, (int) lValueOf2.longValue());
                                                                    Unit unit53 = Unit.INSTANCE;
                                                                }
                                                                break;
                                                            case 7002:
                                                                Object obj70 = sparseArrayCompatA.get(iIntValue);
                                                                obj70.getClass();
                                                                ygVar.b(61, ((Integer) obj70).intValue());
                                                                Unit unit54 = Unit.INSTANCE;
                                                                break;
                                                            case 7003:
                                                                Object obj71 = 0;
                                                                Object obj72 = k3Var.d().get(iIntValue);
                                                                if (obj72 != null) {
                                                                    if (!(obj72 instanceof Integer)) {
                                                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                                                    }
                                                                    obj71 = obj72;
                                                                }
                                                                ygVar.b(62, ((Number) obj71).intValue());
                                                                Unit unit55 = Unit.INSTANCE;
                                                                break;
                                                            default:
                                                                switch (iIntValue) {
                                                                    case 8001:
                                                                        Object obj73 = k3Var.d().get(iIntValue);
                                                                        if (obj73 == null) {
                                                                            obj73 = null;
                                                                        } else if (!(obj73 instanceof Integer)) {
                                                                            throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                                                        }
                                                                        Integer num5 = (Integer) obj73;
                                                                        if (num5 != null) {
                                                                            int iM14875constructorimpl5 = UInt.m14875constructorimpl(num5.intValue());
                                                                            ygVar.d(4, 4);
                                                                            ygVar.b(iM14875constructorimpl5);
                                                                            numValueOf12 = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                                                                        }
                                                                        if (numValueOf12 != null) {
                                                                            ygVar.c(70, numValueOf12.intValue());
                                                                            Unit unit56 = Unit.INSTANCE;
                                                                        }
                                                                        break;
                                                                    case 8002:
                                                                        if (k3Var.a(iIntValue)) {
                                                                            Object obj74 = sparseArrayCompatA.get(iIntValue);
                                                                            obj74.getClass();
                                                                            ygVar.b(71, ((Integer) obj74).intValue());
                                                                        }
                                                                        Unit unit57 = Unit.INSTANCE;
                                                                        break;
                                                                    case 8003:
                                                                        if (k3Var.a(iIntValue)) {
                                                                            Object obj75 = Boolean.FALSE;
                                                                            Object obj76 = k3Var.d().get(iIntValue);
                                                                            if (obj76 != null) {
                                                                                if (!(obj76 instanceof Boolean)) {
                                                                                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Boolean.class).getSimpleName()).toString());
                                                                                }
                                                                                obj75 = obj76;
                                                                            }
                                                                            boolean zBooleanValue3 = ((Boolean) obj75).booleanValue();
                                                                            if (ygVar.l || zBooleanValue3) {
                                                                                ygVar.d(1, 0);
                                                                                ByteBuffer byteBuffer4 = ygVar.a;
                                                                                int i4 = ygVar.b - 1;
                                                                                ygVar.b = i4;
                                                                                byteBuffer4.put(i4, zBooleanValue3 ? (byte) 1 : (byte) 0);
                                                                                ygVar.c(72);
                                                                            }
                                                                        }
                                                                        Unit unit58 = Unit.INSTANCE;
                                                                        break;
                                                                    default:
                                                                        switch (iIntValue) {
                                                                            case CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB /* 10001 */:
                                                                                Object obj77 = 0;
                                                                                Object obj78 = k3Var.d().get(iIntValue);
                                                                                if (obj78 != null) {
                                                                                    if (!(obj78 instanceof Integer)) {
                                                                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                                                                    }
                                                                                    obj77 = obj78;
                                                                                }
                                                                                ygVar.a(59, ((Number) obj77).intValue());
                                                                                Unit unit59 = Unit.INSTANCE;
                                                                                break;
                                                                            case CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR /* 10002 */:
                                                                                Object obj79 = 0;
                                                                                Object obj80 = k3Var.d().get(iIntValue);
                                                                                if (obj80 != null) {
                                                                                    if (!(obj80 instanceof Integer)) {
                                                                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                                                                    }
                                                                                    obj79 = obj80;
                                                                                }
                                                                                ygVar.a(57, ((Number) obj79).intValue());
                                                                                Unit unit60 = Unit.INSTANCE;
                                                                                break;
                                                                            case 10003:
                                                                                Object obj81 = 0;
                                                                                Object obj82 = k3Var.d().get(iIntValue);
                                                                                if (obj82 != null) {
                                                                                    if (!(obj82 instanceof Integer)) {
                                                                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
                                                                                    }
                                                                                    obj81 = obj82;
                                                                                }
                                                                                ygVar.a(58, ((Number) obj81).intValue());
                                                                                Unit unit61 = Unit.INSTANCE;
                                                                                break;
                                                                            case 10004:
                                                                                Object obj83 = k3Var.d().get(iIntValue);
                                                                                if (obj83 != null) {
                                                                                    if (!(obj83 instanceof AudioEncoding)) {
                                                                                        throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(AudioEncoding.class).getSimpleName()).toString());
                                                                                    }
                                                                                    obj10 = obj83;
                                                                                }
                                                                                Enum r14 = (Enum) obj10;
                                                                                AudioEncoding audioEncoding = AudioEncoding.SIGNED;
                                                                                audioEncoding.getClass();
                                                                                ygVar.a(60, (int) ((short) (r14 != null ? r14.ordinal() : audioEncoding.ordinal())));
                                                                                Unit unit62 = Unit.INSTANCE;
                                                                                break;
                                                                            default:
                                                                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                                                                throw new IllegalArgumentException(String.format(Locale.US, "Field implementation missing (%d), implement field conversion!", Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue)}, 1)));
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                    } else {
                        if (k3Var.a(iIntValue)) {
                            Object obj84 = sparseArrayCompatA.get(iIntValue);
                            obj84.getClass();
                            ygVar.b(46, ((Integer) obj84).intValue());
                        }
                        Unit unit63 = Unit.INSTANCE;
                    }
                }
                Object obj85 = k3Var.d().get(iIntValue);
                if (obj85 == null) {
                    obj85 = null;
                } else if (!(obj85 instanceof Date)) {
                    throw new IllegalArgumentException(("Property with key " + iIntValue + " is not a " + Reflection.getOrCreateKotlinClass(Date.class).getSimpleName()).toString());
                }
                Date date2 = (Date) obj85;
                if (date2 != null) {
                    long jM14954constructorimpl2 = ULong.m14954constructorimpl(date2.getTime() / ((long) 1000));
                    ygVar.d(8, 8);
                    ygVar.a(jM14954constructorimpl2);
                    numValueOf = Integer.valueOf(ygVar.a.capacity() - ygVar.b);
                }
                if (numValueOf != null) {
                    ygVar.c(49, numValueOf.intValue());
                    Unit unit64 = Unit.INSTANCE;
                }
            } else {
                if (k3Var.a(iIntValue)) {
                    Object obj86 = sparseArrayCompatA.get(iIntValue);
                    obj86.getClass();
                    ygVar.b(52, ((Integer) obj86).intValue());
                }
                Unit unit65 = Unit.INSTANCE;
            }
        }
        return ygVar.a();
    }

    public static final synchronized int a(k3 k3Var, yg ygVar) {
        k3Var.getClass();
        int iA = ygVar.a("");
        ygVar.d(78);
        Iterator<Integer> it = k3Var.c().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (!k3Var.a(iIntValue)) {
                if (iIntValue == 15) {
                    ygVar.b(23, iA);
                } else if (iIntValue == 22) {
                    ygVar.c(8, iA);
                } else if (iIntValue == 1001) {
                    ygVar.b(29, iA);
                } else if (iIntValue == 4000) {
                    ygVar.b(14, iA);
                } else if (iIntValue == 8002) {
                    ygVar.b(71, iA);
                } else if (iIntValue == 9001) {
                    ygVar.b(5, iA);
                } else if (iIntValue == 11002) {
                    ygVar.b(73, iA);
                } else if (iIntValue == 26) {
                    ygVar.b(40, iA);
                } else if (iIntValue == 27) {
                    ygVar.b(41, iA);
                } else if (iIntValue == 3000) {
                    ygVar.b(12, iA);
                } else if (iIntValue == 3001) {
                    ygVar.b(13, iA);
                } else if (iIntValue == 6001) {
                    ygVar.b(47, iA);
                } else if (iIntValue == 6002) {
                    ygVar.b(46, iA);
                } else {
                    switch (iIntValue) {
                        case 2:
                            ygVar.b(48, iA);
                            break;
                        case 3:
                            ygVar.b(43, iA);
                            break;
                        case 4:
                            ygVar.b(45, iA);
                            break;
                        case 5:
                            ygVar.b(44, iA);
                            break;
                        case 6:
                            ygVar.b(52, iA);
                            break;
                        case 7:
                            ygVar.d(8, 8);
                            ygVar.a(0L);
                            ygVar.c(49, ygVar.a.capacity() - ygVar.b);
                            break;
                        case 8:
                            ygVar.d(8, 8);
                            ygVar.a(0L);
                            ygVar.c(50, ygVar.a.capacity() - ygVar.b);
                            break;
                    }
                }
            }
        }
        return ygVar.a();
    }

    public static final int a(EdgeInsets edgeInsets, yg ygVar) {
        float f = edgeInsets.top;
        float f2 = edgeInsets.left;
        float f3 = edgeInsets.bottom;
        float f4 = edgeInsets.right;
        ygVar.d(4, 16);
        ygVar.a(f4);
        ygVar.a(f3);
        ygVar.a(f2);
        ygVar.a(f);
        return ygVar.a.capacity() - ygVar.b;
    }
}
