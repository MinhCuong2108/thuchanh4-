#!/usr/bin/env bash
# Script chay test + do coverage bang JaCoCo
# Su dung: bash scripts/run-tests.sh
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT"

# Tim JDK
if [ -z "${JAVA_HOME:-}" ] || [ ! -x "$JAVA_HOME/bin/javac" ]; then
  if [ -x /tmp/jdk-21.0.2/bin/javac ]; then
    export JAVA_HOME=/tmp/jdk-21.0.2
  elif command -v javac >/dev/null 2>&1; then
    export JAVA_HOME="$(dirname "$(dirname "$(readlink -f "$(command -v javac)")")")"
  else
    echo "[ERROR] Khong tim thay JDK. Cai dat JDK 17+ hoac set JAVA_HOME." >&2
    exit 1
  fi
fi
export PATH="$JAVA_HOME/bin:$PATH"

echo "[1/4] Compile main sources..."
rm -rf build/classes build/test-classes
mkdir -p build/classes build/test-classes
javac -d build/classes src/main/java/*.java

echo "[2/4] Compile tests..."
javac -cp "build/classes:lib/junit-platform-console-standalone.jar" \
      -d build/test-classes src/test/java/*.java

echo "[3/4] Run JUnit 5 + JaCoCo agent..."
java "-javaagent:lib/jacoco-agent.jar=destfile=build/coverage.exec,includes=*" \
     -jar lib/junit-platform-console-standalone.jar execute \
     -cp "build/classes:build/test-classes" \
     --scan-classpath \
     --details=tree \
     --details-theme=ascii \
     --disable-banner | tee logs/junit-run.log

echo "[4/4] Generate coverage report..."
java -jar lib/jacoco.jar report build/coverage.exec \
     --classfiles build/classes \
     --sourcefiles src/main/java \
     --csv logs/coverage.csv \
     --html logs/coverage-html \
     --xml logs/coverage.xml

echo ""
echo "=== Coverage summary ==="
cat logs/coverage.csv | tail -n +2 | awk -F, '
  BEGIN { ins_m=0; ins_c=0; br_m=0; br_c=0 }
  { ins_m+=$4; ins_c+=$5; br_m+=$6; br_c+=$7 }
  END {
    if (ins_m+ins_c > 0) printf "Instructions: %d/%d (%.1f%%)\n", ins_c, ins_c+ins_m, 100*ins_c/(ins_c+ins_m);
    if (br_m+br_c > 0)   printf "Branches:     %d/%d (%.1f%%)\n", br_c, br_c+br_m, 100*br_c/(br_c+br_m);
  }'