
:: Create index
curl -X PUT "localhost:9200/open-trivia"

:: Create a mapping
curl -X PUT "localhost:9200/open-trivia/_mapping?pretty" -H "Content-Type: application/json" -d @mapping.json

:: Bulk upload data
curl -X POST "localhost:9200/open-trivia/_bulk?pretty" -H "Content-Type: application/x-ndjson" --data-binary @open-trivia.json