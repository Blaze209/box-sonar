package com.pspdfkit.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AtomicFile;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.common.utilities.BoxCommonConstants;
import com.pspdfkit.R;
import com.pspdfkit.contentediting.ContentEditingFormatter;
import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.contentediting.models.TextBlockStyleInfo;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.document.providers.WritableDataProvider;
import com.pspdfkit.exceptions.ContentEditingUnavailableException;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.jni.NativeContentEditingError;
import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.internal.jni.NativeContentEditor;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.special_mode.controller.ContentEditingController;
import com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController;
import com.pspdfkit.ui.special_mode.controller.ContentEditingStylingBarItem;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import com.pspdfkit.undo.UndoManager;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ab extends l30 implements ContentEditingController, mb, ContentEditingManager.OnContentEditingContentChangeListener {
    public final la d;
    public final PdfFragment e;
    public final Lazy f;
    public final kb g;
    public final kb h;
    public final ArrayList<ta> i;
    public ContentEditingInspectorController j;
    public ContentEditingStylingBarItem k;
    public String l;
    public final CopyOnWriteArrayList<pg> m;
    public Function0<Unit> n;

    @DebugMetadata(c = "com.pspdfkit.internal.specialMode.handler.ContentEditingSpecialModeHandler$1", f = "ContentEditingSpecialModeHandler.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, nl = {229}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        /* JADX INFO: renamed from: com.pspdfkit.internal.ab$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pspdfkit.internal.specialMode.handler.ContentEditingSpecialModeHandler$1$1", f = "ContentEditingSpecialModeHandler.kt", i = {}, l = {BoxCommonConstants.REQUEST_DELETE_CURRENT_FOLDER}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
        public static final class C0251a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ ab b;

            /* JADX INFO: renamed from: com.pspdfkit.internal.ab$a$a$a, reason: collision with other inner class name */
            public static final class C0252a<T> implements FlowCollector {
                public final /* synthetic */ ab a;

                public C0252a(ab abVar) {
                    this.a = abVar;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    int iOrdinal = ((kb.a) obj).ordinal();
                    if (iOrdinal == 0) {
                        this.a.finishContentEditingSession(true);
                    } else {
                        if (iOrdinal != 1) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.a.finishContentEditingSession(false);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0251a(ab abVar, Continuation<? super C0251a> continuation) {
                super(2, continuation);
                this.b = abVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0251a(this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new C0251a(this.b, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SharedFlow<kb.a> sharedFlow = ((kb) this.b.f.getValue()).e;
                    C0252a c0252a = new C0252a(this.b);
                    this.a = 1;
                    if (sharedFlow.collect(c0252a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ab.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ab.this.new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Lifecycle lifecycleRegistry = ab.this.e.getLifecycle();
                lifecycleRegistry.getClass();
                Lifecycle.State state = Lifecycle.State.STARTED;
                C0251a c0251a = new C0251a(ab.this, null);
                this.a = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycleRegistry, state, c0251a, this) == coroutine_suspended) {
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
    }

    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ContentEditingStylingBarItem.values().length];
            try {
                iArr[ContentEditingStylingBarItem.FONT_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContentEditingStylingBarItem.FONT_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ContentEditingStylingBarItem.FONT_COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ContentEditingStylingBarItem.LINE_SPACING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public static final class c extends Lambda implements Function0<Fragment> {
        public final /* synthetic */ Fragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PdfFragment pdfFragment) {
            super(0);
            this.a = pdfFragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return this.a;
        }
    }

    public static final class d extends Lambda implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c cVar) {
            super(0);
            this.a = cVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStoreOwner invoke() {
            return this.a.a;
        }
    }

    public static final class e extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ Lazy a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Lazy lazy) {
            super(0);
            this.a = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m10254viewModels$lambda1(this.a).getViewModelStore();
        }
    }

    public static final class f extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Lazy a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Lazy lazy) {
            super(0);
            this.a = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            ViewModelStoreOwner viewModelStoreOwnerM10254viewModels$lambda1 = FragmentViewModelLazyKt.m10254viewModels$lambda1(this.a);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM10254viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM10254viewModels$lambda1 : null;
            return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ Lazy b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PdfFragment pdfFragment, Lazy lazy) {
            super(0);
            this.a = pdfFragment;
            this.b = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            ViewModelStoreOwner viewModelStoreOwnerM10254viewModels$lambda1 = FragmentViewModelLazyKt.m10254viewModels$lambda1(this.b);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM10254viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM10254viewModels$lambda1 : null;
            return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? this.a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ab(la laVar, PdfFragment pdfFragment) {
        laVar.getClass();
        pdfFragment.getClass();
        Context contextRequireContext = pdfFragment.requireContext();
        UndoManager contentEditingUndoManager = pdfFragment.getContentEditingUndoManager();
        contentEditingUndoManager.getClass();
        super(contextRequireContext, pdfFragment, (at) contentEditingUndoManager);
        this.d = laVar;
        this.e = pdfFragment;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new d(new c(pdfFragment)));
        Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(pdfFragment, Reflection.getOrCreateKotlinClass(kb.class), new e(lazy), new f(lazy), new g(pdfFragment, lazy));
        this.f = lazyCreateViewModelLazy;
        this.g = (kb) lazyCreateViewModelLazy.getValue();
        this.h = (kb) lazyCreateViewModelLazy.getValue();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(pdfFragment), null, null, new a(null), 3, null);
        this.i = new ArrayList<>(3);
        this.m = new CopyOnWriteArrayList<>();
    }

    public final Size a(i50 i50Var) {
        ta taVar;
        ta taVar2;
        i50Var.getClass();
        String str = i50Var.c;
        str.getClass();
        ArrayList<ta> arrayList = this.i;
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                taVar = null;
                break;
            }
            taVar = arrayList.get(i);
            i++;
            taVar2 = taVar;
            taVar2.getClass();
        } while (!taVar2.n().containsKey(str));
        ta taVar3 = taVar;
        if (taVar3 != null) {
            return taVar3.C;
        }
        return null;
    }

    public final ya<Unit> b() throws Exception {
        PdfDocument document = this.e.getDocument();
        if (document == null) {
            throw new ContentEditingUnavailableException("Document is no longer available");
        }
        File fileA = wg.a(this.a, "pdf");
        FileOutputStream fileOutputStream = null;
        String absolutePath = fileA != null ? fileA.getAbsolutePath() : null;
        if (absolutePath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Collection collectionValues = this.h.b.values();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Map) it.next()).values());
        }
        ya<Unit> yaVarA = a(new c00(absolutePath, arrayList));
        if (yaVarA.b.getError() != null) {
            throw new NutrientException("Could not write temporary file " + absolutePath + ", error: " + yaVarA.b.getError());
        }
        if (!document.getDocumentSource().isFileSource()) {
            DataProvider dataProvider = document.getDocumentSource().getDataProvider();
            if (!(dataProvider instanceof WritableDataProvider) || !((WritableDataProvider) dataProvider).canWrite()) {
                throw new IllegalStateException("Saving content changes in place can be applied only when the source is a file Uri or a data provider that supports saving.");
            }
            DataProvider dataProvider2 = document.getDocumentSource().getDataProvider();
            dataProvider2.getClass();
            WritableDataProvider writableDataProvider = (WritableDataProvider) dataProvider2;
            writableDataProvider.startWrite(WritableDataProvider.WriteMode.REWRITE_FILE);
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(new File(absolutePath));
                    try {
                        byte[] bArr = new byte[65535];
                        while (fileInputStream.read(bArr) >= 0) {
                            writableDataProvider.write(bArr);
                        }
                        CloseableKt.closeFinally(fileInputStream, null);
                        writableDataProvider.finishWrite();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileInputStream, th);
                            throw th2;
                        }
                    }
                } catch (FileNotFoundException e2) {
                    PdfLog.e("Nutri.CEditingSMHandler", e2, "Error while opening cached file.", new Object[0]);
                    throw e2;
                } catch (IOException e3) {
                    PdfLog.e("Nutri.CEditingSMHandler", e3, "Error while writing.", new Object[0]);
                    throw e3;
                }
            } catch (Throwable th3) {
                writableDataProvider.finishWrite();
                throw th3;
            }
        } else {
            if (!document.isWritableAndCanSave()) {
                throw new NutrientException("Content Editing - SaveToDocument: document is not valid for editing.");
            }
            Uri fileUri = document.getDocumentSource().getFileUri();
            if (fileUri == null) {
                throw new NutrientException("Content Editing - SaveToDocument: File URI is null.");
            }
            wg.a(this.a, true, Arrays.asList(fileUri));
            String strA = wg.a(this.a, fileUri);
            if (strA == null) {
                throw new IllegalStateException("File path for the document source is null.");
            }
            AtomicFile atomicFile = new AtomicFile(new File(strA));
            try {
                FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(absolutePath);
                    try {
                        wg.a(fileInputStream2, fileOutputStreamStartWrite);
                        CloseableKt.closeFinally(fileInputStream2, null);
                        atomicFile.finishWrite(fileOutputStreamStartWrite);
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            CloseableKt.closeFinally(fileInputStream2, th4);
                            throw th5;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = fileOutputStreamStartWrite;
                    if (fileOutputStream != null) {
                        atomicFile.failWrite(fileOutputStream);
                    }
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        try {
            new File(absolutePath).delete();
        } catch (Exception unused) {
        }
        return yaVarA;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final void bindContentEditingInspectorController(ContentEditingInspectorController contentEditingInspectorController) {
        contentEditingInspectorController.getClass();
        this.j = contentEditingInspectorController;
    }

    @Override // com.pspdfkit.internal.mb
    public final ya<g70> c(i50 i50Var, int i, int i2) {
        i50Var.getClass();
        return a(new qc(i50Var, a(i50Var), i, i2));
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final void clearContentEditing() {
        gb gbVar;
        ta taVarA = a();
        if (taVarA == null || (gbVar = taVarA.p) == null) {
            return;
        }
        i50 textBlock = gbVar.getTextBlock();
        ab abVar = taVarA.a;
        int length = ((String) textBlock.e.i.getValue()).length();
        abVar.getClass();
        abVar.b(textBlock, "", textBlock.a(0), textBlock.a(length));
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final void displayColorPicker(StyleInfo styleInfo) {
        a(ContentEditingStylingBarItem.FONT_COLOR, styleInfo, (Float) null);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final void displayFontNamesSheet(StyleInfo styleInfo) {
        a(ContentEditingStylingBarItem.FONT_NAME, styleInfo, (Float) null);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final void displayFontSizesSheet(StyleInfo styleInfo) {
        a(ContentEditingStylingBarItem.FONT_SIZE, styleInfo, (Float) null);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final void displayLineSpacingSheet(Float f2) {
        a(ContentEditingStylingBarItem.LINE_SPACING, (StyleInfo) null, f2);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final void finishContentEditingSession() {
        DocumentSource documentSource;
        Uri fileUri;
        PdfDocument document = this.e.getDocument();
        String path = null;
        if (document != null) {
            if (!document.isWritableAndCanSave()) {
                document = null;
            }
            if (document != null && (documentSource = document.getDocumentSource()) != null && (fileUri = documentSource.getFileUri()) != null) {
                path = fileUri.getPath();
            }
        }
        UndoManager contentEditingUndoManager = this.e.getContentEditingUndoManager();
        contentEditingUndoManager.getClass();
        if (!contentEditingUndoManager.canUndo() || path == null) {
            this.b.exitCurrentlyActiveMode();
            return;
        }
        int i = a00.b;
        Context context = this.a;
        int i2 = R.string.pspdf__contentediting_confirm_discard_changes;
        String name = new File(path).getName();
        String strA = wg.a(path);
        String strSubstring = name.substring(strA.length() + 1);
        int iIndexOf = strSubstring.indexOf(95) + 1;
        if (iIndexOf > 0 && strSubstring.length() - iIndexOf == 40) {
            name = name.substring(0, strA.length() + iIndexOf);
        }
        String string = context.getString(i2, name);
        string.getClass();
        a00 a00Var = new a00();
        Bundle bundle = new Bundle();
        bundle.putString("message", string);
        a00Var.setArguments(bundle);
        a00Var.show(this.e.getChildFragmentManager(), "saveDialog");
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final ContentEditingStylingBarItem getActiveContentEditingStylingItem() {
        ContentEditingStylingBarItem contentEditingStylingBarItem = this.k;
        if (contentEditingStylingBarItem != null) {
            return contentEditingStylingBarItem;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentEditingStylingBarItem");
        return null;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final ContentEditingManager getContentEditingManager() {
        return this.d;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final ContentEditingFormatter getCurrentFormatter() {
        ta taVar;
        gb gbVar;
        ArrayList<ta> arrayList = this.i;
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                taVar = null;
                break;
            }
            taVar = arrayList.get(i);
            i++;
            gbVar = taVar.p;
            if (gbVar == null) {
                gbVar = null;
            }
            if (!(gbVar instanceof ContentEditingFormatter)) {
                gbVar = null;
            }
        } while (gbVar == null);
        ta taVar2 = taVar;
        if (taVar2 != null) {
            gb gbVar2 = taVar2.p;
            if (gbVar2 == null) {
                gbVar2 = null;
            }
            if (gbVar2 instanceof ContentEditingFormatter) {
                return gbVar2;
            }
        }
        return null;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final StyleInfo getCurrentStyleInfo() {
        i50 i50VarL;
        ta taVarA = a();
        if (taVarA == null || (i50VarL = taVarA.l()) == null) {
            return null;
        }
        return i50VarL.d();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final TextBlockStyleInfo getCurrentTextBlockStyleInfo() {
        i50 i50VarL;
        ta taVarA = a();
        if (taVarA == null || (i50VarL = taVarA.l()) == null) {
            return null;
        }
        l50 l50Var = i50VarL.d;
        Alignment alignment = l50Var.b;
        Float f2 = l50Var.d;
        aj ajVar = l50Var.c;
        return new TextBlockStyleInfo(alignment, f2, ajVar.a, ajVar.b);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController
    public final PdfFragment getFragment() {
        return this.e;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final UndoManager getUndoManager() {
        UndoManager contentEditingUndoManager = this.e.getContentEditingUndoManager();
        contentEditingUndoManager.getClass();
        return contentEditingUndoManager;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final boolean hasUnsavedChanges() {
        UndoManager contentEditingUndoManager = this.e.getContentEditingUndoManager();
        contentEditingUndoManager.getClass();
        return contentEditingUndoManager.canUndo();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final boolean isBoldStyleButtonEnabled(StyleInfo styleInfo) {
        return true;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final boolean isClearContentEditingEnabled() {
        return a() != null;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final boolean isItalicStyleButtonEnabled(StyleInfo styleInfo) {
        return true;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final boolean isRedoEnabled() {
        UndoManager contentEditingUndoManager = this.e.getContentEditingUndoManager();
        contentEditingUndoManager.getClass();
        return contentEditingUndoManager.canRedo();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final boolean isSaveEnabled() {
        UndoManager contentEditingUndoManager = this.e.getContentEditingUndoManager();
        contentEditingUndoManager.getClass();
        return contentEditingUndoManager.canUndo();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final boolean isUndoEnabled() {
        UndoManager contentEditingUndoManager = this.e.getContentEditingUndoManager();
        contentEditingUndoManager.getClass();
        return contentEditingUndoManager.canUndo();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public final void onContentChange(String str) {
        str.getClass();
        nb nbVar = (nb) this.d;
        nbVar.getClass();
        str.getClass();
        Iterator<ContentEditingManager.OnContentEditingContentChangeListener> it = nbVar.b.iterator();
        while (it.hasNext()) {
            it.next().onContentChange(str);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public final void onContentSelectionChange(String str, int i, int i2, StyleInfo styleInfo, boolean z) {
        str.getClass();
        styleInfo.getClass();
        if (Intrinsics.areEqual(this.l, str)) {
            new Pair(Integer.valueOf(i), Integer.valueOf(i2));
        }
        nb nbVar = (nb) this.d;
        nbVar.getClass();
        Iterator<ContentEditingManager.OnContentEditingContentChangeListener> it = nbVar.b.iterator();
        while (it.hasNext()) {
            it.next().onContentSelectionChange(str, i, i2, styleInfo, z);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public final void onDisplayPropertyInspector(PropertyInspector propertyInspector) {
        propertyInspector.getClass();
        if (this.l == null || a() == null) {
            return;
        }
        propertyInspector.getClass();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public final void onFinishEditingContentBlock(String str) {
        str.getClass();
        if (Intrinsics.areEqual(str, this.l)) {
            this.l = null;
        }
        nb nbVar = (nb) this.d;
        nbVar.getClass();
        Iterator<ContentEditingManager.OnContentEditingContentChangeListener> it = nbVar.b.iterator();
        while (it.hasNext()) {
            it.next().onFinishEditingContentBlock(str);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public final void onPreparePropertyInspector(PropertyInspector propertyInspector) {
        propertyInspector.getClass();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public final void onRemovePropertyInspector(PropertyInspector propertyInspector) {
        ta taVarA;
        propertyInspector.getClass();
        if (this.l == null || (taVarA = a()) == null) {
            return;
        }
        taVarA.onRemovePropertyInspector(propertyInspector);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public final void onStartEditingContentBlock(String str) {
        str.getClass();
        this.l = str;
        nb nbVar = (nb) this.d;
        nbVar.getClass();
        str.getClass();
        Iterator<ContentEditingManager.OnContentEditingContentChangeListener> it = nbVar.b.iterator();
        while (it.hasNext()) {
            it.next().onStartEditingContentBlock(str);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public final void onTextBlockStyleChange(String str, TextBlockStyleInfo textBlockStyleInfo) {
        str.getClass();
        textBlockStyleInfo.getClass();
        nb nbVar = (nb) this.d;
        nbVar.getClass();
        str.getClass();
        textBlockStyleInfo.getClass();
        Iterator<ContentEditingManager.OnContentEditingContentChangeListener> it = nbVar.b.iterator();
        while (it.hasNext()) {
            it.next().onTextBlockStyleChange(str, textBlockStyleInfo);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final void unbindContentEditingInspectorController() {
        this.j = null;
    }

    public final void c() {
        this.m.clear();
        this.m.addAll((List) a(new b7()).a);
        PdfLog.d("Nutri.CEditingSMHandler", "Available Faces (" + this.m.size() + "):\r\n" + CollectionsKt.joinToString$default(this.m, IOUtils.LINE_SEPARATOR_WINDOWS, null, null, 0, null, null, 62, null), new Object[0]);
    }

    public final <ResultType> ya<ResultType> a(ga<?, ResultType> gaVar) {
        ya<ResultType> yaVar;
        NativeContentEditor nativeContentEditor = this.g.a;
        if (nativeContentEditor != null) {
            synchronized (nativeContentEditor) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    NativeContentEditingResult nativeContentEditingResultA = gaVar.a(nativeContentEditor);
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    za<ResultType> zaVarE = gaVar.e();
                    NativeContentEditingError error = nativeContentEditingResultA.getError();
                    if (error == null) {
                        Object objDecodeFromString = ra.a.decodeFromString(zaVarE.a, zaVarE.a(nativeContentEditingResultA));
                        zaVarE.b.invoke((ResultType) objDecodeFromString, nativeContentEditingResultA);
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                        PdfLog.d("Nutri.CEditingSMHandler", gaVar.d() + " " + gaVar.a() + " executed in " + jCurrentTimeMillis3 + " ms (native execution = " + jCurrentTimeMillis2 + " ms, conversion = " + (jCurrentTimeMillis3 - jCurrentTimeMillis2) + " ms.", new Object[0]);
                        yaVar = new ya<>(objDecodeFromString, nativeContentEditingResultA);
                    } else {
                        PdfLog.e("Nutri.ContEditingResCon", error.toString(), new Object[0]);
                        throw new NutrientException(error.toString());
                    }
                } catch (Exception e2) {
                    PdfLog.e("Nutri.CEditingSMHandler", e2, "Error on executing " + gaVar.d() + " " + gaVar.a(), new Object[0]);
                    throw e2;
                }
            }
            return yaVar;
        }
        throw new ContentEditingUnavailableException("Content editing session is no longer active");
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingController
    public final void finishContentEditingSession(boolean z) {
        if (z) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new bb(this, null), 3, null);
        } else {
            this.b.exitCurrentlyActiveMode();
        }
    }

    public final i50 a(int i, String str) {
        str.getClass();
        Map map = (Map) this.h.b.get(Integer.valueOf(i));
        if (map != null) {
            return (i50) map.get(str);
        }
        return null;
    }

    public final ta a() {
        ta taVar;
        ArrayList<ta> arrayList = this.i;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            taVar = arrayList.get(i);
            i++;
            if (taVar.p != null) {
                return taVar;
            }
        }
        taVar = null;
        return taVar;
    }

    public final void a(ContentEditingStylingBarItem contentEditingStylingBarItem, StyleInfo styleInfo, Float f2) {
        ContentEditingInspectorController contentEditingInspectorController = this.j;
        if (contentEditingInspectorController == null) {
            return;
        }
        Object currentFormatter = getCurrentFormatter();
        if (currentFormatter != null) {
            hn.c((View) currentFormatter);
            gb gbVar = (gb) currentFormatter;
            gbVar.e();
            s00 s00Var = gbVar.k;
            s00Var.a();
            s00Var.b();
            PdfLog.d("ContentEditingTextInputView", "hideSelectionUI: hidden for inspector", new Object[0]);
        }
        this.k = contentEditingStylingBarItem;
        int i = b.a[contentEditingStylingBarItem.ordinal()];
        if (i == 1) {
            contentEditingInspectorController.displayFontNamesSheet(true, this.m, styleInfo);
            return;
        }
        if (i == 2) {
            contentEditingInspectorController.displayFontSizesSheet(true, styleInfo);
        } else if (i == 3) {
            contentEditingInspectorController.displayColorPicker(true, styleInfo);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            contentEditingInspectorController.displayLineSpacingSheet(true, f2);
        }
    }

    @Override // com.pspdfkit.internal.mb
    public final ya<g70> a(i50 i50Var, String str, Integer num) {
        i50Var.getClass();
        str.getClass();
        return a(new pk(i50Var, a(i50Var), str, num));
    }

    @Override // com.pspdfkit.internal.mb
    public final ya<g70> a(i50 i50Var, Integer num, b9 b9Var) {
        i50Var.getClass();
        return a(new v00(i50Var, num, b9Var));
    }

    @Override // com.pspdfkit.internal.mb
    public final ya<g70> a(i50 i50Var, Alignment alignment) {
        i50Var.getClass();
        alignment.getClass();
        return a(new w00(i50Var, a(i50Var), alignment));
    }

    @Override // com.pspdfkit.internal.mb
    public final ya<g70> a(i50 i50Var, Float f2) {
        i50Var.getClass();
        return a(new x00(i50Var, a(i50Var), f2));
    }

    @Override // com.pspdfkit.internal.mb
    public final ya<g70> a(i50 i50Var, StyleInfo styleInfo) {
        i50Var.getClass();
        styleInfo.getClass();
        return a(new p5(i50Var, a(i50Var), styleInfo));
    }
}
