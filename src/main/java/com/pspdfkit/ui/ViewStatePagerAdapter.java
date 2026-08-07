package com.pspdfkit.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewStatePagerAdapter extends PagerAdapter {
    private final SparseArray<View> attached;
    private SparseArray<SparseArray<Parcelable>> detached;

    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.pspdfkit.ui.ViewStatePagerAdapter.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(SavedState.readNestedSparseArray(parcel, SavedState.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final SparseArray<SparseArray<Parcelable>> detached;

        public SavedState(SparseArray<SparseArray<Parcelable>> sparseArray) {
            this.detached = sparseArray == null ? new SparseArray<>() : sparseArray;
        }

        public static SparseArray<SparseArray<Parcelable>> readNestedSparseArray(Parcel parcel, ClassLoader classLoader) {
            int i = parcel.readInt();
            if (i == -1) {
                return null;
            }
            SparseArray<SparseArray<Parcelable>> sparseArray = new SparseArray<>(i);
            while (i != 0) {
                sparseArray.append(parcel.readInt(), readSparseArray(parcel, classLoader));
                i--;
            }
            return sparseArray;
        }

        public static SparseArray<Parcelable> readSparseArray(Parcel parcel, ClassLoader classLoader) {
            int i = parcel.readInt();
            if (i == -1) {
                return null;
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>(i);
            while (i != 0) {
                sparseArray.append(parcel.readInt(), parcel.readParcelable(classLoader));
                i--;
            }
            return sparseArray;
        }

        public static void writeNestedSparseArray(Parcel parcel, SparseArray<SparseArray<Parcelable>> sparseArray, int i) {
            if (sparseArray == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 != size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                writeSparseArray(parcel, sparseArray.valueAt(i2), i);
            }
        }

        public static void writeSparseArray(Parcel parcel, SparseArray<Parcelable> sparseArray, int i) {
            if (sparseArray == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 != size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeParcelable(sparseArray.valueAt(i2), i);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            writeNestedSparseArray(parcel, this.detached, i);
        }
    }

    public ViewStatePagerAdapter(int i) {
        this.attached = new SparseArray<>(i);
    }

    private void putInDetached(int i, View view) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        view.saveHierarchyState(sparseArray);
        SparseArray<SparseArray<Parcelable>> sparseArray2 = this.detached;
        if (sparseArray2 != null) {
            sparseArray2.put(i, sparseArray);
        }
    }

    public abstract View createView(ViewGroup viewGroup, int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        destroyView(viewGroup, i, view);
        putInDetached(i, view);
        viewGroup.removeView(view);
        this.attached.remove(i);
    }

    public void destroyView(ViewGroup viewGroup, int i, View view) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.detached == null) {
            this.detached = new SparseArray<>();
        }
        View viewCreateView = createView(viewGroup, i);
        if (viewCreateView == null) {
            throw new NullPointerException("CreateView must not return null. (Position: " + i + ")");
        }
        SparseArray<Parcelable> sparseArray = this.detached.get(i);
        if (sparseArray != null) {
            viewCreateView.restoreHierarchyState(sparseArray);
        }
        viewGroup.addView(viewCreateView);
        this.attached.put(i, viewCreateView);
        return viewCreateView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.detached = ((SavedState) parcelable).detached;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final SavedState saveState() {
        for (int i = 0; i < this.attached.size(); i++) {
            putInDetached(this.attached.keyAt(i), this.attached.valueAt(i));
        }
        return new SavedState(this.detached);
    }
}
