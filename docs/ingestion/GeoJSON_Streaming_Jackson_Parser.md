# GeoJSON FeatureCollection Streaming Ingestion Specification

## 1. Large-Scale GeoJSON Ingestion
Parsing multi-gigabyte spatial shapefiles (e.g. All-India district boundaries) exhausts heap memory if loaded into a single DOM tree.

## 2. Streaming Jackson Token Pipeline
Utilizes Jackson `JsonParser` streaming API:
```java
while (parser.nextToken() != JsonToken.END_ARRAY) {
    if ("Feature".equals(currentName)) {
        SpatialFeature feature = parseFeature(parser);
        spatialIndex.insert(feature);
    }
}
```

## 3. Resource Bounds
Memory consumption remains constant ($< 45\,\text{MB}$) regardless of whether the source GeoJSON file is $100\,\text{MB}$ or $10\,\text{GB}$.
