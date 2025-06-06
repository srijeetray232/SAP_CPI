# SAP CPI iFlow – OData-Based Product Stock Report

This project demonstrates a real-world SAP Cloud Integration (CPI) iFlow that consumes a public OData service, processes product stock data, and generates a clean, formatted stock report.

## 💼 Use Case

In a typical procurement or inventory management scenario, it's important to monitor product stock levels. This iFlow:
- Connects to a free public OData API
- Retrieves product data in XML format
- Parses and transforms the data using Groovy
- Outputs a professional, human-readable stock report (plain text)
- Flags low-stock products for reorder alerts

## 🔧 Technology Stack

- **SAP BTP Integration Suite (CPI)**
- **OData Adapter**
- **Groovy Scripting**
- **Webhook.site** (for receiving HTTP output)

## 🧪 Input & Output

### Input:
XML response from public OData service (e.g. Northwind Products)

### Output:
Formatted report with product name, units in stock, price, and reorder alert.

Example:
Product Stock Report
Product Name : Chang
Units In Stock : 17
Unit Price : $19.0
Reorder Alert : YES

Product Name : Aniseed Syrup
Units In Stock : 13
Unit Price : $10.0
Reorder Alert : YES

pgsql
Copy
Edit

## 🚀 How to Run

1. Import the `.zip` package in your SAP CPI tenant.
2. Deploy the iFlow.
3. Configure a public webhook URL as the endpoint.
4. Check your output on Webhook.site or HTTP endpoint.

## 📎 Notes

- You can modify the Groovy script to output JSON or filter by conditions.
- Extend this for SFTP, email, or API integrations.
