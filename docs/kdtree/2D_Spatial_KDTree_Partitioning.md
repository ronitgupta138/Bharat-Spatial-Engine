# 2D Spatial KDTree Partitioning

## Overview
Architectural specification and design document for the **Bharat-Spatial-Engine** high-performance Java 21 Loom backend engine.

## Engineering Details
Alternating axis median splitting (Latitude / Longitude) constructing balanced spatial binary tree.

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.
