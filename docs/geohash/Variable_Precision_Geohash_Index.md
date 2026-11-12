# Variable-Precision Geohash Spatial Prefix Indexing Specification

## 1. Interleaving Coordinates into Base32
Coordinates $(\text{lat}, \text{lon})$ are converted to binary strings via binary search interval bisection and interleaved into standard Base32 strings.

## 2. Precision & Error Bounding Table
| Geohash Length | Cell Width | Cell Height | Target Entity Type |
|---|---|---|---|
| 4 chars | $\pm 20\,\text{km}$ | $\pm 20\,\text{km}$ | District / Region |
| 5 chars | $\pm 2.4\,\text{km}$ | $\pm 4.9\,\text{km}$ | City Municipality |
| 6 chars | $\pm 610\,\text{m}$ | $\pm 1.2\,\text{km}$ | Pincode Sector |
| 7 chars | $\pm 76\,\text{m}$ | $\pm 153\,\text{m}$ | Street / Neighborhood |

## 3. 8-Neighbor Bounding Box Lookup
Radius queries map to the target cell plus its 8 surrounding topological neighbor hashes, preventing edge-boundary blind spots.
