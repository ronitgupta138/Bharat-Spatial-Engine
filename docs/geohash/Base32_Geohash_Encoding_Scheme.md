# Base32 Geohash Encoding Scheme

## Overview
Architectural specification and design document for the **Bharat-Spatial-Engine** high-performance Java 21 Loom backend engine.

## Engineering Details
Interleaving binary bits of latitude and longitude coordinates into Base32 spatial characters.

## Performance Invariants
- Virtual Threads concurrency scaling (`Thread.ofVirtual().start(...)`).
- Zero locks on hot read/query paths (lock-free / CAS / read-copy-update semantics).
- Predictable GC behavior with off-heap or compact memory layout.
