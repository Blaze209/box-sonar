package com.box.android.capture.documentscanning.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.capture.R;
import com.box.android.common.utilities.RotateTransformation;
import com.box.android.domain.models.ScannedDocumentPage;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.ObjectKey;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannedPagesAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/capture/documentscanning/presentation/adapter/ScannedPagesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/box/android/capture/documentscanning/presentation/adapter/ScannedPagesAdapter$ScannedPageViewHolder;", SupportedFileExtensions.PAGES_EXTENSION, "", "Lcom/box/android/domain/models/ScannedDocumentPage;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "updateItems", "", "newPages", "onBindViewHolder", "holder", ViewProps.POSITION, "ScannedPageViewHolder", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScannedPagesAdapter extends RecyclerView.Adapter<ScannedPageViewHolder> {
    public static final int $stable = 8;
    private List<ScannedDocumentPage> pages;

    public ScannedPagesAdapter(List<ScannedDocumentPage> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.pages = pages;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ScannedPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.scanned_page, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ScannedPageViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.pages.size();
    }

    public final void updateItems(final List<ScannedDocumentPage> newPages) {
        Intrinsics.checkNotNullParameter(newPages, "newPages");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: com.box.android.capture.documentscanning.presentation.adapter.ScannedPagesAdapter$updateItems$diffResult$1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                return Intrinsics.areEqual(((ScannedDocumentPage) this.this$0.pages.get(oldItemPosition)).getId(), newPages.get(newItemPosition).getId());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return this.this$0.pages.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return newPages.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return ((ScannedDocumentPage) this.this$0.pages.get(oldItemPosition)).getVersion() == newPages.get(newItemPosition).getVersion();
            }
        });
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
        diffResultCalculateDiff.dispatchUpdatesTo(this);
        this.pages = newPages;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ScannedPageViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ScannedDocumentPage scannedDocumentPage = this.pages.get(position);
        Glide.with(holder.itemView.getContext()).load(scannedDocumentPage.getEnhancedImagePath()).signature(new ObjectKey(Integer.valueOf(scannedDocumentPage.getVersion()))).fitCenter().transform(new RotateTransformation(holder.itemView.getContext(), scannedDocumentPage.getRotationAngle())).into(holder.getImage());
    }

    /* JADX INFO: compiled from: ScannedPagesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/box/android/capture/documentscanning/presentation/adapter/ScannedPagesAdapter$ScannedPageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ScannedPageViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ImageView image;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScannedPageViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.page_image);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.image = (ImageView) viewFindViewById;
        }

        public final ImageView getImage() {
            return this.image;
        }
    }
}
