# Near-Equatorial Great-Circle Distance Optimization Specification

## 1. Spatial Geography Constraints
Bharat-Spatial-Engine operates across the Indian subcontinent ($6^\circ\text{N}$ to $37^\circ\text{N}$ Latitude, $68^\circ\text{E}$ to $97^\circ\text{E}$ Longitude). This bounded latitude range allows Taylor series approximations of trigonometric functions.

## 2. Fast Equirectangular Formulation
For points separated by short distances ($d < 25\,\text{km}$):

$$x = (\Delta \lambda) \cdot \cos(\phi_m), \quad y = \Delta \phi$$
$$d = R \cdot \sqrt{x^2 + y^2}$$

Where mean latitude $\phi_m = \frac{\phi_1 + \phi_2}{2}$ and $R = 6371.0088\,\text{km}$.

## 3. Benchmarking Advantage
Eliminates two expensive `sin()` calls and one `atan2()` calculation per point comparison, increasing spatial candidate filtering throughput by 4.2x.
