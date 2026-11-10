# Indic Phonetic Trigram Indexing and Transliteration Search

## 1. Challenge
Indian location names frequently exhibit varied English transliterations (e.g., "Varanasi" vs "Banaras", "Bengaluru" vs "Bangalore", "Howrah" vs "Haora").

## 2. Phonetic Normalization Pipeline
1. **Script Detection:** Detects whether query tokens are Romanized Latin or native Indic unicode blocks.
2. **Double Metaphone Extension:** Encodes aspirated plosives ('dh', 'th', 'kh', 'bh') into canonical phonetic tokens.
3. **Character Trigram Inverted Index:**
   - Decomposes normalized strings into 3-grams: `"bengaluru"` -> `{"ben", "eng", "nga", "gal", "alu", "lur", "uru"}`.
   - Computes Jaccard / Cosine overlap with spatial candidate names to provide fault-tolerant fuzzy matches under 0.12ms.
