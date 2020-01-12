package InterfacesAndAbstraction.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    public static final int MAXSIZE = 100;
    private List<String> items;

    protected Collection() {
        this.items = new ArrayList<>(MAXSIZE);
    }

}
