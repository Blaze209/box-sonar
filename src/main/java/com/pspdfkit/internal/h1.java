package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.configuration.AnnotationBorderStyleConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder;
import com.pspdfkit.annotations.configuration.AnnotationFillColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationOutlineColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h1<T extends AnnotationConfiguration.Builder<T>> extends g1<T> implements AnnotationColorConfiguration.Builder<T>, AnnotationFillColorConfiguration.Builder<T>, AnnotationOutlineColorConfiguration.Builder<T>, AnnotationBorderStyleConfiguration.Builder<T> {
    public final Context c;
    public final AnnotationTool d;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[AnnotationProperty.values().length];
            try {
                iArr[AnnotationProperty.COLOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationProperty.FILL_COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationProperty.OUTLINE_COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationProperty.BORDER_STYLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationProperty.THICKNESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
            int[] iArr2 = new int[AnnotationTool.values().length];
            try {
                iArr2[AnnotationTool.HIGHLIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[AnnotationTool.SQUIGGLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[AnnotationTool.STRIKEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[AnnotationTool.UNDERLINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[AnnotationTool.NOTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(Context context, AnnotationTool annotationTool, AnnotationProperty... annotationPropertyArr) {
        super((AnnotationProperty[]) Arrays.copyOf(annotationPropertyArr, annotationPropertyArr.length));
        context.getClass();
        annotationTool.getClass();
        this.c = context;
        this.d = annotationTool;
    }

    public final void a() {
        List<Integer> list;
        EnumSet<AnnotationProperty> enumSet = this.b;
        if (enumSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supportedProperties");
            enumSet = null;
        }
        Iterator<AnnotationProperty> it = enumSet.iterator();
        it.getClass();
        while (it.hasNext()) {
            AnnotationProperty next = it.next();
            int i = next == null ? -1 : a.a[next.ordinal()];
            if (i == 1) {
                j1 j1Var = this.a;
                i1<Integer> i1Var = i1.d;
                j1Var.getClass();
                Object obj = j1Var.a.get(i1Var);
                if (obj == null) {
                    obj = null;
                }
                if (((Integer) obj) == null) {
                    j1 j1Var2 = this.a;
                    Context context = this.c;
                    AnnotationTool annotationTool = this.d;
                    float f = ww.a;
                    context.getClass();
                    annotationTool.getClass();
                    AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
                    annotationToolVariantDefaultVariant.getClass();
                    Integer numValueOf = Integer.valueOf(ww.a(context, annotationTool, annotationToolVariantDefaultVariant));
                    j1Var2.getClass();
                    j1Var2.a.put(i1Var, numValueOf);
                }
                j1 j1Var3 = this.a;
                i1<List<Integer>> i1Var2 = i1.e;
                j1Var3.getClass();
                Object obj2 = j1Var3.a.get(i1Var2);
                if (obj2 == null) {
                    obj2 = null;
                }
                if (((List) obj2) == null) {
                    int i2 = a.b[this.d.ordinal()];
                    if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                        list = ww.i;
                    } else {
                        list = i2 != 5 ? ww.d : ww.h;
                    }
                    j1 j1Var4 = this.a;
                    j1Var4.getClass();
                    HashMap<i1<?>, Object> map = j1Var4.a;
                    list.getClass();
                    map.put(i1Var2, list);
                }
            } else if (i == 2) {
                j1 j1Var5 = this.a;
                i1<Integer> i1Var3 = i1.f;
                j1Var5.getClass();
                Object obj3 = j1Var5.a.get(i1Var3);
                if (obj3 == null) {
                    obj3 = null;
                }
                if (((Integer) obj3) == null) {
                    j1 j1Var6 = this.a;
                    AnnotationTool annotationTool2 = this.d;
                    float f2 = ww.a;
                    annotationTool2.getClass();
                    Integer numValueOf2 = Integer.valueOf(ww.a.b[annotationTool2.ordinal()] == 22 ? -16777216 : 0);
                    j1Var6.getClass();
                    j1Var6.a.put(i1Var3, numValueOf2);
                }
                j1 j1Var7 = this.a;
                i1<List<Integer>> i1Var4 = i1.g;
                j1Var7.getClass();
                Object obj4 = j1Var7.a.get(i1Var4);
                if (obj4 == null) {
                    obj4 = null;
                }
                List<Integer> list2 = (List) obj4;
                if (list2 == null) {
                    list2 = ww.f;
                }
                if (this.d == AnnotationTool.REDACTION && list2.contains(0)) {
                    List mutableList = CollectionsKt.toMutableList((Collection) list2);
                    mutableList.remove((Object) 0);
                    j1 j1Var8 = this.a;
                    j1Var8.getClass();
                    j1Var8.a.put(i1Var4, mutableList);
                } else {
                    j1 j1Var9 = this.a;
                    j1Var9.getClass();
                    HashMap<i1<?>, Object> map2 = j1Var9.a;
                    list2.getClass();
                    map2.put(i1Var4, list2);
                }
            } else if (i == 3) {
                j1 j1Var10 = this.a;
                i1<Integer> i1Var5 = i1.h;
                j1Var10.getClass();
                Object obj5 = j1Var10.a.get(i1Var5);
                if (obj5 == null) {
                    obj5 = null;
                }
                if (((Integer) obj5) == null) {
                    j1 j1Var11 = this.a;
                    Context context2 = this.c;
                    AnnotationTool annotationTool3 = this.d;
                    float f3 = ww.a;
                    context2.getClass();
                    annotationTool3.getClass();
                    AnnotationToolVariant annotationToolVariantDefaultVariant2 = AnnotationToolVariant.defaultVariant();
                    annotationToolVariantDefaultVariant2.getClass();
                    Integer numValueOf3 = Integer.valueOf(ww.a(context2, annotationTool3, annotationToolVariantDefaultVariant2));
                    j1Var11.getClass();
                    j1Var11.a.put(i1Var5, numValueOf3);
                }
                j1 j1Var12 = this.a;
                i1<List<Integer>> i1Var6 = i1.i;
                j1Var12.getClass();
                Object obj6 = j1Var12.a.get(i1Var6);
                if (obj6 == null) {
                    obj6 = null;
                }
                if (((List) obj6) == null) {
                    j1 j1Var13 = this.a;
                    List<Integer> list3 = ww.d;
                    j1Var13.getClass();
                    HashMap<i1<?>, Object> map3 = j1Var13.a;
                    list3.getClass();
                    map3.put(i1Var6, list3);
                }
            } else if (i == 4) {
                boolean z = this.d.toAnnotationType() == AnnotationType.FREETEXT;
                BorderStylePreset borderStylePreset = z ? BorderStylePreset.NONE : BorderStylePreset.SOLID;
                borderStylePreset.getClass();
                j1 j1Var14 = this.a;
                i1<BorderStylePreset> i1Var7 = i1.v;
                j1Var14.getClass();
                Object obj7 = j1Var14.a.get(i1Var7);
                if (obj7 == null) {
                    obj7 = null;
                }
                if (((BorderStylePreset) obj7) == null) {
                    j1 j1Var15 = this.a;
                    j1Var15.getClass();
                    j1Var15.a.put(i1Var7, borderStylePreset);
                }
                j1 j1Var16 = this.a;
                i1<List<BorderStylePreset>> i1Var8 = i1.w;
                j1Var16.getClass();
                Object obj8 = j1Var16.a.get(i1Var8);
                if (obj8 == null) {
                    obj8 = null;
                }
                if (((List) obj8) == null) {
                    ArrayList arrayList = new ArrayList(6);
                    if (z) {
                        arrayList.add(BorderStylePreset.NONE);
                        arrayList.add(BorderStylePreset.SOLID);
                    } else {
                        arrayList.add(BorderStylePreset.SOLID);
                    }
                    arrayList.add(BorderStylePreset.DASHED_1_1);
                    arrayList.add(BorderStylePreset.DASHED_1_3);
                    arrayList.add(BorderStylePreset.DASHED_3_3);
                    arrayList.add(BorderStylePreset.DASHED_6_6);
                    AnnotationType annotationType = this.d.toAnnotationType();
                    annotationType.getClass();
                    if (annotationType == AnnotationType.SQUARE || annotationType == AnnotationType.CIRCLE || annotationType == AnnotationType.POLYGON) {
                        arrayList.add(BorderStylePreset.CLOUDY);
                    }
                    j1 j1Var17 = this.a;
                    j1Var17.getClass();
                    j1Var17.a.put(i1Var8, arrayList);
                }
            } else if (i == 5) {
                j1 j1Var18 = this.a;
                i1<Float> i1Var9 = i1.k;
                j1Var18.getClass();
                Object obj9 = j1Var18.a.get(i1Var9);
                if (obj9 == null) {
                    obj9 = null;
                }
                if (((Float) obj9) == null) {
                    j1 j1Var19 = this.a;
                    Float fValueOf = Float.valueOf(5.0f);
                    j1Var19.getClass();
                    j1Var19.a.put(i1Var9, fValueOf);
                }
            }
        }
        if (this.d.toAnnotationType() == AnnotationType.NOTE) {
            EnumSet<AnnotationProperty> enumSet2 = this.b;
            if (enumSet2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("supportedProperties");
                enumSet2 = null;
            }
            if (enumSet2.contains(AnnotationProperty.COLOR)) {
                return;
            }
            j1 j1Var20 = this.a;
            i1<Integer> i1Var10 = i1.d;
            j1Var20.getClass();
            Object obj10 = j1Var20.a.get(i1Var10);
            if (((Integer) (obj10 != null ? obj10 : null)) == null) {
                j1 j1Var21 = this.a;
                Context context3 = this.c;
                AnnotationTool annotationTool4 = this.d;
                float f4 = ww.a;
                context3.getClass();
                annotationTool4.getClass();
                AnnotationToolVariant annotationToolVariantDefaultVariant3 = AnnotationToolVariant.defaultVariant();
                annotationToolVariantDefaultVariant3.getClass();
                Integer numValueOf4 = Integer.valueOf(ww.a(context3, annotationTool4, annotationToolVariantDefaultVariant3));
                j1Var21.getClass();
                j1Var21.a.put(i1Var10, numValueOf4);
            }
        }
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationColorConfiguration.Builder
    public final Object setAvailableColors(List list) {
        list.getClass();
        j1 j1Var = this.a;
        i1<List<Integer>> i1Var = i1.e;
        j1Var.getClass();
        j1Var.a.put(i1Var, list);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationFillColorConfiguration.Builder
    public final Object setAvailableFillColors(List list) {
        list.getClass();
        j1 j1Var = this.a;
        i1<List<Integer>> i1Var = i1.g;
        j1Var.getClass();
        j1Var.a.put(i1Var, list);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationOutlineColorConfiguration.Builder
    public final T setAvailableOutlineColors(List<Integer> list) {
        list.getClass();
        j1 j1Var = this.a;
        i1<List<Integer>> i1Var = i1.i;
        j1Var.getClass();
        HashMap<i1<?>, Object> map = j1Var.a;
        list.getClass();
        map.put(i1Var, list);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationBorderStyleConfiguration.Builder
    public final Object setBorderStylePresets(List list) {
        list.getClass();
        j1 j1Var = this.a;
        i1<List<BorderStylePreset>> i1Var = i1.w;
        j1Var.getClass();
        j1Var.a.put(i1Var, list);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationBorderStyleConfiguration.Builder
    public final Object setDefaultBorderStylePreset(BorderStylePreset borderStylePreset) {
        borderStylePreset.getClass();
        j1 j1Var = this.a;
        i1<BorderStylePreset> i1Var = i1.v;
        j1Var.getClass();
        j1Var.a.put(i1Var, borderStylePreset);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationColorConfiguration.Builder
    public final Object setDefaultColor(int i) {
        j1 j1Var = this.a;
        i1<Integer> i1Var = i1.d;
        Integer numValueOf = Integer.valueOf(i);
        j1Var.getClass();
        j1Var.a.put(i1Var, numValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationFillColorConfiguration.Builder
    public final Object setDefaultFillColor(int i) {
        j1 j1Var = this.a;
        i1<Integer> i1Var = i1.f;
        Integer numValueOf = Integer.valueOf(i);
        j1Var.getClass();
        j1Var.a.put(i1Var, numValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationOutlineColorConfiguration.Builder
    public final T setDefaultOutlineColor(int i) {
        j1 j1Var = this.a;
        i1<Integer> i1Var = i1.h;
        Integer numValueOf = Integer.valueOf(i);
        j1Var.getClass();
        j1Var.a.put(i1Var, numValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationColorConfiguration.Builder, com.pspdfkit.annotations.configuration.AnnotationFillColorConfiguration.Builder, com.pspdfkit.annotations.configuration.AnnotationOutlineColorConfiguration.Builder
    public final T setCustomColorPickerEnabled(boolean z) {
        j1 j1Var = this.a;
        i1<Boolean> i1Var = i1.j;
        Boolean boolValueOf = Boolean.valueOf(z);
        j1Var.getClass();
        j1Var.a.put(i1Var, boolValueOf);
        return this;
    }
}
