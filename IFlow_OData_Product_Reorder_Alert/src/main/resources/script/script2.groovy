import com.sap.gateway.ip.core.customdev.util.Message
import groovy.util.XmlParser

def Message processData(Message message) {
    def body = message.getBody(String)
    def parser = new XmlParser()
    def productsNode = parser.parseText(body)

    def builder = new StringBuilder()
    builder.append("Product Stock Report\n")
    builder.append("\n")

    int count = 1
    productsNode.Product.each { product ->
        def name = product.ProductName.text()
        def stock = product.UnitsInStock.text().toInteger()
        def price = product.UnitPrice.text().toBigDecimal()
        def alert = (stock < 20) ? "YES" : "NO"

        builder.append("${count}. Product Name : ${name}\n")
        builder.append("   Units In Stock : ${stock}\n")
        builder.append("   Unit Price     : \$${price}\n")
        builder.append("   Reorder Alert  : ${alert}\n\n")

        count++
    }

    message.setBody(builder.toString())
    return message
}
