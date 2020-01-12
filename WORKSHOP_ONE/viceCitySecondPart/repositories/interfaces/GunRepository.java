package WORKSHOP_ONE.viceCitySecondPart.repositories.interfaces;


import WORKSHOP_ONE.viceCitySecondPart.models.guns.Gun;

import java.util.*;



public class GunRepository implements Repository<Gun> {
    private Map<String, Gun> gunRepository;

    public GunRepository() {
        this.gunRepository = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.gunRepository.values());
    }

    @Override
    public void add(Gun model) {
        this.gunRepository.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Gun model) {
        if (this.gunRepository.containsKey(model.getName())){
            this.gunRepository.remove(model.getName());
            return true;
        }
        return false;
    }

    @Override
    public Gun find(String name) {
        return this.gunRepository.get(name);

    }

}
