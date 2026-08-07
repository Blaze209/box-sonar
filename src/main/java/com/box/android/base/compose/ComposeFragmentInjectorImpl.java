package com.box.android.base.compose;

import android.app.Activity;
import android.os.Bundle;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.box.android.base.presentation.fragments.IBoxFragmentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ComposeFragmentInjector.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00050\u000fH\u0017¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/compose/ComposeFragmentInjectorImpl;", "Lcom/box/android/base/compose/ComposeFragmentInjector;", "<init>", "()V", "applyFragment", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "fragmentClass", "Lkotlin/reflect/KClass;", "modifier", "Landroidx/compose/ui/Modifier;", "arguments", "Landroid/os/Bundle;", "onUpdate", "Lkotlin/Function1;", "(Lkotlin/reflect/KClass;Landroidx/compose/ui/Modifier;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ComposeFragmentInjectorImpl implements ComposeFragmentInjector {
    public static final int $stable = 0;

    @Override // com.box.android.base.compose.ComposeFragmentInjector
    public /* bridge */ <T extends Fragment> void applyFragment(KClass<T> kClass, Modifier modifier, Composer composer, int i) {
        super.applyFragment(kClass, modifier, composer, i);
    }

    @Override // com.box.android.base.compose.ComposeFragmentInjector
    public <T extends Fragment> void applyFragment(KClass<T> fragmentClass, Modifier modifier, Bundle arguments, Function1<? super T, Unit> onUpdate, Composer composer, int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        composer.startReplaceGroup(2131868309);
        ComposerKt.sourceInformation(composer, "C(applyFragment)N(fragmentClass,modifier,arguments,onUpdate)41@1300L7:ComposeFragmentInjector.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2131868309, i, -1, "com.box.android.base.compose.ComposeFragmentInjectorImpl.applyFragment (ComposeFragmentInjector.kt:40)");
        }
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (!(((Activity) objConsume) instanceof IBoxFragmentActivity)) {
            composer2 = composer;
            composer2.startReplaceGroup(806293293);
        } else {
            composer.startReplaceGroup(807644087);
            ComposerKt.sourceInformation(composer, "43@1368L190");
            Class javaClass = JvmClassMappingKt.getJavaClass((KClass) fragmentClass);
            int i2 = i << 3;
            composer2 = composer;
            SafeAndroidFragmentKt.SafeAndroidFragment(javaClass, modifier, null, arguments, onUpdate, composer2, (i & 112) | (i2 & 7168) | (i2 & 57344), 4);
        }
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
    }
}
