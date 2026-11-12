# Spatial K-Nearest Neighbor (kNN) Cursor Pagination Specification

## 1. Deep Pagination Pitfall
Traditional offset-based pagination (`OFFSET 1000 LIMIT 50`) forces the KD-Tree traversal to re-discover and discard the first 1,000 points on every page turn.

## 2. Deterministic Distance Cursors
Cursor encoded as opaque Base64 token containing:
`Cursor = Base64(last_distance_meters:last_entity_id)`

- **Next Page Query:** Search proceeds directly to candidates with $\text{dist} > \text{last\_distance}$, or equal distance with $\text{id} > \text{last\_id}$.
- **Complexity:** $O(k)$ per page traversal instead of $O(\text{offset} + k)$.
