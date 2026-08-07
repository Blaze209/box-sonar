package com.pspdfkit.ui.tabs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.pspdfkit.internal.aw;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.zv;
import com.pspdfkit.ui.DocumentCoordinator;
import com.pspdfkit.ui.DocumentDescriptor;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PdfTabBar extends LinearLayout {
    private DocumentCoordinator documentCoordinator;
    private final PdfDocumentManagerListener documentManagerListener;
    zv tabBarLayout;
    private final PdfTabBarLayoutDelegate tabBarLayoutDelegate;
    private final go<OnTabClickedListener> tabClickedListeners;
    private final go<OnTabsChangedListener> tabsChangedListeners;
    private aw themeConfiguration;

    public interface OnTabClickedListener {
        boolean onCloseButtonClicked(PdfTabBarItem pdfTabBarItem);

        boolean onTabClicked(PdfTabBarItem pdfTabBarItem);
    }

    public interface OnTabsChangedListener {
        void onTabsChanged();
    }

    public class PdfDocumentManagerListener implements DocumentCoordinator.OnDocumentVisibleListener, DocumentCoordinator.OnDocumentsChangedListener {
        private PdfDocumentManagerListener() {
        }

        @Override // com.pspdfkit.ui.DocumentCoordinator.OnDocumentsChangedListener
        public void onDocumentAdded(DocumentDescriptor documentDescriptor) {
            if (PdfTabBar.this.getTabBarItem(documentDescriptor) == null) {
                PdfTabBar pdfTabBar = PdfTabBar.this;
                zv zvVar = pdfTabBar.tabBarLayout;
                PdfTabBarItem pdfTabBarItemCreateTabBarItem = pdfTabBar.createTabBarItem(documentDescriptor);
                int size = zvVar.e.size();
                if (zvVar.e.indexOf(pdfTabBarItemCreateTabBarItem) < 0) {
                    zvVar.e.add(size, pdfTabBarItemCreateTabBarItem);
                    zvVar.c.notifyItemInserted(size);
                    zv.e eVar = zvVar.c;
                    eVar.notifyItemRangeChanged(0, zv.this.e.size(), zv.i);
                    zv.c cVar = zvVar.g;
                    if (cVar != null) {
                        cVar.onTabsChanged();
                    }
                }
            }
        }

        @Override // com.pspdfkit.ui.DocumentCoordinator.OnDocumentsChangedListener
        public void onDocumentMoved(DocumentDescriptor documentDescriptor, int i) {
            PdfTabBarItem tabBarItem = PdfTabBar.this.getTabBarItem(documentDescriptor);
            if (tabBarItem != null) {
                zv zvVar = PdfTabBar.this.tabBarLayout;
                int iIndexOf = zvVar.e.indexOf(tabBarItem);
                if (iIndexOf < 0 || iIndexOf == i) {
                    return;
                }
                zvVar.e.remove(iIndexOf);
                zvVar.e.add(i, tabBarItem);
                zvVar.c.notifyItemMoved(iIndexOf, i);
            }
        }

        @Override // com.pspdfkit.ui.DocumentCoordinator.OnDocumentsChangedListener
        public void onDocumentRemoved(DocumentDescriptor documentDescriptor) {
            PdfTabBarItem tabBarItem = PdfTabBar.this.getTabBarItem(documentDescriptor);
            if (tabBarItem != null) {
                PdfTabBar.this.tabBarLayout.a(tabBarItem);
            }
        }

        @Override // com.pspdfkit.ui.DocumentCoordinator.OnDocumentsChangedListener
        public void onDocumentReplaced(DocumentDescriptor documentDescriptor, DocumentDescriptor documentDescriptor2) {
            int iIndexOf;
            PdfTabBarItem tabBarItem = PdfTabBar.this.getTabBarItem(documentDescriptor);
            if (tabBarItem == null || (iIndexOf = PdfTabBar.this.tabBarLayout.e.indexOf(tabBarItem)) < 0) {
                return;
            }
            PdfTabBar pdfTabBar = PdfTabBar.this;
            zv zvVar = pdfTabBar.tabBarLayout;
            PdfTabBarItem pdfTabBarItemCreateTabBarItem = pdfTabBar.createTabBarItem(documentDescriptor2);
            if (zvVar.e.indexOf(pdfTabBarItemCreateTabBarItem) < 0) {
                boolean z = zvVar.e.get(iIndexOf) == zvVar.f;
                zvVar.e.set(iIndexOf, pdfTabBarItemCreateTabBarItem);
                if (z) {
                    zvVar.setSelectedTab(pdfTabBarItemCreateTabBarItem);
                }
                zvVar.c.notifyItemChanged(iIndexOf);
                zv.c cVar = zvVar.g;
                if (cVar != null) {
                    cVar.onTabsChanged();
                }
            }
        }

        @Override // com.pspdfkit.ui.DocumentCoordinator.OnDocumentsChangedListener
        public void onDocumentUpdated(DocumentDescriptor documentDescriptor) {
            if (PdfTabBar.this.getTabBarItem(documentDescriptor) != null) {
                PdfTabBar.this.tabBarLayout.c.notifyDataSetChanged();
            }
        }

        @Override // com.pspdfkit.ui.DocumentCoordinator.OnDocumentVisibleListener
        public void onDocumentVisible(DocumentDescriptor documentDescriptor) {
            PdfTabBarItem tabBarItem = PdfTabBar.this.getTabBarItem(documentDescriptor);
            if (tabBarItem == null) {
                tabBarItem = PdfTabBar.this.createTabBarItem(documentDescriptor);
            }
            PdfTabBar.this.tabBarLayout.setSelectedTab(tabBarItem);
        }
    }

    public class PdfTabBarLayoutDelegate implements zv.c {
        private PdfTabBarLayoutDelegate() {
        }

        @Override // com.pspdfkit.internal.zv.c
        public boolean onMoveTab(PdfTabBarItem pdfTabBarItem, int i) {
            return PdfTabBar.this.getDocumentCoordinator().moveDocument(pdfTabBarItem.getDocumentDescriptor(), i);
        }

        @Override // com.pspdfkit.internal.zv.c
        public void onTabClosed(PdfTabBarItem pdfTabBarItem) {
            PdfTabBar.this.getDocumentCoordinator().removeDocument(pdfTabBarItem.getDocumentDescriptor());
        }

        @Override // com.pspdfkit.internal.zv.c
        public void onTabSelected(PdfTabBarItem pdfTabBarItem) {
            PdfTabBar.this.getDocumentCoordinator().setVisibleDocument(pdfTabBarItem.getDocumentDescriptor());
        }

        @Override // com.pspdfkit.internal.zv.c
        public void onTabsChanged() {
            Iterator it = PdfTabBar.this.tabsChangedListeners.iterator();
            while (it.hasNext()) {
                ((OnTabsChangedListener) it.next()).onTabsChanged();
            }
        }

        @Override // com.pspdfkit.internal.zv.c
        public boolean shouldCloseTab(PdfTabBarItem pdfTabBarItem) {
            Iterator it = PdfTabBar.this.tabClickedListeners.iterator();
            while (it.hasNext()) {
                if (!((OnTabClickedListener) it.next()).onCloseButtonClicked(pdfTabBarItem)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.pspdfkit.internal.zv.c
        public boolean shouldSelectTab(PdfTabBarItem pdfTabBarItem) {
            Iterator it = PdfTabBar.this.tabClickedListeners.iterator();
            while (it.hasNext()) {
                if (!((OnTabClickedListener) it.next()).onTabClicked(pdfTabBarItem)) {
                    return false;
                }
            }
            return true;
        }
    }

    public PdfTabBar(Context context) {
        super(context);
        this.tabsChangedListeners = new go<>();
        this.tabClickedListeners = new go<>();
        this.documentManagerListener = new PdfDocumentManagerListener();
        this.tabBarLayoutDelegate = new PdfTabBarLayoutDelegate();
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PdfTabBarItem createTabBarItem(DocumentDescriptor documentDescriptor) {
        return new PdfTabBarItem(documentDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DocumentCoordinator getDocumentCoordinator() {
        DocumentCoordinator documentCoordinator = this.documentCoordinator;
        if (documentCoordinator != null) {
            return documentCoordinator;
        }
        throw new NullPointerException("DocumentCoordinator must be bound to PdfTabBar before using tabs.");
    }

    private void initialize() {
        setOrientation(0);
        aw awVar = new aw(getContext());
        this.themeConfiguration = awVar;
        setBackgroundColor(awVar.a);
        zv zvVar = new zv(getContext(), this.themeConfiguration);
        this.tabBarLayout = zvVar;
        addView(zvVar, new LinearLayout.LayoutParams(-1, this.themeConfiguration.g));
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.pspdfkit.ui.tabs.PdfTabBar$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return this.f$0.lambda$initialize$0(view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat lambda$initialize$0(View view, WindowInsetsCompat windowInsetsCompat) {
        setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), 0, windowInsetsCompat.getSystemWindowInsetRight(), 0);
        return windowInsetsCompat.consumeStableInsets();
    }

    public void addOnTabClickedListener(OnTabClickedListener onTabClickedListener) {
        this.tabClickedListeners.a(onTabClickedListener);
    }

    public void addOnTabsChangedListener(OnTabsChangedListener onTabsChangedListener) {
        this.tabsChangedListeners.a(onTabsChangedListener);
    }

    public void bindToDocumentCoordinator(DocumentCoordinator documentCoordinator) {
        PdfTabBarItem tabBarItem;
        uw.a(documentCoordinator, "documentCoordinator", null);
        this.documentCoordinator = documentCoordinator;
        documentCoordinator.addOnDocumentVisibleListener(this.documentManagerListener);
        documentCoordinator.addOnDocumentsChangedListener(this.documentManagerListener);
        this.tabBarLayout.setDelegate(this.tabBarLayoutDelegate);
        zv zvVar = this.tabBarLayout;
        if (!zvVar.e.isEmpty()) {
            zvVar.e.clear();
            zvVar.c.notifyDataSetChanged();
            zv.c cVar = zvVar.g;
            if (cVar != null) {
                cVar.onTabsChanged();
            }
        }
        for (DocumentDescriptor documentDescriptor : documentCoordinator.getDocuments()) {
            zv zvVar2 = this.tabBarLayout;
            PdfTabBarItem pdfTabBarItemCreateTabBarItem = createTabBarItem(documentDescriptor);
            int size = zvVar2.e.size();
            if (zvVar2.e.indexOf(pdfTabBarItemCreateTabBarItem) < 0) {
                zvVar2.e.add(size, pdfTabBarItemCreateTabBarItem);
                zvVar2.c.notifyItemInserted(size);
                zv.e eVar = zvVar2.c;
                eVar.notifyItemRangeChanged(0, zv.this.e.size(), zv.i);
                zv.c cVar2 = zvVar2.g;
                if (cVar2 != null) {
                    cVar2.onTabsChanged();
                }
            }
        }
        DocumentDescriptor visibleDocument = documentCoordinator.getVisibleDocument();
        if (visibleDocument == null || (tabBarItem = getTabBarItem(visibleDocument)) == null) {
            return;
        }
        this.tabBarLayout.setSelectedTab(tabBarItem);
    }

    public int getSize() {
        return this.tabBarLayout.getTabs().size();
    }

    public PdfTabBarItem getTabBarItem(DocumentDescriptor documentDescriptor) {
        if (documentDescriptor == null) {
            return null;
        }
        for (PdfTabBarItem pdfTabBarItem : this.tabBarLayout.getTabs()) {
            if (pdfTabBarItem.getDocumentDescriptor() == documentDescriptor) {
                return pdfTabBarItem;
            }
        }
        return null;
    }

    public List<PdfTabBarItem> getTabs() {
        return Collections.unmodifiableList(this.tabBarLayout.getTabs());
    }

    public void removeOnTabClickedListener(OnTabClickedListener onTabClickedListener) {
        this.tabClickedListeners.b(onTabClickedListener);
    }

    public void removeOnTabsChangedListener(OnTabsChangedListener onTabsChangedListener) {
        this.tabsChangedListeners.b(onTabsChangedListener);
    }

    public void setCloseMode(PdfTabBarCloseMode pdfTabBarCloseMode) {
        uw.a(pdfTabBarCloseMode, "closeMode", null);
        this.tabBarLayout.setCloseMode(pdfTabBarCloseMode);
    }

    public void unbindDocumentCoordinator() {
        DocumentCoordinator documentCoordinator = this.documentCoordinator;
        if (documentCoordinator != null) {
            documentCoordinator.removeOnDocumentsChangedListener(this.documentManagerListener);
            this.documentCoordinator.removeOnDocumentVisibleListener(this.documentManagerListener);
            zv zvVar = this.tabBarLayout;
            if (!zvVar.e.isEmpty()) {
                zvVar.e.clear();
                zvVar.c.notifyDataSetChanged();
                zv.c cVar = zvVar.g;
                if (cVar != null) {
                    cVar.onTabsChanged();
                }
            }
            this.tabBarLayout.setDelegate(null);
        }
        this.documentCoordinator = null;
    }

    public PdfTabBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tabsChangedListeners = new go<>();
        this.tabClickedListeners = new go<>();
        this.documentManagerListener = new PdfDocumentManagerListener();
        this.tabBarLayoutDelegate = new PdfTabBarLayoutDelegate();
        initialize();
    }

    public PdfTabBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tabsChangedListeners = new go<>();
        this.tabClickedListeners = new go<>();
        this.documentManagerListener = new PdfDocumentManagerListener();
        this.tabBarLayoutDelegate = new PdfTabBarLayoutDelegate();
        initialize();
    }
}
