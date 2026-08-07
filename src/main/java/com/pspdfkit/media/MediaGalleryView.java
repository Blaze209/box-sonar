package com.pspdfkit.media;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.pspdfkit.R;
import com.pspdfkit.internal.nv;
import com.pspdfkit.utils.PdfLog;
import com.squareup.picasso.Picasso;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MediaGalleryView extends ViewPager implements MediaViewController {
    private final String LOG_TAG;
    private final Context context;
    MediaViewListener mediaViewListener;

    public static class GalleryElement {
        public static final String CAPTION_KEY = "caption";
        public static final String URL_KEY = "contentURL";
        public final String caption;
        public final String url;

        public GalleryElement(String str, String str2) {
            this.url = str;
            this.caption = str2;
        }

        public String toString() {
            return nv.a(new StringBuilder("GalleryElement{url='").append(this.url).append("', caption='"), this.caption, "'}");
        }
    }

    public class GalleryPagerAdapter extends PagerAdapter {
        private final List<GalleryElement> galleryElements;

        public GalleryPagerAdapter(List<GalleryElement> list) {
            this.galleryElements = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((RelativeLayout) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.galleryElements.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GalleryElement galleryElement = this.galleryElements.get(i);
            View viewInflate = LayoutInflater.from(MediaGalleryView.this.context).inflate(R.layout.pspdf__gallery_item, viewGroup, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.pspdf__gallery_item_img);
            TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__gallery_caption);
            try {
                Class.forName("com.squareup.picasso.Picasso");
                Picasso.get().load(galleryElement.url).into(imageView);
            } catch (ClassNotFoundException unused) {
                PdfLog.w("Nutri.MediaGalleryView", "Picasso dependency not found.", new Object[0]);
                MediaViewListener mediaViewListener = MediaGalleryView.this.mediaViewListener;
                if (mediaViewListener != null) {
                    mediaViewListener.onContentError();
                }
            }
            textView.setText(galleryElement.caption);
            viewGroup.addView(viewInflate);
            return viewInflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public MediaGalleryView(Context context) {
        super(context);
        this.LOG_TAG = "Nutri.MediaGalleryView";
        this.context = context;
    }

    private List<GalleryElement> parseJson(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new GalleryElement(jSONObject.getString(GalleryElement.URL_KEY), jSONObject.has(GalleryElement.CAPTION_KEY) ? jSONObject.getString(GalleryElement.CAPTION_KEY) : ""));
        }
        return arrayList;
    }

    @Override // com.pspdfkit.media.MediaViewController
    public void close() {
    }

    public void setMediaViewListener(MediaViewListener mediaViewListener) {
        this.mediaViewListener = mediaViewListener;
    }

    @Override // com.pspdfkit.media.MediaViewController
    public void start(String str, String str2) {
        String path;
        InputStream fileInputStream = null;
        try {
            try {
                if (str2.startsWith("localhost/")) {
                    fileInputStream = this.context.getAssets().open(str2.replace("localhost/", ""));
                } else if (str2.startsWith("file://") && (path = Uri.parse(str2).getPath()) != null) {
                    fileInputStream = new FileInputStream(new File(path));
                }
                if (fileInputStream == null) {
                    MediaViewListener mediaViewListener = this.mediaViewListener;
                    if (mediaViewListener != null) {
                        mediaViewListener.onContentError();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return;
                        } catch (Throwable unused) {
                            PdfLog.i("Nutri.Utilities", "Awaiting for safe closing failed and the exception was ignored.", new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
                StringBuilder sb = new StringBuilder();
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    sb.append(line);
                }
                bufferedReader.close();
                setAdapter(new GalleryPagerAdapter(parseJson(sb.toString())));
                MediaViewListener mediaViewListener2 = this.mediaViewListener;
                if (mediaViewListener2 != null) {
                    mediaViewListener2.onContentReady();
                }
                try {
                    fileInputStream.close();
                } catch (Throwable unused2) {
                    PdfLog.i("Nutri.Utilities", "Awaiting for safe closing failed and the exception was ignored.", new Object[0]);
                }
            } catch (IOException | JSONException unused3) {
                MediaViewListener mediaViewListener3 = this.mediaViewListener;
                if (mediaViewListener3 != null) {
                    mediaViewListener3.onContentError();
                }
                if (0 != 0) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused4) {
                        PdfLog.i("Nutri.Utilities", "Awaiting for safe closing failed and the exception was ignored.", new Object[0]);
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused5) {
                    PdfLog.i("Nutri.Utilities", "Awaiting for safe closing failed and the exception was ignored.", new Object[0]);
                }
            }
            throw th;
        }
    }

    public MediaGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LOG_TAG = "Nutri.MediaGalleryView";
        this.context = context;
    }
}
