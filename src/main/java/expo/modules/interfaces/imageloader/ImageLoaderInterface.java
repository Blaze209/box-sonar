package expo.modules.interfaces.imageloader;

import android.graphics.Bitmap;
import expo.modules.kotlin.services.Service;
import java.util.concurrent.Future;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageLoaderInterface.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "Lexpo/modules/kotlin/services/Service;", "loadImageForDisplayFromURL", "Ljava/util/concurrent/Future;", "Landroid/graphics/Bitmap;", "url", "", "", "resultListener", "Lexpo/modules/interfaces/imageloader/ImageLoaderInterface$ResultListener;", "loadImageForManipulationFromURL", "ResultListener", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ImageLoaderInterface extends Service {

    /* JADX INFO: compiled from: ImageLoaderInterface.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lexpo/modules/interfaces/imageloader/ImageLoaderInterface$ResultListener;", "", "onSuccess", "", "bitmap", "Landroid/graphics/Bitmap;", "onFailure", "cause", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ResultListener {
        void onFailure(Throwable cause);

        void onSuccess(Bitmap bitmap);
    }

    Future<Bitmap> loadImageForDisplayFromURL(String url);

    void loadImageForDisplayFromURL(String url, ResultListener resultListener);

    Future<Bitmap> loadImageForManipulationFromURL(String url);

    void loadImageForManipulationFromURL(String url, ResultListener resultListener);
}
