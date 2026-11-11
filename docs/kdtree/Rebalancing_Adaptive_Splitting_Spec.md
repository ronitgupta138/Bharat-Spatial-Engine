# Adaptive KD-Tree Partitioning & Rebalancing Specification

## 1. Sliding Midpoint Rule
When spatial point distributions are non-uniform (e.g. high density in metropolitan centers like Mumbai or Kolkata, sparse in rural sectors), sliding midpoint partitioning ensures cell aspect ratios remain bounded, avoiding degenerate deep slices.
