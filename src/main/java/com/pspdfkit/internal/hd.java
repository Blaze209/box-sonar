package com.pspdfkit.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.box.android.data.api.models.annotations.Location;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.editor.FilePicker;
import com.pspdfkit.document.editor.PdfDocumentEditor;
import com.pspdfkit.document.editor.page.NewPageFactory;
import com.pspdfkit.document.processor.NewPage;
import com.pspdfkit.internal.bx.a;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView;
import com.pspdfkit.ui.PdfThumbnailGrid;
import com.pspdfkit.ui.document.editor.DocumentEditorProgressDialog;
import com.pspdfkit.ui.special_mode.controller.DocumentEditingController;
import com.pspdfkit.ui.special_mode.manager.DocumentEditingManager;
import com.pspdfkit.undo.EditingChange;
import com.pspdfkit.undo.EditingOperation;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class hd implements DocumentEditingController, NewPageFactory.OnNewPageReadyListener {
    public final PdfThumbnailGrid a;
    public gd b;
    public final PdfThumbnailGrid c;
    public final ThumbnailGridRecyclerView d;
    public boolean e;
    public boolean f;

    @DebugMetadata(c = "com.pspdfkit.internal.document.editor.DocumentEditorSavingToolbarHandler$checkForRedactionAnnotations$1", f = "DocumentEditorSavingToolbarHandler.kt", i = {0, 0, 1, 1, 1, 1}, l = {249, 254}, m = "invokeSuspend", n = {"document", "redactionTypes", "document", "redactionTypes", "found", Location.TYPE_PAGE}, nl = {251, 253}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "I$1"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object a;
        public Object b;
        public Iterator c;
        public int d;
        public int e;
        public final /* synthetic */ HashSet<Integer> g;
        public final /* synthetic */ Context h;
        public final /* synthetic */ Runnable i;
        public final /* synthetic */ DocumentEditorProgressDialog j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HashSet<Integer> hashSet, Context context, Runnable runnable, DocumentEditorProgressDialog documentEditorProgressDialog, Continuation<? super a> continuation) {
            super(2, continuation);
            this.g = hashSet;
            this.h = context;
            this.i = runnable;
            this.j = documentEditorProgressDialog;
        }

        public static final void a(Runnable runnable, DialogInterface dialogInterface, int i) {
            runnable.run();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return hd.this.new a(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0081 A[Catch: all -> 0x00dd, CancellationException -> 0x00ef, TryCatch #3 {CancellationException -> 0x00ef, all -> 0x00dd, blocks: (B:7:0x001b, B:30:0x00a6, B:25:0x007b, B:27:0x0081, B:35:0x00b2, B:36:0x00d7, B:12:0x0030, B:20:0x0066, B:15:0x0046, B:17:0x004a, B:24:0x0071), top: B:48:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00af  */
        /* JADX WARN: Code duplicated, block: B:35:0x00b2 A[Catch: all -> 0x00dd, CancellationException -> 0x00ef, TryCatch #3 {CancellationException -> 0x00ef, all -> 0x00dd, blocks: (B:7:0x001b, B:30:0x00a6, B:25:0x007b, B:27:0x0081, B:35:0x00b2, B:36:0x00d7, B:12:0x0030, B:20:0x0066, B:15:0x0046, B:17:0x004a, B:24:0x0071), top: B:48:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00d7 A[Catch: all -> 0x00dd, CancellationException -> 0x00ef, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x00ef, all -> 0x00dd, blocks: (B:7:0x001b, B:30:0x00a6, B:25:0x007b, B:27:0x0081, B:35:0x00b2, B:36:0x00d7, B:12:0x0030, B:20:0x0066, B:15:0x0046, B:17:0x004a, B:24:0x0071), top: B:48:0x0009 }] */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00a3, code lost:
        
            if (r10 == r0) goto L29;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a3 -> B:30:0x00a6). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 248
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.hd.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ HashSet<Integer> b;

        public b(HashSet<Integer> hashSet) {
            this.b = hashSet;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            ((List) obj).getClass();
            ThumbnailGridRecyclerView thumbnailGridRecyclerView = hd.this.d;
            HashSet<Integer> hashSet = this.b;
            if (thumbnailGridRecyclerView.f != null) {
                ArrayList arrayList = new ArrayList(hashSet);
                Collections.sort(arrayList, Collections.reverseOrder());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    thumbnailGridRecyclerView.f.notifyItemInserted(((Integer) obj2).intValue() + 1);
                }
                thumbnailGridRecyclerView.c.a();
            }
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            Bundle bundle = new Bundle();
            bundle.putString(Analytics.Data.ACTION, "duplicate_selected_pages");
            bundle.putString("value", u40.a(",", u40.a(this.b)));
            i0VarA.a(Analytics.Event.PERFORM_DOCUMENT_EDITOR_ACTION, bundle);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = new c<>();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Throwable th = (Throwable) obj;
            th.getClass();
            PdfLog.e("Nutri.DocEdiSavTBarHand", th, "Error duplicating selected pages.", new Object[0]);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.document.editor.DocumentEditorSavingToolbarHandler$exitActiveMode$1", f = "DocumentEditorSavingToolbarHandler.kt", i = {}, l = {533}, m = "invokeSuspend", n = {}, nl = {532}, s = {}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        @DebugMetadata(c = "com.pspdfkit.internal.document.editor.DocumentEditorSavingToolbarHandler$exitActiveMode$1$hasUndo$1", f = "DocumentEditorSavingToolbarHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            public final /* synthetic */ hd a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(hd hdVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.a = hdVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.a, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                return new a(this.a, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(this.a.b.a(true).canUndo());
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        public static final void a(hd hdVar, DialogInterface dialogInterface, int i) {
            hdVar.c.exitDocumentEditingMode();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return hd.this.new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return hd.this.new d(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                a aVar = new a(hd.this, null);
                this.a = 1;
                obj = BuildersKt.withContext(io2, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                AlertDialog.Builder message = new AlertDialog.Builder(hd.this.c.getContext()).setMessage(R.string.pspdf__discard_changes);
                int i2 = R.string.pspdf__ok;
                final hd hdVar = hd.this;
                message.setPositiveButton(i2, new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.hd$d$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        hd.d.a(hdVar, dialogInterface, i3);
                    }
                }).setNegativeButton(R.string.pspdf__cancel, (DialogInterface.OnClickListener) null).show();
            } else {
                hd.this.c.exitDocumentEditingMode();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;

        public e(Context context, int i) {
            this.b = context;
            this.c = i;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public final Object apply(Object obj) {
            Uri uri = (Uri) obj;
            uri.getClass();
            return hd.this.b.importDocument(this.b, new DocumentSource(uri), this.c).toMaybe();
        }
    }

    public static final class f extends y20<List<? extends EditingChange>> {
        public final /* synthetic */ int b;

        public f(int i) {
            this.b = i;
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public final void onComplete() {
            PdfLog.d("Nutri.DocEdiSavTBarHand", "Document importing was canceled.", new Object[0]);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public final void onError(Throwable th) {
            th.getClass();
            PdfLog.e("Nutri.DocEdiSavTBarHand", th, "Document couldn't be imported.", new Object[0]);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public final void onSuccess(Object obj) {
            ((List) obj).getClass();
            ThumbnailGridRecyclerView thumbnailGridRecyclerView = hd.this.d;
            int i = this.b;
            l60 l60Var = thumbnailGridRecyclerView.f;
            if (l60Var != null) {
                l60Var.notifyItemRangeChanged(i, l60Var.getItemCount());
                thumbnailGridRecyclerView.c.a();
                thumbnailGridRecyclerView.scrollToPosition(i);
            }
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.document.editor.DocumentEditorSavingToolbarHandler$performUIChanges$1", f = "DocumentEditorSavingToolbarHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List<EditingChange> a;
        public final /* synthetic */ hd b;
        public final /* synthetic */ boolean c;

        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EditingOperation.values().length];
                try {
                    iArr[EditingOperation.REMOVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EditingOperation.INSERT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EditingOperation.INSERTREFERENCE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EditingOperation.ROTATE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[EditingOperation.MOVE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(List<EditingChange> list, hd hdVar, boolean z, Continuation<? super g> continuation) {
            super(2, continuation);
            this.a = list;
            this.b = hdVar;
            this.c = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.a, this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            for (EditingChange editingChange : this.a) {
                EditingOperation editingOperation = editingChange.getEditingOperation();
                int affectedPageIndex = editingChange.getAffectedPageIndex();
                int pageIndexDestination = editingChange.getPageIndexDestination();
                int i = a.a[editingOperation.ordinal()];
                if (i == 1) {
                    ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.b.d;
                    l60 l60Var = thumbnailGridRecyclerView.f;
                    if (l60Var != null) {
                        l60Var.notifyItemRemoved(affectedPageIndex);
                        thumbnailGridRecyclerView.c.a();
                    }
                } else if (i == 2 || i == 3) {
                    ThumbnailGridRecyclerView thumbnailGridRecyclerView2 = this.b.d;
                    boolean z = this.c;
                    l60 l60Var2 = thumbnailGridRecyclerView2.f;
                    if (l60Var2 != null) {
                        l60Var2.notifyItemInserted(affectedPageIndex);
                        thumbnailGridRecyclerView2.c.a();
                        if (!z) {
                            thumbnailGridRecyclerView2.scrollToPosition(affectedPageIndex);
                        }
                    }
                } else if (i == 4) {
                    boolean z2 = this.c;
                    ThumbnailGridRecyclerView thumbnailGridRecyclerView3 = this.b.d;
                    if (z2) {
                        l60 l60Var3 = thumbnailGridRecyclerView3.f;
                        if (l60Var3 != null) {
                            l60Var3.notifyItemChanged(affectedPageIndex);
                        }
                    } else {
                        l60 l60Var4 = thumbnailGridRecyclerView3.f;
                        if (l60Var4 != null) {
                            l60Var4.notifyItemChanged(affectedPageIndex);
                        }
                    }
                } else {
                    if (i != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ThumbnailGridRecyclerView thumbnailGridRecyclerView4 = this.b.d;
                    l60 l60Var5 = thumbnailGridRecyclerView4.f;
                    if (l60Var5 != null) {
                        l60Var5.notifyItemMoved(affectedPageIndex, pageIndexDestination);
                        thumbnailGridRecyclerView4.f.notifyItemChanged(affectedPageIndex);
                        thumbnailGridRecyclerView4.f.notifyItemChanged(pageIndexDestination);
                        thumbnailGridRecyclerView4.c.a();
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ HashSet<Integer> b;

        public h(HashSet<Integer> hashSet) {
            this.b = hashSet;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            ((List) obj).getClass();
            ThumbnailGridRecyclerView thumbnailGridRecyclerView = hd.this.d;
            HashSet<Integer> hashSet = this.b;
            if (thumbnailGridRecyclerView.f != null) {
                ArrayList arrayList = new ArrayList(hashSet);
                Collections.sort(arrayList, Collections.reverseOrder());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    thumbnailGridRecyclerView.f.notifyItemRemoved(((Integer) obj2).intValue());
                }
                thumbnailGridRecyclerView.c.a();
            }
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            Bundle bundle = new Bundle();
            bundle.putString(Analytics.Data.ACTION, "remove_selected_pages");
            bundle.putString("value", u40.a(",", u40.a(this.b)));
            i0VarA.a(Analytics.Event.PERFORM_DOCUMENT_EDITOR_ACTION, bundle);
        }
    }

    public static final class i<T> implements Consumer {
        public static final i<T> a = new i<>();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Throwable th = (Throwable) obj;
            th.getClass();
            PdfLog.e("Nutri.DocEdiSavTBarHand", th, "Error removing selected pages.", new Object[0]);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ HashSet<Integer> b;

        public j(HashSet<Integer> hashSet) {
            this.b = hashSet;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            ((List) obj).getClass();
            ThumbnailGridRecyclerView thumbnailGridRecyclerView = hd.this.d;
            HashSet<Integer> hashSet = this.b;
            thumbnailGridRecyclerView.getClass();
            Iterator<Integer> it = hashSet.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                l60 l60Var = thumbnailGridRecyclerView.f;
                if (l60Var != null) {
                    l60Var.notifyItemChanged(iIntValue);
                }
            }
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            Bundle bundle = new Bundle();
            bundle.putString(Analytics.Data.ACTION, "rotate_selected_pages");
            bundle.putString("value", u40.a(",", u40.a(this.b)));
            i0VarA.a(Analytics.Event.PERFORM_DOCUMENT_EDITOR_ACTION, bundle);
        }
    }

    public static final class k<T> implements Consumer {
        public static final k<T> a = new k<>();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Throwable th = (Throwable) obj;
            th.getClass();
            PdfLog.e("Nutri.DocEdiSavTBarHand", th, "Error rotating selected pages.", new Object[0]);
        }
    }

    public static final class l<T, R> implements Function {
        public final /* synthetic */ Context a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ PdfDocumentEditor c;
        public final /* synthetic */ HashSet<Integer> d;

        public l(Context context, boolean z, PdfDocumentEditor pdfDocumentEditor, HashSet<Integer> hashSet) {
            this.a = context;
            this.b = z;
            this.c = pdfDocumentEditor;
            this.d = hashSet;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public final Object apply(Object obj) {
            Uri uri = (Uri) obj;
            uri.getClass();
            try {
                wg.a(this.a, true, Arrays.asList(uri));
                OutputStream outputStreamOpenOutputStream = MAMContentResolverManagement.openOutputStream(this.a.getContentResolver(), uri, "w");
                if (outputStreamOpenOutputStream == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                boolean z = this.b;
                PdfDocumentEditor pdfDocumentEditor = this.c;
                Context context = this.a;
                if (z) {
                    Maybe<T> maybeAndThen = pdfDocumentEditor.saveDocument(context, outputStreamOpenOutputStream, null).andThen(Maybe.just(uri));
                    maybeAndThen.getClass();
                    return maybeAndThen;
                }
                Maybe<T> maybeAndThen2 = pdfDocumentEditor.exportPages(context, outputStreamOpenOutputStream, this.d, null).andThen(Maybe.just(uri));
                maybeAndThen2.getClass();
                return maybeAndThen2;
            } catch (FileNotFoundException e) {
                PdfLog.e("Nutri.DocEdiSavTBarHand", "File not found", e);
                return Maybe.error(e);
            }
        }
    }

    public static final class m extends y20<Uri> {
        public final /* synthetic */ DocumentEditorProgressDialog a;
        public final /* synthetic */ hd b;
        public final /* synthetic */ Context c;

        public m(DocumentEditorProgressDialog documentEditorProgressDialog, hd hdVar, Context context) {
            this.a = documentEditorProgressDialog;
            this.b = hdVar;
            this.c = context;
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public final void onComplete() {
            this.a.dismiss();
            PdfLog.d("Nutri.DocEdiSavTBarHand", "Document saving was canceled.", new Object[0]);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public final void onError(Throwable th) {
            th.getClass();
            this.a.showErrorDialog(this.c, R.string.pspdf__document_could_not_be_saved);
            PdfLog.e("Nutri.DocEdiSavTBarHand", th, "Document couldn't be saved.", new Object[0]);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver
        public final void onSuccess(Object obj) {
            Uri uri = (Uri) obj;
            uri.getClass();
            this.a.dismiss();
            this.b.a.onDocumentExported(uri);
        }
    }

    public hd(PdfThumbnailGrid pdfThumbnailGrid, gd gdVar, PdfThumbnailGrid pdfThumbnailGrid2, ThumbnailGridRecyclerView thumbnailGridRecyclerView) {
        gdVar.getClass();
        thumbnailGridRecyclerView.getClass();
        this.a = pdfThumbnailGrid;
        this.b = gdVar;
        this.c = pdfThumbnailGrid2;
        this.d = thumbnailGridRecyclerView;
        this.e = true;
        this.f = true;
    }

    public final void a(final Context context, final PdfDocumentEditor pdfDocumentEditor, final HashSet<Integer> hashSet, final FilePicker filePicker) {
        a(context, hashSet, new Runnable() { // from class: com.pspdfkit.internal.hd$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                hd.a(this.f$0, context, pdfDocumentEditor, hashSet, filePicker);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final void duplicateSelectedPages() {
        HashSet<Integer> selectedPages = this.d.getSelectedPages();
        selectedPages.getClass();
        HashSet hashSet = CollectionsKt.toHashSet(selectedPages);
        this.b.duplicatePages(hashSet).blockingSubscribe(new b(hashSet), c.a);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.base.SpecialModeController
    public final void exitActiveMode() {
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this.c);
        if (lifecycleOwner != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new d(null), 3, null);
        } else {
            this.c.exitDocumentEditingMode();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final void exportSelectedPages(Context context) {
        context.getClass();
        HashSet<Integer> selectedPages = this.d.getSelectedPages();
        selectedPages.getClass();
        HashSet<Integer> hashSet = CollectionsKt.toHashSet(selectedPages);
        gd gdVar = this.b;
        FilePicker filePicker = this.c.getFilePicker();
        filePicker.getClass();
        a(context, gdVar, hashSet, filePicker);
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Analytics.Data.ACTION, "export_selected_pages");
        bundle.putString("value", u40.a(",", u40.a(hashSet)));
        i0VarA.a(Analytics.Event.PERFORM_DOCUMENT_EDITOR_ACTION, bundle);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final DocumentEditingManager getDocumentEditingManager() {
        DocumentEditingManager documentEditingManager = this.c.getDocumentEditingManager();
        documentEditingManager.getClass();
        return documentEditingManager;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final Set<Integer> getSelectedPages() {
        HashSet<Integer> selectedPages = this.d.getSelectedPages();
        selectedPages.getClass();
        return selectedPages;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.base.ThumbnailGridSpecialModeController
    public final PdfThumbnailGrid getThumbnailGrid() {
        return this.c;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final void importDocument(Context context) {
        context.getClass();
        HashSet<Integer> selectedPages = this.d.getSelectedPages();
        selectedPages.getClass();
        HashSet hashSet = CollectionsKt.toHashSet(selectedPages);
        Object objValueOf = Integer.valueOf(this.b.a(true).getPageCount());
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            objValueOf = it.next();
            while (it.hasNext()) {
                objValueOf = it.next();
            }
        }
        objValueOf.getClass();
        int iIntValue = ((Number) objValueOf).intValue();
        Maybe<Uri> destinationUri = this.c.getFilePicker().getDestinationUri("android.intent.action.OPEN_DOCUMENT");
        destinationUri.getClass();
        Maybe<R> maybeFlatMap = destinationUri.flatMap(new e(context, iIntValue));
        lm lmVar = this.b.b;
        lmVar.getClass();
        bx bxVar = lmVar.a.a;
        bxVar.getClass();
        maybeFlatMap.subscribeOn(bxVar.new a(5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(iIntValue));
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final boolean isDocumentEmpty() {
        return this.b.a(true).getPageCount() == 0;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final boolean isExportEnabled() {
        return this.f;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final boolean isRedoEnabled() {
        return this.b.a(true).canRedo();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final boolean isSaveAsEnabled() {
        return this.e;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final boolean isUndoEnabled() {
        return this.b.a(true).canUndo();
    }

    @Override // com.pspdfkit.document.editor.page.NewPageFactory.OnNewPageReadyListener
    public final void onCancelled() {
    }

    @Override // com.pspdfkit.document.editor.page.NewPageFactory.OnNewPageReadyListener
    public final void onNewPageReady(NewPage newPage) {
        newPage.getClass();
        List<EditingChange> listBlockingGet = this.b.addPage(0, newPage).blockingGet();
        listBlockingGet.getClass();
        a(listBlockingGet, false);
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Analytics.Data.ACTION, "insert_new_page");
        i0VarA.a(Analytics.Event.PERFORM_DOCUMENT_EDITOR_ACTION, bundle);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final void performSaving(Context context, View view) {
        context.getClass();
        view.getClass();
        gd gdVar = this.b;
        if (this.e) {
            FilePicker filePicker = this.c.getFilePicker();
            filePicker.getClass();
            a(context, gdVar, view, filePicker);
        } else if (gdVar.b.A.get(0).getFileUri() != null) {
            DocumentEditorProgressDialog documentEditorProgressDialog = new DocumentEditorProgressDialog();
            documentEditorProgressDialog.showIndeterminateProgressDialog(context, R.string.pspdf__saving);
            Completable completableSaveDocument = gdVar.saveDocument(context, null);
            PdfDocument document = gdVar.getDocument();
            document.getClass();
            bx bxVar = ((lm) document).a.a;
            bxVar.getClass();
            completableSaveDocument.subscribeOn(bxVar.new a(5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new id(documentEditorProgressDialog, this, context));
        }
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Analytics.Data.ACTION, "save_document");
        i0VarA.a(Analytics.Event.PERFORM_DOCUMENT_EDITOR_ACTION, bundle);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final List<EditingChange> redo() {
        List<EditingChange> listRedo = this.b.redo();
        a(listRedo, false);
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Analytics.Data.ACTION, "redo");
        i0VarA.a(Analytics.Event.PERFORM_DOCUMENT_EDITOR_ACTION, bundle);
        return listRedo;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final void removeSelectedPages() {
        HashSet<Integer> selectedPages = this.d.getSelectedPages();
        selectedPages.getClass();
        HashSet hashSet = CollectionsKt.toHashSet(selectedPages);
        this.b.removePages(hashSet).blockingSubscribe(new h(hashSet), i.a);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final void rotateSelectedPages() {
        HashSet<Integer> selectedPages = this.d.getSelectedPages();
        selectedPages.getClass();
        HashSet hashSet = CollectionsKt.toHashSet(selectedPages);
        this.b.rotatePages(hashSet, 90).blockingSubscribe(new j(hashSet), k.a);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final void setSelectedPages(Set<Integer> set) {
        set.getClass();
        this.d.setSelectedPages(set);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.DocumentEditingController
    public final List<EditingChange> undo() {
        List<EditingChange> listUndo = this.b.undo();
        a(listUndo, true);
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Analytics.Data.ACTION, "undo");
        i0VarA.a(Analytics.Event.PERFORM_DOCUMENT_EDITOR_ACTION, bundle);
        return listUndo;
    }

    public static final void a(hd hdVar, Context context, PdfDocumentEditor pdfDocumentEditor, HashSet hashSet, FilePicker filePicker) {
        hdVar.getClass();
        String strA = null;
        try {
            Uri fileUri = pdfDocumentEditor.getDocument().getDocumentSource().getFileUri();
            if (fileUri != null) {
                strA = wg.a(fileUri, true);
            }
        } catch (Exception e2) {
            PdfLog.e("Nutri.DocEdiSavTBarHand", "Could not extract filename from Uri", e2);
        }
        Maybe<Uri> destinationUri = filePicker.getDestinationUri("android.intent.action.CREATE_DOCUMENT", strA);
        destinationUri.getClass();
        hdVar.a(context, pdfDocumentEditor, (HashSet<Integer>) hashSet, destinationUri);
    }

    public final void a(final Context context, final PdfDocumentEditor pdfDocumentEditor, View view, final FilePicker filePicker) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.pspdfkit.internal.hd$$ExternalSyntheticLambda0
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return hd.a(this.f$0, context, pdfDocumentEditor, filePicker, menuItem);
            }
        });
        popupMenu.inflate(R.menu.pspdf__menu_document_editor_save);
        if (!pdfDocumentEditor.getDocument().isWritableAndCanSave()) {
            popupMenu.getMenu().removeItem(R.id.pspdf__menu_document_editor_save);
        }
        popupMenu.show();
    }

    public static final boolean a(final hd hdVar, final Context context, final PdfDocumentEditor pdfDocumentEditor, final FilePicker filePicker, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.pspdf__menu_document_editor_save) {
            hdVar.getClass();
            DocumentEditorProgressDialog documentEditorProgressDialog = new DocumentEditorProgressDialog();
            documentEditorProgressDialog.showIndeterminateProgressDialog(context, R.string.pspdf__saving);
            Completable completableSaveDocument = pdfDocumentEditor.saveDocument(context, null);
            PdfDocument document = pdfDocumentEditor.getDocument();
            document.getClass();
            bx bxVar = ((lm) document).a.a;
            bxVar.getClass();
            completableSaveDocument.subscribeOn(bxVar.new a(5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new id(documentEditorProgressDialog, hdVar, context));
            return false;
        }
        if (itemId != R.id.pspdf__menu_document_editor_save_as) {
            return false;
        }
        hdVar.a(context, null, new Runnable() { // from class: com.pspdfkit.internal.hd$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                hd.a(this.f$0, context, pdfDocumentEditor, filePicker);
            }
        });
        return false;
    }

    public static final void a(hd hdVar, Context context, PdfDocumentEditor pdfDocumentEditor, FilePicker filePicker) {
        String strA;
        hdVar.getClass();
        try {
            Uri fileUri = pdfDocumentEditor.getDocument().getDocumentSource().getFileUri();
            strA = fileUri != null ? wg.a(fileUri, true) : null;
        } catch (Exception e2) {
            PdfLog.e("Nutri.DocEdiSavTBarHand", "Could not extract filename from Uri", e2);
        }
        Maybe<Uri> destinationUri = filePicker.getDestinationUri("android.intent.action.CREATE_DOCUMENT", strA);
        destinationUri.getClass();
        hdVar.a(context, pdfDocumentEditor, (HashSet<Integer>) null, destinationUri);
    }

    public final void a(Context context, PdfDocumentEditor pdfDocumentEditor, HashSet<Integer> hashSet, Maybe<Uri> maybe) {
        DocumentEditorProgressDialog documentEditorProgressDialog = new DocumentEditorProgressDialog();
        boolean z = hashSet == null || hashSet.isEmpty();
        documentEditorProgressDialog.showIndeterminateProgressDialog(context, z ? R.string.pspdf__saving : R.string.pspdf__exporting);
        Maybe<R> maybeFlatMap = maybe.flatMap(new l(context, z, pdfDocumentEditor, hashSet));
        PdfDocument document = pdfDocumentEditor.getDocument();
        document.getClass();
        bx bxVar = ((lm) document).a.a;
        bxVar.getClass();
        maybeFlatMap.subscribeOn(bxVar.new a(5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(documentEditorProgressDialog, this, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Context context, HashSet<Integer> hashSet, Runnable runnable) {
        LifecycleCoroutineScope lifecycleCoroutineScope;
        if (!ar.b().a(NativeLicenseFeatures.REDACTION)) {
            runnable.run();
            return;
        }
        DocumentEditorProgressDialog documentEditorProgressDialog = new DocumentEditorProgressDialog();
        documentEditorProgressDialog.showIndeterminateProgressDialog(context, (hashSet == null || hashSet.isEmpty()) ? R.string.pspdf__saving : R.string.pspdf__exporting);
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this.c);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            LifecycleOwner lifecycleOwner2 = context instanceof LifecycleOwner ? (LifecycleOwner) context : null;
            if (lifecycleOwner2 != null) {
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner2);
                lifecycleCoroutineScope = lifecycleScope;
            } else {
                lifecycleCoroutineScope = null;
            }
        } else {
            lifecycleCoroutineScope = lifecycleScope;
        }
        if (lifecycleCoroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleCoroutineScope, null, null, new a(hashSet, context, runnable, documentEditorProgressDialog, null), 3, null);
        } else {
            documentEditorProgressDialog.dismiss();
            runnable.run();
        }
    }

    public final void a(List<EditingChange> list, boolean z) {
        LifecycleCoroutineScope lifecycleScope;
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this.c);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, Dispatchers.getMain(), null, new g(list, this, z, null), 2, null);
    }
}
