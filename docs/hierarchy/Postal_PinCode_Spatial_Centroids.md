# Indian Postal Index Number (PIN Code) Spatial Centroid Standards

## 1. Postal Numbering Structure
India PIN codes comprise 6 digits:
- **Digit 1:** Northern, Western, Southern, Eastern postal region.
- **Digit 2:** Sub-region / State postal circle.
- **Digit 3:** Sorting / Revenue district.
- **Digits 4–6:** Individual delivery post office.

## 2. Geometric Polygon Triangulation & Centroids
$$\text{Centroid} = \left( \frac{1}{6A} \sum (x_i + x_{i+1})(x_i y_{i+1} - x_{i+1} y_i), \; \frac{1}{6A} \sum (y_i + y_{i+1})(x_i y_{i+1} - x_{i+1} y_i) \right)$$

Ensures centroid coordinates lie strictly within administrative polygon boundaries.
