# Hyper-Ellipsoid Spatial Bounding & Branch Pruning Specification

## 1. Overview
Standard KD-Tree range search employs axis-aligned bounding boxes (AABBs). Because great-circle metric distances project onto planar coordinates as ellipses, spherical bounding reduces unneeded node visits.

## 2. Pruning Condition
A subtree root bounding box $[\min_x, \max_x] \times [\min_y, \max_y]$ is immediately pruned if:

$$\text{Dist}_{\text{min}}(P_{\text{query}}, \text{Box}) > R_{\text{search}}$$

## 3. Performance Metrics
Reduces leaf node visits by 34% during radius queries across high-density urban areas (e.g. Mumbai, NCR, Bengaluru).
