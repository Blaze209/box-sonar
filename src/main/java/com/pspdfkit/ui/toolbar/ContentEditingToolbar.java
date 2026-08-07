package com.pspdfkit.ui.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.media3.extractor.ts.PsExtractor;
import com.pspdfkit.R;
import com.pspdfkit.internal.no;
import com.pspdfkit.ui.special_mode.controller.ContentEditingController;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import com.pspdfkit.undo.OnUndoHistoryChangeListener;
import com.pspdfkit.undo.UndoManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u00011B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0014H\u0014J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140*H\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u0002H\u0002J\u0010\u0010/\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u0002H\u0002J\b\u00100\u001a\u00020\u0019H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/pspdfkit/ui/toolbar/ContentEditingToolbar;", "Lcom/pspdfkit/ui/toolbar/ContextualToolbar;", "Lcom/pspdfkit/ui/special_mode/controller/ContentEditingController;", "Lcom/pspdfkit/ui/special_mode/manager/ContentEditingManager$OnContentEditingContentChangeListener;", "Lcom/pspdfkit/undo/OnUndoHistoryChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "controller", "iconColorInactive", "textIconColor", "iconColorActivated", "undoIcon", "redoIcon", "saveButtonItem", "Lcom/pspdfkit/ui/toolbar/ContextualToolbarMenuItem;", "saveButtonFontSize", "undoItem", "redoItem", "toolbarScope", "Lkotlinx/coroutines/CoroutineScope;", "onAttachedToWindow", "", "onDetachedFromWindow", "isDraggable", "", "bindController", "specialModeController", "unbindController", "isControllerBound", "onUndoHistoryChanged", "undoManager", "Lcom/pspdfkit/undo/UndoManager;", "handleMenuItemClick", "item", "initializeToolbar", "generateMenuItems", "", "shouldEnableSaveButton", "updateSaveButtonEnabledState", "executeUndo", "currentController", "executeRedo", "createToolbarScope", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentEditingToolbar extends ContextualToolbar<ContentEditingController> implements ContentEditingManager.OnContentEditingContentChangeListener, OnUndoHistoryChangeListener {
    private static final float SAVE_TEXT_SIZE_SP = 14.0f;
    private ContentEditingController controller;
    private int iconColorActivated;
    private int iconColorInactive;
    private int redoIcon;
    private ContextualToolbarMenuItem redoItem;
    private int saveButtonFontSize;
    private ContextualToolbarMenuItem saveButtonItem;
    private int textIconColor;
    private CoroutineScope toolbarScope;
    private int undoIcon;
    private ContextualToolbarMenuItem undoItem;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.pspdfkit.ui.toolbar.ContentEditingToolbar$executeRedo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.toolbar.ContentEditingToolbar$executeRedo$1", f = "ContentEditingToolbar.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, nl = {247}, s = {}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ContentEditingController $currentController;
        int label;

        /* JADX INFO: renamed from: com.pspdfkit.ui.toolbar.ContentEditingToolbar$executeRedo$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.pspdfkit.ui.toolbar.ContentEditingToolbar$executeRedo$1$1", f = "ContentEditingToolbar.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
        public static final class C02981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ContentEditingController $currentController;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02981(ContentEditingController contentEditingController, Continuation<? super C02981> continuation) {
                super(2, continuation);
                this.$currentController = contentEditingController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02981(this.$currentController, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    UndoManager undoManager = this.$currentController.getUndoManager();
                    this.label = 1;
                    if (undoManager.redo(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ContentEditingController contentEditingController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$currentController = contentEditingController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$currentController, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                C02981 c02981 = new C02981(this.$currentController, null);
                this.label = 1;
                if (BuildersKt.withContext(io2, c02981, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.ui.toolbar.ContentEditingToolbar$executeUndo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.toolbar.ContentEditingToolbar$executeUndo$1", f = "ContentEditingToolbar.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, nl = {PsExtractor.VIDEO_STREAM_MASK}, s = {}, v = 2)
    public static final class C18631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ContentEditingController $currentController;
        int label;

        /* JADX INFO: renamed from: com.pspdfkit.ui.toolbar.ContentEditingToolbar$executeUndo$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.pspdfkit.ui.toolbar.ContentEditingToolbar$executeUndo$1$1", f = "ContentEditingToolbar.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
        public static final class C02991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ContentEditingController $currentController;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02991(ContentEditingController contentEditingController, Continuation<? super C02991> continuation) {
                super(2, continuation);
                this.$currentController = contentEditingController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02991(this.$currentController, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    UndoManager undoManager = this.$currentController.getUndoManager();
                    this.label = 1;
                    if (undoManager.undo(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18631(ContentEditingController contentEditingController, Continuation<? super C18631> continuation) {
            super(2, continuation);
            this.$currentController = contentEditingController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18631(this.$currentController, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                C02991 c02991 = new C02991(this.$currentController, null);
                this.label = 1;
                if (BuildersKt.withContext(io2, c02991, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentEditingToolbar(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    private final CoroutineScope createToolbarScope() {
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    }

    private final void executeRedo(ContentEditingController currentController) {
        if (currentController.isRedoEnabled()) {
            BuildersKt__Builders_commonKt.launch$default(this.toolbarScope, null, null, new AnonymousClass1(currentController, null), 3, null);
        }
    }

    private final void executeUndo(ContentEditingController currentController) {
        if (currentController.isUndoEnabled()) {
            BuildersKt__Builders_commonKt.launch$default(this.toolbarScope, null, null, new C18631(currentController, null), 3, null);
        }
    }

    private final List<ContextualToolbarMenuItem> generateMenuItems() {
        Context context = getContext();
        ArrayList arrayList = new ArrayList();
        int i = R.id.pspdf__document_editing_toolbar_item_undo;
        Drawable drawable = AppCompatResources.getDrawable(context, this.undoIcon);
        drawable.getClass();
        ContextualToolbarMenuItem contextualToolbarMenuItem = null;
        String strA = no.a(context, R.string.pspdf__undo, null);
        int i2 = this.iconColorInactive;
        int i3 = this.iconColorActivated;
        ContextualToolbarMenuItem.Position position = ContextualToolbarMenuItem.Position.END;
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem = ContextualToolbarMenuItem.createSingleItem(context, i, drawable, strA, i2, i3, position, false);
        ContentEditingController contentEditingController = this.controller;
        boolean z = false;
        contextualToolbarMenuItemCreateSingleItem.setEnabled(contentEditingController != null && contentEditingController.isUndoEnabled());
        this.undoItem = contextualToolbarMenuItemCreateSingleItem;
        arrayList.add(contextualToolbarMenuItemCreateSingleItem);
        int i4 = R.id.pspdf__document_editing_toolbar_item_redo;
        Drawable drawable2 = AppCompatResources.getDrawable(context, this.redoIcon);
        drawable2.getClass();
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem2 = ContextualToolbarMenuItem.createSingleItem(context, i4, drawable2, no.a(context, R.string.pspdf__redo, null), this.iconColorInactive, this.iconColorActivated, position, false);
        ContentEditingController contentEditingController2 = this.controller;
        if (contentEditingController2 != null && contentEditingController2.isRedoEnabled()) {
            z = true;
        }
        contextualToolbarMenuItemCreateSingleItem2.setEnabled(z);
        this.redoItem = contextualToolbarMenuItemCreateSingleItem2;
        arrayList.add(contextualToolbarMenuItemCreateSingleItem2);
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleTextItem = ContextualToolbarMenuItem.createSingleTextItem(context, R.id.pspdf__document_editing_toolbar_item_save, position);
        contextualToolbarMenuItemCreateSingleTextItem.getClass();
        this.saveButtonItem = contextualToolbarMenuItemCreateSingleTextItem;
        String strA2 = no.a(context, R.string.pspdf__save, null);
        strA2.getClass();
        this.saveButtonFontSize = (int) TypedValue.applyDimension(2, 14.0f, context.getResources().getDisplayMetrics());
        ContextualToolbarMenuItem contextualToolbarMenuItem2 = this.saveButtonItem;
        if (contextualToolbarMenuItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButtonItem");
            contextualToolbarMenuItem2 = null;
        }
        contextualToolbarMenuItem2.setTitle(strA2);
        ContextualToolbarMenuItem contextualToolbarMenuItem3 = this.saveButtonItem;
        if (contextualToolbarMenuItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButtonItem");
            contextualToolbarMenuItem3 = null;
        }
        contextualToolbarMenuItem3.setTextItemFirstFromEnd(true);
        updateSaveButtonEnabledState();
        ContextualToolbarMenuItem contextualToolbarMenuItem4 = this.saveButtonItem;
        if (contextualToolbarMenuItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButtonItem");
        } else {
            contextualToolbarMenuItem = contextualToolbarMenuItem4;
        }
        arrayList.add(contextualToolbarMenuItem);
        return arrayList;
    }

    private final void initializeToolbar(Context context) {
        setId(R.id.pspdf__content_editing_toolbar);
        int color = ContextCompat.getColor(context, R.color.pspdf__primaryLight);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__ContentEditingToolbar, R.attr.pspdf__contentEditingToolbarStyle, R.style.PSPDFKit_ContentEditingToolbar);
        typedArrayObtainStyledAttributes.getClass();
        this.iconColorInactive = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ContentEditingToolbar_pspdf__contentEditingToolbarIconColorInactive, color);
        this.iconColorActivated = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ContentEditingToolbar_pspdf__contentEditingToolbarIconColorActivated, color);
        this.textIconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ContentEditingToolbar_pspdf__contentEditingToolbarTextIconColor, color);
        typedArrayObtainStyledAttributes.recycle();
        this.closeButton.setIconColor(this.iconColorActivated);
        this.closeButton.setPosition(ContextualToolbarMenuItem.Position.START);
        setMenuItemGroupingRule(null);
        setMenuItems(generateMenuItems());
    }

    private final boolean shouldEnableSaveButton() {
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController == null) {
            return false;
        }
        return contentEditingController.isSaveEnabled();
    }

    private final void updateSaveButtonEnabledState() {
        ContextualToolbarMenuItem contextualToolbarMenuItem = this.saveButtonItem;
        ContextualToolbarMenuItem contextualToolbarMenuItem2 = null;
        if (contextualToolbarMenuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButtonItem");
            contextualToolbarMenuItem = null;
        }
        String title = contextualToolbarMenuItem.getTitle();
        if (title == null) {
            return;
        }
        boolean zShouldEnableSaveButton = shouldEnableSaveButton();
        ContextualToolbarMenuItem contextualToolbarMenuItem3 = this.saveButtonItem;
        if (contextualToolbarMenuItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButtonItem");
            contextualToolbarMenuItem3 = null;
        }
        float f = this.saveButtonFontSize;
        int i = this.textIconColor;
        Typeface typeface = Typeface.DEFAULT_BOLD;
        typeface.getClass();
        float f2 = zShouldEnableSaveButton ? 1.0f : 0.5f;
        typeface.getClass();
        double d = f2;
        if (0.0d > d || d > 1.0d) {
            throw new IllegalArgumentException("TextToBitmapUtils: Text alpha must be between 0 and 1.");
        }
        Paint paint = new Paint(1);
        paint.setTextSize(f);
        paint.setColor(i);
        paint.setTypeface(typeface);
        paint.setAlpha((int) (f2 * 255));
        float f3 = -paint.ascent();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (paint.measureText(title) + 0.5f), (int) (paint.descent() + f3 + 0.5f), Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.getClass();
        new Canvas(bitmapCreateBitmap).drawText(title, 0.0f, f3, paint);
        contextualToolbarMenuItem3.setImageBitmap(bitmapCreateBitmap);
        ContextualToolbarMenuItem contextualToolbarMenuItem4 = this.saveButtonItem;
        if (contextualToolbarMenuItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButtonItem");
        } else {
            contextualToolbarMenuItem2 = contextualToolbarMenuItem4;
        }
        contextualToolbarMenuItem2.setEnabled(zShouldEnableSaveButton);
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void handleMenuItemClick(ContextualToolbarMenuItem item) {
        item.getClass();
        ContextualToolbarMenuItem defaultSelectedMenuItem = item.getDefaultSelectedMenuItem();
        if (defaultSelectedMenuItem != null) {
            item = defaultSelectedMenuItem;
        }
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController != null && item.isEnabled()) {
            int id = item.getId();
            if (id == this.closeButton.getId()) {
                contentEditingController.finishContentEditingSession();
                return;
            }
            ContextualToolbarMenuItem contextualToolbarMenuItem = this.saveButtonItem;
            ContextualToolbarMenuItem contextualToolbarMenuItem2 = null;
            if (contextualToolbarMenuItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saveButtonItem");
                contextualToolbarMenuItem = null;
            }
            if (id == contextualToolbarMenuItem.getId()) {
                contentEditingController.finishContentEditingSession(true);
                return;
            }
            ContextualToolbarMenuItem contextualToolbarMenuItem3 = this.undoItem;
            if (contextualToolbarMenuItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("undoItem");
                contextualToolbarMenuItem3 = null;
            }
            if (id == contextualToolbarMenuItem3.getId()) {
                executeUndo(contentEditingController);
                return;
            }
            ContextualToolbarMenuItem contextualToolbarMenuItem4 = this.redoItem;
            if (contextualToolbarMenuItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("redoItem");
            } else {
                contextualToolbarMenuItem2 = contextualToolbarMenuItem4;
            }
            if (id == contextualToolbarMenuItem2.getId()) {
                executeRedo(contentEditingController);
            }
        }
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public boolean isControllerBound() {
        return this.controller != null;
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public boolean isDraggable() {
        return false;
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (CoroutineScopeKt.isActive(this.toolbarScope)) {
            return;
        }
        this.toolbarScope = createToolbarScope();
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        CoroutineScopeKt.cancel$default(this.toolbarScope, null, 1, null);
        super.onDetachedFromWindow();
    }

    @Override // com.pspdfkit.undo.OnUndoHistoryChangeListener
    public void onUndoHistoryChanged(UndoManager undoManager) {
        undoManager.getClass();
        ContextualToolbarMenuItem contextualToolbarMenuItem = this.undoItem;
        ContextualToolbarMenuItem contextualToolbarMenuItem2 = null;
        if (contextualToolbarMenuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("undoItem");
            contextualToolbarMenuItem = null;
        }
        contextualToolbarMenuItem.setEnabled(undoManager.canUndo());
        ContextualToolbarMenuItem contextualToolbarMenuItem3 = this.redoItem;
        if (contextualToolbarMenuItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redoItem");
            contextualToolbarMenuItem3 = null;
        }
        contextualToolbarMenuItem3.setEnabled(undoManager.canRedo());
        ContextualToolbarMenuItem contextualToolbarMenuItem4 = this.saveButtonItem;
        if (contextualToolbarMenuItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButtonItem");
        } else {
            contextualToolbarMenuItem2 = contextualToolbarMenuItem4;
        }
        if (contextualToolbarMenuItem2.isEnabled() != shouldEnableSaveButton()) {
            updateSaveButtonEnabledState();
        }
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void unbindController() {
        UndoManager undoManager;
        ContentEditingManager contentEditingManager;
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController != null && (contentEditingManager = contentEditingController.getContentEditingManager()) != null) {
            contentEditingManager.removeOnContentEditingContentChangeListener(this);
        }
        ContentEditingController contentEditingController2 = this.controller;
        if (contentEditingController2 != null && (undoManager = contentEditingController2.getUndoManager()) != null) {
            undoManager.removeOnUndoHistoryChangeListener(this);
        }
        this.controller = null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentEditingToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void bindController(ContentEditingController specialModeController) {
        UndoManager undoManager;
        UndoManager undoManager2;
        ContentEditingManager contentEditingManager;
        specialModeController.getClass();
        unbindController();
        this.controller = specialModeController;
        if (specialModeController != null && (contentEditingManager = specialModeController.getContentEditingManager()) != null) {
            contentEditingManager.addOnContentEditingContentChangeListener(this);
        }
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController != null && (undoManager2 = contentEditingController.getUndoManager()) != null) {
            undoManager2.addOnUndoHistoryChangeListener(this);
        }
        ContentEditingController contentEditingController2 = this.controller;
        if (contentEditingController2 == null || (undoManager = contentEditingController2.getUndoManager()) == null) {
            return;
        }
        onUndoHistoryChanged(undoManager);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentEditingToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.undoIcon = R.drawable.pspdf__ic_undo;
        this.redoIcon = R.drawable.pspdf__ic_redo;
        this.toolbarScope = createToolbarScope();
        initializeToolbar(context);
    }

    public /* synthetic */ ContentEditingToolbar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
