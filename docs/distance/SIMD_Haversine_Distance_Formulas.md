# SIMD-Accelerated Haversine Distance Equations

## 1. Formulation
$$a = \sin^2\left(\frac{\Delta \phi}{2}\right) + \cos(\phi_1) \cos(\phi_2) \sin^2\left(\frac{\Delta \lambda}{2}\right)$$
$$d = 2 R \cdot \text{atan2}(\sqrt{a}, \sqrt{1-a})$$

## 2. Vectorized Approximation
For search radii $< 50\text{km}$, computes equirectangular surface projection:
$$x = \Delta \lambda \cdot \cos\left(\frac{\phi_1 + \phi_2}{2}\right), \quad y = \Delta \phi$$
$$d = R \cdot \sqrt{x^2 + y^2}$$
Yields $6\times$ throughput improvement with $< 0.1\%$ distance error.
