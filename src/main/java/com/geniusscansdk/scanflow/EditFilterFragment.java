package com.geniusscansdk.scanflow;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.BundleCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.data.api.models.annotations.Location;
import com.facebook.react.uimanager.ViewProps;
import com.geniusscansdk.R;
import com.google.android.material.button.MaterialButton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: EditFilterFragment.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001d\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\"J\u0018\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u00060\fR\u00020\u00000\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006("}, d2 = {"Lcom/geniusscansdk/scanflow/EditFilterFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "filters", "", "Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;", "pageProcessor", "Lcom/geniusscansdk/scanflow/PageProcessor;", "filterLayout", "Landroid/widget/LinearLayout;", "filterViewHolderList", "Lcom/geniusscansdk/scanflow/EditFilterFragment$FilterViewHolder;", "validateButton", "Lcom/google/android/material/button/MaterialButton;", "imageViewSize", "", "Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "applyCustomStyle", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "updateWithPage", Location.TYPE_PAGE, "Lcom/geniusscansdk/scanflow/Page;", "updateWithPage$gssdk_release", "isOptionSelected", "", ViewProps.FILTER, "FilterViewHolder", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditFilterFragment extends Fragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EDIT_FILTER_REQUEST_KEY = "EDIT_FILTER_REQUEST";
    public static final String ON_FILTER_CHANGED_KEY = "ON_FILTER_CHANGED";
    public static final String ON_FILTER_VALIDATED_KEY = "ON_FILTER_VALIDATED";
    private LinearLayout filterLayout;
    private List<FilterViewHolder> filterViewHolderList;
    private List<? extends ScanConfiguration.Filter> filters;
    private Integer imageViewSize;
    private PageProcessor pageProcessor;
    private MaterialButton validateButton;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Serializable serializable = BundleCompat.getSerializable(requireArguments(), "scanConfiguration", ScanConfiguration.class);
        Intrinsics.checkNotNull(serializable);
        ScanConfiguration scanConfiguration = (ScanConfiguration) serializable;
        this.filters = scanConfiguration.availableFilters;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.pageProcessor = new PageProcessor(contextRequireContext, scanConfiguration);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.edit_filter_fragment, container, false);
        ((Button) viewInflate.findViewById(R.id.validate_filter_button)).setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.EditFilterFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditFilterFragment.onCreateView$lambda$1(this.f$0, view);
            }
        });
        this.filterLayout = (LinearLayout) viewInflate.findViewById(R.id.filter_linear_layout);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.filter_preview_margin);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.filter_preview_size);
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        List<? extends ScanConfiguration.Filter> list = this.filters;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filters");
            list = null;
        }
        Integer numCalculateItemSize = viewUtils.calculateItemSize(list, dimensionPixelSize2 + dimensionPixelSize, getResources().getDisplayMetrics().widthPixels);
        this.imageViewSize = numCalculateItemSize != null ? Integer.valueOf(numCalculateItemSize.intValue() - dimensionPixelSize) : null;
        List<? extends ScanConfiguration.Filter> list2 = this.filters;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filters");
            list2 = null;
        }
        List<? extends ScanConfiguration.Filter> list3 = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (ScanConfiguration.Filter filter : list3) {
            View viewInflate2 = inflater.inflate(R.layout.filter_item, container, false);
            LinearLayout linearLayout = this.filterLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterLayout");
                linearLayout = null;
            }
            linearLayout.addView(viewInflate2);
            Intrinsics.checkNotNull(viewInflate2);
            arrayList.add(new FilterViewHolder(this, viewInflate2, filter));
        }
        this.filterViewHolderList = arrayList;
        this.validateButton = (MaterialButton) viewInflate.findViewById(R.id.validate_filter_button);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(EditFilterFragment editFilterFragment, View view) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ON_FILTER_VALIDATED_KEY, true);
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(editFilterFragment, EDIT_FILTER_REQUEST_KEY, bundle);
    }

    private final void applyCustomStyle(ScanConfiguration scanConfiguration) {
        MaterialButton materialButton = this.validateButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
            materialButton = null;
        }
        ViewUtils.applyColor(materialButton, scanConfiguration.foregroundColor, scanConfiguration.backgroundColor);
    }

    public final void updateWithPage$gssdk_release(Page page, ScanConfiguration scanConfiguration) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
        applyCustomStyle(scanConfiguration);
        List<FilterViewHolder> list = this.filterViewHolderList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterViewHolderList");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((FilterViewHolder) it.next()).bindData(page, scanConfiguration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: EditFilterFragment.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/geniusscansdk/scanflow/EditFilterFragment$FilterViewHolder;", "", "view", "Landroid/view/View;", ViewProps.FILTER, "Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;", "<init>", "(Lcom/geniusscansdk/scanflow/EditFilterFragment;Landroid/view/View;Lcom/geniusscansdk/scanflow/ScanConfiguration$Filter;)V", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "bindData", "", Location.TYPE_PAGE, "Lcom/geniusscansdk/scanflow/Page;", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "onItemClick", "item", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    final class FilterViewHolder {
        private final ScanConfiguration.Filter filter;
        private final ImageView imageView;
        private final TextView textView;
        final /* synthetic */ EditFilterFragment this$0;
        private final View view;

        public FilterViewHolder(EditFilterFragment editFilterFragment, View view, ScanConfiguration.Filter filter) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(filter, "filter");
            this.this$0 = editFilterFragment;
            this.view = view;
            this.filter = filter;
            View viewFindViewById = view.findViewById(R.id.image_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.imageView = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.text_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.textView = (TextView) viewFindViewById2;
        }

        public final void bindData(Page page, ScanConfiguration scanConfiguration) {
            Intrinsics.checkNotNullParameter(page, "page");
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            this.textView.setText(this.filter.getLabelResId());
            ViewUtils.INSTANCE.applyColor(this.textView, scanConfiguration.foregroundColor, scanConfiguration.backgroundColor);
            this.textView.setSelected(this.this$0.isOptionSelected(page, this.filter));
            this.view.setOnClickListener(null);
            this.view.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.EditFilterFragment$FilterViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditFilterFragment.FilterViewHolder.bindData$lambda$0(this.f$0, view);
                }
            });
            Integer num = this.this$0.imageViewSize;
            if (num != null) {
                int iIntValue = num.intValue();
                this.imageView.setLayoutParams(new LinearLayout.LayoutParams(iIntValue, iIntValue));
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), new EditFilterFragment$FilterViewHolder$bindData$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this.this$0), null, new EditFilterFragment$FilterViewHolder$bindData$3(this.this$0, page, this, null), 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindData$lambda$0(FilterViewHolder filterViewHolder, View view) {
            filterViewHolder.onItemClick(filterViewHolder.filter);
        }

        private final void onItemClick(ScanConfiguration.Filter item) {
            EditFilterFragment editFilterFragment = this.this$0;
            Bundle bundle = new Bundle();
            bundle.putString(EditFilterFragment.ON_FILTER_CHANGED_KEY, item.name());
            Unit unit = Unit.INSTANCE;
            FragmentKt.setFragmentResult(editFilterFragment, EditFilterFragment.EDIT_FILTER_REQUEST_KEY, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isOptionSelected(Page page, ScanConfiguration.Filter filter) {
        return filter == page.getFilter();
    }

    /* JADX INFO: compiled from: EditFilterFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/scanflow/EditFilterFragment$Companion;", "", "<init>", "()V", "EDIT_FILTER_REQUEST_KEY", "", "ON_FILTER_VALIDATED_KEY", "ON_FILTER_CHANGED_KEY", "newInstance", "Lcom/geniusscansdk/scanflow/EditFilterFragment;", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditFilterFragment newInstance(ScanConfiguration scanConfiguration) {
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            Bundle bundle = new Bundle();
            bundle.putSerializable("scanConfiguration", scanConfiguration);
            EditFilterFragment editFilterFragment = new EditFilterFragment();
            editFilterFragment.setArguments(bundle);
            return editFilterFragment;
        }
    }
}
