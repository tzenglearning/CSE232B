package expression;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataContext {

    public List<Node> data;
    public Map<String, List<Node>> map;
    public String name;
    public boolean ok;
    public List<Map<String, List<Node>>> possibilities;
    public DataContext(List<Node> data, Map<String, List<Node>> map){
        this.data  = new ArrayList<>(data);
        this.map = new HashMap<>(map);
        this.possibilities = new ArrayList<>();
    }

    public DataContext(String name){
        this.data  = new ArrayList<>();
        this.map = new HashMap<>();
        this.name = name;
        this.possibilities = new ArrayList<>();
    }

    public DataContext(List<Node> data, Map<String, List<Node>> map, String name){
        this.data  = new ArrayList<>(data);
        this.map = new HashMap<>(map);
        this.name = name;
        this.possibilities = new ArrayList<>();
    }

    public DataContext(boolean ok){
        this.data  = new ArrayList<>();
        this.map = new HashMap<>();
        this.name = null;
        this.ok = ok;
        this.possibilities = new ArrayList<>();
    }

    public DataContext(List<Node> data, Map<String, List<Node>> map, String name, boolean ok, List<Map<String, List<Node>>> list){
        this.data  = new ArrayList<>(data);
        this.map = new HashMap<>(map);
        this.name = name;
        this.ok = ok;
        this.possibilities = new ArrayList<>(list);
    }

    public DataContext clone(){
        return new DataContext(this.data, this.map, this.name, this.ok, this.possibilities);
    }

    @Override
    public String toString(){
        String str = this.data.size() < 10 ? this.data.toString():
                    "Data Size " + String.valueOf(this.data.size());

        return str + " " + this.map.toString();
    }


}
