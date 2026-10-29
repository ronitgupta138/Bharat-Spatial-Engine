# Boundary Polygon Simplification

## Overview
Architectural specification and design document for the **Bharat-Spatial-Engine** high-performance Java 21 Loom backend engine.

## Engineering Details
Ramer-Douglas-Peucker algorithm simplifying district polygon perimeters for web display.

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.
