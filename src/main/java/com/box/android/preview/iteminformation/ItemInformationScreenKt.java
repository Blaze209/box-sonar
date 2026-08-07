package com.box.android.preview.iteminformation;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.base.compose.BoxColorsKt;
import com.box.android.base.compose.BoxItemThumbnailKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.compose.ItemThumbnail;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.base.compose.divider.BoxHorizontalDividerKt;
import com.box.android.base.compose.textfield.BoxTextFieldKt;
import com.box.android.base.cpl.StringResourceWrapper;
import com.box.android.common.utilities.BoxDateUtils;
import com.box.android.cpl.Store;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.ItemCollaborationModel;
import com.box.android.preview.R;
import com.box.android.preview.fileactions.UpdateItemInfoMessagesKt;
import com.box.android.preview.fileactions.UpdateItemInfoReducer;
import com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt;
import com.box.androidsdk.content.models.BoxFile;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ItemInformationScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u001a3\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001aO\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u0015\u001a'\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0019\u001a%\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u001e\u001a1\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\u0010$\u001a)\u0010%\u001a\u00020\u00012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010'H\u0007¢\u0006\u0002\u0010)\u001a'\u0010*\u001a\u00020\u00012\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010.\u001a\u001f\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020-2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u00101\u001a/\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u00107\u001aC\u00108\u001a\u00020\u00012\b\b\u0001\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010'2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010'H\u0007¢\u0006\u0002\u0010?¨\u0006@²\u0006\n\u0010\f\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"ItemInformationScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$State;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "avatarController", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "isRedesignedVersion", "", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;ZLandroidx/compose/runtime/Composer;II)V", "EditableNameDescription", "state", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;", "onNameChange", "Lkotlin/Function1;", "", "onDescriptionChange", "isFile", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NotEditableNameDescription", "name", "description", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ItemThumbnailSection", "thumbnail", "Lcom/box/android/base/compose/ItemThumbnail;", BoxFile.FIELD_EXTENSION, "(Landroidx/compose/ui/Modifier;Lcom/box/android/base/compose/ItemThumbnail;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "NotEditableItemInformationItem", "title", "text", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "UnsavedChangesConfirmationDialog", "onKeepChanges", "Lkotlin/Function0;", "onDiscardChanges", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MetadataSection", "entries", "", "Lcom/box/android/preview/iteminformation/MetadataItem;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MetadataItemSection", "entry", "(Lcom/box/android/preview/iteminformation/MetadataItem;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ItemInformationDetails", "itemDetails", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$ItemDetails;", "created", "modified", "(Lcom/box/android/preview/iteminformation/ItemInformationReducer$ItemDetails;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ItemInformationTopBar", "titleRes", "", "saveButtonEnabled", "saveButtonVisible", "onSaveClick", "onCloseClick", "(IZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemInformationScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditableNameDescription$lambda$1(UpdateItemInfoReducer.State state, Function1 function1, Function1 function2, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        EditableNameDescription(state, function1, function2, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationDetails$lambda$1(ItemInformationReducer.ItemDetails itemDetails, String str, String str2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ItemInformationDetails(itemDetails, str, str2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$11(Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, boolean z, int i, int i2, Composer composer, int i3) {
        ItemInformationScreen(store, defaultAvatarControllerWrapper, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationTopBar$lambda$1(int i, boolean z, boolean z2, Function0 function0, Function0 function1, int i2, Composer composer, int i3) {
        ItemInformationTopBar(i, z, z2, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemThumbnailSection$lambda$1(Modifier modifier, ItemThumbnail itemThumbnail, String str, int i, Composer composer, int i2) {
        ItemThumbnailSection(modifier, itemThumbnail, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MetadataItemSection$lambda$1(MetadataItem metadataItem, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MetadataItemSection(metadataItem, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MetadataSection$lambda$0(List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MetadataSection(list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MetadataSection$lambda$2(List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MetadataSection(list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotEditableItemInformationItem$lambda$2(String str, String str2, Modifier modifier, TextStyle textStyle, int i, int i2, Composer composer, int i3) {
        NotEditableItemInformationItem(str, str2, modifier, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotEditableNameDescription$lambda$1(String str, String str2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NotEditableNameDescription(str, str2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnsavedChangesConfirmationDialog$lambda$2(Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        UnsavedChangesConfirmationDialog(function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0269  */
    /* JADX WARN: Code duplicated, block: B:102:0x026b  */
    /* JADX WARN: Code duplicated, block: B:107:0x027b  */
    /* JADX WARN: Code duplicated, block: B:111:0x029b  */
    /* JADX WARN: Code duplicated, block: B:113:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:115:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:118:0x02df  */
    /* JADX WARN: Code duplicated, block: B:123:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:127:0x030b  */
    /* JADX WARN: Code duplicated, block: B:129:0x0310  */
    /* JADX WARN: Code duplicated, block: B:131:0x031f  */
    /* JADX WARN: Code duplicated, block: B:134:0x032a  */
    /* JADX WARN: Code duplicated, block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:50:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:51:0x0106  */
    /* JADX WARN: Code duplicated, block: B:54:0x0135  */
    /* JADX WARN: Code duplicated, block: B:57:0x0145  */
    /* JADX WARN: Code duplicated, block: B:58:0x0147  */
    /* JADX WARN: Code duplicated, block: B:63:0x0157  */
    /* JADX WARN: Code duplicated, block: B:66:0x0175  */
    /* JADX WARN: Code duplicated, block: B:67:0x0177  */
    /* JADX WARN: Code duplicated, block: B:72:0x0187  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:77:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:83:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:86:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:87:0x01df  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:94:0x0200  */
    /* JADX WARN: Code duplicated, block: B:97:0x023b  */
    /* JADX WARN: Code duplicated, block: B:99:0x0245  */
    public static final void ItemInformationScreen(Store<ItemInformationReducer.State, ItemInformationReducer.Action> store, final DefaultAvatarControllerWrapper avatarController, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        Composer composer2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        final State stateCollectAsStateWithLifecycle;
        final FocusManager focusManager;
        Object objRememberedValue;
        final SnackbarHostState snackbarHostState;
        Context context;
        Date contentCreatedDate;
        String dateAndTimeAccordingToLocalConventions;
        Date contentModifiedDate;
        String str;
        int i5;
        boolean z6;
        boolean z7;
        Object objRememberedValue2;
        boolean z8;
        boolean z9;
        Object objRememberedValue3;
        StringResourceWrapper updateItemErrorMessage;
        boolean z10;
        boolean z11;
        ItemInformationScreenKt$ItemInformationScreen$4$1$1 itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue;
        ItemInformationReducer.Error error;
        String strStringResource;
        boolean zChanged;
        ItemInformationScreenKt$ItemInformationScreen$5$1$1 itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue;
        boolean z12;
        Object objRememberedValue4;
        boolean z13;
        Object objRememberedValue5;
        final Store<ItemInformationReducer.State, ItemInformationReducer.Action> store2 = store;
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(avatarController, "avatarController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1897637920);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemInformationScreen)N(store,avatarController,isRedesignedVersion)86@4254L29,87@4325L7,88@4361L32,89@4425L7,102@4939L73,102@4928L84,107@5047L80,107@5036L91,120@5419L4276,120@5410L4285:ItemInformationScreen.kt#kcqqv0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(avatarController) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            i4 = i3;
            if ((i4 & Token.DOTQUERY) != 146) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1897637920, i4, -1, "com.box.android.preview.iteminformation.ItemInformationScreen (ItemInformationScreen.kt:85)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localFocusManager);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                focusManager = (FocusManager) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731049472, "CC(remember):ItemInformationScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                snackbarHostState = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume2;
                contentCreatedDate = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemModel().getContentCreatedDate();
                if (contentCreatedDate != null || (dateAndTimeAccordingToLocalConventions = BoxDateUtils.formatDateAndTimeAccordingToLocalConventions(contentCreatedDate, context)) == null) {
                    dateAndTimeAccordingToLocalConventions = "";
                }
                contentModifiedDate = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemModel().getContentModifiedDate();
                if (contentModifiedDate == null) {
                    composerStartRestartGroup.startReplaceGroup(-2122642212);
                    composerStartRestartGroup.endReplaceGroup();
                    str = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2122642211);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*95@4744L151");
                    String dateAndTimeAccordingToLocalConventions2 = BoxDateUtils.formatDateAndTimeAccordingToLocalConventions(contentModifiedDate, context);
                    int i7 = R.string.item_information_modified_date_by_user_format;
                    Intrinsics.checkNotNull(dateAndTimeAccordingToLocalConventions2);
                    String strStringResource2 = StringResources_androidKt.stringResource(i7, new Object[]{dateAndTimeAccordingToLocalConventions2, ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getDetails().getUpdatedByName()}, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    str = strStringResource2;
                }
                String str2 = str != null ? str : "";
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731030935, "CC(remember):ItemInformationScreen.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(focusManager);
                i5 = i4 & 14;
                if (i5 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance | z6;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z7 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ItemInformationScreenKt.ItemInformationScreen$lambda$4$0(focusManager, store2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function0 function0Remembered = ComposeUtilsKt.remembered((Function0) objRememberedValue2, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731027472, "CC(remember):ItemInformationScreen.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(focusManager);
                if (i5 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = zChangedInstance2 | z8;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z9 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ItemInformationScreenKt.ItemInformationScreen$lambda$5$0(focusManager, store2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function0 function0Remembered2 = ComposeUtilsKt.remembered((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                if (ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getShowUnsavedInfoConfirmationDialog()) {
                    composerStartRestartGroup.startReplaceGroup(-2127254174);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2122110561);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "113@5249L34,114@5316L72,112@5187L211");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731021054, "CC(remember):ItemInformationScreen.kt#9igjgp");
                    if (i5 == 4) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z12 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ItemInformationScreenKt.ItemInformationScreen$lambda$6$0(store2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function0 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731018872, "CC(remember):ItemInformationScreen.kt#9igjgp");
                    if (i5 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z13 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ItemInformationScreenKt.ItemInformationScreen$lambda$7$0(store2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    UnsavedChangesConfirmationDialog(function0, (Function0) objRememberedValue5, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                final String str3 = str2;
                final String str4 = dateAndTimeAccordingToLocalConventions;
                final boolean z14 = z5;
                Function2 function2 = new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemInformationScreenKt.ItemInformationScreen$lambda$8(z14, focusManager, function0Remembered, function0Remembered2, stateCollectAsStateWithLifecycle, snackbarHostState, store2, avatarController, str4, str3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                store2 = store2;
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1363888171, true, function2, composer2, 54), composer2, 6);
                updateItemErrorMessage = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getUpdateItemInfoState().getUpdateItemErrorMessage();
                if (updateItemErrorMessage == null) {
                    composer2.startReplaceGroup(-2117536698);
                } else {
                    composer2.startReplaceGroup(-2117536697);
                    ComposerKt.sourceInformation(composer2, "*211@9863L169,211@9801L231");
                    DomainError updateItemInfoError = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getUpdateItemInfoState().getUpdateItemInfoError();
                    ComposerKt.sourceInformationMarkerStart(composer2, -1417326728, "CC(remember):ItemInformationScreen.kt#9igjgp");
                    boolean zChangedInstance3 = composer2.changedInstance(updateItemErrorMessage);
                    if (i5 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance3 | z10;
                    itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue = composer2.rememberedValue();
                    if (!z11 || itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue = new ItemInformationScreenKt$ItemInformationScreen$4$1$1(snackbarHostState, updateItemErrorMessage, store2, null);
                        composer2.updateRememberedValue(itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(updateItemInfoError, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue, composer2, 0);
                }
                composer2.endReplaceGroup();
                error = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getError();
                if (error == null) {
                    composer2.startReplaceGroup(-2117263526);
                } else {
                    composer2.startReplaceGroup(-2117263525);
                    ComposerKt.sourceInformation(composer2, "*222@10303L202,222@10275L230");
                    if (error instanceof ItemInformationReducer.Error.RefreshFailed) {
                        composer2.startReplaceGroup(-327080542);
                        composer2.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer2.startReplaceGroup(-327078196);
                    ComposerKt.sourceInformation(composer2, "218@10174L82");
                    strStringResource = StringResources_androidKt.stringResource(R.string.failed_to_refresh_data, composer2, 0);
                    composer2.endReplaceGroup();
                    ItemInformationReducer.Error error2 = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getError();
                    ComposerKt.sourceInformationMarkerStart(composer2, -327073948, "CC(remember):ItemInformationScreen.kt#9igjgp");
                    zChanged = composer2.changed(strStringResource) | (i5 == 4);
                    itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged || itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue = new ItemInformationScreenKt$ItemInformationScreen$5$1$1(snackbarHostState, strStringResource, store2, null);
                        composer2.updateRememberedValue(itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(error2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue, composer2, 0);
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z14;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemInformationScreenKt.ItemInformationScreen$lambda$11(store2, avatarController, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        i4 = i3;
        if ((i4 & Token.DOTQUERY) != 146) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i6 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1897637920, i4, -1, "com.box.android.preview.iteminformation.ItemInformationScreen (ItemInformationScreen.kt:85)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ProvidableCompositionLocal<FocusManager> localFocusManager2 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localFocusManager2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            focusManager = (FocusManager) objConsume3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731049472, "CC(remember):ItemInformationScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume4;
            contentCreatedDate = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemModel().getContentCreatedDate();
            if (contentCreatedDate != null) {
                dateAndTimeAccordingToLocalConventions = "";
            } else {
                dateAndTimeAccordingToLocalConventions = "";
            }
            contentModifiedDate = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemModel().getContentModifiedDate();
            if (contentModifiedDate == null) {
                composerStartRestartGroup.startReplaceGroup(-2122642212);
                composerStartRestartGroup.endReplaceGroup();
                str = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-2122642211);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*95@4744L151");
                String dateAndTimeAccordingToLocalConventions3 = BoxDateUtils.formatDateAndTimeAccordingToLocalConventions(contentModifiedDate, context);
                int i8 = R.string.item_information_modified_date_by_user_format;
                Intrinsics.checkNotNull(dateAndTimeAccordingToLocalConventions3);
                String strStringResource3 = StringResources_androidKt.stringResource(i8, new Object[]{dateAndTimeAccordingToLocalConventions3, ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getDetails().getUpdatedByName()}, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                str = strStringResource3;
            }
            if (str != null) {
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731030935, "CC(remember):ItemInformationScreen.kt#9igjgp");
            boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(focusManager);
            i5 = i4 & 14;
            if (i5 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = zChangedInstance4 | z6;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemInformationScreenKt.ItemInformationScreen$lambda$4$0(focusManager, store2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemInformationScreenKt.ItemInformationScreen$lambda$4$0(focusManager, store2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Function0 function0Remembered3 = ComposeUtilsKt.remembered((Function0) objRememberedValue2, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731027472, "CC(remember):ItemInformationScreen.kt#9igjgp");
            boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(focusManager);
            if (i5 == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = zChangedInstance5 | z8;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z9) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemInformationScreenKt.ItemInformationScreen$lambda$5$0(focusManager, store2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemInformationScreenKt.ItemInformationScreen$lambda$5$0(focusManager, store2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Function0 function0Remembered4 = ComposeUtilsKt.remembered((Function0) objRememberedValue3, composerStartRestartGroup, 0);
            if (ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getShowUnsavedInfoConfirmationDialog()) {
                composerStartRestartGroup.startReplaceGroup(-2127254174);
            } else {
                composerStartRestartGroup.startReplaceGroup(-2122110561);
                ComposerKt.sourceInformation(composerStartRestartGroup, "113@5249L34,114@5316L72,112@5187L211");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731021054, "CC(remember):ItemInformationScreen.kt#9igjgp");
                if (i5 == 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ItemInformationScreenKt.ItemInformationScreen$lambda$6$0(store2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ItemInformationScreenKt.ItemInformationScreen$lambda$6$0(store2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function0 function1 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1731018872, "CC(remember):ItemInformationScreen.kt#9igjgp");
                if (i5 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z13) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ItemInformationScreenKt.ItemInformationScreen$lambda$7$0(store2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ItemInformationScreenKt.ItemInformationScreen$lambda$7$0(store2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                UnsavedChangesConfirmationDialog(function1, (Function0) objRememberedValue5, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            final String str5 = str2;
            final String str6 = dateAndTimeAccordingToLocalConventions;
            final boolean z15 = z5;
            Function2 function3 = new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.ItemInformationScreen$lambda$8(z15, focusManager, function0Remembered3, function0Remembered4, stateCollectAsStateWithLifecycle, snackbarHostState, store2, avatarController, str6, str5, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            store2 = store2;
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1363888171, true, function3, composer2, 54), composer2, 6);
            updateItemErrorMessage = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getUpdateItemInfoState().getUpdateItemErrorMessage();
            if (updateItemErrorMessage == null) {
                composer2.startReplaceGroup(-2117536698);
            } else {
                composer2.startReplaceGroup(-2117536697);
                ComposerKt.sourceInformation(composer2, "*211@9863L169,211@9801L231");
                DomainError updateItemInfoError2 = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getUpdateItemInfoState().getUpdateItemInfoError();
                ComposerKt.sourceInformationMarkerStart(composer2, -1417326728, "CC(remember):ItemInformationScreen.kt#9igjgp");
                boolean zChangedInstance6 = composer2.changedInstance(updateItemErrorMessage);
                if (i5 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = zChangedInstance6 | z10;
                itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue = composer2.rememberedValue();
                if (!z11) {
                    itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue = new ItemInformationScreenKt$ItemInformationScreen$4$1$1(snackbarHostState, updateItemErrorMessage, store2, null);
                    composer2.updateRememberedValue(itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue);
                } else {
                    itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue = new ItemInformationScreenKt$ItemInformationScreen$4$1$1(snackbarHostState, updateItemErrorMessage, store2, null);
                    composer2.updateRememberedValue(itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(updateItemInfoError2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) itemInformationScreenKt$ItemInformationScreen$4$1$1RememberedValue, composer2, 0);
            }
            composer2.endReplaceGroup();
            error = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getError();
            if (error == null) {
                composer2.startReplaceGroup(-2117263526);
            } else {
                composer2.startReplaceGroup(-2117263525);
                ComposerKt.sourceInformation(composer2, "*222@10303L202,222@10275L230");
                if (error instanceof ItemInformationReducer.Error.RefreshFailed) {
                    composer2.startReplaceGroup(-327080542);
                    composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer2.startReplaceGroup(-327078196);
                ComposerKt.sourceInformation(composer2, "218@10174L82");
                strStringResource = StringResources_androidKt.stringResource(R.string.failed_to_refresh_data, composer2, 0);
                composer2.endReplaceGroup();
                ItemInformationReducer.Error error3 = ItemInformationScreen$lambda$0(stateCollectAsStateWithLifecycle).getError();
                ComposerKt.sourceInformationMarkerStart(composer2, -327073948, "CC(remember):ItemInformationScreen.kt#9igjgp");
                zChanged = composer2.changed(strStringResource) | (i5 == 4);
                itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue = composer2.rememberedValue();
                if (!zChanged) {
                    itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue = new ItemInformationScreenKt$ItemInformationScreen$5$1$1(snackbarHostState, strStringResource, store2, null);
                    composer2.updateRememberedValue(itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue);
                } else {
                    itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue = new ItemInformationScreenKt$ItemInformationScreen$5$1$1(snackbarHostState, strStringResource, store2, null);
                    composer2.updateRememberedValue(itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(error3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) itemInformationScreenKt$ItemInformationScreen$5$1$1RememberedValue, composer2, 0);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z15;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.ItemInformationScreen$lambda$11(store2, avatarController, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$4$0(FocusManager focusManager, Store store) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        store.send(ItemInformationReducer.Action.Save.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$5$0(FocusManager focusManager, Store store) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        store.send(ItemInformationReducer.Action.TriggerExit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$6$0(Store store) {
        store.send(ItemInformationReducer.Action.KeepChanges.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$7$0(Store store) {
        store.send(ItemInformationReducer.Action.DiscardChangesAndExit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$8(boolean z, final FocusManager focusManager, final Function0 function0, final Function0 function1, final State state, final SnackbarHostState snackbarHostState, final Store store, final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, final String str, final String str2, Composer composer, int i) {
        long jM11544getPreviewBackground0d7_KjU;
        ComposerKt.sourceInformation(composer, "C124@5631L142,142@6452L11,132@5917L486,129@5802L92,144@6475L3214,121@5429L4260:ItemInformationScreen.kt#kcqqv0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1363888171, i, -1, "com.box.android.preview.iteminformation.ItemInformationScreen.<anonymous> (ItemInformationScreen.kt:121)");
            }
            if (z) {
                composer.startReplaceGroup(731509944);
                ComposerKt.sourceInformation(composer, "122@5502L6");
                jM11544getPreviewBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
            } else {
                composer.startReplaceGroup(731511068);
                ComposerKt.sourceInformation(composer, "122@5537L6");
                jM11544getPreviewBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU();
            }
            composer.endReplaceGroup();
            long j = jM11544getPreviewBackground0d7_KjU;
            Modifier.Companion companion = Modifier.INSTANCE;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 731513977, "CC(remember):ItemInformationScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(focusManager);
            ItemInformationScreenKt$ItemInformationScreen$3$1$1 itemInformationScreenKt$ItemInformationScreen$3$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || itemInformationScreenKt$ItemInformationScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                itemInformationScreenKt$ItemInformationScreen$3$1$1RememberedValue = new ItemInformationScreenKt$ItemInformationScreen$3$1$1(focusManager);
                composer.updateRememberedValue(itemInformationScreenKt$ItemInformationScreen$3$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ScaffoldKt.m4038ScaffoldTvnljyQ(SuspendingPointerInputFilterKt.pointerInput(companion, unit, (PointerInputEventHandler) itemInformationScreenKt$ItemInformationScreen$3$1$1RememberedValue), ComposableLambdaKt.rememberComposableLambda(1413209583, true, new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.ItemInformationScreen$lambda$8$1(function0, function1, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposableLambdaKt.rememberComposableLambda(692290161, true, new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.ItemInformationScreen$lambda$8$2(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0, j, 0L, WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composer, 6), ComposableLambdaKt.rememberComposableLambda(985930618, true, new Function3() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ItemInformationScreenKt.ItemInformationScreen$lambda$8$3(state, function0, store, defaultAvatarControllerWrapper, focusManager, str, str2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805309488, 180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$8$2(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C130@5820L60:ItemInformationScreen.kt#kcqqv0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(692290161, i, -1, "com.box.android.preview.iteminformation.ItemInformationScreen.<anonymous>.<anonymous> (ItemInformationScreen.kt:130)");
            }
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$8$1(Function0 function0, Function0 function1, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C134@6043L346:ItemInformationScreen.kt#kcqqv0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1413209583, i, -1, "com.box.android.preview.iteminformation.ItemInformationScreen.<anonymous>.<anonymous> (ItemInformationScreen.kt:133)");
            }
            ItemInformationTopBar(ItemInformationScreen$lambda$0(state).getDetails().isFile() ? R.string.file_info : R.string.folder_info, ItemInformationScreen$lambda$0(state).getUpdateItemInfoState().getUpdateEnabled(), ItemInformationScreen$lambda$0(state).getUpdateItemInfoState().getHasUpdatePermission(), function0, function1, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$8$3(State state, final Function0 function0, final Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, final FocusManager focusManager, String str, String str2, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer2, "CN(paddingValues)148@6621L21,145@6506L3173:ItemInformationScreen.kt#kcqqv0");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(985930618, i2, -1, "com.box.android.preview.iteminformation.ItemInformationScreen.<anonymous>.<anonymous> (ItemInformationScreen.kt:145)");
            }
            Modifier modifierPadding = PaddingKt.padding(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null), paddingValues);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceEvenly, Alignment.INSTANCE.getStart(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1495789181, "C152@6783L240,157@7040L2625:ItemInformationScreen.kt#kcqqv0");
            ItemThumbnailSection(columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally()), ItemInformationScreen$lambda$0(state).getItemThumbnailState().getThumbnail(), ItemInformationScreen$lambda$0(state).getDetails().getExtension(), composer2, ItemThumbnail.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 755760035, "C188@8895L181,188@8884L192,183@8518L646,194@9185L276,200@9482L165:ItemInformationScreen.kt#kcqqv0");
            if (ItemInformationScreen$lambda$0(state).getUpdateItemInfoState().getHasUpdatePermission()) {
                composer2.startReplaceGroup(755762669);
                ComposerKt.sourceInformation(composer2, "159@7176L80,162@7397L372,171@7877L54,172@7983L61,160@7281L848");
                final String strStringResource = StringResources_androidKt.stringResource(R.string.save_name_and_description_changes_action_talkback_label, composer2, 0);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 162934978, "CC(remember):ItemInformationScreen.kt#9igjgp");
                boolean zChanged = composer2.changed(strStringResource) | composer2.changed(function0);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ItemInformationScreenKt.ItemInformationScreen$lambda$8$3$0$0$0$0(strStringResource, function0, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue, 1, null);
                UpdateItemInfoReducer.State updateItemInfoState = ItemInformationScreen$lambda$0(state).getUpdateItemInfoState();
                boolean zIsFile = ItemInformationScreen$lambda$0(state).getDetails().isFile();
                ComposerKt.sourceInformationMarkerStart(composer2, 162950020, "CC(remember):ItemInformationScreen.kt#9igjgp");
                boolean zChanged2 = composer2.changed(store);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ItemInformationScreenKt.ItemInformationScreen$lambda$8$3$0$0$1$0(store, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function1 function1 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 162953419, "CC(remember):ItemInformationScreen.kt#9igjgp");
                boolean zChanged3 = composer2.changed(store);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ItemInformationScreenKt.ItemInformationScreen$lambda$8$3$0$0$2$0(store, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EditableNameDescription(updateItemInfoState, function1, (Function1) objRememberedValue3, zIsFile, modifierSemantics$default, composer2, 0, 0);
                composer2 = composer2;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(756769921);
                ComposerKt.sourceInformation(composer2, "176@8183L291");
                NotEditableNameDescription(ItemInformationScreen$lambda$0(state).getUpdateItemInfoState().getUpdatedName(), ItemInformationScreen$lambda$0(state).getUpdateItemInfoState().getUpdatedDescription(), PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(40), 0.0f, 2, null), composer2, 384, 0);
                composer2.endReplaceGroup();
            }
            ImmutableList<ItemCollaborationModel> collaborations = ItemInformationScreen$lambda$0(state).getCollaborations();
            ComposerKt.sourceInformationMarkerStart(composer2, 162982723, "CC(remember):ItemInformationScreen.kt#9igjgp");
            boolean zChangedInstance = composer2.changedInstance(focusManager) | composer2.changed(store);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemInformationScreenKt.ItemInformationScreen$lambda$8$3$0$0$3$0(focusManager, store);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            float f = 24;
            CollaboratorsElementKt.CollaboratorsElement(collaborations, 8, 99, defaultAvatarControllerWrapper, ComposeUtilsKt.remembered((Function0) objRememberedValue4, composer2, 0), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 13, null), composer2, 197040, 0);
            float f2 = 40;
            ItemInformationDetails(ItemInformationScreen$lambda$0(state).getDetails(), str, str2, PaddingKt.m1219paddingVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f)), composer, 3072, 0);
            MetadataSection(ItemInformationScreen$lambda$0(state).getMetadataItems(), PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null), composer, 48, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$8$3$0$0$0$0(String str, final Function0 function0, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setCustomActions(semantics, CollectionsKt.listOf(new CustomAccessibilityAction(str, new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ItemInformationScreenKt.ItemInformationScreen$lambda$8$3$0$0$0$0$0(function0));
            }
        })));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ItemInformationScreen$lambda$8$3$0$0$0$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$8$3$0$0$1$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new ItemInformationReducer.Action.UpdateItemInfo(new UpdateItemInfoReducer.Action.NameUpdated(it)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$8$3$0$0$2$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new ItemInformationReducer.Action.UpdateItemInfo(new UpdateItemInfoReducer.Action.DescriptionUpdated(it)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreen$lambda$8$3$0$0$3$0(FocusManager focusManager, Store store) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        store.send(new ItemInformationReducer.Action.Navigate(ItemInformationReducer.Route.Collaborators.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x0091  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:60:0x0106  */
    /* JADX WARN: Code duplicated, block: B:61:0x010a  */
    /* JADX WARN: Code duplicated, block: B:64:0x016d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0179  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:69:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:72:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:73:0x0207  */
    /* JADX WARN: Code duplicated, block: B:76:0x026f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0274  */
    /* JADX WARN: Code duplicated, block: B:81:0x0280  */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    private static final void EditableNameDescription(UpdateItemInfoReducer.State state, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function2, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        UpdateItemInfoReducer.State state2;
        int i3;
        Modifier modifier2;
        boolean z2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        UpdateItemInfoReducer.NameError nameError;
        String str;
        int i4;
        UpdateItemInfoReducer.DescriptionError descriptionError;
        String message;
        Composer composerStartRestartGroup = composer.startRestartGroup(545507152);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditableNameDescription)N(state,onNameChange,onDescriptionChange,isFile,modifier)240@10746L1483:ItemInformationScreen.kt#kcqqv0");
        if ((i & 6) == 0) {
            state2 = state;
            i3 = (composerStartRestartGroup.changedInstance(state2) ? 4 : 2) | i;
        } else {
            state2 = state;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        int i5 = i2 & 16;
        if (i5 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i3 & 9363) != 9362) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(545507152, i3, -1, "com.box.android.preview.iteminformation.EditableNameDescription (ItemInformationScreen.kt:239)");
                }
                float f = 24;
                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2106229755, "C243@10857L50,244@10935L37,242@10823L530,254@11362L28,258@11463L57,259@11548L251,257@11429L794:ItemInformationScreen.kt#kcqqv0");
                String strStringResource = StringResources_androidKt.stringResource(com.box.android.base.R.string.name, composerStartRestartGroup, 0);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.enter_a_name, composerStartRestartGroup, 0);
                String updatedName = state2.getUpdatedName();
                nameError = state2.getNameError();
                if (nameError == null) {
                    composerStartRestartGroup.startReplaceGroup(-2106044656);
                    composerStartRestartGroup.endReplaceGroup();
                    str = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1456083729);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "246@11053L11");
                    String message2 = UpdateItemInfoMessagesKt.toMessage(nameError, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    str = message2;
                }
                int i6 = (i3 >> 6) & 896;
                BoxTextFieldKt.BoxTextField(updatedName, function1, companion, !state2.isRenamePending(), state2.isRenamePending(), strStringResource, strStringResource2, str, false, 0, 10, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9277getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), null, composerStartRestartGroup, (i3 & 112) | i6, 54, 4864);
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                String strStringResource3 = StringResources_androidKt.stringResource(com.box.android.base.R.string.description, composerStartRestartGroup, 0);
                if (z) {
                    i4 = com.box.android.base.R.string.add_file_description;
                } else {
                    i4 = com.box.android.base.R.string.add_folder_description;
                }
                String strStringResource4 = StringResources_androidKt.stringResource(i4, composerStartRestartGroup, 0);
                String updatedDescription = state2.getUpdatedDescription();
                descriptionError = state2.getDescriptionError();
                if (descriptionError == null) {
                    composerStartRestartGroup.startReplaceGroup(-2105210384);
                    composerStartRestartGroup.endReplaceGroup();
                    message = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1456110641);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "267@11894L11");
                    message = UpdateItemInfoMessagesKt.toMessage(descriptionError, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composer2 = composerStartRestartGroup;
                BoxTextFieldKt.BoxTextField(updatedDescription, function2, companion, !state2.isDescriptionUpdatePending(), state2.isDescriptionUpdatePending(), strStringResource3, strStringResource4, message, false, 0, 10, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9277getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), null, composer2, ((i3 >> 3) & 112) | i6, 54, 4864);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final UpdateItemInfoReducer.State state3 = state2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemInformationScreenKt.EditableNameDescription$lambda$1(state3, function1, function2, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i3 & 9363) != 9362) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(545507152, i3, -1, "com.box.android.preview.iteminformation.EditableNameDescription (ItemInformationScreen.kt:239)");
            }
            float f2 = 24;
            Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2106229755, "C243@10857L50,244@10935L37,242@10823L530,254@11362L28,258@11463L57,259@11548L251,257@11429L794:ItemInformationScreen.kt#kcqqv0");
            String strStringResource5 = StringResources_androidKt.stringResource(com.box.android.base.R.string.name, composerStartRestartGroup, 0);
            String strStringResource6 = StringResources_androidKt.stringResource(R.string.enter_a_name, composerStartRestartGroup, 0);
            String updatedName2 = state2.getUpdatedName();
            nameError = state2.getNameError();
            if (nameError == null) {
                composerStartRestartGroup.startReplaceGroup(-2106044656);
                composerStartRestartGroup.endReplaceGroup();
                str = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1456083729);
                ComposerKt.sourceInformation(composerStartRestartGroup, "246@11053L11");
                String message3 = UpdateItemInfoMessagesKt.toMessage(nameError, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                str = message3;
            }
            int i7 = (i3 >> 6) & 896;
            BoxTextFieldKt.BoxTextField(updatedName2, function1, companion, !state2.isRenamePending(), state2.isRenamePending(), strStringResource5, strStringResource6, str, false, 0, 10, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9277getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), null, composerStartRestartGroup, (i3 & 112) | i7, 54, 4864);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
            String strStringResource7 = StringResources_androidKt.stringResource(com.box.android.base.R.string.description, composerStartRestartGroup, 0);
            if (z) {
                i4 = com.box.android.base.R.string.add_file_description;
            } else {
                i4 = com.box.android.base.R.string.add_folder_description;
            }
            String strStringResource8 = StringResources_androidKt.stringResource(i4, composerStartRestartGroup, 0);
            String updatedDescription2 = state2.getUpdatedDescription();
            descriptionError = state2.getDescriptionError();
            if (descriptionError == null) {
                composerStartRestartGroup.startReplaceGroup(-2105210384);
                composerStartRestartGroup.endReplaceGroup();
                message = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1456110641);
                ComposerKt.sourceInformation(composerStartRestartGroup, "267@11894L11");
                message = UpdateItemInfoMessagesKt.toMessage(descriptionError, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            composer2 = composerStartRestartGroup;
            BoxTextFieldKt.BoxTextField(updatedDescription2, function2, companion, !state2.isDescriptionUpdatePending(), state2.isDescriptionUpdatePending(), strStringResource7, strStringResource8, message, false, 0, 10, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9277getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), null, composer2, ((i3 >> 3) & 112) | i7, 54, 4864);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final UpdateItemInfoReducer.State state4 = state2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.EditableNameDescription$lambda$1(state4, function1, function2, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:49:0x0151  */
    /* JADX WARN: Code duplicated, block: B:50:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:53:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:55:0x0201  */
    /* JADX WARN: Code duplicated, block: B:58:0x020b  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    public static final void NotEditableNameDescription(final String name, final String description, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function0<ComposeUiNode> constructor;
        Modifier modifier5;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Composer composerStartRestartGroup = composer.startRestartGroup(32562750);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotEditableNameDescription)N(name,description,modifier)280@12348L815:ItemInformationScreen.kt#kcqqv0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(name) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(description) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i3;
            if ((i4 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(32562750, i4, -1, "com.box.android.preview.iteminformation.NotEditableNameDescription (ItemInformationScreen.kt:279)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1844805267, "C282@12427L50,281@12375L137,285@12521L28:ItemInformationScreen.kt#kcqqv0");
                NotEditableItemInformationItem(StringResources_androidKt.stringResource(com.box.android.base.R.string.name, composerStartRestartGroup, 0), name, null, null, composerStartRestartGroup, (i4 << 3) & 112, 12);
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), composerStartRestartGroup, 6);
                if (description.length() == 0) {
                    composerStartRestartGroup.startReplaceGroup(-1844609441);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "288@12655L57,289@12737L53,291@12895L6,287@12599L355");
                    modifier5 = modifier4;
                    NotEditableItemInformationItem(StringResources_androidKt.stringResource(com.box.android.base.R.string.description, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.no_description_provided, composerStartRestartGroup, 0), null, TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11527getItemInfoTextTertiary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composerStartRestartGroup, 0, 4);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier5 = modifier4;
                    composerStartRestartGroup.startReplaceGroup(-1844233473);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "296@13040L57,295@12984L163");
                    NotEditableItemInformationItem(StringResources_androidKt.stringResource(com.box.android.base.R.string.description, composerStartRestartGroup, 0), description, null, null, composerStartRestartGroup, i4 & 112, 12);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemInformationScreenKt.NotEditableNameDescription$lambda$1(name, description, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(32562750, i4, -1, "com.box.android.preview.iteminformation.NotEditableNameDescription (ItemInformationScreen.kt:279)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1844805267, "C282@12427L50,281@12375L137,285@12521L28:ItemInformationScreen.kt#kcqqv0");
            NotEditableItemInformationItem(StringResources_androidKt.stringResource(com.box.android.base.R.string.name, composerStartRestartGroup, 0), name, null, null, composerStartRestartGroup, (i4 << 3) & 112, 12);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), composerStartRestartGroup, 6);
            if (description.length() == 0) {
                composerStartRestartGroup.startReplaceGroup(-1844609441);
                ComposerKt.sourceInformation(composerStartRestartGroup, "288@12655L57,289@12737L53,291@12895L6,287@12599L355");
                modifier5 = modifier4;
                NotEditableItemInformationItem(StringResources_androidKt.stringResource(com.box.android.base.R.string.description, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.no_description_provided, composerStartRestartGroup, 0), null, TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11527getItemInfoTextTertiary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composerStartRestartGroup, 0, 4);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                modifier5 = modifier4;
                composerStartRestartGroup.startReplaceGroup(-1844233473);
                ComposerKt.sourceInformation(composerStartRestartGroup, "296@13040L57,295@12984L163");
                NotEditableItemInformationItem(StringResources_androidKt.stringResource(com.box.android.base.R.string.description, composerStartRestartGroup, 0), description, null, null, composerStartRestartGroup, i4 & 112, 12);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.NotEditableNameDescription$lambda$1(name, description, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ItemThumbnailSection(final Modifier modifier, final ItemThumbnail itemThumbnail, String str, Composer composer, final int i) {
        int i2;
        final String str2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-755560758);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemThumbnailSection)N(modifier,thumbnail,extension)305@13283L900:ItemInformationScreen.kt#kcqqv0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(itemThumbnail) : composerStartRestartGroup.changedInstance(itemThumbnail) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            str2 = str;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-755560758, i3, -1, "com.box.android.preview.iteminformation.ItemThumbnailSection (ItemInformationScreen.kt:304)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -435273224, "C306@13318L259:ItemInformationScreen.kt#kcqqv0");
            BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(itemThumbnail, SizeKt.m1266size3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(18), 0.0f, Dp.m9687constructorimpl(24), 5, null), Dp.m9687constructorimpl(175)), Dp.m9687constructorimpl(0), ContentScale.INSTANCE.getFit(), null, composerStartRestartGroup, ((i3 >> 3) & 14) | ItemThumbnail.$stable | 3504, 16);
            if (str.length() > 0) {
                composerStartRestartGroup.startReplaceGroup(-434975625);
                ComposerKt.sourceInformation(composerStartRestartGroup, "319@13786L6,326@14131L6,315@13628L539");
                str2 = str;
                TextKt.m4494TextNvy7gAk(str2, boxScopeInstance.align(PaddingKt.m1219paddingVpY3zN4(BackgroundKt.m588backgroundbw27NRU(OffsetKt.m1175offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(-12), 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11565getTextFieldLabel0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(4))), Dp.m9687constructorimpl(6), Dp.m9687constructorimpl(3)), Alignment.INSTANCE.getBottomCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11516getDialogContainer0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold12(), composerStartRestartGroup, (i3 >> 6) & 14, 0, 131064);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                str2 = str;
                composerStartRestartGroup.startReplaceGroup(-448512302);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.ItemThumbnailSection$lambda$1(modifier, itemThumbnail, str2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0063  */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:41:0x007e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:45:0x0089  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:56:0x00af  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:60:0x010b  */
    /* JADX WARN: Code duplicated, block: B:64:0x011b  */
    /* JADX WARN: Code duplicated, block: B:67:0x0135  */
    /* JADX WARN: Code duplicated, block: B:70:0x018c  */
    /* JADX WARN: Code duplicated, block: B:73:0x0198  */
    /* JADX WARN: Code duplicated, block: B:74:0x019c  */
    /* JADX WARN: Code duplicated, block: B:77:0x029e  */
    /* JADX WARN: Code duplicated, block: B:79:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:82:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    public static final void NotEditableItemInformationItem(final String title, final String text, Modifier modifier, TextStyle textStyle, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        TextStyle textStyle2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final TextStyle textStyle3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i4;
        Modifier modifier4;
        TextStyle textStyleM9104copyp1EtxEg$default;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(1150694177);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotEditableItemInformationItem)N(title,text,modifier,textStyle)342@14500L2,341@14429L419:ItemInformationScreen.kt#kcqqv0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(text) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    textStyle2 = textStyle;
                    int i6 = composerStartRestartGroup.changed(textStyle2) ? 2048 : 1024;
                    i3 |= i6;
                } else {
                    textStyle2 = textStyle;
                }
                i3 |= i6;
            } else {
                textStyle2 = textStyle;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "338@14397L6");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        Modifier modifier5 = companion;
                        i4 = i3 & (-7169);
                        modifier4 = modifier5;
                        textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                    } else {
                        Modifier modifier6 = companion;
                        i4 = i3;
                        modifier4 = modifier6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1150694177, i4, -1, "com.box.android.preview.iteminformation.NotEditableItemInformationItem (ItemInformationScreen.kt:340)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2010518659, "CC(remember):ItemInformationScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ItemInformationScreenKt.NotEditableItemInformationItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier4, true, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1165115285, "C347@14633L6,344@14519L152,349@14680L27,350@14716L126:ItemInformationScreen.kt#kcqqv0");
                    composer2 = composerStartRestartGroup;
                    Modifier modifier7 = modifier4;
                    int i7 = i4;
                    TextKt.m4494TextNvy7gAk(title, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11526getItemInfoTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, i4 & 14, 0, 131066);
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer2, 6);
                    TextStyle textStyle4 = textStyleM9104copyp1EtxEg$default;
                    TextKt.m4494TextNvy7gAk(text, TestTagKt.testTag(Modifier.INSTANCE, title + ":Text"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle4, composer2, (i7 >> 3) & 14, (i7 << 12) & 29360128, 131068);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    textStyle3 = textStyle4;
                    modifier3 = modifier7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    i4 = i3;
                    modifier4 = modifier2;
                }
                textStyleM9104copyp1EtxEg$default = textStyle2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1150694177, i4, -1, "com.box.android.preview.iteminformation.NotEditableItemInformationItem (ItemInformationScreen.kt:340)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2010518659, "CC(remember):ItemInformationScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ItemInformationScreenKt.NotEditableItemInformationItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics2 = SemanticsModifierKt.semantics(modifier4, true, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1165115285, "C347@14633L6,344@14519L152,349@14680L27,350@14716L126:ItemInformationScreen.kt#kcqqv0");
                composer2 = composerStartRestartGroup;
                Modifier modifier8 = modifier4;
                int i8 = i4;
                TextKt.m4494TextNvy7gAk(title, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11526getItemInfoTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, i4 & 14, 0, 131066);
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer2, 6);
                TextStyle textStyle5 = textStyleM9104copyp1EtxEg$default;
                TextKt.m4494TextNvy7gAk(text, TestTagKt.testTag(Modifier.INSTANCE, title + ":Text"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle5, composer2, (i8 >> 3) & 14, (i8 << 12) & 29360128, 131068);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textStyle3 = textStyle5;
                modifier3 = modifier8;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                textStyle3 = textStyle2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemInformationScreenKt.NotEditableItemInformationItem$lambda$2(title, text, modifier3, textStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                textStyle2 = textStyle;
                if (composerStartRestartGroup.changed(textStyle2)) {
                }
                i3 |= i6;
            } else {
                textStyle2 = textStyle;
            }
            i3 |= i6;
        } else {
            textStyle2 = textStyle;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "338@14397L6");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    Modifier modifier9 = companion;
                    i4 = i3 & (-7169);
                    modifier4 = modifier9;
                    textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                } else {
                    Modifier modifier10 = companion;
                    i4 = i3;
                    modifier4 = modifier10;
                    textStyleM9104copyp1EtxEg$default = textStyle2;
                }
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    Modifier modifier11 = companion;
                    i4 = i3 & (-7169);
                    modifier4 = modifier11;
                    textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                } else {
                    Modifier modifier12 = companion;
                    i4 = i3;
                    modifier4 = modifier12;
                    textStyleM9104copyp1EtxEg$default = textStyle2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1150694177, i4, -1, "com.box.android.preview.iteminformation.NotEditableItemInformationItem (ItemInformationScreen.kt:340)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2010518659, "CC(remember):ItemInformationScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ItemInformationScreenKt.NotEditableItemInformationItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics3 = SemanticsModifierKt.semantics(modifier4, true, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics3);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1165115285, "C347@14633L6,344@14519L152,349@14680L27,350@14716L126:ItemInformationScreen.kt#kcqqv0");
            composer2 = composerStartRestartGroup;
            Modifier modifier13 = modifier4;
            int i9 = i4;
            TextKt.m4494TextNvy7gAk(title, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11526getItemInfoTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, i4 & 14, 0, 131066);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer2, 6);
            TextStyle textStyle6 = textStyleM9104copyp1EtxEg$default;
            TextKt.m4494TextNvy7gAk(text, TestTagKt.testTag(Modifier.INSTANCE, title + ":Text"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle6, composer2, (i9 >> 3) & 14, (i9 << 12) & 29360128, 131068);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            textStyle3 = textStyle6;
            modifier3 = modifier13;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            textStyle3 = textStyle2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.NotEditableItemInformationItem$lambda$2(title, text, modifier3, textStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotEditableItemInformationItem$lambda$0$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        return Unit.INSTANCE;
    }

    public static final void UnsavedChangesConfirmationDialog(final Function0<Unit> onKeepChanges, final Function0<Unit> onDiscardChanges, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onKeepChanges, "onKeepChanges");
        Intrinsics.checkNotNullParameter(onDiscardChanges, "onDiscardChanges");
        Composer composerStartRestartGroup = composer.startRestartGroup(1219846073);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UnsavedChangesConfirmationDialog)N(onKeepChanges,onDiscardChanges)364@15202L29,368@15378L26,360@14964L498:ItemInformationScreen.kt#kcqqv0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onKeepChanges) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDiscardChanges) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1219846073, i2, -1, "com.box.android.preview.iteminformation.UnsavedChangesConfirmationDialog (ItemInformationScreen.kt:359)");
            }
            int i3 = i2;
            int i4 = com.box.android.base.R.string.discard_change_dialog_title;
            int i5 = com.box.android.base.R.string.discard_change_dialog_text;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -253984810, "CC(remember):ItemInformationScreen.kt#9igjgp");
            boolean z = (i3 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemInformationScreenKt.UnsavedChangesConfirmationDialog$lambda$0$0(onDiscardChanges);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, com.box.android.base.R.string.Discard, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -253979181, "CC(remember):ItemInformationScreen.kt#9igjgp");
            boolean z2 = (i3 & 14) == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemInformationScreenKt.UnsavedChangesConfirmationDialog$lambda$1$0(onKeepChanges);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i4, i5, textButtonItem, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.LO_Cancel, 1, null), null, null, 0L, 0L, composerStartRestartGroup, 0, PsExtractor.VIDEO_STREAM_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.UnsavedChangesConfirmationDialog$lambda$2(onKeepChanges, onDiscardChanges, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnsavedChangesConfirmationDialog$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnsavedChangesConfirmationDialog$lambda$1$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:62:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:65:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:68:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:71:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:72:0x02dd A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    public static final void MetadataSection(final List<MetadataItem> list, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final List<MetadataItem> list2;
        final Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        List<MetadataItem> list3;
        final Modifier modifier5;
        Composer composerStartRestartGroup = composer.startRestartGroup(2027823792);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MetadataSection)N(entries,modifier)385@15924L648:ItemInformationScreen.kt#kcqqv0");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changedInstance(list) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                list2 = list;
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2027823792, i3, -1, "com.box.android.preview.iteminformation.MetadataSection (ItemInformationScreen.kt:382)");
                }
                list3 = list;
                if (list3 != null || list3.isEmpty()) {
                    modifier5 = modifier4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ItemInformationScreenKt.MetadataSection$lambda$0(list, modifier5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                } else {
                    Modifier modifierTestTag = TestTagKt.testTag(modifier4, "ItemInformationScreen:Metadata");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1742141230, "C389@16031L38,390@16078L488:ItemInformationScreen.kt#kcqqv0");
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, Dp.m9687constructorimpl(2), 0L, composerStartRestartGroup, 48, 5);
                    float f = 24;
                    Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 0.0f, Dp.m9687constructorimpl(f), 5, null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 37949573, "C395@16271L47,397@16410L6,394@16242L210:ItemInformationScreen.kt#kcqqv0");
                    modifier3 = modifier4;
                    TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.metadata_section_title, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11526getItemInfoTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium14(), composerStartRestartGroup, 0, 0, 131066);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(-1799883977);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*400@16508L34");
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        MetadataItemSection((MetadataItem) it.next(), null, composerStartRestartGroup, 0, 2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    list2 = list;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                function2 = new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemInformationScreenKt.MetadataSection$lambda$2(list2, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            list2 = list;
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2027823792, i3, -1, "com.box.android.preview.iteminformation.MetadataSection (ItemInformationScreen.kt:382)");
            }
            list3 = list;
            if (list3 != null) {
            }
            modifier5 = modifier4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                function2 = new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemInformationScreenKt.MetadataSection$lambda$0(list, modifier5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            return;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.MetadataSection$lambda$2(list2, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:43:0x0187 A[LOOP:0: B:41:0x0181->B:43:0x0187, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:47:0x01be  */
    /* JADX WARN: Code duplicated, block: B:50:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    private static final void MetadataItemSection(final MetadataItem metadataItem, Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1870225113);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MetadataItemSection)N(entry,modifier)408@16678L485:ItemInformationScreen.kt#kcqqv0");
        int i3 = (i & 6) == 0 ? (composerStartRestartGroup.changed(metadataItem) ? 4 : 2) | i : i;
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1870225113, i3, -1, "com.box.android.preview.iteminformation.MetadataItemSection (ItemInformationScreen.kt:407)");
                }
                Modifier modifierTestTag = TestTagKt.testTag(companion, "ItemInformationScreen:MetadataItem-" + metadataItem.getId());
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(16));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2062320937, "C415@16932L10,416@16985L6,413@16860L163:ItemInformationScreen.kt#kcqqv0");
                modifier3 = companion;
                TextKt.m4494TextNvy7gAk(metadataItem.getTitle(), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11526getItemInfoTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium(), composerStartRestartGroup, 0, 0, 131066);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(343626881);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*419@17076L71");
                for (MetadataField metadataField : metadataItem.getFields()) {
                    NotEditableItemInformationItem(metadataField.getLabel(), metadataField.getValue(), null, null, composerStartRestartGroup, 0, 12);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemInformationScreenKt.MetadataItemSection$lambda$1(metadataItem, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1870225113, i3, -1, "com.box.android.preview.iteminformation.MetadataItemSection (ItemInformationScreen.kt:407)");
            }
            Modifier modifierTestTag2 = TestTagKt.testTag(companion, "ItemInformationScreen:MetadataItem-" + metadataItem.getId());
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_5, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2062320937, "C415@16932L10,416@16985L6,413@16860L163:ItemInformationScreen.kt#kcqqv0");
            modifier3 = companion;
            TextKt.m4494TextNvy7gAk(metadataItem.getTitle(), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11526getItemInfoTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium(), composerStartRestartGroup, 0, 0, 131066);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.startReplaceGroup(343626881);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*419@17076L71");
            while (r11.hasNext()) {
                NotEditableItemInformationItem(metadataField.getLabel(), metadataField.getValue(), null, null, composerStartRestartGroup, 0, 12);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.MetadataItemSection$lambda$1(metadataItem, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    /* JADX WARN: Code duplicated, block: B:38:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:43:0x008e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0095  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:53:0x0156  */
    /* JADX WARN: Code duplicated, block: B:56:0x0162  */
    /* JADX WARN: Code duplicated, block: B:57:0x0166  */
    /* JADX WARN: Code duplicated, block: B:61:0x01c9 A[LOOP:0: B:59:0x01c3->B:61:0x01c9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x0200  */
    /* JADX WARN: Code duplicated, block: B:66:0x0205  */
    /* JADX WARN: Code duplicated, block: B:69:0x020f  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    public static final void ItemInformationDetails(final ItemInformationReducer.ItemDetails itemDetails, final String created, final String modified, Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        List<Pair> listMutableListOf;
        Function0<ComposeUiNode> constructor;
        Intrinsics.checkNotNullParameter(itemDetails, "itemDetails");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(modified, "modified");
        Composer composerStartRestartGroup = composer.startRestartGroup(1036642800);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemInformationDetails)N(itemDetails,created,modified,modifier)432@17382L34,433@17446L35,434@17516L37,435@17574L38,441@17761L223:ItemInformationScreen.kt#kcqqv0");
        int i3 = (i & 6) == 0 ? (composerStartRestartGroup.changed(itemDetails) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(created) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modified) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1036642800, i3, -1, "com.box.android.preview.iteminformation.ItemInformationDetails (ItemInformationScreen.kt:430)");
                }
                listMutableListOf = CollectionsKt.mutableListOf(TuplesKt.to(StringResources_androidKt.stringResource(R.string.size, composerStartRestartGroup, 0), itemDetails.getSize()), TuplesKt.to(StringResources_androidKt.stringResource(R.string.owner, composerStartRestartGroup, 0), itemDetails.getOwnerName()), TuplesKt.to(StringResources_androidKt.stringResource(R.string.created, composerStartRestartGroup, 0), created), TuplesKt.to(StringResources_androidKt.stringResource(R.string.modified, composerStartRestartGroup, 0), modified));
                if (itemDetails.isFile()) {
                    composerStartRestartGroup.startReplaceGroup(1793754002);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1811275698);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "438@17684L39");
                    listMutableListOf.add(0, TuplesKt.to(StringResources_androidKt.stringResource(R.string.file_extension, composerStartRestartGroup, 0), itemDetails.getExtension()));
                }
                composerStartRestartGroup.endReplaceGroup();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(24));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1301993631, "C:ItemInformationScreen.kt#kcqqv0");
                composerStartRestartGroup.startReplaceGroup(1704568028);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*446@17902L66");
                for (Pair pair : listMutableListOf) {
                    NotEditableItemInformationItem((String) pair.getFirst(), (String) pair.getSecond(), null, null, composerStartRestartGroup, 0, 12);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemInformationScreenKt.ItemInformationDetails$lambda$1(itemDetails, created, modified, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1036642800, i3, -1, "com.box.android.preview.iteminformation.ItemInformationDetails (ItemInformationScreen.kt:430)");
            }
            listMutableListOf = CollectionsKt.mutableListOf(TuplesKt.to(StringResources_androidKt.stringResource(R.string.size, composerStartRestartGroup, 0), itemDetails.getSize()), TuplesKt.to(StringResources_androidKt.stringResource(R.string.owner, composerStartRestartGroup, 0), itemDetails.getOwnerName()), TuplesKt.to(StringResources_androidKt.stringResource(R.string.created, composerStartRestartGroup, 0), created), TuplesKt.to(StringResources_androidKt.stringResource(R.string.modified, composerStartRestartGroup, 0), modified));
            if (itemDetails.isFile()) {
                composerStartRestartGroup.startReplaceGroup(1793754002);
            } else {
                composerStartRestartGroup.startReplaceGroup(1811275698);
                ComposerKt.sourceInformation(composerStartRestartGroup, "438@17684L39");
                listMutableListOf.add(0, TuplesKt.to(StringResources_androidKt.stringResource(R.string.file_extension, composerStartRestartGroup, 0), itemDetails.getExtension()));
            }
            composerStartRestartGroup.endReplaceGroup();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(24));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_5, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1301993631, "C:ItemInformationScreen.kt#kcqqv0");
            composerStartRestartGroup.startReplaceGroup(1704568028);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*446@17902L66");
            while (r0.hasNext()) {
                NotEditableItemInformationItem((String) pair.getFirst(), (String) pair.getSecond(), null, null, composerStartRestartGroup, 0, 12);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.ItemInformationDetails$lambda$1(itemDetails, created, modified, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ItemInformationTopBar(final int i, final boolean z, final boolean z2, final Function0<Unit> onSaveClick, final Function0<Unit> onCloseClick, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onSaveClick, "onSaveClick");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-77447787);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemInformationTopBar)N(titleRes,saveButtonEnabled,saveButtonVisible,onSaveClick,onCloseClick)460@18229L1558:ItemInformationScreen.kt#kcqqv0");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onSaveClick) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCloseClick) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-77447787, i3, -1, "com.box.android.preview.iteminformation.ItemInformationTopBar (ItemInformationScreen.kt:459)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 543811813, "C462@18277L351,472@18659L407,481@19090L504,493@19694L6,492@19635L105,461@18246L1504,496@19759L22:ItemInformationScreen.kt#kcqqv0");
            composer2 = composerStartRestartGroup;
            AppBarKt.m2785TopAppBargNPyAyM(ComposableLambdaKt.rememberComposableLambda(-1081031389, true, new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.ItemInformationTopBar$lambda$0$0(columnScopeInstance, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-835223515, true, new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.ItemInformationTopBar$lambda$0$1(onCloseClick, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(384628046, true, new Function3() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ItemInformationScreenKt.ItemInformationTopBar$lambda$0$2(z2, onSaveClick, z, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11576getTopBarBackgroundSecondary0d7_KjU(), 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 62), null, null, composer2, 3462, 434);
            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer2, 0, 7);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationScreenKt.ItemInformationTopBar$lambda$1(i, z, z2, onSaveClick, onCloseClick, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationTopBar$lambda$0$0(ColumnScope columnScope, int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C467@18453L24,469@18579L6,463@18295L319:ItemInformationScreen.kt#kcqqv0");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1081031389, i2, -1, "com.box.android.preview.iteminformation.ItemInformationTopBar.<anonymous>.<anonymous> (ItemInformationScreen.kt:463)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer, 0), ColumnScope.weight$default(columnScope, TestTagKt.testTag(Modifier.INSTANCE, "topBarTitle"), 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold22(), composer, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationTopBar$lambda$0$1(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C477@18961L51,473@18677L375:ItemInformationScreen.kt#kcqqv0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-835223515, i, -1, "com.box.android.preview.iteminformation.ItemInformationTopBar.<anonymous>.<anonymous> (ItemInformationScreen.kt:473)");
            }
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composer, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left_secondary), false, 17, null), null, null, 0L, 0.0f, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationTopBar$lambda$0$2(boolean z, Function0 function0, final boolean z2, RowScope TopAppBar, Composer composer, int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation(composer, "C:ItemInformationScreen.kt#kcqqv0");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(384628046, i, -1, "com.box.android.preview.iteminformation.ItemInformationTopBar.<anonymous>.<anonymous> (ItemInformationScreen.kt:482)");
            }
            if (z) {
                composer.startReplaceGroup(-518572749);
                ComposerKt.sourceInformation(composer, "483@19216L346,483@19153L409");
                composer2 = composer;
                IconButtonKt.IconButton((Function0<Unit>) function0, (Modifier) null, z2, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(-1076245323, true, new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemInformationScreenKt.ItemInformationTopBar$lambda$0$2$0(z2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer2, 1572864, 58);
            } else {
                composer2 = composer;
                composer2.startReplaceGroup(-537565612);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationTopBar$lambda$0$2$0(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C485@19276L38,486@19365L52,487@19463L6,484@19242L298:ItemInformationScreen.kt#kcqqv0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1076245323, i, -1, "com.box.android.preview.iteminformation.ItemInformationTopBar.<anonymous>.<anonymous>.<anonymous> (ItemInformationScreen.kt:484)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_done_24, composer, 0), StringResources_androidKt.stringResource(R.string.save_changes_talkback_label, composer, 0), (Modifier) null, BoxColorsKt.m11587enabledek8zF_U$default(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), z, 0.0f, 2, null), composer, Painter.$stable, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final ItemInformationReducer.State ItemInformationScreen$lambda$0(State<ItemInformationReducer.State> state) {
        return state.getValue();
    }
}
