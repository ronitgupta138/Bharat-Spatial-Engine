# Geospatial Boundary Regression Test Matrix Specification

## 1. Subcontinent Extremities
Regression tests verify coordinate boundary edge cases at the geographical limits of India:
- **Northern Extremity:** Indira Col, Siachen ($35.6745^\circ\text{N}, 76.8458^\circ\text{E}$)
- **Southern Extremity:** Indira Point, Great Nicobar ($6.7533^\circ\text{N}, 93.8291^\circ\text{E}$)
- **Western Extremity:** Sir Creek / Ghuar Moti ($23.7144^\circ\text{N}, 68.0534^\circ\text{E}$)
- **Eastern Extremity:** Kibithu, Arunachal Pradesh ($28.0289^\circ\text{N}, 97.0225^\circ\text{E}$)

## 2. Validation Assertions
- Zero NaN coordinate projections.
- Great-circle distance calculations remain mathematically symmetric:
  $$\text{dist}(A, B) \equiv \text{dist}(B, A) \quad (\pm 10^{-6}\,\text{meters})$$
