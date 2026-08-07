package com.pspdfkit.ui.inspector;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.fk;
import com.pspdfkit.internal.gk;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.views.inspector.bottomsheet.d;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PropertyInspectorCoordinatorLayout extends CoordinatorLayout implements PropertyInspectorCoordinatorLayoutController {
    private PropertyInspector activePropertyInspector;
    private int bottomInset;
    private d<PropertyInspector> bottomSheetLayout;
    private int customBottomInset;
    private hn.c keyboardObserver;
    private final go<PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener> lifecycleListeners;
    private boolean showInspectorViewsUnderBottomInset;

    public PropertyInspectorCoordinatorLayout(Context context) {
        super(context);
        this.lifecycleListeners = new go<>();
        this.showInspectorViewsUnderBottomInset = false;
        init(context, null, 0, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.elevation}, i, i2);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, context.getResources().getDimensionPixelOffset(com.pspdfkit.R.dimen.pspdf__inspector_elevation));
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setElevation(this, dimensionPixelOffset);
        d<PropertyInspector> dVar = new d<>(getContext());
        this.bottomSheetLayout = dVar;
        dVar.setCallback(new d.a() { // from class: com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayout.1
            private fk.a systemUiVisibleLock;

            @Override // com.pspdfkit.internal.views.inspector.bottomsheet.d.a
            public void onHide(d dVar2) {
                PropertyInspectorCoordinatorLayout propertyInspectorCoordinatorLayout = PropertyInspectorCoordinatorLayout.this;
                if (propertyInspectorCoordinatorLayout.activePropertyInspector != null) {
                    Iterator it = propertyInspectorCoordinatorLayout.lifecycleListeners.iterator();
                    while (it.hasNext()) {
                        ((PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener) it.next()).onRemovePropertyInspector(PropertyInspectorCoordinatorLayout.this.activePropertyInspector);
                    }
                    PropertyInspectorCoordinatorLayout.this.activePropertyInspector.reset();
                    if (this.systemUiVisibleLock != null) {
                        Context context2 = PropertyInspectorCoordinatorLayout.this.getContext();
                        fk.a aVar = this.systemUiVisibleLock;
                        fk fkVarA = gk.a(context2);
                        if (fkVarA != null) {
                            fkVarA.d.remove(aVar);
                            fkVarA.b();
                        }
                        this.systemUiVisibleLock = null;
                    }
                }
                PropertyInspectorCoordinatorLayout.this.reset();
                PropertyInspectorCoordinatorLayout propertyInspectorCoordinatorLayout2 = PropertyInspectorCoordinatorLayout.this;
                synchronized (hn.class) {
                    hn.b bVarA = hn.a(propertyInspectorCoordinatorLayout2);
                    if (bVarA != null) {
                        bVarA.a.remove(propertyInspectorCoordinatorLayout2);
                        if (bVarA.a.isEmpty()) {
                            ArrayList arrayList = bVarA.b;
                            int size = arrayList.size();
                            int i3 = 0;
                            while (i3 < size) {
                                Object obj = arrayList.get(i3);
                                i3++;
                                ((Runnable) obj).run();
                            }
                        }
                    }
                }
            }

            @Override // com.pspdfkit.internal.views.inspector.bottomsheet.d.a
            public void onShow(d dVar2) {
                PropertyInspectorCoordinatorLayout propertyInspectorCoordinatorLayout = PropertyInspectorCoordinatorLayout.this;
                if (propertyInspectorCoordinatorLayout.activePropertyInspector != null) {
                    Iterator it = propertyInspectorCoordinatorLayout.lifecycleListeners.iterator();
                    while (it.hasNext()) {
                        ((PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener) it.next()).onDisplayPropertyInspector(PropertyInspectorCoordinatorLayout.this.activePropertyInspector);
                    }
                    this.systemUiVisibleLock = gk.a(PropertyInspectorCoordinatorLayout.this.getContext(), this.systemUiVisibleLock);
                }
                PropertyInspector propertyInspector = PropertyInspectorCoordinatorLayout.this.activePropertyInspector;
                if (propertyInspector != null) {
                    propertyInspector.requestFocus();
                }
            }
        });
        this.bottomSheetLayout.setVisibility(8);
        addView(this.bottomSheetLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInspector$0(PropertyInspector propertyInspector) {
        hideInspector(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showInspector$1(View view, MotionEvent motionEvent) {
        hideInspector(true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInspector$2(PropertyInspector propertyInspector, boolean z) {
        if (z && propertyInspector.findFocus() == null) {
            hideInspector(false);
        }
    }

    private void refreshBottomInset() {
        if (this.activePropertyInspector == null) {
            return;
        }
        this.bottomSheetLayout.setBottomInset(this.bottomInset + this.customBottomInset);
        this.activePropertyInspector.setBottomInset(this.bottomInset + this.customBottomInset);
        int i = 0;
        if (!this.showInspectorViewsUnderBottomInset) {
            int iA = gk.a(a80.a((View) this));
            int i2 = this.bottomInset;
            if (iA >= i2) {
                i = i2;
            }
        }
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        hn.c cVar = this.keyboardObserver;
        if (cVar != null) {
            cVar.b();
        }
        synchronized (hn.class) {
            hn.b bVarA = hn.a(this);
            if (bVarA != null) {
                bVarA.a.remove(this);
                if (bVarA.a.isEmpty()) {
                    ArrayList arrayList = bVarA.b;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((Runnable) obj).run();
                    }
                }
            }
        }
        if (getChildCount() > 1 || getChildAt(0) != this.bottomSheetLayout) {
            removeAllViews();
            addView(this.bottomSheetLayout);
        }
        PropertyInspector propertyInspector = this.activePropertyInspector;
        if (propertyInspector != null) {
            propertyInspector.reset();
            this.activePropertyInspector.setCancelListener(null);
            this.activePropertyInspector = null;
        }
        this.customBottomInset = 0;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController
    public void addPropertyInspectorLifecycleListener(PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener propertyInspectorLifecycleListener) {
        this.lifecycleListeners.a(propertyInspectorLifecycleListener);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = rect.left;
            marginLayoutParams.topMargin = rect.top;
            marginLayoutParams.rightMargin = rect.right;
            setLayoutParams(marginLayoutParams);
        }
        this.bottomInset = rect.bottom;
        refreshBottomInset();
        return false;
    }

    public PropertyInspector getActiveInspector() {
        return this.activePropertyInspector;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController
    public boolean hideInspector(boolean z) {
        if (getActiveInspector() == null) {
            return false;
        }
        synchronized (hn.class) {
            IBinder iBinderB = hn.b(this);
            if (iBinderB == null) {
                PdfLog.w("Nutri.KeyboardUtils", "Can't lock the keyboard for detached view!", new Object[0]);
            } else {
                WeakHashMap weakHashMap = hn.a;
                hn.b bVar = (hn.b) weakHashMap.get(iBinderB);
                if (bVar == null) {
                    bVar = new hn.b();
                    weakHashMap.put(iBinderB, bVar);
                }
                bVar.a.add(this);
            }
        }
        d<PropertyInspector> dVar = this.bottomSheetLayout;
        dVar.getBehavior().t = 5;
        if (z) {
            dVar.a.a();
            return true;
        }
        dVar.setVisibility(8);
        d.a aVar = dVar.b;
        if (aVar == null) {
            return true;
        }
        aVar.onHide(dVar);
        return true;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController
    public boolean isInspectorVisible(PropertyInspector propertyInspector) {
        uw.a(propertyInspector, "inspector", null);
        return getActiveInspector() == propertyInspector;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController
    public void removePropertyInspectorLifecycleListener(PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener propertyInspectorLifecycleListener) {
        this.lifecycleListeners.b(propertyInspectorLifecycleListener);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController
    public void setBottomInset(int i) {
        if (this.customBottomInset == i) {
            return;
        }
        this.customBottomInset = i;
        refreshBottomInset();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController
    public void setDrawUnderBottomInset(boolean z) {
        if (this.showInspectorViewsUnderBottomInset != z) {
            this.showInspectorViewsUnderBottomInset = z;
            refreshBottomInset();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(false);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController
    public boolean showInspector(final PropertyInspector propertyInspector, boolean z) {
        PropertyInspector propertyInspector2 = this.activePropertyInspector;
        boolean z2 = false;
        if (propertyInspector2 != null && propertyInspector2 == propertyInspector) {
            return false;
        }
        hideInspector(false);
        this.activePropertyInspector = propertyInspector;
        propertyInspector.setCancelListener(new PropertyInspector.OnCancelListener() { // from class: com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayout$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.inspector.PropertyInspector.OnCancelListener
            public final void onCancel(PropertyInspector propertyInspector3) {
                this.f$0.lambda$showInspector$0(propertyInspector3);
            }
        });
        if (propertyInspector.isCancelOnTouchOutside()) {
            View view = new View(getContext());
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayout$$ExternalSyntheticLambda1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f$0.lambda$showInspector$1(view2, motionEvent);
                }
            });
            view.setBackgroundColor(0);
            view.setSoundEffectsEnabled(false);
            addView(view, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        refreshBottomInset();
        this.bottomSheetLayout.setContentView(propertyInspector);
        hn.d dVar = new hn.d() { // from class: com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayout$$ExternalSyntheticLambda2
            @Override // com.pspdfkit.internal.hn.d
            public final void a(boolean z3) {
                this.f$0.lambda$showInspector$2(propertyInspector, z3);
            }
        };
        WeakHashMap weakHashMap = hn.a;
        this.keyboardObserver = new hn.c(a80.a((View) this), dVar);
        Iterator<PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener> it = this.lifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onPreparePropertyInspector(this.activePropertyInspector);
        }
        d<PropertyInspector> dVar2 = this.bottomSheetLayout;
        if (z && this.keyboardObserver.g <= 0) {
            z2 = true;
        }
        dVar2.a(z2);
        return true;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController
    public boolean isInspectorVisible() {
        return getActiveInspector() != null;
    }

    public PropertyInspectorCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lifecycleListeners = new go<>();
        this.showInspectorViewsUnderBottomInset = false;
        init(context, attributeSet, 0, 0);
    }

    public PropertyInspectorCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lifecycleListeners = new go<>();
        this.showInspectorViewsUnderBottomInset = false;
        init(context, attributeSet, i, 0);
    }
}
