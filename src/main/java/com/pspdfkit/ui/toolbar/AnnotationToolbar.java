package com.pspdfkit.ui.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.react.modules.dialog.AlertFragment;
import com.pspdfkit.BuildConfig;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.internal.a40;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.e9;
import com.pspdfkit.internal.n;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.tg;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.ww;
import com.pspdfkit.internal.y40;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.annotations.OnAnnotationSelectedListener;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.ui.toolbar.grouping.presets.AnnotationCreationToolbarGroupingRule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u008a\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0004\u008b\u0001\u008a\u0001B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\t\u0010\rB#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J'\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\b\b\u0001\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010#\u001a\u00020\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J'\u0010(\u001a\u00020\u001a2\b\b\u0001\u0010'\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002¢\u0006\u0004\b(\u0010)J1\u0010,\u001a\u00020\"2\u0018\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u001d2\u0006\u0010+\u001a\u00020\u001eH\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u001aH\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\"H\u0002¢\u0006\u0004\b1\u0010&J\u000f\u00102\u001a\u00020\"H\u0002¢\u0006\u0004\b2\u0010&J\u0017\u00104\u001a\u00020\"2\u0006\u00103\u001a\u00020\u0002H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\"H\u0002¢\u0006\u0004\b6\u0010&J)\u0010=\u001a\u00020\u001a2\b\u00108\u001a\u0004\u0018\u0001072\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J\u001f\u0010@\u001a\u00020?2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010+\u001a\u00020;H\u0002¢\u0006\u0004\b@\u0010AJ%\u0010C\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002¢\u0006\u0004\bC\u0010DJ/\u0010E\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u0001072\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\"H\u0002¢\u0006\u0004\bG\u0010&J\u000f\u0010H\u001a\u00020\"H\u0002¢\u0006\u0004\bH\u0010&J\u0017\u0010I\u001a\u00020\"2\u0006\u00103\u001a\u00020\u0002H\u0016¢\u0006\u0004\bI\u00105J\u000f\u0010J\u001a\u00020\"H\u0016¢\u0006\u0004\bJ\u0010&J\u000f\u0010K\u001a\u00020\u001aH\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\"2\u0006\u00103\u001a\u00020\u0002H\u0016¢\u0006\u0004\bM\u00105J%\u0010R\u001a\u00020\"2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020O0N2\u0006\u0010Q\u001a\u00020\u001aH\u0016¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\"2\u0006\u0010T\u001a\u00020\u001eH\u0014¢\u0006\u0004\bU\u0010VJ#\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016¢\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001a\u00020\"2\b\u0010Z\u001a\u0004\u0018\u00010Y¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u001aH\u0014¢\u0006\u0004\b]\u0010LJ\u0015\u0010_\u001a\u00020\"2\u0006\u0010^\u001a\u00020\u001a¢\u0006\u0004\b_\u00100J\u000f\u0010`\u001a\u00020\u001aH\u0014¢\u0006\u0004\b`\u0010LJ\u0017\u0010a\u001a\u00020\"2\u0006\u00103\u001a\u00020\u0002H\u0016¢\u0006\u0004\ba\u00105J\u0017\u0010b\u001a\u00020\"2\u0006\u00103\u001a\u00020\u0002H\u0016¢\u0006\u0004\bb\u00105J\u0017\u0010c\u001a\u00020\"2\u0006\u00103\u001a\u00020\u0002H\u0016¢\u0006\u0004\bc\u00105J\u0011\u0010e\u001a\u0004\u0018\u00010dH\u0016¢\u0006\u0004\be\u0010fR$\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u00105R\u0016\u0010k\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bm\u0010lR\u0016\u0010n\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bn\u0010lR\u0016\u0010o\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bo\u0010lR\u0014\u0010q\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR4\u0010t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR4\u0010|\u001a\u0012\u0012\u0004\u0012\u00020\u000e0zj\b\u0012\u0004\u0012\u00020\u000e`{8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bZ\u0010\u0082\u0001R\u0017\u0010]\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b]\u0010\u0083\u0001R\u001a\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u00108\u001a\u0004\u0018\u0001078VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/pspdfkit/ui/toolbar/AnnotationToolbar;", "Lcom/pspdfkit/ui/toolbar/ContextualToolbar;", "Lcom/pspdfkit/ui/special_mode/controller/AnnotatingController;", "Lcom/pspdfkit/ui/annotations/OnAnnotatingModeSettingsChangeListener;", "Lcom/pspdfkit/ui/annotations/OnAnnotatingModeChangeListener;", "Lcom/pspdfkit/ui/annotations/OnAnnotationSelectedListener;", "Lcom/pspdfkit/ui/toolbar/UndoRedoToolbarHelper$UndoRedoToolbarHost;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemId", "Landroid/util/Pair;", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationTool;", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationToolVariant;", "getAnnotationToolForItemId", "(I)Landroid/util/Pair;", "toolVariantPair", "getItemIdForAnnotationTool", "(Landroid/util/Pair;)Ljava/lang/Integer;", "", "isStyleIndicatorCircleEnabled", "(I)Z", "", "Lcom/pspdfkit/ui/toolbar/ContextualToolbarMenuItem;", "generateMenuItems", "()Ljava/util/List;", "menuItems", "", "initializeStyleIndicatorCircleIcons", "(Ljava/util/List;)V", "updateStyleIndicatorCircleIcons", "()V", "id", "isAnnotationMenuItem", "(ILjava/util/List;)Z", "lastAnnotationTools", "menuItem", "setLatestUsedToolAsDefault", "(Ljava/util/List;Lcom/pspdfkit/ui/toolbar/ContextualToolbarMenuItem;)V", "notifyToolbarChanged", "applyAnnotationControllerChanges", "(Z)V", "updateStylusIcon", "updateStylusSelectionState", "controller", "bindUndoManager", "(Lcom/pspdfkit/ui/special_mode/controller/AnnotatingController;)V", "updateActiveAnnotationTool", "Lcom/pspdfkit/configuration/PdfConfiguration;", "configuration", "Lcom/pspdfkit/internal/tg;", "features", "Lcom/pspdfkit/ui/toolbar/AnnotationCreationToolMenuItem;", "toolItem", "shouldToolMenuItemBeShown", "(Lcom/pspdfkit/configuration/PdfConfiguration;Lcom/pspdfkit/internal/tg;Lcom/pspdfkit/ui/toolbar/AnnotationCreationToolMenuItem;)Z", "", "getToolTitle", "(Landroid/content/Context;Lcom/pspdfkit/ui/toolbar/AnnotationCreationToolMenuItem;)Ljava/lang/String;", AlertFragment.ARG_ITEMS, "addColorPickerMenuItem", "(Landroid/content/Context;Ljava/util/List;)V", "addUndoRedoMenuItem", "(Landroid/content/Context;Lcom/pspdfkit/configuration/PdfConfiguration;Ljava/util/List;)V", "updateColorPickerIcons", "unbindUndoManager", "bindController", "unbindController", "isControllerBound", "()Z", "onChangeAnnotatingMode", "", "Lcom/pspdfkit/annotations/Annotation;", "annotations", "annotationsCreated", "onAnnotationSelectionFinished", "(Ljava/util/List;Z)V", "item", "handleMenuItemClick", "(Lcom/pspdfkit/ui/toolbar/ContextualToolbarMenuItem;)V", "onMenuItemsGrouped", "(Ljava/util/List;)Ljava/util/List;", "Lcom/pspdfkit/ui/toolbar/AnnotationToolbar$ItemToAnnotationToolMapper;", "itemToAnnotationToolMapper", "setItemToAnnotationToolMapper", "(Lcom/pspdfkit/ui/toolbar/AnnotationToolbar$ItemToAnnotationToolMapper;)V", "shouldShowStylusButton", "shouldShow", "setShouldShowStylusButton", "getUseAlternateBackground", "onAnnotatingModeSettingsChange", "onEnterAnnotatingMode", "onExitAnnotatingMode", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "Lcom/pspdfkit/ui/special_mode/controller/AnnotatingController;", "getController", "()Lcom/pspdfkit/ui/special_mode/controller/AnnotatingController;", "setController", "iconColor", "I", "iconColorActivated", "undoIcon", "redoIcon", "Lcom/pspdfkit/ui/toolbar/UndoRedoToolbarHelper;", "undoRedoHelper", "Lcom/pspdfkit/ui/toolbar/UndoRedoToolbarHelper;", "Landroid/util/SparseArray;", "defaultItemToAnnotationToolMappings", "Landroid/util/SparseArray;", "getDefaultItemToAnnotationToolMappings", "()Landroid/util/SparseArray;", "setDefaultItemToAnnotationToolMappings", "(Landroid/util/SparseArray;)V", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "menuItemsWithStyleIndicators", "Ljava/util/HashSet;", "getMenuItemsWithStyleIndicators", "()Ljava/util/HashSet;", "setMenuItemsWithStyleIndicators", "(Ljava/util/HashSet;)V", "Lcom/pspdfkit/ui/toolbar/AnnotationToolbar$ItemToAnnotationToolMapper;", "Z", "Lcom/pspdfkit/ui/PdfFragment;", "getFragment", "()Lcom/pspdfkit/ui/PdfFragment;", BuildConfig.FLAVOR, "getConfiguration", "()Lcom/pspdfkit/configuration/PdfConfiguration;", "Companion", "ItemToAnnotationToolMapper", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnnotationToolbar extends ContextualToolbar<AnnotatingController> implements OnAnnotatingModeSettingsChangeListener, OnAnnotatingModeChangeListener, OnAnnotationSelectedListener, UndoRedoToolbarHelper.UndoRedoToolbarHost {
    private static final int[] ATTRS;
    private static final int DEF_STYLE_ATTR;
    private AnnotatingController controller;
    private SparseArray<Pair<AnnotationTool, AnnotationToolVariant>> defaultItemToAnnotationToolMappings;
    private int iconColor;
    private int iconColorActivated;
    private ItemToAnnotationToolMapper itemToAnnotationToolMapper;
    private HashSet<Integer> menuItemsWithStyleIndicators;
    private int redoIcon;
    private boolean shouldShowStylusButton;
    private int undoIcon;
    private final UndoRedoToolbarHelper undoRedoHelper;
    public static final int $stable = 8;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<ToolbarCoordinatorLayout.LayoutParams.Position> entries$0 = EnumEntriesKt.enumEntries(ToolbarCoordinatorLayout.LayoutParams.Position.values());
        public static final /* synthetic */ EnumEntries<AnnotationCreationToolMenuItem> entries$1 = EnumEntriesKt.enumEntries(AnnotationCreationToolMenuItem.values());
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH&R$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/toolbar/AnnotationToolbar$ItemToAnnotationToolMapper;", "", "itemToAnnotationToolMapping", "Landroid/util/SparseArray;", "Landroid/util/Pair;", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationTool;", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationToolVariant;", "getItemToAnnotationToolMapping", "()Landroid/util/SparseArray;", "isStyleIndicatorCircleEnabled", "", "itemId", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface ItemToAnnotationToolMapper {
        SparseArray<Pair<AnnotationTool, AnnotationToolVariant>> getItemToAnnotationToolMapping();

        boolean isStyleIndicatorCircleEnabled(int itemId);
    }

    static {
        int[] iArr = R.styleable.pspdf__AnnotationCreationToolbarIcons;
        iArr.getClass();
        ATTRS = iArr;
        DEF_STYLE_ATTR = R.attr.pspdf__annotationCreationToolbarIconsStyle;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationToolbar(Context context) {
        super(context);
        context.getClass();
        this.undoRedoHelper = new UndoRedoToolbarHelper(this, R.id.pspdf__annotation_toolbar_group_undo_redo, R.id.pspdf__annotation_toolbar_item_undo, R.id.pspdf__annotation_toolbar_item_redo);
        this.defaultItemToAnnotationToolMappings = new SparseArray<>();
        this.menuItemsWithStyleIndicators = new HashSet<>();
        this.shouldShowStylusButton = true;
        setId(R.id.pspdf__annotation_toolbar);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, ATTRS, DEF_STYLE_ATTR, 0);
        typedArrayObtainStyledAttributes.getClass();
        this.iconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__iconsColor, getDefaultIconsColor());
        this.iconColorActivated = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__iconsColorActivated, getDefaultIconsColorActivated());
        this.undoIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__undoIcon, R.drawable.pspdf__ic_undo);
        this.redoIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__redoIcon, R.drawable.pspdf__ic_redo);
        typedArrayObtainStyledAttributes.recycle();
        this.closeButton.setIconColor(this.iconColor);
        ContextualToolbarMenuItem contextualToolbarMenuItem = this.stylusButton;
        contextualToolbarMenuItem.setIconColor(contextualToolbarMenuItem.getIconColor());
        contextualToolbarMenuItem.setIconColorActivated(contextualToolbarMenuItem.getIconColorActivated());
        setDragButtonColor(this.iconColor);
        setDraggable(true);
        ToolbarCoordinatorLayout.LayoutParams.Position lastToolbarPosition = PSPDFKitPreferences.get(getContext()).getLastToolbarPosition(this, uc.a(getContext(), 540) ? ToolbarCoordinatorLayout.LayoutParams.Position.LEFT : ToolbarCoordinatorLayout.LayoutParams.Position.TOP);
        lastToolbarPosition.getClass();
        setLayoutParams(new ToolbarCoordinatorLayout.LayoutParams(lastToolbarPosition, EnumSet.copyOf((Collection) EntriesMappings.entries$0)));
        setUseBackButtonForCloseWhenHorizontal(false);
        updateStylusSelectionState();
    }

    private final void addColorPickerMenuItem(Context context, List<ContextualToolbarMenuItem> items) {
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem = ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__annotation_toolbar_item_picker, new e9(context, this.iconColor, this.iconColorActivated, 8.0f, 10.0f, 1.0f), no.a(context, R.string.pspdf__edit_menu_color, null), this.iconColor, this.iconColorActivated, ContextualToolbarMenuItem.Position.END, false);
        contextualToolbarMenuItemCreateSingleItem.setTintingEnabled(false);
        contextualToolbarMenuItemCreateSingleItem.setVisibility(4);
        items.add(contextualToolbarMenuItemCreateSingleItem);
    }

    private final void addUndoRedoMenuItem(Context context, PdfConfiguration configuration, List<ContextualToolbarMenuItem> items) {
        List<ContextualToolbarMenuItem> listAddUndoRedoMenuItems = this.undoRedoHelper.addUndoRedoMenuItems(context, configuration, R.string.pspdf__undo, R.string.pspdf__redo, this.undoIcon, this.redoIcon, this.iconColor, this.iconColorActivated);
        Iterator<T> it = listAddUndoRedoMenuItems.iterator();
        while (it.hasNext()) {
            ((ContextualToolbarMenuItem) it.next()).setUseAlternateBackground(getUseAlternateBackground());
        }
        items.addAll(listAddUndoRedoMenuItems);
    }

    private final void applyAnnotationControllerChanges(boolean notifyToolbarChanged) {
        if (this.controller == null) {
            return;
        }
        UndoRedoToolbarHelper.updateUndoRedoButtons$default(this.undoRedoHelper, null, 1, null);
        updateColorPickerIcons();
        updateActiveAnnotationTool();
        updateStylusIcon();
        if (notifyToolbarChanged) {
            notifyToolbarChanged();
        }
        List<ContextualToolbarMenuItem> groupedMenuItems = getGroupedMenuItems();
        groupedMenuItems.getClass();
        initializeStyleIndicatorCircleIcons(groupedMenuItems);
    }

    private final void bindUndoManager(AnnotatingController controller) {
        UndoRedoToolbarHelper undoRedoToolbarHelper = this.undoRedoHelper;
        PdfFragment fragment = controller.getFragment();
        fragment.getClass();
        undoRedoToolbarHelper.bindUndoManager(fragment);
    }

    private final List<ContextualToolbarMenuItem> generateMenuItems() {
        Drawable drawable;
        Context context = getContext();
        this.closeButton.setIconColor(this.iconColor);
        tg tgVarB = ar.b();
        tgVarB.getClass();
        AnnotatingController annotatingController = this.controller;
        PdfConfiguration configuration = annotatingController != null ? annotatingController.getConfiguration() : null;
        ArrayList arrayList = new ArrayList(20);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, ATTRS, DEF_STYLE_ATTR, 0);
        typedArrayObtainStyledAttributes.getClass();
        for (AnnotationCreationToolMenuItem annotationCreationToolMenuItem : EntriesMappings.entries$1) {
            if (shouldToolMenuItemBeShown(configuration, tgVarB, annotationCreationToolMenuItem) && (drawable = AppCompatResources.getDrawable(context, typedArrayObtainStyledAttributes.getResourceId(annotationCreationToolMenuItem.styleableId, annotationCreationToolMenuItem.drawableId))) != null) {
                arrayList.add(ContextualToolbarMenuItem.createSingleItem(context, annotationCreationToolMenuItem.id, drawable, getToolTitle(context, annotationCreationToolMenuItem), this.iconColor, this.iconColorActivated, ContextualToolbarMenuItem.Position.START, true));
                this.defaultItemToAnnotationToolMappings.put(annotationCreationToolMenuItem.id, new Pair<>(annotationCreationToolMenuItem.annotationTool, annotationCreationToolMenuItem.annotationToolVariant));
                if (annotationCreationToolMenuItem.isStyleIndicatorEnabled) {
                    this.menuItemsWithStyleIndicators.add(Integer.valueOf(annotationCreationToolMenuItem.id));
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        addUndoRedoMenuItem(context, configuration, arrayList);
        addColorPickerMenuItem(context, arrayList);
        return arrayList;
    }

    private final Pair<AnnotationTool, AnnotationToolVariant> getAnnotationToolForItemId(int itemId) {
        SparseArray<Pair<AnnotationTool, AnnotationToolVariant>> itemToAnnotationToolMapping;
        Pair<AnnotationTool, AnnotationToolVariant> pair;
        ItemToAnnotationToolMapper itemToAnnotationToolMapper = this.itemToAnnotationToolMapper;
        return (itemToAnnotationToolMapper == null || (itemToAnnotationToolMapping = itemToAnnotationToolMapper.getItemToAnnotationToolMapping()) == null || (pair = itemToAnnotationToolMapping.get(itemId)) == null) ? this.defaultItemToAnnotationToolMappings.get(itemId) : pair;
    }

    private final Integer getItemIdForAnnotationTool(Pair<AnnotationTool, AnnotationToolVariant> toolVariantPair) {
        ItemToAnnotationToolMapper itemToAnnotationToolMapper = this.itemToAnnotationToolMapper;
        if (itemToAnnotationToolMapper != null) {
            SparseArray<Pair<AnnotationTool, AnnotationToolVariant>> itemToAnnotationToolMapping = itemToAnnotationToolMapper.getItemToAnnotationToolMapping();
            int size = itemToAnnotationToolMapping.size();
            for (int i = 0; i < size; i++) {
                int iKeyAt = itemToAnnotationToolMapping.keyAt(i);
                if (Intrinsics.areEqual(itemToAnnotationToolMapping.get(iKeyAt), toolVariantPair) && findItemById(iKeyAt) != null) {
                    return Integer.valueOf(iKeyAt);
                }
            }
        }
        int size2 = this.defaultItemToAnnotationToolMappings.size();
        for (int i2 = 0; i2 < size2; i2++) {
            int iKeyAt2 = this.defaultItemToAnnotationToolMappings.keyAt(i2);
            if (Intrinsics.areEqual(this.defaultItemToAnnotationToolMappings.get(iKeyAt2), toolVariantPair) && findItemById(iKeyAt2) != null) {
                return Integer.valueOf(iKeyAt2);
            }
        }
        return null;
    }

    private final String getToolTitle(Context context, AnnotationCreationToolMenuItem menuItem) {
        String strA = no.a(context, menuItem.stringId, null);
        strA.getClass();
        return strA;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    private final void initializeStyleIndicatorCircleIcons(List<ContextualToolbarMenuItem> menuItems) {
        Pair<AnnotationTool, AnnotationToolVariant> annotationToolForItemId;
        AnnotatingController annotatingController = this.controller;
        if (annotatingController == null) {
            return;
        }
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : menuItems) {
            List<ContextualToolbarMenuItem> subMenuItems = contextualToolbarMenuItem.getSubMenuItems();
            if (subMenuItems != null) {
                initializeStyleIndicatorCircleIcons(subMenuItems);
            }
            if (contextualToolbarMenuItem.hasSubmenu()) {
                ContextualToolbarMenuItem defaultSelectedMenuItem = contextualToolbarMenuItem.getDefaultSelectedMenuItem();
                if (defaultSelectedMenuItem == null || !isStyleIndicatorCircleEnabled(defaultSelectedMenuItem.getId())) {
                    annotationToolForItemId = null;
                } else {
                    annotationToolForItemId = getAnnotationToolForItemId(defaultSelectedMenuItem.getId());
                }
            } else if (isStyleIndicatorCircleEnabled(contextualToolbarMenuItem.getId())) {
                annotationToolForItemId = getAnnotationToolForItemId(contextualToolbarMenuItem.getId());
            } else {
                annotationToolForItemId = null;
            }
            if (annotationToolForItemId != null) {
                AnnotationPreferencesManager annotationPreferences = annotatingController.getAnnotationPreferences();
                annotationPreferences.getClass();
                contextualToolbarMenuItem.showColorIndicatorCircle(annotationPreferences.getColor((AnnotationTool) annotationToolForItemId.first, (AnnotationToolVariant) annotationToolForItemId.second), annotationPreferences.getThickness((AnnotationTool) annotationToolForItemId.first, (AnnotationToolVariant) annotationToolForItemId.second));
            } else {
                contextualToolbarMenuItem.hideColorIndicatorCircle();
            }
        }
    }

    private final boolean isAnnotationMenuItem(int id, List<ContextualToolbarMenuItem> menuItems) {
        List<ContextualToolbarMenuItem> subMenuItems;
        if (getAnnotationToolForItemId(id) != null) {
            return true;
        }
        ContextualToolbarMenuItem contextualToolbarMenuItemFindItemById = findItemById(id, menuItems);
        boolean zIsAnnotationMenuItem = false;
        if (contextualToolbarMenuItemFindItemById != null && (subMenuItems = contextualToolbarMenuItemFindItemById.getSubMenuItems()) != null) {
            Iterator<T> it = subMenuItems.iterator();
            while (it.hasNext()) {
                zIsAnnotationMenuItem = isAnnotationMenuItem(((ContextualToolbarMenuItem) it.next()).getId(), subMenuItems);
            }
        }
        return zIsAnnotationMenuItem;
    }

    private final boolean isStyleIndicatorCircleEnabled(int itemId) {
        ItemToAnnotationToolMapper itemToAnnotationToolMapper = this.itemToAnnotationToolMapper;
        return (itemToAnnotationToolMapper != null && itemToAnnotationToolMapper.isStyleIndicatorCircleEnabled(itemId)) || this.menuItemsWithStyleIndicators.contains(Integer.valueOf(itemId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMenuItemsGrouped$lambda$1(AnnotationToolbar annotationToolbar) {
        List<ContextualToolbarMenuItem> groupedMenuItems = annotationToolbar.getGroupedMenuItems();
        groupedMenuItems.getClass();
        annotationToolbar.initializeStyleIndicatorCircleIcons(groupedMenuItems);
    }

    private final void setLatestUsedToolAsDefault(List<Pair<AnnotationTool, AnnotationToolVariant>> lastAnnotationTools, ContextualToolbarMenuItem menuItem) {
        List<ContextualToolbarMenuItem> subMenuItems = menuItem.getSubMenuItems();
        if (subMenuItems == null || subMenuItems.isEmpty()) {
            return;
        }
        ContextualToolbarMenuItem contextualToolbarMenuItem = null;
        int i = Integer.MAX_VALUE;
        for (ContextualToolbarMenuItem contextualToolbarMenuItem2 : subMenuItems) {
            int iIndexOf = CollectionsKt.indexOf((List<? extends Pair<AnnotationTool, AnnotationToolVariant>>) lastAnnotationTools, getAnnotationToolForItemId(contextualToolbarMenuItem2.getId()));
            if (iIndexOf != -1 && iIndexOf < i) {
                contextualToolbarMenuItem = contextualToolbarMenuItem2;
                i = iIndexOf;
            }
        }
        if (contextualToolbarMenuItem != null) {
            menuItem.setDefaultSelectedMenuItem(contextualToolbarMenuItem);
        } else if (menuItem.getDefaultSelectedMenuItem() == null) {
            menuItem.setDefaultSelectedMenuItem((ContextualToolbarMenuItem) CollectionsKt.first((List) subMenuItems));
        }
    }

    private final boolean shouldToolMenuItemBeShown(PdfConfiguration configuration, tg features, AnnotationCreationToolMenuItem toolItem) {
        if (toolItem == AnnotationCreationToolMenuItem.ERASER_ITEM) {
            return configuration == null || (features.a(configuration, AnnotationType.INK) && features.a(configuration, AnnotationTool.ERASER));
        }
        if (configuration != null) {
            AnnotationTool annotationTool = toolItem.annotationTool;
            annotationTool.getClass();
            if (!features.a(configuration, annotationTool)) {
                return false;
            }
        }
        return true;
    }

    private final void unbindUndoManager() {
        this.undoRedoHelper.unbindUndoManager();
    }

    private final void updateActiveAnnotationTool() {
        ContextualToolbarMenuItem contextualToolbarMenuItemFindItemById;
        AnnotatingController annotatingController = this.controller;
        if (annotatingController == null) {
            return;
        }
        AnnotationTool activeAnnotationTool = annotatingController.getActiveAnnotationTool();
        AnnotationToolVariant activeAnnotationToolVariant = annotatingController.getActiveAnnotationToolVariant();
        if (activeAnnotationTool == null || activeAnnotationToolVariant == null) {
            return;
        }
        if (activeAnnotationTool == AnnotationTool.NONE) {
            deselectCurrentMenuItem();
            return;
        }
        Integer itemIdForAnnotationTool = getItemIdForAnnotationTool(new Pair<>(activeAnnotationTool, activeAnnotationToolVariant));
        if (itemIdForAnnotationTool == null || (contextualToolbarMenuItemFindItemById = findItemById(itemIdForAnnotationTool.intValue())) == null) {
            return;
        }
        selectMenuItem(contextualToolbarMenuItemFindItemById);
    }

    private final void updateColorPickerIcons() {
        int color;
        AnnotatingController annotatingController = this.controller;
        if (annotatingController == null) {
            return;
        }
        boolean zShouldDisplayPicker = annotatingController.shouldDisplayPicker();
        ContextualToolbarMenuItem contextualToolbarMenuItemFindItemById = findItemById(R.id.pspdf__annotation_toolbar_item_picker);
        if (contextualToolbarMenuItemFindItemById != null && zShouldDisplayPicker) {
            List<Annotation> currentlySelectedAnnotations = annotatingController.getCurrentlySelectedAnnotations();
            currentlySelectedAnnotations.getClass();
            if (currentlySelectedAnnotations.isEmpty()) {
                color = annotatingController.getColor();
            } else {
                Object objFirst = CollectionsKt.first((List<? extends Object>) currentlySelectedAnnotations);
                objFirst.getClass();
                Annotation annotation = (Annotation) objFirst;
                float f = ww.a;
                color = annotation.getType() == AnnotationType.STAMP ? a40.a((StampAnnotation) annotation) : annotation.getColor();
            }
            contextualToolbarMenuItemFindItemById.setIcon(new e9(getContext(), this.iconColor, color, 8.0f, 10.0f, 1.0f));
        }
        setMenuItemVisibility(R.id.pspdf__annotation_toolbar_item_picker, zShouldDisplayPicker ? 0 : 4);
    }

    private final void updateStyleIndicatorCircleIcons() {
        Integer itemIdForAnnotationTool;
        Object next;
        AnnotatingController annotatingController = this.controller;
        if (annotatingController == null) {
            return;
        }
        AnnotationTool activeAnnotationTool = annotatingController.getActiveAnnotationTool();
        AnnotationToolVariant activeAnnotationToolVariant = annotatingController.getActiveAnnotationToolVariant();
        if (activeAnnotationTool == null || activeAnnotationToolVariant == null || (itemIdForAnnotationTool = getItemIdForAnnotationTool(new Pair<>(activeAnnotationTool, activeAnnotationToolVariant))) == null) {
            return;
        }
        List<ContextualToolbarMenuItem> groupedMenuItems = getGroupedMenuItems();
        groupedMenuItems.getClass();
        Iterator<T> it = groupedMenuItems.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ContextualToolbarMenuItem defaultSelectedMenuItem = ((ContextualToolbarMenuItem) next).getDefaultSelectedMenuItem();
            if (defaultSelectedMenuItem != null && defaultSelectedMenuItem.getId() == itemIdForAnnotationTool.intValue()) {
                break;
            }
        }
        ContextualToolbarMenuItem contextualToolbarMenuItem = (ContextualToolbarMenuItem) next;
        Integer numValueOf = contextualToolbarMenuItem != null ? Integer.valueOf(contextualToolbarMenuItem.getId()) : null;
        ContextualToolbarMenuItem contextualToolbarMenuItemFindItemById = findItemById(itemIdForAnnotationTool.intValue());
        ContextualToolbarMenuItem contextualToolbarMenuItemFindItemById2 = numValueOf != null ? findItemById(numValueOf.intValue()) : null;
        if (!isStyleIndicatorCircleEnabled(itemIdForAnnotationTool.intValue())) {
            if (contextualToolbarMenuItemFindItemById != null) {
                contextualToolbarMenuItemFindItemById.hideColorIndicatorCircle();
            }
            if (contextualToolbarMenuItemFindItemById2 != null) {
                contextualToolbarMenuItemFindItemById2.hideColorIndicatorCircle();
                return;
            }
            return;
        }
        int color = annotatingController.getColor();
        float thickness = annotatingController.getThickness();
        if (contextualToolbarMenuItemFindItemById != null) {
            contextualToolbarMenuItemFindItemById.showColorIndicatorCircle(color, thickness);
        }
        if (contextualToolbarMenuItemFindItemById2 != null) {
            contextualToolbarMenuItemFindItemById2.showColorIndicatorCircle(color, thickness);
        }
    }

    private final void updateStylusIcon() {
        AnnotationTool activeAnnotationTool;
        AnnotatingController annotatingController = this.controller;
        if (annotatingController == null || (activeAnnotationTool = annotatingController.getActiveAnnotationTool()) == null) {
            return;
        }
        this.stylusButton.setVisibility((ww.e.contains(activeAnnotationTool.toAnnotationType()) || activeAnnotationTool == AnnotationTool.ERASER) ? 0 : 4);
        ContextualToolbarMenuItem contextualToolbarMenuItem = this.stylusButton;
        Boolean boolUseStylusForAnnotating = this.preferences.useStylusForAnnotating();
        boolUseStylusForAnnotating.getClass();
        contextualToolbarMenuItem.setSelected(boolUseStylusForAnnotating.booleanValue());
    }

    private final void updateStylusSelectionState() {
        this.preferences.setStylusSettingChangeListener(new y40() { // from class: com.pspdfkit.ui.toolbar.AnnotationToolbar.updateStylusSelectionState.1
            @Override // com.pspdfkit.internal.y40
            public void onStylusSettingChange(boolean useStylusForAnnotating) {
                AnnotationToolbar.this.stylusButton.setSelected(useStylusForAnnotating);
            }
        });
    }

    @Override // com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper.UndoRedoToolbarHost
    public PdfConfiguration getConfiguration() {
        AnnotatingController annotatingController = this.controller;
        if (annotatingController != null) {
            return annotatingController.getConfiguration();
        }
        return null;
    }

    public final AnnotatingController getController() {
        return this.controller;
    }

    public final SparseArray<Pair<AnnotationTool, AnnotationToolVariant>> getDefaultItemToAnnotationToolMappings() {
        return this.defaultItemToAnnotationToolMappings;
    }

    @Override // com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper.UndoRedoToolbarHost
    public PdfFragment getFragment() {
        AnnotatingController annotatingController = this.controller;
        if (annotatingController != null) {
            return annotatingController.getFragment();
        }
        return null;
    }

    @Override // com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper.UndoRedoToolbarHost
    public LifecycleOwner getLifecycleOwner() {
        PdfFragment fragment;
        AnnotatingController annotatingController = this.controller;
        if (annotatingController == null || (fragment = annotatingController.getFragment()) == null) {
            return null;
        }
        return fragment.getViewLifecycleOwner();
    }

    public final HashSet<Integer> getMenuItemsWithStyleIndicators() {
        return this.menuItemsWithStyleIndicators;
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public boolean getUseAlternateBackground() {
        return true;
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void handleMenuItemClick(ContextualToolbarMenuItem item) {
        item.getClass();
        uw.b(this.controller != null, "Controller must be bind to the AnnotationToolbar before menu clicks can be handled.");
        AnnotatingController annotatingController = this.controller;
        if (annotatingController == null) {
            return;
        }
        boolean zIsSelectable = item.isSelectable();
        ContextualToolbarMenuItem defaultSelectedMenuItem = item.getDefaultSelectedMenuItem();
        if (defaultSelectedMenuItem != null) {
            item = defaultSelectedMenuItem;
        }
        if (item.isEnabled()) {
            if (item.getId() == R.id.pspdf__annotation_toolbar_item_picker) {
                annotatingController.toggleAnnotationInspector();
                return;
            }
            if (item == this.closeButton) {
                annotatingController.exitActiveMode();
                return;
            }
            if (item.getId() == R.id.pspdf__annotation_toolbar_item_undo || item.getId() == R.id.pspdf__annotation_toolbar_group_undo_redo) {
                this.undoRedoHelper.executeUndo();
                return;
            }
            if (item.getId() == R.id.pspdf__annotation_toolbar_item_redo) {
                this.undoRedoHelper.executeRedo();
                return;
            }
            Pair<AnnotationTool, AnnotationToolVariant> annotationToolForItemId = getAnnotationToolForItemId(item.getId());
            if (annotationToolForItemId != null) {
                AnnotationTool annotationTool = (AnnotationTool) annotationToolForItemId.first;
                AnnotationToolVariant annotationToolVariantDefaultVariant = (AnnotationToolVariant) annotationToolForItemId.second;
                AnnotationTool activeAnnotationTool = annotatingController.getActiveAnnotationTool();
                AnnotationTool annotationTool2 = AnnotationTool.NONE;
                if (activeAnnotationTool == annotationTool2 && annotationTool == annotationTool2) {
                    return;
                }
                if (annotationTool == annotatingController.getActiveAnnotationTool() && Intrinsics.areEqual(annotationToolVariantDefaultVariant, annotatingController.getActiveAnnotationToolVariant()) && zIsSelectable) {
                    annotationTool = annotationTool2;
                } else {
                    annotationTool.getClass();
                }
                if (annotationTool == annotationTool2) {
                    annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
                }
                annotatingController.changeAnnotationCreationMode(annotationTool, annotationToolVariantDefaultVariant);
            }
        }
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public boolean isControllerBound() {
        return this.controller != null;
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener
    public void onAnnotatingModeSettingsChange(AnnotatingController controller) {
        controller.getClass();
        updateColorPickerIcons();
        updateStyleIndicatorCircleIcons();
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public /* bridge */ void onAnnotationDeselected(Annotation annotation, boolean z) {
        super.onAnnotationDeselected(annotation, z);
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public /* bridge */ void onAnnotationSelected(Annotation annotation, boolean z) {
        super.onAnnotationSelected(annotation, z);
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public void onAnnotationSelectionFinished(List<? extends Annotation> annotations, boolean annotationsCreated) {
        annotations.getClass();
        updateColorPickerIcons();
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public /* bridge */ void onAnnotationWritingModeChanged(boolean z) {
        super.onAnnotationWritingModeChanged(z);
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
    public void onChangeAnnotatingMode(AnnotatingController controller) {
        controller.getClass();
        applyAnnotationControllerChanges(false);
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
    public void onEnterAnnotatingMode(AnnotatingController controller) {
        controller.getClass();
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
    public void onExitAnnotatingMode(AnnotatingController controller) {
        controller.getClass();
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public List<ContextualToolbarMenuItem> onMenuItemsGrouped(List<ContextualToolbarMenuItem> menuItems) {
        menuItems.getClass();
        List<Pair<AnnotationTool, AnnotationToolVariant>> lastAnnotationTools = PSPDFKitPreferences.get(getContext()).getLastAnnotationTools();
        lastAnnotationTools.getClass();
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : menuItems) {
            if (isAnnotationMenuItem(contextualToolbarMenuItem.getId(), menuItems)) {
                setLatestUsedToolAsDefault(lastAnnotationTools, contextualToolbarMenuItem);
            }
        }
        postOnAnimation(new Runnable() { // from class: com.pspdfkit.ui.toolbar.AnnotationToolbar$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AnnotationToolbar.onMenuItemsGrouped$lambda$1(this.f$0);
            }
        });
        return menuItems;
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public /* bridge */ boolean onPrepareAnnotationSelection(AnnotationSelectionController annotationSelectionController, Annotation annotation, boolean z) {
        return super.onPrepareAnnotationSelection(annotationSelectionController, annotation, z);
    }

    public final void setController(AnnotatingController annotatingController) {
        this.controller = annotatingController;
    }

    public final void setDefaultItemToAnnotationToolMappings(SparseArray<Pair<AnnotationTool, AnnotationToolVariant>> sparseArray) {
        sparseArray.getClass();
        this.defaultItemToAnnotationToolMappings = sparseArray;
    }

    public final void setItemToAnnotationToolMapper(ItemToAnnotationToolMapper itemToAnnotationToolMapper) {
        this.itemToAnnotationToolMapper = itemToAnnotationToolMapper;
    }

    public final void setMenuItemsWithStyleIndicators(HashSet<Integer> hashSet) {
        hashSet.getClass();
        this.menuItemsWithStyleIndicators = hashSet;
    }

    public final void setShouldShowStylusButton(boolean shouldShow) {
        this.shouldShowStylusButton = shouldShow;
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    /* JADX INFO: renamed from: shouldShowStylusButton, reason: from getter */
    public boolean getShouldShowStylusButton() {
        return this.shouldShowStylusButton;
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void unbindController() {
        AnnotatingController annotatingController = this.controller;
        if (annotatingController != null) {
            annotatingController.removeOnSettingsChangeListener(this);
            annotatingController.removeOnAnnotatingModeChangeListener(this);
            annotatingController.getFragment().removeOnAnnotationSelectedListener(this);
            this.controller = null;
            unbindUndoManager();
            this.preferences.setStylusSettingChangeListener(null);
        }
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void bindController(AnnotatingController controller) {
        controller.getClass();
        unbindController();
        controller.addOnSettingsChangeListener(this);
        controller.addOnAnnotatingModeChangeListener(this);
        this.controller = controller;
        controller.getFragment().addOnAnnotationSelectedListener(this);
        bindUndoManager(controller);
        tg tgVarB = ar.b();
        PdfConfiguration configuration = controller.getConfiguration();
        configuration.getClass();
        if (tgVarB.f(configuration)) {
            Context context = getContext();
            context.getClass();
            EnumSet enumSetOf = EnumSet.of(n.MEASUREMENT_TOOLS);
            enumSetOf.getClass();
            setMenuItemGroupingRule(new AnnotationCreationToolbarGroupingRule(context, enumSetOf));
        } else {
            Context context2 = getContext();
            context2.getClass();
            setMenuItemGroupingRule(new AnnotationCreationToolbarGroupingRule(context2));
        }
        setMenuItems(generateMenuItems());
        applyAnnotationControllerChanges(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationToolbar(Context context, AttributeSet attributeSet) {
        ToolbarCoordinatorLayout.LayoutParams.Position position;
        super(context, attributeSet);
        context.getClass();
        this.undoRedoHelper = new UndoRedoToolbarHelper(this, R.id.pspdf__annotation_toolbar_group_undo_redo, R.id.pspdf__annotation_toolbar_item_undo, R.id.pspdf__annotation_toolbar_item_redo);
        this.defaultItemToAnnotationToolMappings = new SparseArray<>();
        this.menuItemsWithStyleIndicators = new HashSet<>();
        this.shouldShowStylusButton = true;
        setId(R.id.pspdf__annotation_toolbar);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, ATTRS, DEF_STYLE_ATTR, 0);
        typedArrayObtainStyledAttributes.getClass();
        this.iconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__iconsColor, getDefaultIconsColor());
        this.iconColorActivated = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__iconsColorActivated, getDefaultIconsColorActivated());
        this.undoIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__undoIcon, R.drawable.pspdf__ic_undo);
        this.redoIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__redoIcon, R.drawable.pspdf__ic_redo);
        typedArrayObtainStyledAttributes.recycle();
        this.closeButton.setIconColor(this.iconColor);
        ContextualToolbarMenuItem contextualToolbarMenuItem = this.stylusButton;
        contextualToolbarMenuItem.setIconColor(contextualToolbarMenuItem.getIconColor());
        contextualToolbarMenuItem.setIconColorActivated(contextualToolbarMenuItem.getIconColorActivated());
        setDragButtonColor(this.iconColor);
        setDraggable(true);
        if (uc.a(getContext(), 540)) {
            position = ToolbarCoordinatorLayout.LayoutParams.Position.LEFT;
        } else {
            position = ToolbarCoordinatorLayout.LayoutParams.Position.TOP;
        }
        ToolbarCoordinatorLayout.LayoutParams.Position lastToolbarPosition = PSPDFKitPreferences.get(getContext()).getLastToolbarPosition(this, position);
        lastToolbarPosition.getClass();
        setLayoutParams(new ToolbarCoordinatorLayout.LayoutParams(lastToolbarPosition, EnumSet.copyOf((Collection) EntriesMappings.entries$0)));
        setUseBackButtonForCloseWhenHorizontal(false);
        updateStylusSelectionState();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationToolbar(Context context, AttributeSet attributeSet, int i) {
        ToolbarCoordinatorLayout.LayoutParams.Position position;
        super(context, attributeSet, i);
        context.getClass();
        this.undoRedoHelper = new UndoRedoToolbarHelper(this, R.id.pspdf__annotation_toolbar_group_undo_redo, R.id.pspdf__annotation_toolbar_item_undo, R.id.pspdf__annotation_toolbar_item_redo);
        this.defaultItemToAnnotationToolMappings = new SparseArray<>();
        this.menuItemsWithStyleIndicators = new HashSet<>();
        this.shouldShowStylusButton = true;
        setId(R.id.pspdf__annotation_toolbar);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, ATTRS, DEF_STYLE_ATTR, 0);
        typedArrayObtainStyledAttributes.getClass();
        this.iconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__iconsColor, getDefaultIconsColor());
        this.iconColorActivated = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__iconsColorActivated, getDefaultIconsColorActivated());
        this.undoIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__undoIcon, R.drawable.pspdf__ic_undo);
        this.redoIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationCreationToolbarIcons_pspdf__redoIcon, R.drawable.pspdf__ic_redo);
        typedArrayObtainStyledAttributes.recycle();
        this.closeButton.setIconColor(this.iconColor);
        ContextualToolbarMenuItem contextualToolbarMenuItem = this.stylusButton;
        contextualToolbarMenuItem.setIconColor(contextualToolbarMenuItem.getIconColor());
        contextualToolbarMenuItem.setIconColorActivated(contextualToolbarMenuItem.getIconColorActivated());
        setDragButtonColor(this.iconColor);
        setDraggable(true);
        if (uc.a(getContext(), 540)) {
            position = ToolbarCoordinatorLayout.LayoutParams.Position.LEFT;
        } else {
            position = ToolbarCoordinatorLayout.LayoutParams.Position.TOP;
        }
        ToolbarCoordinatorLayout.LayoutParams.Position lastToolbarPosition = PSPDFKitPreferences.get(getContext()).getLastToolbarPosition(this, position);
        lastToolbarPosition.getClass();
        setLayoutParams(new ToolbarCoordinatorLayout.LayoutParams(lastToolbarPosition, EnumSet.copyOf((Collection) EntriesMappings.entries$0)));
        setUseBackButtonForCloseWhenHorizontal(false);
        updateStylusSelectionState();
    }
}
