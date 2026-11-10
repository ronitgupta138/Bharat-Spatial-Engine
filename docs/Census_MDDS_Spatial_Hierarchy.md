# Census of India MDDS (Metadata & Data Standards) Spatial Hierarchy

## 1. Administrative Code Hierarchy
- **State Code:** 2 digits (e.g., `19` = West Bengal, `27` = Maharashtra).
- **District Code:** 3 digits.
- **Sub-District / Tehsil Code:** 5 digits.
- **Village / Town (MDDS) Code:** 6 digits.

## 2. In-Memory Prefix Trie
Bharat-Spatial-Engine organizes MDDS administrative hierarchies in a compact Radix Trie. Point queries resolve full administrative containment (State -> District -> Block -> Pincode) via single-pointer lookups without database joins.
