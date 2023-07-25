

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetCurrencyData {
    public static String findCurrencyData(String xmlString, String charCode) throws Exception {
        String currencyData = "";
        Document xmlDoc = ConvertStringToXML.convertStringToXMLDocument(xmlString);

        NodeList nodeList = xmlDoc.getElementsByTagName("Valute");

        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;
                String currencyCharCode = eElement.getElementsByTagName("CharCode").item(0).getTextContent();
                String currencyName = eElement.getElementsByTagName("Name").item(0).getTextContent();
                String currencyValue = eElement.getElementsByTagName("Value").item(0).getTextContent();
                if (!currencyCharCode.equals(charCode))
                    continue;
                currencyData = currencyCharCode + " (" + currencyName + "): " + currencyValue;
                break;
            }
        }
        if (currencyData.length() == 0)
            throw new Exception("Wrong currency name or missing data on this currency");
        return currencyData;
    }
}
