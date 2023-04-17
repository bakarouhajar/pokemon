package com.pro.mylistpokemon;

public class ListPokemonDetails {


    private  String ability;
    private String is_hidden;
    private String slot;

    public String getAbility() {
        return ability;
    }

    public void setAbility(String bility) {
        this.ability = bility;
    }



    public String getIshidden() {
        return is_hidden;
    }

    public void setIshidden(String is_hidden) {
        this.is_hidden = is_hidden;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public ListPokemonDetails(String ability, String is_hidden, String slot) {
        this.ability = ability;
        this.is_hidden = is_hidden;
        this.slot=slot;
    }

}
