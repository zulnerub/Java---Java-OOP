package InterfacesAndAbstraction.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class MyListImpl extends Collection implements MyList {

    private List<String> data;

    public MyListImpl(){
        this.data = new ArrayList<>(MAXSIZE);
    }

    @Override
    public int getUsed() {
        return this.data.size();
    }

    @Override
    public String remove() {

            return this.data.remove(0);

    }


    @Override
    public int add(String item) {
        this.data.add(0, item);
        return this.data.indexOf(item);
    }
}
