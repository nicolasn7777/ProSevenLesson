package JAXB.catalog;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    private final static QName _Catalog_QNAME = new QName("", "catalog");

    public ObjectFactory() {
    }

    public CatalogType createCatalogType() {
        return new CatalogType();
    }

    public HumanType createHumanType() {
        return new HumanType();
    }

    @XmlElementDecl(namespace = "", name = "catalog")
    public JAXBElement<CatalogType> createCatalog(CatalogType value) {
        return new JAXBElement<CatalogType>(_Catalog_QNAME, CatalogType.class, null, value);
    }
}
