# Spatial Query REST and gRPC API Specifications

## 1. Endpoints
- `GET /v1/spatial/nearby?lat={lat}&lon={lon}&radius_km={radius}&limit={k}`
  - Returns nearest $K$ points within the radius, ordered by Haversine distance.
- `GET /v1/spatial/search?q={query}&fuzzy=true`
  - Returns phonetically transliterated matches with MDDS administrative metadata.
- `POST /v1/spatial/bounding-box`
  - Body: `{"min_lat": ..., "max_lat": ..., "min_lon": ..., "max_lon": ...}`
  - High-speed range polygon clipping.
