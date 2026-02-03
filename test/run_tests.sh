#!/bin/bash

# Configuration
SRC_DIR="src"
SCENARIOS_DIR="test/scenarios"
MAIN_CLASS="fr._42lyon.avaj.simulator.Simulator"

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m' # No Color

TOTAL_TESTS=0
FAILED_TESTS=0

run_test() {
    local scenario_file=$1
    local expected_type=$2 # "valid" or "invalid"
    ((TOTAL_TESTS++))

    echo -n "Testing $scenario_file... "

    # Run simulator and capture output
    # Redirect stdout to /dev/null for now as we focus on parsing errors
    # Redirect stderr to a temp file
    err_out=$(java -cp "$SRC_DIR" "$MAIN_CLASS" "$scenario_file" 2>&1 > /dev/null)

    if [ "$expected_type" == "valid" ]; then
        if [[ -z "$err_out" ]]; then
            echo -e "${GREEN}[OK]${NC}"
        else
            echo -e "${RED}[FAIL] Expected success but got error: $err_out${NC}"
            ((FAILED_TESTS++))
        fi
    else
        if [[ "$err_out" == Error:* ]]; then
            echo -e "${GREEN}[OK] ($err_out)${NC}"
        else
            echo -e "${RED}[FAIL] Expected error but command succeeded or gave unexpected output${NC}"
            ((FAILED_TESTS++))
        fi
    fi
}

# Run tests
for f in "$SCENARIOS_DIR"/valid_*.txt; do
    [ -e "$f" ] || continue
    run_test "$f" "valid"
done

for f in "$SCENARIOS_DIR"/invalid_*.txt; do
    [ -e "$f" ] || continue
    run_test "$f" "invalid"
done

echo "---------------------------------------"
if [ "$FAILED_TESTS" -eq 0 ]; then
    echo -e "${GREEN}[SUCCESS] All $TOTAL_TESTS tests passed!${NC}"
    exit 0
else
    echo -e "${RED}[FAILURE] $FAILED_TESTS/$TOTAL_TESTS tests failed${NC}"
    exit 1
fi
