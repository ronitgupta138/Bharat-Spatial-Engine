# High-Throughput Loom Virtual Thread Scheduling Guide (38k+ QPS)

## 1. Throughput Architecture
- **Worker Configuration:** Virtual threads spawned per incoming client connection or batch tile request.
- **Garbage Collection Optimization:** Zero per-query object allocations on hot spatial traversal loops. Coordinates stored in primitive `double[]` flat buffers.
- **Carrier Thread Tuning:** `-Djdk.virtualThreadScheduler.parallelism=12` on AMD Ryzen 5 hex-core platforms.
