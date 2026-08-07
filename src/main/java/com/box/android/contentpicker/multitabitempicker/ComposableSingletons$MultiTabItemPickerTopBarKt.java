package com.box.android.contentpicker.multitabitempicker;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiTabItemPickerTopBar.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$MultiTabItemPickerTopBarKt {
    public static final ComposableSingletons$MultiTabItemPickerTopBarKt INSTANCE = new ComposableSingletons$MultiTabItemPickerTopBarKt();

    /* JADX INFO: renamed from: lambda$-1613263971, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f230lambda$1613263971 = ComposableLambdaKt.composableLambdaInstance(-1613263971, false, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MultiTabItemPickerTopBarKt.lambda__1613263971$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1613263971$content_picker_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12437getLambda$1613263971$content_picker_generalProdRelease() {
        return f230lambda$1613263971;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1613263971$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C172@6326L2,173@6360L2,176@6570L8,171@6272L316:MultiTabItemPickerTopBar.kt#aug1cj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1613263971, i, -1, "com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerTopBarKt.lambda$-1613263971.<anonymous> (MultiTabItemPickerTopBar.kt:171)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 136519775, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 136520863, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            List listListOf = CollectionsKt.listOf((Object[]) new FolderModel[]{FolderModel.INSTANCE.createFromId("1", "Files"), FolderModel.INSTANCE.createFromId("2", "Folder A")});
            ComposerKt.sourceInformationMarkerStart(composer, 136527589, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$MultiTabItemPickerTopBarKt.lambda__1613263971$lambda$0$2$0((ItemId.Remote) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar(function0, function1, "Fourth Folder", listListOf, (Function1) objRememberedValue3, false, composer, 25014, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1613263971$lambda$0$2$0(ItemId.Remote remote) {
        Intrinsics.checkNotNullParameter(remote, "<unused var>");
        return Unit.INSTANCE;
    }
}
