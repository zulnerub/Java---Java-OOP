package InterfacesAndAbstraction.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollection extends Collection implements AddRemovable {
    private List<String> data;

    public AddRemoveCollection(){
        this.data = new ArrayList<>(MAXSIZE);
    }

    @Override
    public String remove() {


            return this.data.remove(this.data.size() - 1);




    }


    @Override
    public int add(String item) {
        this.data.add(0, item);
        return this.data.indexOf(item);
    }
}
