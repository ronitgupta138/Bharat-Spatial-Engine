# High-Throughput Parallel GeoJSON Ingestion Architecture

## 1. Streaming Chunk Parser
- Large multi-gigabyte administrative boundary GeoJSON files stream through memory-mapped file channels.
- Partitions feature collections across Java 21 Loom virtual threads, converting polygon vertex rings into contiguous double arrays in parallel.
