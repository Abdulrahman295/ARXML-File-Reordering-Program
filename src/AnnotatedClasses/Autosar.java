package AnnotatedClasses;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement(name = "AUTOSAR")
public class Autosar {
    private ArrayList<Container> containers;

    public Autosar() {}

    public Autosar(ArrayList<Container> containers) {
        this.containers = containers;
    }

    @XmlElement(name = "CONTAINER")
    public ArrayList<Container> getContainers() {
        return containers;
    }

    public void setContainers(ArrayList<Container> containers) {
        this.containers = containers;
    }

}
