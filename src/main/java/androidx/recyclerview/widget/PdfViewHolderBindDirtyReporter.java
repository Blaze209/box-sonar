package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public abstract class PdfViewHolderBindDirtyReporter extends RecyclerView.ViewHolder {
    private static final int[] DIRTY_FLAGS = {1, 2, 4, 32};

    public PdfViewHolderBindDirtyReporter(View view) {
        super(view);
    }

    private static boolean isBindDirty(int i) {
        for (int i2 : DIRTY_FLAGS) {
            if ((i & i2) == i2) {
                return true;
            }
        }
        return false;
    }

    private void validate(int i) {
        if (isBindDirty(i)) {
            onViewHolderBindDirty();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
    public void addFlags(int i) {
        super.addFlags(i);
        validate(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
    public void offsetPosition(int i, boolean z) {
        super.offsetPosition(i, z);
        onViewHolderBindDirty();
    }

    public abstract void onViewHolderBindDirty();

    @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
    public void setFlags(int i, int i2) {
        super.setFlags(i, i2);
        validate(i & i2);
    }
}
