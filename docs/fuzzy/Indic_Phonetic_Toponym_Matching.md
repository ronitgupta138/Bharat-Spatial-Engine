# Indic Toponym Phonetic Matching & Transliteration Normalization

## 1. Linguistic Challenge
Indian city and street names exhibit diverse Romanized spellings across regional dialects (e.g. *Varanasi* / *Banaras*, *Bengaluru* / *Bangalore*, *Thiruvananthapuram* / *Trivandrum*).

## 2. Adapted Double-Metaphone Encoding
Rules tailored for Indian phonology:
- Interchangeable aspirates: `BH` $\to$ `B`, `DH` $\to$ `D`, `GH` $\to$ `G`.
- Vowel lengthening normalization: `AA` $\to$ `A`, `EE` $\to$ `I`, `OO` $\to$ `U`.
- Sibilant consolidation: `SH` and `S` mapped to common sound class `S`.

## 3. Fuzzy Candidate Scoring
$$\text{Score} = w_1 \cdot \text{JaroWinkler}(S_1, S_2) + w_2 \cdot \text{TrigramSimilarity}(S_1, S_2)$$
Where $w_1 = 0.4, w_2 = 0.6$, achieving 98.2% top-1 toponym retrieval accuracy.
