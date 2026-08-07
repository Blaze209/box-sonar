package com.pspdfkit.ui.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.internal.uw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationBackStack<T> implements Parcelable {
    public static final Parcelable.Creator<NavigationBackStack> CREATOR = new Parcelable.Creator<NavigationBackStack>() { // from class: com.pspdfkit.ui.navigation.NavigationBackStack.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NavigationBackStack createFromParcel(Parcel parcel) {
            return new NavigationBackStack(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NavigationBackStack[] newArray(int i) {
            return new NavigationBackStack[i];
        }
    };
    private boolean backInProgress;
    private final List<T> backList;
    private final List<BackStackListener<T>> backStackListeners;
    private boolean forwardInProgress;
    private final List<T> forwardList;

    public interface BackStackListener<T> {
        void onBackStackChanged();

        void visitedItem(T t);
    }

    public NavigationBackStack() {
        this.backList = new ArrayList();
        this.forwardList = new ArrayList();
        this.backInProgress = false;
        this.forwardInProgress = false;
        this.backStackListeners = new ArrayList();
    }

    private void goBackToItem(T t) {
        uw.a(t, "item", null);
        List<T> listPopBackToItem = popBackToItem(t);
        if (listPopBackToItem.size() > 0) {
            this.backInProgress = true;
            for (BackStackListener<T> backStackListener : this.backStackListeners) {
                Iterator<T> it = listPopBackToItem.iterator();
                while (it.hasNext()) {
                    backStackListener.visitedItem(it.next());
                }
            }
            this.backInProgress = false;
        }
    }

    private void goForwardToItem(T t) {
        uw.a(t, "item", null);
        List<T> listPopForwardToItem = popForwardToItem(t);
        if (listPopForwardToItem.size() > 0) {
            this.forwardInProgress = true;
            for (BackStackListener<T> backStackListener : this.backStackListeners) {
                Iterator<T> it = listPopForwardToItem.iterator();
                while (it.hasNext()) {
                    backStackListener.visitedItem(it.next());
                }
            }
            this.forwardInProgress = false;
        }
    }

    private List<T> popBackToItem(T t) {
        uw.a(t, "item", null);
        ArrayList arrayList = new ArrayList();
        for (int size = this.backList.size() - 1; size >= 0; size--) {
            arrayList.add(0, this.backList.get(size));
            if (this.backList.get(size) == t) {
                int size2 = this.backList.size() - arrayList.size();
                for (int size3 = this.backList.size() - 1; size3 >= size2; size3--) {
                    this.backList.remove(size3);
                }
                Iterator<BackStackListener<T>> it = this.backStackListeners.iterator();
                while (it.hasNext()) {
                    it.next().onBackStackChanged();
                }
                return arrayList;
            }
        }
        return Collections.EMPTY_LIST;
    }

    private List<T> popForwardToItem(T t) {
        uw.a(t, "item", null);
        ArrayList arrayList = new ArrayList();
        for (int size = this.forwardList.size() - 1; size >= 0; size--) {
            arrayList.add(0, this.forwardList.get(size));
            if (this.forwardList.get(size) == t) {
                int size2 = this.forwardList.size() - arrayList.size();
                for (int size3 = this.forwardList.size() - 1; size3 >= size2; size3--) {
                    this.forwardList.remove(size3);
                }
                Iterator<BackStackListener<T>> it = this.backStackListeners.iterator();
                while (it.hasNext()) {
                    it.next().onBackStackChanged();
                }
                return arrayList;
            }
        }
        return Collections.EMPTY_LIST;
    }

    private void pushBackItem(T t) {
        uw.a(t, "item", null);
        this.backList.add(t);
        Iterator<BackStackListener<T>> it = this.backStackListeners.iterator();
        while (it.hasNext()) {
            it.next().onBackStackChanged();
        }
    }

    private void pushForwardItem(T t) {
        uw.a(t, "item", null);
        this.forwardList.add(t);
        Iterator<BackStackListener<T>> it = this.backStackListeners.iterator();
        while (it.hasNext()) {
            it.next().onBackStackChanged();
        }
    }

    public void addBackStackListener(BackStackListener<T> backStackListener) {
        uw.a(backStackListener, "backStackListener", null);
        if (this.backStackListeners.contains(backStackListener)) {
            return;
        }
        this.backStackListeners.add(backStackListener);
    }

    public void addItem(T t) {
        uw.a(t, "item", null);
        if (this.backInProgress) {
            pushForwardItem(t);
            return;
        }
        if (!this.forwardInProgress) {
            resetForwardList();
        }
        pushBackItem(t);
    }

    public void clearBackStackListeners() {
        this.backStackListeners.clear();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public T getBackItem() {
        if (this.backList.isEmpty()) {
            return null;
        }
        List<T> list = this.backList;
        return list.get(list.size() - 1);
    }

    public T getForwardItem() {
        if (this.forwardList.isEmpty()) {
            return null;
        }
        List<T> list = this.forwardList;
        return list.get(list.size() - 1);
    }

    public void goBack() {
        T backItem = getBackItem();
        if (backItem != null) {
            goBackToItem(backItem);
        }
    }

    public void goForward() {
        T forwardItem = getForwardItem();
        if (forwardItem != null) {
            goForwardToItem(forwardItem);
        }
    }

    public void removeBackStackListener(BackStackListener<T> backStackListener) {
        uw.a(backStackListener, "backStackListener", null);
        this.backStackListeners.remove(backStackListener);
    }

    public void replaceWith(NavigationBackStack<T> navigationBackStack) {
        uw.a(navigationBackStack, "navigationHistory", null);
        if (navigationBackStack == this) {
            return;
        }
        this.backInProgress = navigationBackStack.backInProgress;
        this.forwardInProgress = navigationBackStack.forwardInProgress;
        this.forwardList.clear();
        this.forwardList.addAll(navigationBackStack.forwardList);
        this.backList.clear();
        this.backList.addAll(navigationBackStack.backList);
        Iterator<BackStackListener<T>> it = this.backStackListeners.iterator();
        while (it.hasNext()) {
            it.next().onBackStackChanged();
        }
    }

    public void resetForwardList() {
        this.forwardList.clear();
        Iterator<BackStackListener<T>> it = this.backStackListeners.iterator();
        while (it.hasNext()) {
            it.next().onBackStackChanged();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.backInProgress ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.forwardInProgress ? (byte) 1 : (byte) 0);
        parcel.writeArray(this.forwardList.toArray());
        parcel.writeArray(this.backList.toArray());
    }

    public static class NavigationItem<T> implements Parcelable {
        public static final Parcelable.Creator<NavigationItem> CREATOR = new Parcelable.Creator<NavigationItem>() { // from class: com.pspdfkit.ui.navigation.NavigationBackStack.NavigationItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NavigationItem createFromParcel(Parcel parcel) {
                return new NavigationItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NavigationItem[] newArray(int i) {
                return new NavigationItem[i];
            }
        };
        public final T inverseItem;
        public final T item;

        public NavigationItem(T t, T t2) {
            this.item = t;
            this.inverseItem = t2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NavigationItem)) {
                return false;
            }
            NavigationItem navigationItem = (NavigationItem) obj;
            return this.item.equals(navigationItem.item) && this.inverseItem.equals(navigationItem.inverseItem);
        }

        public NavigationItem<T> getInverse() {
            return new NavigationItem<>(this.inverseItem, this.item);
        }

        public int hashCode() {
            return this.inverseItem.hashCode() + (this.item.hashCode() * 31);
        }

        public String toString() {
            return "Navigation Item: " + this.item.toString() + " / " + this.inverseItem.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeValue(this.item);
            parcel.writeValue(this.inverseItem);
        }

        public NavigationItem(Parcel parcel) {
            this.item = (T) parcel.readValue(getClass().getClassLoader());
            this.inverseItem = (T) parcel.readValue(getClass().getClassLoader());
        }
    }

    private NavigationBackStack(Parcel parcel) {
        this.backList = new ArrayList();
        this.forwardList = new ArrayList();
        this.backInProgress = false;
        this.forwardInProgress = false;
        this.backStackListeners = new ArrayList();
        this.backInProgress = parcel.readByte() != 0;
        this.forwardInProgress = parcel.readByte() != 0;
        Object[] array = parcel.readArray(getClass().getClassLoader());
        Object[] array2 = parcel.readArray(getClass().getClassLoader());
        if (array != null && array2 != null) {
            for (Object obj : array) {
                this.forwardList.add((T) obj);
            }
            for (Object obj2 : array2) {
                this.backList.add((T) obj2);
            }
            return;
        }
        throw new IllegalStateException("NavigationBackStack parcel does not contain valid data.");
    }
}
