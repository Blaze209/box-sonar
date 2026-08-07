package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.annotations.Location;
import com.box.android.data.api.models.annotations.Path;
import com.box.android.data.api.models.annotations.PathGroup;
import com.box.android.data.api.models.annotations.Point;
import com.box.android.data.api.models.annotations.Shape;
import com.box.android.data.api.models.annotations.ShapeType;
import com.box.android.data.api.models.annotations.Stroke;
import com.box.android.data.api.models.annotations.TargetDTO;
import com.box.android.data.mappers.DomainMapper;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.annotations.AnnotationPath;
import com.box.android.domain.models.annotations.AnnotationPathGroup;
import com.box.android.domain.models.annotations.AnnotationPoint;
import com.box.android.domain.models.annotations.AnnotationRectangle;
import com.box.android.domain.models.annotations.AnnotationStroke;
import com.box.android.domain.models.annotations.AnnotationTargetModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TargetDTOToTargetModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016J\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/mappers/annotation/TargetDTOToTargetModelMapper;", "Lcom/box/android/data/mappers/DomainMapper;", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", "Lcom/box/android/data/api/models/annotations/TargetDTO;", "<init>", "()V", "toDomain", "dataModel", "fromDomain", "domainModel", "locationModel", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "toStrokeDTO", "Lcom/box/android/data/api/models/annotations/Stroke;", "Lcom/box/android/domain/models/annotations/AnnotationStroke;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TargetDTOToTargetModelMapper implements DomainMapper<AnnotationTargetModel, TargetDTO> {
    public static final TargetDTOToTargetModelMapper INSTANCE = new TargetDTOToTargetModelMapper();

    private TargetDTOToTargetModelMapper() {
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public AnnotationTargetModel toDomain(TargetDTO dataModel) {
        Stroke stroke;
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        if (dataModel instanceof TargetDTO.Region) {
            TargetDTO.Region region = (TargetDTO.Region) dataModel;
            Stroke stroke2 = region.getShape().getStroke();
            return new AnnotationTargetModel.Area(new AnnotationRectangle(region.getShape().getY(), region.getShape().getX(), region.getShape().getHeight(), region.getShape().getWidth()), stroke2 != null ? new AnnotationStroke(stroke2.getColor(), stroke2.getSize()) : null);
        }
        if (dataModel instanceof TargetDTO.Highlight) {
            TargetDTO.Highlight highlight = (TargetDTO.Highlight) dataModel;
            Shape shape = (Shape) CollectionsKt.firstOrNull((List) highlight.getShapes());
            AnnotationStroke annotationStroke = (shape == null || (stroke = shape.getStroke()) == null) ? null : new AnnotationStroke(stroke.getColor(), stroke.getSize());
            List<Shape> shapes = highlight.getShapes();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(shapes, 10));
            for (Shape shape2 : shapes) {
                arrayList.add(new AnnotationRectangle(shape2.getY(), shape2.getX(), shape2.getHeight(), shape2.getWidth()));
            }
            return new AnnotationTargetModel.TextSelection(null, annotationStroke, arrayList);
        }
        if (!(dataModel instanceof TargetDTO.Drawing)) {
            throw new NoWhenBranchMatchedException();
        }
        List<PathGroup> pathGroups = ((TargetDTO.Drawing) dataModel).getPathGroups();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(pathGroups, 10));
        for (PathGroup pathGroup : pathGroups) {
            AnnotationStroke annotationStroke2 = new AnnotationStroke(pathGroup.getStroke().getColor(), pathGroup.getStroke().getSize());
            List<Path> paths = pathGroup.getPaths();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(paths, 10));
            Iterator<T> it = paths.iterator();
            while (it.hasNext()) {
                List<Point> points = ((Path) it.next()).getPoints();
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(points, 10));
                for (Point point : points) {
                    arrayList4.add(new AnnotationPoint(point.getX(), point.getY()));
                }
                arrayList3.add(new AnnotationPath(arrayList4));
            }
            arrayList2.add(new AnnotationPathGroup(annotationStroke2, arrayList3));
        }
        return new AnnotationTargetModel.Drawing(arrayList2);
    }

    public final TargetDTO fromDomain(AnnotationTargetModel domainModel, AnnotationLocationModel locationModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        Intrinsics.checkNotNullParameter(locationModel, "locationModel");
        if (domainModel instanceof AnnotationTargetModel.Area) {
            Location locationFromDomain = LocationDomainModelMapper.INSTANCE.fromDomain(locationModel);
            AnnotationTargetModel.Area area = (AnnotationTargetModel.Area) domainModel;
            double height = area.getAnnotationRectangle().getHeight();
            double width = area.getAnnotationRectangle().getWidth();
            double left = area.getAnnotationRectangle().getLeft();
            double top = area.getAnnotationRectangle().getTop();
            AnnotationStroke annotationStroke = area.getAnnotationStroke();
            return new TargetDTO.Region(locationFromDomain, new Shape(height, width, left, top, annotationStroke != null ? new Stroke(annotationStroke.getColor(), annotationStroke.getWidth()) : null, ShapeType.RECT));
        }
        if (domainModel instanceof AnnotationTargetModel.TextSelection) {
            Location locationFromDomain2 = LocationDomainModelMapper.INSTANCE.fromDomain(locationModel);
            AnnotationTargetModel.TextSelection textSelection = (AnnotationTargetModel.TextSelection) domainModel;
            List<AnnotationRectangle> highlights = textSelection.getHighlights();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(highlights, 10));
            for (AnnotationRectangle annotationRectangle : highlights) {
                double height2 = annotationRectangle.getHeight();
                double width2 = annotationRectangle.getWidth();
                double left2 = annotationRectangle.getLeft();
                double top2 = annotationRectangle.getTop();
                AnnotationStroke highlightStroke = textSelection.getHighlightStroke();
                arrayList.add(new Shape(height2, width2, left2, top2, highlightStroke != null ? new Stroke(highlightStroke.getColor(), highlightStroke.getWidth()) : null, ShapeType.RECT));
            }
            return new TargetDTO.Highlight(locationFromDomain2, arrayList);
        }
        if (!(domainModel instanceof AnnotationTargetModel.Drawing)) {
            throw new NoWhenBranchMatchedException();
        }
        Location locationFromDomain3 = LocationDomainModelMapper.INSTANCE.fromDomain(locationModel);
        List<AnnotationPathGroup> pathGroups = ((AnnotationTargetModel.Drawing) domainModel).getPathGroups();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(pathGroups, 10));
        for (AnnotationPathGroup annotationPathGroup : pathGroups) {
            Stroke strokeDTO = INSTANCE.toStrokeDTO(annotationPathGroup.getStroke());
            List<AnnotationPath> paths = annotationPathGroup.getPaths();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(paths, 10));
            Iterator<T> it = paths.iterator();
            while (it.hasNext()) {
                List<AnnotationPoint> points = ((AnnotationPath) it.next()).getPoints();
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(points, 10));
                for (AnnotationPoint annotationPoint : points) {
                    arrayList4.add(new Point(annotationPoint.getX(), annotationPoint.getY()));
                }
                arrayList3.add(new Path(arrayList4));
            }
            arrayList2.add(new PathGroup(strokeDTO, arrayList3));
        }
        return new TargetDTO.Drawing(locationFromDomain3, arrayList2);
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public TargetDTO fromDomain(AnnotationTargetModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final Stroke toStrokeDTO(AnnotationStroke annotationStroke) {
        return new Stroke(annotationStroke.getColor(), annotationStroke.getWidth());
    }
}
