package chuva.hg.groups;

import org.bukkit.ChatColor;

public enum Groups {

    DEFAULT("Membro", "", 0, 0, ChatColor.GRAY),
    VIP("Vip", "VIP", 1, 0, ChatColor.GREEN),
    MVP("Mvp", "MVP", 2, 0, ChatColor.AQUA),
    STAFF("Staff", "Staff", 3, 5, ChatColor.YELLOW),
    MANAGER("Manager", "Manager", 10, 1, ChatColor.GOLD);

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
