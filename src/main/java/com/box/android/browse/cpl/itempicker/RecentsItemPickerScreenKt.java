package com.box.android.browse.cpl.itempicker;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.box.android.browse.compose.FolderListingScreenKt;
import com.box.android.browse.cpl.RecentsItemPickerViewModel;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RecentsItemPickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"RecentsItemPickerScreen", "", "viewModel", "Lcom/box/android/browse/cpl/RecentsItemPickerViewModel;", "(Lcom/box/android/browse/cpl/RecentsItemPickerViewModel;Landroidx/compose/runtime/Composer;II)V", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RecentsItemPickerScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecentsItemPickerScreen$lambda$3(RecentsItemPickerViewModel recentsItemPickerViewModel, int i, int i2, Composer composer, int i3) {
        RecentsItemPickerScreen(recentsItemPickerViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void RecentsItemPickerScreen(final RecentsItemPickerViewModel recentsItemPickerViewModel, Composer composer, final int i, final int i2) {
        int i3;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Composer composerStartRestartGroup = composer.startRestartGroup(2076314586);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RecentsItemPickerScreen)N(viewModel)18@724L73,18@703L94,22@822L184,34@1191L39,29@1011L261:RecentsItemPickerScreen.kt#oru6qt");
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && composerStartRestartGroup.changedInstance(recentsItemPickerViewModel)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "15@647L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
            } else if ((i2 & 1) != 0) {
                composerStartRestartGroup.startReplaceableGroup(1890788296);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                }
                ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(1729797275);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                if (current instanceof HasDefaultViewModelProviderFactory) {
                    defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                } else {
                    defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                }
                ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) RecentsItemPickerViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                recentsItemPickerViewModel = (RecentsItemPickerViewModel) viewModel;
                i3 &= -15;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2076314586, i3, -1, "com.box.android.browse.cpl.itempicker.RecentsItemPickerScreen (RecentsItemPickerScreen.kt:15)");
            }
            Store<ItemPickerReducer.State, ItemPickerReducer.Action> store = recentsItemPickerViewModel.getStore();
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1821470781, "CC(remember):RecentsItemPickerScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(store);
            RecentsItemPickerScreenKt$RecentsItemPickerScreen$1$1 recentsItemPickerScreenKt$RecentsItemPickerScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || recentsItemPickerScreenKt$RecentsItemPickerScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                recentsItemPickerScreenKt$RecentsItemPickerScreen$1$1RememberedValue = new RecentsItemPickerScreenKt$RecentsItemPickerScreen$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(recentsItemPickerScreenKt$RecentsItemPickerScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) recentsItemPickerScreenKt$RecentsItemPickerScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1821467534, "CC(remember):RecentsItemPickerScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = store.scope(new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itempicker.RecentsItemPickerScreenKt$RecentsItemPickerScreen$currentStore$1$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ItemPickerReducer.State) obj).getStack();
                    }
                }, 0, RecentsItemPickerScreenKt$RecentsItemPickerScreen$currentStore$1$2.INSTANCE);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Store store2 = (Store) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(TestTagKt.testTag(Modifier.INSTANCE, "RecentsItemPickerScreen"), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1821455871, "CC(remember):RecentsItemPickerScreen.kt#9igjgp");
            RecentsItemPickerScreenKt$RecentsItemPickerScreen$2$1 recentsItemPickerScreenKt$RecentsItemPickerScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (recentsItemPickerScreenKt$RecentsItemPickerScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                recentsItemPickerScreenKt$RecentsItemPickerScreen$2$1RememberedValue = new RecentsItemPickerScreenKt$RecentsItemPickerScreen$2$1(null);
                composerStartRestartGroup.updateRememberedValue(recentsItemPickerScreenKt$RecentsItemPickerScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FolderListingScreenKt.FolderListingScreen(store2, modifierFillMaxSize$default, null, null, (Function4) recentsItemPickerScreenKt$RecentsItemPickerScreen$2$1RememberedValue, true, composerStartRestartGroup, 196662, 12);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itempicker.RecentsItemPickerScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecentsItemPickerScreenKt.RecentsItemPickerScreen$lambda$3(recentsItemPickerViewModel, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
