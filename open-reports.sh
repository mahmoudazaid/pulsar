#!/bin/bash

echo "Opening Cucumber HTML Reports..."

# Check if we're on macOS
if [[ "$OSTYPE" == "darwin"* ]]; then
    # macOS
    open "target/cucumber-reports/cucumber-html-reports/overview-features.html"
    echo "✅ Opened enhanced HTML report in default browser"
    echo "📊 Report location: target/cucumber-reports/cucumber-html-reports/"
elif [[ "$OSTYPE" == "linux-gnu"* ]]; then
    # Linux
    if command -v xdg-open &> /dev/null; then
        xdg-open "target/cucumber-reports/cucumber-html-reports/overview-features.html"
        echo "✅ Opened enhanced HTML report in default browser"
    else
        echo "❌ xdg-open not found. Please install it or open manually:"
        echo "   target/cucumber-reports/cucumber-html-reports/overview-features.html"
    fi
else
    echo "❌ Unsupported OS. Please open manually:"
    echo "   target/cucumber-reports/cucumber-html-reports/overview-features.html"
fi

echo ""
echo "📁 Available reports:"
echo "   • Enhanced HTML: target/cucumber-reports/cucumber-html-reports/"
echo "   • Basic HTML: target/cucumber-reports/cucumber.html"
echo "   • JSON: target/cucumber-reports/cucumber.json"
echo "   • XML: target/cucumber-reports/cucumber.xml" 