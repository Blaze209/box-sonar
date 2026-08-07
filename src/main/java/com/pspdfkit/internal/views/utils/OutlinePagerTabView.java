package com.pspdfkit.internal.views.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pspdfkit.R;
import com.pspdfkit.internal.no;
import com.pspdfkit.ui.PdfOutlineView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class OutlinePagerTabView extends FrameLayout implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {
    public final BottomNavigationView a;
    public ViewPager b;
    public PdfOutlineView.OutlinePagerAdapter c;
    public final ArrayList d;

    public OutlinePagerTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) View.inflate(getContext(), R.layout.pspdf__view_pager_tab_view, this).findViewById(R.id.pspdf__view_pager_tab_buttons_bar);
        this.a = bottomNavigationView;
        bottomNavigationView.inflateMenu(R.menu.pspdf__menu_pdf_outline_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        ViewCompat.setOnApplyWindowInsetsListener(bottomNavigationView, null);
        int i = 0;
        while (true) {
            int size = this.a.getMenu().size();
            BottomNavigationView bottomNavigationView2 = this.a;
            if (i >= size) {
                bottomNavigationView2.getMenu().clear();
                return;
            } else {
                this.d.add(bottomNavigationView2.getMenu().getItem(i));
                i++;
            }
        }
    }

    public final void a() {
        String strA;
        if (this.a.getMenu().size() == 0 && this.c != null) {
            for (int i = 0; i < this.c.getCount(); i++) {
                int itemTabButtonId = this.c.getItemTabButtonId(i);
                ArrayList arrayList = this.d;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    MenuItem menuItem = (MenuItem) obj;
                    if (menuItem.getItemId() == itemTabButtonId) {
                        Menu menu = this.a.getMenu();
                        int groupId = menuItem.getGroupId();
                        int itemId = menuItem.getItemId();
                        int order = menuItem.getOrder();
                        Context context = getContext();
                        int itemId2 = menuItem.getItemId();
                        if (itemId2 == R.id.pspdf__menu_pdf_outline_view_outline) {
                            strA = no.a(context, R.string.pspdf__activity_menu_outline, null);
                        } else if (itemId2 == R.id.pspdf__menu_pdf_outline_view_bookmarks) {
                            strA = no.a(context, R.string.pspdf__bookmarks, null);
                        } else if (itemId2 == R.id.pspdf__menu_pdf_outline_view_document_info) {
                            strA = no.a(context, R.string.pspdf__document_info, null);
                        } else if (itemId2 == R.id.pspdf__menu_pdf_outline_view_annotations) {
                            strA = no.a(context, R.string.pspdf__annotations, null);
                        } else {
                            strA = itemId2 == R.id.pspdf__menu_pdf_outline_embedded_documents ? no.a(context, R.string.pspdf__attachments, null) : "";
                        }
                        menu.add(groupId, itemId, order, strA).setIcon(menuItem.getIcon());
                    }
                }
            }
        }
        PdfOutlineView.OutlinePagerAdapter outlinePagerAdapter = this.c;
        if (outlinePagerAdapter == null || outlinePagerAdapter.getCount() <= 0 || this.b == null) {
            return;
        }
        this.a.setOnNavigationItemSelectedListener(null);
        this.a.setSelectedItemId(this.c.getItemTabButtonId(this.b.getCurrentItem()));
        this.a.setOnNavigationItemSelectedListener(this);
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        ViewPager viewPager = this.b;
        if (viewPager == null || this.c == null) {
            return false;
        }
        viewPager.removeOnPageChangeListener(this);
        this.b.setCurrentItem(this.c.getPositionOfItemWithTabButtonId(menuItem.getItemId()));
        this.b.addOnPageChangeListener(this);
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        if (this.c != null) {
            this.a.setOnNavigationItemSelectedListener(null);
            this.a.setSelectedItemId(this.c.getItemTabButtonId(i));
            this.a.setOnNavigationItemSelectedListener(this);
        }
    }
}
