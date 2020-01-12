package InterfacesAndAbstraction.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddCollection extends Collection implements Addable {

    private List<String> data;

    public AddCollection () {
        this.data = new ArrayList<>(MAXSIZE);
    }

    @Override
    public int add(String item) {
        this.data.add(item);

        return this.data.size() - 1;
    }
}
