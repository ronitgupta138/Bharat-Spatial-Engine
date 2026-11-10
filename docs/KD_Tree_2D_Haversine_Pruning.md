# 2D KD-Tree Spatial Partitioning and Haversine Bounding Box Pruning

## 1. Spatial Index Structure
Bharat-Spatial-Engine indexes 1.2M+ Indian geographic points of interest (villages, postal pin codes, towns) in a balanced 2D KD-Tree:
- **Splitting Dimension:** Alternates between Latitude ($x$-axis) and Longitude ($y$-axis) at each tree depth.
- **Median Selection:** Linear-time Quickselect algorithm ensures $O(N \log N)$ construction time and $O(\log N)$ balanced search depth.

## 2. Haversine Pruning Mechanics
- Rather than computing the trigonometric Haversine distance across all tree candidates, queries maintain an equirectangular bounding box:
  $$\Delta \text{lat} = \frac{R_{\text{query}}}{R_{\text{Earth}}}, \quad \Delta \text{lon} = \frac{R_{\text{query}}}{R_{\text{Earth}} \cdot \cos(\text{lat})}$$
- If a KD-Tree node partition plane lies completely outside the bounding envelope, the entire subtree is pruned in $O(1)$ without evaluating child points.
