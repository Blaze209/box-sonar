package com.geniusscansdk.camera;

import android.hardware.Camera;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
class CameraSizeChooser {
    CameraSizeChooser() {
    }

    public class CameraSizes {
        public Camera.Size pictureSize;
        public Camera.Size previewSize;

        public CameraSizes(Camera.Size size, Camera.Size size2) {
            this.pictureSize = size;
            this.previewSize = size2;
        }
    }

    public CameraSizes pickBestSizes(List<Camera.Size> list, List<Camera.Size> list2, Camera.Size size, int i) {
        Camera.Size sizePickLargestSize = pickLargestSize(list);
        return new CameraSizes(sizePickLargestSize, pickBestPreviewSize(list2, (sizePickLargestSize.width * i) / sizePickLargestSize.height, i));
    }

    private Camera.Size pickBestPreviewSize(List<Camera.Size> list, int i, int i2) {
        double d = i;
        double d2 = d / ((double) i2);
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double dAbs = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            double d3 = ((double) size2.width) / ((double) size2.height);
            if (((double) size2.width) / d <= 1.5d && Math.abs(d3 - d2) <= 0.1d && Math.abs(size2.height - i2) < dAbs) {
                dAbs = Math.abs(size2.height - i2);
                size = size2;
            }
        }
        if (size == null) {
            double dAbs2 = Double.MAX_VALUE;
            for (Camera.Size size3 : list) {
                if (((double) size3.width) / d <= 1.5d && Math.abs(size3.height - i2) < dAbs2) {
                    dAbs2 = Math.abs(size3.height - i2);
                    size = size3;
                }
            }
        }
        if (size == null) {
            double dAbs3 = Double.MAX_VALUE;
            for (Camera.Size size4 : list) {
                if (Math.abs(size4.height - i2) < dAbs3) {
                    size = size4;
                    dAbs3 = Math.abs(size4.height - i2);
                }
            }
        }
        return size;
    }

    private Camera.Size pickLargestSize(List<Camera.Size> list) {
        Camera.Size size = null;
        int i = 0;
        for (Camera.Size size2 : list) {
            int i2 = size2.width * size2.height;
            if (size == null || i2 > i) {
                size = size2;
                i = i2;
            }
        }
        return size;
    }
}
