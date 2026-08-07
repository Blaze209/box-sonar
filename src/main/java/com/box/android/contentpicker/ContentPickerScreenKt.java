package com.box.android.contentpicker;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.box.android.base.compose.NavControllerExtensionsKt;
import com.box.android.base.compose.SimpleBottomSheetKt;
import com.box.android.browse.cpl.RecentsItemPickerViewModel;
import com.box.android.contentpicker.contentsourcepicker.ContentSourcePickerScreenKt;
import com.box.android.contentpicker.multitabitempicker.ItemPickerTab;
import com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt;
import com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerViewModels;
import com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerKt;
import com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerReducer;
import com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerViewModel;
import com.box.android.contentpicker.uploadcontent.UploadContentHandlerKt;
import com.box.android.contentpicker.uploadcontent.UploadContentHandlerReducer;
import com.box.android.contentpicker.uploadcontent.UploadContentHandlerViewModel;
import com.box.android.cpl.Store;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ContentPickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0013\b\u0002\u0010\b\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"ContentPickerScreen", "", "recentsItemPickerViewModel", "Lcom/box/android/browse/cpl/RecentsItemPickerViewModel;", "contentPickerViewModel", "Lcom/box/android/contentpicker/ContentPickerViewModel;", "multiTabItemPickerViewModels", "Lcom/box/android/contentpicker/multitabitempicker/MultiTabItemPickerViewModels;", "captureMediaHandlerViewModel", "Lkotlin/Function0;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerViewModel;", "Landroidx/compose/runtime/Composable;", "uploadContentHandlerViewModel", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerViewModel;", "(Lcom/box/android/browse/cpl/RecentsItemPickerViewModel;Lcom/box/android/contentpicker/ContentPickerViewModel;Lcom/box/android/contentpicker/multitabitempicker/MultiTabItemPickerViewModels;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MULTI_TAB_ITEM_PICKER", "", "ITEM_SOURCE_PICKER", "CAPTURE_MEDIA", "UPLOAD_CONTENT", "content-picker_generalProdRelease", "state", "Lcom/box/android/contentpicker/ContentPickerReducer$State;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ContentPickerScreenKt {
    private static final String CAPTURE_MEDIA = "capture_media";
    private static final String ITEM_SOURCE_PICKER = "item_source_picker";
    private static final String MULTI_TAB_ITEM_PICKER = "multi_tab_item_picker";
    private static final String UPLOAD_CONTENT = "upload_content";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$2(RecentsItemPickerViewModel recentsItemPickerViewModel, ContentPickerViewModel contentPickerViewModel, MultiTabItemPickerViewModels multiTabItemPickerViewModels, Function2 function2, Function2 function3, int i, int i2, Composer composer, int i3) {
        ContentPickerScreen(recentsItemPickerViewModel, contentPickerViewModel, multiTabItemPickerViewModels, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$8(RecentsItemPickerViewModel recentsItemPickerViewModel, ContentPickerViewModel contentPickerViewModel, MultiTabItemPickerViewModels multiTabItemPickerViewModels, Function2 function2, Function2 function3, int i, int i2, Composer composer, int i3) {
        ContentPickerScreen(recentsItemPickerViewModel, contentPickerViewModel, multiTabItemPickerViewModels, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CaptureMediaHandlerViewModel ContentPickerScreen$lambda$0(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-1157364782);
        ComposerKt.sourceInformation(composer, "C36@2128L15:ContentPickerScreen.kt#tyt3w8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1157364782, i, -1, "com.box.android.contentpicker.ContentPickerScreen.<anonymous> (ContentPickerScreen.kt:36)");
        }
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CaptureMediaHandlerViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        CaptureMediaHandlerViewModel captureMediaHandlerViewModel = (CaptureMediaHandlerViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return captureMediaHandlerViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadContentHandlerViewModel ContentPickerScreen$lambda$1(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(947862456);
        ComposerKt.sourceInformation(composer, "C37@2234L15:ContentPickerScreen.kt#tyt3w8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(947862456, i, -1, "com.box.android.contentpicker.ContentPickerScreen.<anonymous> (ContentPickerScreen.kt:37)");
        }
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) UploadContentHandlerViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        UploadContentHandlerViewModel uploadContentHandlerViewModel = (UploadContentHandlerViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return uploadContentHandlerViewModel;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void ContentPickerScreen(RecentsItemPickerViewModel recentsItemPickerViewModel, ContentPickerViewModel contentPickerViewModel, MultiTabItemPickerViewModels multiTabItemPickerViewModels, Function2<? super Composer, ? super Integer, CaptureMediaHandlerViewModel> function2, Function2<? super Composer, ? super Integer, UploadContentHandlerViewModel> function3, Composer composer, final int i, final int i2) {
        int i3;
        ContentPickerViewModel contentPickerViewModel2;
        MultiTabItemPickerViewModels multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels;
        Function2<? super Composer, ? super Integer, CaptureMediaHandlerViewModel> function4;
        Function2<? super Composer, ? super Integer, UploadContentHandlerViewModel> function5;
        final RecentsItemPickerViewModel recentsItemPickerViewModel2;
        final Function2<? super Composer, ? super Integer, UploadContentHandlerViewModel> function6;
        final ContentPickerViewModel contentPickerViewModel3;
        final MultiTabItemPickerViewModels multiTabItemPickerViewModels2;
        final Function2<? super Composer, ? super Integer, CaptureMediaHandlerViewModel> function7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i4;
        char c;
        String str;
        int i5;
        int i6;
        RecentsItemPickerViewModel recentsItemPickerViewModel3;
        String str2;
        int i7;
        Function2<? super Composer, ? super Integer, CaptureMediaHandlerViewModel> function9;
        Function2<? super Composer, ? super Integer, UploadContentHandlerViewModel> function10;
        RecentsItemPickerViewModel recentsItemPickerViewModel4;
        ContentPickerViewModel contentPickerViewModel4;
        MultiTabItemPickerViewModels multiTabItemPickerViewModels3;
        int i8;
        Function2<? super Composer, ? super Integer, CaptureMediaHandlerViewModel> function11;
        CreationExtras.Empty defaultViewModelCreationExtras;
        CreationExtras.Empty defaultViewModelCreationExtras2;
        final NavHostController navHostController;
        final Function2<? super Composer, ? super Integer, UploadContentHandlerViewModel> function12;
        final ContentPickerViewModel contentPickerViewModel5;
        final MultiTabItemPickerViewModels multiTabItemPickerViewModels4;
        final Function2<? super Composer, ? super Integer, CaptureMediaHandlerViewModel> function13;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(905954432);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContentPickerScreen)N(recentsItemPickerViewModel,contentPickerViewModel,multiTabItemPickerViewModels,captureMediaHandlerViewModel,uploadContentHandlerViewModel)39@2289L7,42@2382L29,44@2438L169,44@2417L190,49@2633L23,53@2747L24,54@2798L23,55@2828L1902,50@2661L2069:ContentPickerScreen.kt#tyt3w8");
        if ((i & 6) == 0) {
            if ((i2 & 1) != 0) {
                i9 = 2;
            } else {
                if ((i & 8) == 0 ? composerStartRestartGroup.changed(recentsItemPickerViewModel) : composerStartRestartGroup.changedInstance(recentsItemPickerViewModel)) {
                    i9 = 4;
                } else {
                    i9 = 2;
                }
            }
            i3 = i9 | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                contentPickerViewModel2 = contentPickerViewModel;
                int i10 = composerStartRestartGroup.changedInstance(contentPickerViewModel2) ? 32 : 16;
                i3 |= i10;
            } else {
                contentPickerViewModel2 = contentPickerViewModel;
            }
            i3 |= i10;
        } else {
            contentPickerViewModel2 = contentPickerViewModel;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels = multiTabItemPickerViewModels;
                int i11 = composerStartRestartGroup.changed(multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels) ? 256 : 128;
                i3 |= i11;
            } else {
                multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels = multiTabItemPickerViewModels;
            }
            i3 |= i11;
        } else {
            multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels = multiTabItemPickerViewModels;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                function4 = function2;
                int i12 = composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                i3 |= i12;
            } else {
                function4 = function2;
            }
            i3 |= i12;
        } else {
            function4 = function2;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                function5 = function3;
                int i13 = composerStartRestartGroup.changedInstance(function5) ? 16384 : 8192;
                i3 |= i13;
            } else {
                function5 = function3;
            }
            i3 |= i13;
        } else {
            function5 = function3;
        }
        boolean z = true;
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "33@1844L15,34@1914L23,35@2004L37");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
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
                        defaultViewModelCreationExtras2 = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras2 = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) RecentsItemPickerViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras2, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    i6 = i3 & (-15);
                    recentsItemPickerViewModel3 = (RecentsItemPickerViewModel) viewModel;
                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    i5 = 0;
                    i4 = 1890788296;
                    c = 16384;
                } else {
                    i4 = 1890788296;
                    c = 16384;
                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    i5 = 0;
                    i6 = i3;
                    recentsItemPickerViewModel3 = recentsItemPickerViewModel;
                }
                if ((i2 & 2) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                    ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str);
                    Object objConsume = composerStartRestartGroup.consume(localActivity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                    ComponentActivity componentActivity = (ComponentActivity) objConsume;
                    composerStartRestartGroup.startReplaceableGroup(i4);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory2 = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, i5);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    i7 = i5;
                    CreationExtras creationExtras = defaultViewModelCreationExtras;
                    str2 = str;
                    ViewModel viewModel2 = ViewModelKt.viewModel((Class<ViewModel>) ContentPickerViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory2, creationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    contentPickerViewModel2 = (ContentPickerViewModel) viewModel2;
                    i6 &= -113;
                } else {
                    str2 = str;
                    i7 = i5;
                }
                int i14 = i6;
                if ((i2 & 4) != 0) {
                    multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels = MultiTabItemPickerScreenContentKt.defaultMultiTabItemPickerViewModels(composerStartRestartGroup, i7);
                    i14 &= -897;
                }
                if ((i2 & 8) != 0) {
                    function9 = new Function2() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ContentPickerScreenKt.ContentPickerScreen$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    i14 &= -7169;
                } else {
                    function9 = function2;
                }
                if ((i2 & 16) != 0) {
                    recentsItemPickerViewModel4 = recentsItemPickerViewModel3;
                    contentPickerViewModel4 = contentPickerViewModel2;
                    multiTabItemPickerViewModels3 = multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels;
                    function11 = function9;
                    function10 = new Function2() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ContentPickerScreenKt.ContentPickerScreen$lambda$1((Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    i8 = i14 & (-57345);
                } else {
                    function10 = function3;
                    recentsItemPickerViewModel4 = recentsItemPickerViewModel3;
                    contentPickerViewModel4 = contentPickerViewModel2;
                    multiTabItemPickerViewModels3 = multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels;
                    i8 = i14;
                    function11 = function9;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
                recentsItemPickerViewModel4 = recentsItemPickerViewModel;
                contentPickerViewModel4 = contentPickerViewModel2;
                multiTabItemPickerViewModels3 = multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels;
                function11 = function4;
                function10 = function5;
                str2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                i7 = 0;
                i8 = i3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(905954432, i8, -1, "com.box.android.contentpicker.ContentPickerScreen (ContentPickerScreen.kt:38)");
            }
            ProvidableCompositionLocal<Activity> localActivity2 = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str2);
            Object objConsume2 = composerStartRestartGroup.consume(localActivity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Activity activity = (Activity) objConsume2;
            if (activity != null) {
                final RecentsItemPickerViewModel recentsItemPickerViewModel5 = recentsItemPickerViewModel4;
                ContentPickerViewModel contentPickerViewModel6 = contentPickerViewModel4;
                MultiTabItemPickerViewModels multiTabItemPickerViewModels5 = multiTabItemPickerViewModels3;
                Function2<? super Composer, ? super Integer, CaptureMediaHandlerViewModel> function14 = function11;
                final Store<ContentPickerReducer.State, ContentPickerReducer.Action> store = contentPickerViewModel6.getStore();
                int i15 = i7;
                Function2<? super Composer, ? super Integer, UploadContentHandlerViewModel> function15 = function10;
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1256130007, "CC(remember):ContentPickerScreen.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(activity) | composerStartRestartGroup.changed(store);
                ContentPickerScreenKt$ContentPickerScreen$3$1 contentPickerScreenKt$ContentPickerScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || contentPickerScreenKt$ContentPickerScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    contentPickerScreenKt$ContentPickerScreen$3$1RememberedValue = new ContentPickerScreenKt$ContentPickerScreen$3$1(activity, store, null);
                    composerStartRestartGroup.updateRememberedValue(contentPickerScreenKt$ContentPickerScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) contentPickerScreenKt$ContentPickerScreen$3$1RememberedValue, composerStartRestartGroup, 6);
                NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[i15], composerStartRestartGroup, i15);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1256120264, "CC(remember):ContentPickerScreen.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ContentPickerScreenKt.ContentPickerScreen$lambda$5$0((AnimatedContentTransitionScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1256118633, "CC(remember):ContentPickerScreen.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ContentPickerScreenKt.ContentPickerScreen$lambda$6$0((AnimatedContentTransitionScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function16 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1256115794, "CC(remember):ContentPickerScreen.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(store) | composerStartRestartGroup.changedInstance(activity) | (((6 ^ (i8 & 14)) > 4 && composerStartRestartGroup.changedInstance(recentsItemPickerViewModel5)) || (i8 & 6) == 4) | composerStartRestartGroup.changedInstance(contentPickerViewModel6) | composerStartRestartGroup.changedInstance(navHostControllerRememberNavController) | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | ((((i8 & 896) ^ 384) > 256 && composerStartRestartGroup.changed(multiTabItemPickerViewModels5)) || (i8 & 384) == 256) | ((((i8 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(function14)) || (i8 & 3072) == 2048);
                if ((((57344 & i8) ^ 24576) <= 16384 || !composerStartRestartGroup.changed(function15)) && (i8 & 24576) != 16384) {
                    z = false;
                }
                boolean z2 = zChanged | z;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    navHostController = navHostControllerRememberNavController;
                    function12 = function15;
                    contentPickerViewModel5 = contentPickerViewModel6;
                    multiTabItemPickerViewModels4 = multiTabItemPickerViewModels5;
                    function13 = function14;
                    objRememberedValue3 = new Function1() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0(store, activity, recentsItemPickerViewModel5, contentPickerViewModel5, navHostController, stateCollectAsStateWithLifecycle, multiTabItemPickerViewModels4, function13, function12, (NavGraphBuilder) obj);
                        }
                    };
                    recentsItemPickerViewModel2 = recentsItemPickerViewModel5;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    navHostController = navHostControllerRememberNavController;
                    function12 = function15;
                    contentPickerViewModel5 = contentPickerViewModel6;
                    recentsItemPickerViewModel2 = recentsItemPickerViewModel5;
                    multiTabItemPickerViewModels4 = multiTabItemPickerViewModels5;
                    function13 = function14;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NavHostKt.NavHost(navHostController, ITEM_SOURCE_PICKER, null, null, null, function1, function16, null, null, null, (Function1) objRememberedValue3, composerStartRestartGroup, 1769520, 0, 924);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contentPickerViewModel3 = contentPickerViewModel5;
                multiTabItemPickerViewModels2 = multiTabItemPickerViewModels4;
                function7 = function13;
                function6 = function12;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final RecentsItemPickerViewModel recentsItemPickerViewModel6 = recentsItemPickerViewModel4;
                final ContentPickerViewModel contentPickerViewModel7 = contentPickerViewModel4;
                final MultiTabItemPickerViewModels multiTabItemPickerViewModels6 = multiTabItemPickerViewModels3;
                final Function2<? super Composer, ? super Integer, CaptureMediaHandlerViewModel> function17 = function11;
                final Function2<? super Composer, ? super Integer, UploadContentHandlerViewModel> function18 = function10;
                function8 = new Function2() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ContentPickerScreenKt.ContentPickerScreen$lambda$2(recentsItemPickerViewModel6, contentPickerViewModel7, multiTabItemPickerViewModels6, function17, function18, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function8);
        }
        composerStartRestartGroup.skipToGroupEnd();
        recentsItemPickerViewModel2 = recentsItemPickerViewModel;
        function6 = function3;
        contentPickerViewModel3 = contentPickerViewModel2;
        multiTabItemPickerViewModels2 = multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels;
        function7 = function2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function8 = new Function2() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContentPickerScreenKt.ContentPickerScreen$lambda$8(recentsItemPickerViewModel2, contentPickerViewModel3, multiTabItemPickerViewModels2, function7, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition ContentPickerScreen$lambda$5$0(AnimatedContentTransitionScope NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        return EnterTransition.INSTANCE.getNone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition ContentPickerScreen$lambda$6$0(AnimatedContentTransitionScope NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        return ExitTransition.INSTANCE.getNone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0(final Store store, final Activity activity, final RecentsItemPickerViewModel recentsItemPickerViewModel, final ContentPickerViewModel contentPickerViewModel, final NavHostController navHostController, final State state, final MultiTabItemPickerViewModels multiTabItemPickerViewModels, final Function2 function2, final Function2 function3, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.composable$default(NavHost, ITEM_SOURCE_PICKER, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-277529821, true, new Function4() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$0(store, activity, recentsItemPickerViewModel, contentPickerViewModel, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, MULTI_TAB_ITEM_PICKER, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1463459302, true, new Function4() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$1(state, multiTabItemPickerViewModels, contentPickerViewModel, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, CAPTURE_MEDIA, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1375094939, true, new Function4() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$2(function2, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, UPLOAD_CONTENT, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-81318116, true, new Function4() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$3(function3, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$0(Store store, final Activity activity, final RecentsItemPickerViewModel recentsItemPickerViewModel, final ContentPickerViewModel contentPickerViewModel, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)57@2904L120,57@2883L141,61@3091L21,62@3127L716,60@3037L806:ContentPickerScreen.kt#tyt3w8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-277529821, i, -1, "com.box.android.contentpicker.ContentPickerScreen.<anonymous>.<anonymous>.<anonymous> (ContentPickerScreen.kt:57)");
        }
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -418184389, "CC(remember):ContentPickerScreen.kt#9igjgp");
        boolean zChanged = composer.changed(store);
        ContentPickerScreenKt$ContentPickerScreen$6$1$1$1$1 contentPickerScreenKt$ContentPickerScreen$6$1$1$1$1RememberedValue = composer.rememberedValue();
        if (zChanged || contentPickerScreenKt$ContentPickerScreen$6$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            contentPickerScreenKt$ContentPickerScreen$6$1$1$1$1RememberedValue = new ContentPickerScreenKt$ContentPickerScreen$6$1$1$1$1(store, null);
            composer.updateRememberedValue(contentPickerScreenKt$ContentPickerScreen$6$1$1$1$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) contentPickerScreenKt$ContentPickerScreen$6$1$1$1$1RememberedValue, composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, -418178504, "CC(remember):ContentPickerScreen.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(activity);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$0$1$0(activity);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SimpleBottomSheetKt.SimpleBottomSheet((Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(1821493305, true, new Function2() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$0$2(recentsItemPickerViewModel, contentPickerViewModel, navHostController, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$0$1$0(Activity activity) {
        activity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$0$2(RecentsItemPickerViewModel recentsItemPickerViewModel, ContentPickerViewModel contentPickerViewModel, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@3363L198,71@3600L85,74@3725L86,63@3145L684:ContentPickerScreen.kt#tyt3w8");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1821493305, i, -1, "com.box.android.contentpicker.ContentPickerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ContentPickerScreen.kt:63)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1891582913, "CC(remember):ContentPickerScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$0$2$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1891575442, "CC(remember):ContentPickerScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(navHostController);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$0$2$1$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1891571441, "CC(remember):ContentPickerScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(navHostController);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$0$2$2$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ContentSourcePickerScreenKt.ContentSourcePickerScreen(recentsItemPickerViewModel, contentPickerViewModel, function0, function1, (Function0) objRememberedValue3, composer, RecentsItemPickerViewModel.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$0$2$0$0(NavHostController navHostController) {
        navHostController.navigate(MULTI_TAB_ITEM_PICKER, new Function1() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$0$2$0$0$0((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$0$2$0$0$0(NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.popUpTo(ITEM_SOURCE_PICKER, new Function1() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$0$2$0$0$0$0((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$0$2$0$0$0$0(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setInclusive(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$0$2$1$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, CAPTURE_MEDIA, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$0$2$2$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, UPLOAD_CONTENT, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$1(State state, MultiTabItemPickerViewModels multiTabItemPickerViewModels, ContentPickerViewModel contentPickerViewModel, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):ContentPickerScreen.kt#tyt3w8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1463459302, i, -1, "com.box.android.contentpicker.ContentPickerScreen.<anonymous>.<anonymous>.<anonymous> (ContentPickerScreen.kt:82)");
        }
        List<ItemPickerTab> enabledTabs = ContentPickerScreen$lambda$3(state).getEnabledTabs();
        if (enabledTabs == null) {
            composer.startReplaceGroup(296996766);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(296996767);
            ComposerKt.sourceInformation(composer, "*83@3960L221");
            MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent(enabledTabs, null, multiTabItemPickerViewModels, contentPickerViewModel, null, composer, 0, 18);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$2(Function2 function2, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)93@4300L30,94@4365L74,92@4255L198:ContentPickerScreen.kt#tyt3w8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1375094939, i, -1, "com.box.android.contentpicker.ContentPickerScreen.<anonymous>.<anonymous>.<anonymous> (ContentPickerScreen.kt:92)");
        }
        Store<CaptureMediaHandlerReducer.State, CaptureMediaHandlerReducer.Action> store = ((CaptureMediaHandlerViewModel) function2.invoke(composer, 0)).getStore();
        ComposerKt.sourceInformationMarkerStart(composer, -1383686747, "CC(remember):ContentPickerScreen.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$2$0$0(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        CaptureMediaHandlerKt.CaptureMediaHandler(store, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$2$0$0(NavHostController navHostController) {
        NavControllerExtensionsKt.popBackStackSafely(navHostController);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$3(Function2 function2, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)102@4560L31,103@4626L74,101@4514L200:ContentPickerScreen.kt#tyt3w8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-81318116, i, -1, "com.box.android.contentpicker.ContentPickerScreen.<anonymous>.<anonymous>.<anonymous> (ContentPickerScreen.kt:101)");
        }
        Store<UploadContentHandlerReducer.State, UploadContentHandlerReducer.Action> store = ((UploadContentHandlerViewModel) function2.invoke(composer, 0)).getStore();
        ComposerKt.sourceInformationMarkerStart(composer, -837294042, "CC(remember):ContentPickerScreen.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.ContentPickerScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ContentPickerScreenKt.ContentPickerScreen$lambda$7$0$3$0$0(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        UploadContentHandlerKt.UploadContentHandler(store, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentPickerScreen$lambda$7$0$3$0$0(NavHostController navHostController) {
        NavControllerExtensionsKt.popBackStackSafely(navHostController);
        return Unit.INSTANCE;
    }

    private static final ContentPickerReducer.State ContentPickerScreen$lambda$3(State<ContentPickerReducer.State> state) {
        return state.getValue();
    }
}
