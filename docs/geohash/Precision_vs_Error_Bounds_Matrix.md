# Precision vs Error Bounds Matrix

## Overview
Architectural specification and design document for the **Bharat-Spatial-Engine** high-performance Java 21 Loom backend engine.

## Engineering Details
Geohash precision mapping from length 1 (±2500 km) to length 8 (±19 meters).

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.
