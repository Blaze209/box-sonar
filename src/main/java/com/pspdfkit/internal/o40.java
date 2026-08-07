package com.pspdfkit.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class o40 {
    public static final SnapshotStateList a(final Object[] objArr, Composer composer) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1790838843, 0, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.util.rememberMutableStateListOf (StateListUtils.kt:18)");
        }
        Object[] objArr2 = new Object[0];
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new Function2() { // from class: com.pspdfkit.internal.o40$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return o40.a((SaverScope) obj, (SnapshotStateList) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2 function2 = (Function2) objRememberedValue;
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.o40$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return o40.a((List) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Saver saverListSaver = ListSaverKt.listSaver(function2, (Function1) objRememberedValue2);
        boolean zChangedInstance = composer.changedInstance(objArr);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: com.pspdfkit.internal.o40$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return o40.a(objArr);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) RememberSaveableKt.m6247rememberSaveable(objArr2, saverListSaver, (Function0) objRememberedValue3, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return snapshotStateList;
    }

    public static final List a(SaverScope saverScope, SnapshotStateList snapshotStateList) {
        saverScope.getClass();
        snapshotStateList.getClass();
        if (!snapshotStateList.isEmpty()) {
            Object objFirst = CollectionsKt.first((List<? extends Object>) snapshotStateList);
            if (!saverScope.canBeSaved(objFirst)) {
                throw new IllegalStateException(Reflection.getOrCreateKotlinClass(objFirst.getClass()) + " cannot be saved. By default only types which can be stored in the Bundle class can be saved.");
            }
        }
        return snapshotStateList.toList();
    }

    public static final SnapshotStateList a(List list) {
        list.getClass();
        return SnapshotStateKt.toMutableStateList(list);
    }

    public static final SnapshotStateList a(Object[] objArr) {
        return SnapshotStateKt.toMutableStateList(ArraysKt.toList(objArr));
    }
}
