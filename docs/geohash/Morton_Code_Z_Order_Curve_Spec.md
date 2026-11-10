# Morton Code (Z-Order Space-Filling Curve) Spatial Indexing

## 1. Mathematical Formulation
Maps 2-dimensional geographic coordinates (Latitude, Longitude) into a 1-dimensional 64-bit integer while preserving spatial locality:
- **Bit Interleaving:**
  $$\text{Morton}(x, y) = \sum_{i=0}^{31} (x_i \cdot 2^{2i} + y_i \cdot 2^{2i+1})$$
- Interleaving bit shifts executed via BMI2 hardware instruction `_pdep_u64` (Parallel Bits Deposit).
