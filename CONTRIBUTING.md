# Contributing to Bharat Spatial Engine

Thank you for your interest in contributing to **Bharat Spatial Engine**! We welcome contributions to 2D KD-Tree spatial indexing, Trigram settlement fuzzy search, Haversine geospatial bounding calculations, and high-throughput query APIs.

---

## 🛠️ Development Workflow

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ronitgupta138/bharat-spatial-engine.git
   cd bharat-spatial-engine
   ```

2. **Branching Conventions**:
   - `feat/<feature-name>`: Spatial partitioning, k-NN search, or Trigram fuzzy indexing
   - `fix/<bug-name>`: Precision or edge-case distance bug fixes
   - `perf/<optimization>`: KD-tree traversal and memory layout optimizations
   - `docs/<doc-topic>`: Benchmark results and documentation updates
   - `test/<test-suite>`: Census dataset test additions and stress tests

3. **Running Builds & Tests**:
   Ensure all tests pass before submitting changes:
   ```bash
   mvn clean test
   ```

---

## 📝 Pull Request Guidelines

- **Commit Message Format**: Follow conventional commits (`feat:`, `fix:`, `perf:`, `docs:`, `test:`).
- **Throughput Invariant**: 2D KD-Tree radius queries must maintain sub-millisecond execution times and support ≥ 35,000 QPS under Loom virtual thread concurrency.
- **Geospatial Precision**: Geodetic distance calculations must maintain geodesic boundary accuracy using double-precision coordinates.

---

## ⚖️ License
By contributing, you agree that your contributions will be licensed under the project's [MIT License](LICENSE).
