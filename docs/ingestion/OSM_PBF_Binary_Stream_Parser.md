# OpenStreetMap (OSM) PBF Protocol Buffer Ingestion Architecture

## 1. Binary Stream Processing
- Decodes zlib-compressed `OSMHeader` and `OSMData` blob streams in parallel.
- Converts dense node coordinate deltas into spatial points using fast SIMD delta decoding.
