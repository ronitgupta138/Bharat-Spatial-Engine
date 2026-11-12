# Lock-Free Copy-On-Write (COW) KD-Tree Update Architecture

## 1. Problem Definition
High-throughput spatial search engines require continuous $38,\!000+$ QPS read throughput without being blocked by incoming batch point inserts.

## 2. Immutable Node Trees & Atomic Pointer Swapping
- Nodes in the 2D KD-Tree are strictly immutable once initialized.
- Batch point additions construct a refreshed tree branch in memory.
- Root reference swapped atomically via Java `AtomicReference<KDNode>`:
  ```java
  rootRef.compareAndSet(oldRoot, newRoot);
  ```

## 3. Zero-Pause Read Guarantees
Concurrent readers traversing the spatial graph never acquire mutex locks or block on synchronization primitives.
