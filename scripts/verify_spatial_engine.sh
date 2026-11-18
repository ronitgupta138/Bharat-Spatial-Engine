#!/bin/bash
set -euo pipefail
echo "Verifying Bharat-Spatial-Engine build and test coverage..."
./mvnw clean test --batch-mode
echo "All tests verified successfully!"
