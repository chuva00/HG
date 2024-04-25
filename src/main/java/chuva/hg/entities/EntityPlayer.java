package chuva.hg.entities;

import chuva.hg.groups.Groups;
import chuva.hg.kits.Kits;

import java.util.List;

public class EntityPlayer {

    private final Groups group;
    private final List<Kits> kits;
    private final EntityEconomy economy;
    private final EntityStatus status;

    public EntityPlayer(Groups group, EntityEconomy economy, List<Kits> kits, EntityStatus status) {
        this.group = group;
        this.economy = economy;
        this.status = status;
        this.kits = kits;
    }

    public EntityEconomy getEconomy() {
        return economy;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public Groups getGroup() {
        return group;
    }

    public List<Kits> getKits() {
        return kits;
    }
}
