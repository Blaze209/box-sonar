package com.box.android.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: DataClassUtils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0003\u001a@\u0010\u0004\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0005\"\u0004\b\u0001\u0010\u0006*\u0002H\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\u0002\u001a\u0002H\u0006H\u0086\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"self", ExifInterface.GPS_DIRECTION_TRUE, "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "copyByProperty", "", "TProp", "property", "Lkotlin/reflect/KProperty1;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty1;Ljava/lang/Object;)Ljava/lang/Object;", "cpl-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DataClassUtilsKt {
    public static final <T> T self(T t) {
        return t;
    }

    public static final /* synthetic */ <T, TProp> T copyByProperty(T t, KProperty1<T, ? extends TProp> property, TProp tprop) throws InvalidObjectException {
        T next;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(Object.class)).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
        KFunction kFunction = (KFunction) next;
        if (kFunction == null) {
            throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
        }
        KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
        Intrinsics.checkNotNull(instanceParameter);
        for (KParameter kParameter : kFunction.getParameters()) {
            if (Intrinsics.areEqual(kParameter.getName(), property.getName())) {
                T t2 = (T) kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, t), TuplesKt.to(kParameter, tprop)));
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                return t2;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
