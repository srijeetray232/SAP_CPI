import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

def Message processData(Message message) {
    def body = message.getBody(String)
    
    def xml = new XmlSlurper().parseText(body)
    
    def result = []
    
    xml.Product.each { product ->
        def unitsInStock = product.UnitsInStock.toInteger()
        def productName = product.ProductName.text()
        
        if (unitsInStock < 20) {
            result.add([
                productName: productName,
                unitsInStock: unitsInStock,
                reorderAlert: true
            ])
        }
    }
    
    def jsonOutput = new groovy.json.JsonBuilder(result).toPrettyString()
    message.setBody(jsonOutput)
    
    return message
}
