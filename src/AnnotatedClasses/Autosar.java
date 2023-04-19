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

    public static class Container implements Comparable<Container> {
        
        private String uuid;
        private String shortName;
        private String longName;

        public Container() {}

        public Container(String uuid, String shortName, String longName) {
            this.uuid = uuid;
            this.shortName = shortName;
            this.longName = longName;
        }

        @XmlAttribute(name = "UUID")
        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        @XmlElement(name = "SHORT-NAME")
        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        @XmlElement(name = "LONG-NAME")
        public String getLongName() {
            return longName;
        }

        public void setLongName(String longName) {
            this.longName = longName;
        }

        @Override
        public String toString() {
            return "Container{" +
                    "uuid='" + uuid + '\'' +
                    ", shortName='" + shortName + '\'' +
                    ", longName='" + longName + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Container o) {
            return this.getShortName().compareTo(o.getShortName());
        }
    }
}
