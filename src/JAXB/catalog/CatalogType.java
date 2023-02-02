package JAXB.catalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "catalogType", propOrder = {
    "human"
})
public class CatalogType {

    protected List<HumanType> human;

    public List<HumanType> getHuman() {
        if (human == null) {
            human = new ArrayList<HumanType>();
        }
        return this.human;
    }
}
