package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.pspdfkit.R;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.theming.ThemeMode;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.PdfDocumentLoader;
import com.pspdfkit.document.image.BitmapUtils;
import com.pspdfkit.document.processor.ComparisonDialogListener;
import com.pspdfkit.document.processor.ComparisonDocument;
import com.pspdfkit.internal.jni.NativeComparisonUtilities;
import com.pspdfkit.internal.ui.comparison.ComparisonDocumentTitlesView;
import com.pspdfkit.internal.ui.stepper.StepperView;
import com.pspdfkit.listeners.InternalDocumentListener;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.utils.BundleExtensions;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/bd;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class bd extends DialogFragment {
    public static final /* synthetic */ int o = 0;
    public ArrayList a;
    public PdfFragment b;
    public int c;
    public int d;
    public StepperView e;
    public ComparisonDocumentTitlesView f;
    public ComparisonDialogListener g;
    public ArrayList<ComparisonDocument> h = new ArrayList<>();
    public final ArrayList<ArrayList<PointF>> i = CollectionsKt.arrayListOf(new ArrayList(), new ArrayList());
    public PdfActivityConfiguration j;
    public Toolbar k;
    public Disposable l;
    public ProgressBar m;
    public ImageView n;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ThemeMode.values().length];
            try {
                iArr[ThemeMode.NIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    public static final class b<T> implements Consumer {
        public b() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Uri uri = (Uri) ((Triple) obj).component3();
            Context context = bd.this.getContext();
            if (context == null) {
                return;
            }
            PdfDocumentLoader.openDocument(context, uri).invalidateCache();
        }
    }

    public static final class c<T> implements Consumer {
        public c() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Throwable th = (Throwable) obj;
            th.getClass();
            ComparisonDialogListener comparisonDialogListener = bd.this.g;
            if (comparisonDialogListener != null) {
                comparisonDialogListener.onError(new IllegalStateException("Error while comparing documents.", th));
            }
        }
    }

    public static final class d<T> implements Consumer {
        public d() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Uri uri = (Uri) ((Triple) obj).component3();
            ComparisonDialogListener comparisonDialogListener = bd.this.g;
            if (comparisonDialogListener != null) {
                comparisonDialogListener.onComparisonSuccessful(new DocumentSource(uri));
            }
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ int b;

        public e(int i) {
            this.b = i;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable th) {
            th.getClass();
            ComparisonDialogListener comparisonDialogListener = bd.this.g;
            if (comparisonDialogListener != null) {
                comparisonDialogListener.onError(new IllegalStateException("Error while preparing the document with index " + this.b + " for comparison.", th));
            }
            bd.this.dismiss();
        }
    }

    public static final class f<T> implements Consumer {
        public f() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Uri uri = (Uri) obj;
            bd bdVar = bd.this;
            PdfActivityConfiguration pdfActivityConfiguration = bdVar.j;
            PdfFragment pdfFragment = null;
            if (pdfActivityConfiguration == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configuration");
                pdfActivityConfiguration = null;
            }
            PdfFragment pdfFragmentNewInstance = PdfFragment.newInstance(uri, pdfActivityConfiguration.getConfiguration());
            pdfFragmentNewInstance.getClass();
            bdVar.b = pdfFragmentNewInstance;
            FragmentTransaction fragmentTransactionBeginTransaction = bd.this.getChildFragmentManager().beginTransaction();
            int i = R.id.pspdf__comparison_fragment_frame;
            PdfFragment pdfFragment2 = bd.this.b;
            if (pdfFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pdfFragment");
            } else {
                pdfFragment = pdfFragment2;
            }
            fragmentTransactionBeginTransaction.replace(i, pdfFragment, "com.pspdfkit.ui.PdfFragment").commit();
        }
    }

    public static final class g implements InternalDocumentListener {
        public g() {
        }

        @Override // com.pspdfkit.listeners.DocumentListener
        public final void onDocumentLoaded(PdfDocument pdfDocument) {
            pdfDocument.getClass();
            bd bdVar = bd.this;
            ArrayList<PointF> arrayList = bdVar.i.get(bdVar.d);
            arrayList.getClass();
            bd bdVar2 = bd.this;
            int i = 0;
            for (Object obj : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                bdVar2.a((PointF) obj, i);
                StepperView stepperView = bdVar2.e;
                if (stepperView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stepperView");
                    stepperView = null;
                }
                if (i2 < 0) {
                    stepperView.getClass();
                } else if (stepperView.m != 0) {
                    stepperView.r = i2;
                    stepperView.invalidate();
                }
                i = i2;
            }
            super.onDocumentLoaded(pdfDocument);
        }
    }

    public static final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        view.getClass();
        windowInsetsCompat.getClass();
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        insets.getClass();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = insets.top;
        marginLayoutParams.bottomMargin = insets.bottom;
        view.setLayoutParams(marginLayoutParams);
        return WindowInsetsCompat.CONSUMED;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(bd bdVar, View view) {
        ImageView imageView = bdVar.n;
        if (imageView == null) {
            return;
        }
        ComparisonDocument comparisonDocument = bdVar.h.get(bdVar.d);
        comparisonDocument.getClass();
        ComparisonDocument comparisonDocument2 = comparisonDocument;
        RectF rectF = new RectF();
        PdfFragment pdfFragment = bdVar.b;
        ComparisonDocumentTitlesView comparisonDocumentTitlesView = null;
        StepperView stepperView = null;
        if (pdfFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pdfFragment");
            pdfFragment = null;
        }
        if (pdfFragment.getVisiblePdfRect(rectF, comparisonDocument2.getPageIndex())) {
            PointF pointF = new PointF(imageView.getX() + (imageView.getWidth() / 2), imageView.getY() + (imageView.getHeight() / 2));
            PdfFragment pdfFragment2 = bdVar.b;
            if (pdfFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pdfFragment");
                pdfFragment2 = null;
            }
            pdfFragment2.getViewProjection().toPdfPoint(pointF, comparisonDocument2.getPageIndex());
            float f2 = pointF.x;
            Object[] objArr = f2 >= rectF.left && f2 <= rectF.right;
            float f3 = pointF.y;
            Object[] objArr2 = f3 <= rectF.top && f3 >= rectF.bottom;
            if (objArr == true && objArr2 == true) {
                bdVar.i.get(bdVar.d).add(bdVar.c, pointF);
                bdVar.a(pointF, bdVar.c);
                int i = bdVar.c + 1;
                bdVar.c = i;
                if (i <= 2) {
                    StepperView stepperView2 = bdVar.e;
                    if (stepperView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stepperView");
                    } else {
                        stepperView = stepperView2;
                    }
                    int i2 = bdVar.c;
                    if (i2 < 0) {
                        stepperView.getClass();
                        return;
                    } else {
                        if (stepperView.m == 0) {
                            return;
                        }
                        stepperView.r = i2;
                        stepperView.invalidate();
                        return;
                    }
                }
                if (bdVar.d != 0) {
                    bdVar.b();
                    return;
                }
                bdVar.c = 0;
                StepperView stepperView3 = bdVar.e;
                if (stepperView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stepperView");
                    stepperView3 = null;
                }
                int i3 = bdVar.c;
                if (i3 < 0) {
                    stepperView3.getClass();
                } else if (stepperView3.m != 0) {
                    stepperView3.r = i3;
                    stepperView3.invalidate();
                }
                int i4 = bdVar.d + 1;
                bdVar.d = i4;
                bdVar.a(i4);
                int i5 = bdVar.d;
                if (i5 == 0 || i5 == 1) {
                    ComparisonDocumentTitlesView comparisonDocumentTitlesView2 = bdVar.f;
                    if (comparisonDocumentTitlesView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("comparisonDocumentTitlesView");
                    } else {
                        comparisonDocumentTitlesView = comparisonDocumentTitlesView2;
                    }
                    comparisonDocumentTitlesView.setCurrentDocument(bdVar.d);
                }
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle arguments = getArguments();
            if (arguments == null) {
                throw new IllegalStateException("No arguments were supplied.");
            }
            ArrayList<ComparisonDocument> supportParcelableArrayList = BundleExtensions.getSupportParcelableArrayList(arguments, "comparison_documents_list_argument", ComparisonDocument.class);
            if (supportParcelableArrayList == null) {
                throw new IllegalStateException("No documents were provided.");
            }
            this.h = supportParcelableArrayList;
            PdfActivityConfiguration pdfActivityConfiguration = (PdfActivityConfiguration) BundleExtensions.getSupportParcelable(arguments, "pdf_configuration_argument", PdfActivityConfiguration.class);
            if (pdfActivityConfiguration == null) {
                throw new IllegalStateException("No PdfActivityConfiguration was provided.");
            }
            this.j = pdfActivityConfiguration;
            String string = arguments.getString("output_file_argument");
            if (string == null) {
                throw new IllegalStateException("No output file path was provided.");
            }
            new File(string);
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i < 4; i++) {
                arrayList.add(getString(R.string.pspdf__point_selection_step, Integer.valueOf(i)));
            }
            this.a = arrayList;
            if (bundle != null) {
                this.c = bundle.getInt("selected_point_index");
                this.d = bundle.getInt("current_documentIndex");
                ArrayList<ArrayList<PointF>> arrayList2 = this.i;
                ArrayList<PointF> supportParcelableArrayList2 = BundleExtensions.getSupportParcelableArrayList(bundle, "old_selected_points", PointF.class);
                if (supportParcelableArrayList2 == null) {
                    supportParcelableArrayList2 = new ArrayList<>();
                }
                arrayList2.set(0, supportParcelableArrayList2);
                ArrayList<ArrayList<PointF>> arrayList3 = this.i;
                ArrayList<PointF> supportParcelableArrayList3 = BundleExtensions.getSupportParcelableArrayList(bundle, "new_selected_points", PointF.class);
                if (supportParcelableArrayList3 == null) {
                    supportParcelableArrayList3 = new ArrayList<>();
                }
                arrayList3.set(1, supportParcelableArrayList3);
            }
        } catch (Exception e2) {
            throw new IllegalStateException("Error while creating DocumentComparisonDialog. Make sure to show the dialog by calling DocumentComparisonDialog.show(...) rather than creating the dialog manually.", e2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int theme;
        layoutInflater.getClass();
        PdfActivityConfiguration pdfActivityConfiguration = this.j;
        PdfActivityConfiguration pdfActivityConfiguration2 = null;
        if (pdfActivityConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configuration");
            pdfActivityConfiguration = null;
        }
        int i = a.a[pdfActivityConfiguration.getConfiguration().getThemeMode().ordinal()];
        PdfActivityConfiguration pdfActivityConfiguration3 = this.j;
        if (i == 1) {
            if (pdfActivityConfiguration3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configuration");
            } else {
                pdfActivityConfiguration2 = pdfActivityConfiguration3;
            }
            theme = pdfActivityConfiguration2.getDarkTheme();
        } else {
            if (pdfActivityConfiguration3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configuration");
            } else {
                pdfActivityConfiguration2 = pdfActivityConfiguration3;
            }
            theme = pdfActivityConfiguration2.getTheme();
        }
        View viewInflate = LayoutInflater.from(new ContextThemeWrapper(getContext(), theme)).inflate(R.layout.pspdf__compare_documents_dialog, viewGroup, false);
        ViewCompat.setOnApplyWindowInsetsListener(viewInflate, new OnApplyWindowInsetsListener() { // from class: com.pspdfkit.internal.bd$$ExternalSyntheticLambda7
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return bd.a(view, windowInsetsCompat);
            }
        });
        viewInflate.getClass();
        a(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        yz.a(this.l);
        this.g = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("old_selected_points", this.i.get(0));
        bundle.putParcelableArrayList("new_selected_points", this.i.get(1));
        bundle.putInt("current_documentIndex", this.d);
        bundle.putInt("selected_point_index", this.c);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            a(this.d);
            return;
        }
        ComparisonDocumentTitlesView comparisonDocumentTitlesView = this.f;
        if (comparisonDocumentTitlesView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("comparisonDocumentTitlesView");
            comparisonDocumentTitlesView = null;
        }
        comparisonDocumentTitlesView.setCurrentDocument(this.d);
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("com.pspdfkit.ui.PdfFragment");
        fragmentFindFragmentByTag.getClass();
        PdfFragment pdfFragment = (PdfFragment) fragmentFindFragmentByTag;
        this.b = pdfFragment;
        pdfFragment.addDocumentListener(new g());
    }

    public final void b() {
        try {
            List listReversed = CollectionsKt.reversed(CollectionsKt.flatten(this.i));
            listReversed.getClass();
            ArrayList arrayList = new ArrayList(listReversed);
            Matrix matrixCalculateMatrixFromPoints = NativeComparisonUtilities.calculateMatrixFromPoints(arrayList);
            if (matrixCalculateMatrixFromPoints != null) {
                ComparisonDocument comparisonDocument = this.h.get(0);
                comparisonDocument.getClass();
                ComparisonDocument comparisonDocument2 = this.h.get(1);
                comparisonDocument2.getClass();
                a(matrixCalculateMatrixFromPoints, comparisonDocument, comparisonDocument2);
                return;
            }
            throw new IllegalStateException(("Failed to create a matrix for aligning documents using points: " + CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1() { // from class: com.pspdfkit.internal.bd$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return bd.a((PointF) obj);
                }
            }, 31, null)).toString());
        } catch (Exception e2) {
            ComparisonDialogListener comparisonDialogListener = this.g;
            if (comparisonDialogListener != null) {
                comparisonDialogListener.onError(new IllegalStateException(e2.getMessage()));
            }
            dismiss();
        }
    }

    public static final void b(bd bdVar) {
        bdVar.a(false);
    }

    public final void a(View view) {
        this.m = (ProgressBar) view.findViewById(R.id.pspdf__align_progressbar);
        this.n = (ImageView) view.findViewById(R.id.pspdf__cross_hair_target);
        View viewFindViewById = view.findViewById(R.id.pspdf__comparison_dialog_toolbar);
        viewFindViewById.getClass();
        Toolbar toolbar = (Toolbar) viewFindViewById;
        this.k = toolbar;
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.bd$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bd.a(this.f$0, view2);
            }
        });
        Toolbar toolbar2 = this.k;
        StepperView stepperView = null;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            toolbar2 = null;
        }
        toolbar2.setTitle(getString(R.string.pspdf__align_documents));
        View viewFindViewById2 = view.findViewById(R.id.pspdf__select_point_fab);
        viewFindViewById2.getClass();
        ((ExtendedFloatingActionButton) viewFindViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.bd$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bd.b(this.f$0, view2);
            }
        });
        View viewFindViewById3 = view.findViewById(R.id.pspdf__pointSelectionStepperView);
        viewFindViewById3.getClass();
        StepperView stepperView2 = (StepperView) viewFindViewById3;
        this.e = stepperView2;
        ArrayList arrayList = this.a;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointSelectionSteps");
            arrayList = null;
        }
        stepperView2.setSteps(arrayList);
        StepperView stepperView3 = this.e;
        if (stepperView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepperView");
        } else {
            stepperView = stepperView3;
        }
        int i = this.c;
        if (i >= 0) {
            if (stepperView.m != 0) {
                stepperView.r = i;
                stepperView.invalidate();
            }
        } else {
            stepperView.getClass();
        }
        View viewFindViewById4 = view.findViewById(R.id.pspdf__comparison_breadcrumbs);
        viewFindViewById4.getClass();
        this.f = (ComparisonDocumentTitlesView) viewFindViewById4;
        final PSPDFKitPreferences pSPDFKitPreferences = PSPDFKitPreferences.get(requireContext());
        pSPDFKitPreferences.getClass();
        final CardView cardView = (CardView) view.findViewById(R.id.pspdf__comparison_hint_text_card);
        cardView.getClass();
        Boolean boolIsComparisonFirstLaunch = PSPDFKitPreferences.get(requireContext()).isComparisonFirstLaunch();
        boolIsComparisonFirstLaunch.getClass();
        cardView.setVisibility(boolIsComparisonFirstLaunch.booleanValue() ? 0 : 8);
        ((Button) view.findViewById(R.id.pspdf__comparison_hint_dismiss)).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.bd$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bd.a(cardView, pSPDFKitPreferences, view2);
            }
        });
    }

    public static final void a(bd bdVar, View view) {
        bdVar.dismiss();
    }

    public static final void a(CardView cardView, PSPDFKitPreferences pSPDFKitPreferences, View view) {
        cardView.setVisibility(8);
        pSPDFKitPreferences.setIsComparisonFirstLaunch(false);
    }

    public static final CharSequence a(PointF pointF) {
        pointF.getClass();
        String string = pointF.toString();
        string.getClass();
        return string;
    }

    public final void a(final int i) {
        a(true);
        ComparisonDocument comparisonDocument = this.h.get(i);
        comparisonDocument.getClass();
        ComparisonDocument comparisonDocument2 = comparisonDocument;
        final ComparisonDocument comparisonDocument3 = new ComparisonDocument(comparisonDocument2.getDocumentSource(), comparisonDocument2.getPageIndex(), -16777216);
        this.l = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.bd$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return bd.a(this.f$0, comparisonDocument3, i);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnError(new e(i)).doOnSuccess(new f()).doFinally(new Action() { // from class: com.pspdfkit.internal.bd$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                bd.b(this.f$0);
            }
        }).subscribe();
    }

    public static final Uri a(bd bdVar, ComparisonDocument comparisonDocument, int i) {
        Context contextRequireContext = bdVar.requireContext();
        contextRequireContext.getClass();
        return ad.a(contextRequireContext, comparisonDocument, "document_" + i);
    }

    public final void a(PointF pointF, int i) {
        int i2;
        if (i == 0) {
            i2 = R.drawable.pspdf__point_selection_1;
        } else if (i == 1) {
            i2 = R.drawable.pspdf__point_selection_2;
        } else if (i != 2) {
            i2 = R.drawable.pspdf__point_selection_1;
        } else {
            i2 = R.drawable.pspdf__point_selection_3;
        }
        Bitmap bitmapFromDrawable = BitmapUtils.fromDrawable(requireContext(), i2);
        bitmapFromDrawable.getClass();
        float f2 = pointF.x;
        float f3 = pointF.y;
        StampAnnotation stampAnnotation = new StampAnnotation(this.h.get(this.d).getPageIndex(), new RectF(f2 - 15.0f, f3 + 15.0f, f2 + 15.0f, f3 - 15.0f), bitmapFromDrawable);
        stampAnnotation.setAlpha(0.7f);
        PdfFragment pdfFragment = this.b;
        if (pdfFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pdfFragment");
            pdfFragment = null;
        }
        pdfFragment.addAnnotationToPage(stampAnnotation, false);
    }

    public final void a(final Matrix matrix, final ComparisonDocument comparisonDocument, final ComparisonDocument comparisonDocument2) {
        a(true);
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.bd$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return bd.a(this.f$0, comparisonDocument, comparisonDocument2, matrix);
            }
        });
        singleFromCallable.getClass();
        this.l = singleFromCallable.subscribeOn(Schedulers.io()).doOnSuccess(new b()).observeOn(AndroidSchedulers.mainThread()).doOnError(new c()).doOnSuccess(new d()).doFinally(new Action() { // from class: com.pspdfkit.internal.bd$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                bd.a(this.f$0);
            }
        }).subscribe();
    }

    public static final Triple a(bd bdVar, ComparisonDocument comparisonDocument, ComparisonDocument comparisonDocument2, Matrix matrix) throws IOException {
        Context contextRequireContext = bdVar.requireContext();
        contextRequireContext.getClass();
        Uri uriA = ad.a(contextRequireContext, comparisonDocument, "temp_old");
        Context contextRequireContext2 = bdVar.requireContext();
        contextRequireContext2.getClass();
        Uri uriA2 = ad.a(contextRequireContext2, comparisonDocument2, "temp_new");
        Context contextRequireContext3 = bdVar.requireContext();
        contextRequireContext3.getClass();
        int pageIndex = comparisonDocument.getPageIndex();
        int pageIndex2 = comparisonDocument2.getPageIndex();
        String string = bdVar.getString(R.string.pspdf__document_comparison);
        string.getClass();
        return new Triple(uriA, uriA2, ad.a(contextRequireContext3, uriA, pageIndex, uriA2, pageIndex2, string, matrix, BlendMode.DARKEN));
    }

    public static final void a(bd bdVar) {
        bdVar.a();
        bdVar.a(false);
        bdVar.dismiss();
    }

    public final void a(boolean z) {
        ProgressBar progressBar = this.m;
        if (progressBar != null) {
            progressBar.setVisibility(z ? 0 : 8);
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(z ? 8 : 0);
        }
    }

    public final void a() {
        ArrayList<ComparisonDocument> arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            arrayList.get(i);
            i++;
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            a(contextRequireContext, "document_" + i2);
            i2 = i3;
        }
        Context contextRequireContext2 = requireContext();
        contextRequireContext2.getClass();
        a(contextRequireContext2, "temp_new");
        Context contextRequireContext3 = requireContext();
        contextRequireContext3.getClass();
        a(contextRequireContext3, "temp_old");
    }

    public static void a(Context context, String str) {
        File file = new File(context.getFilesDir(), str + ".pdf");
        if (file.exists()) {
            file.delete();
        }
    }
}
