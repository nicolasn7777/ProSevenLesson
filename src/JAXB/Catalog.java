package JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "catalog")
public class Catalog {
    @XmlElement(name = "human")
    private List<Human> humans = new ArrayList<>();

    public void add(Human human) {
        humans.add(human);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(humans.toArray());
    }
}

