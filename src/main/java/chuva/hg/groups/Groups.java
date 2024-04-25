package chuva.hg.groups;

import org.bukkit.ChatColor;

public enum Groups {

    ;

    private final String name, displayName;
    private final int weight, slots;
    private final ChatColor color;

    Groups(String name, String displayName, int weight, int slots, ChatColor color) {
        this.name = name;
        this.displayName = displayName;
        this.weight = weight;
        this.slots = slots;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }

    public int getSlots() {
        return slots;
    }

    public int getWeight() {
        return weight;
    }

    public String getDisplayName() {
        return displayName;
    }
}
