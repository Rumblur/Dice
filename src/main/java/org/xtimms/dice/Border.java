package org.xtimms.dice;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.concurrent.ThreadLocalRandom;

public class Border {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final int maxVanillaRadius;

    public Border(int maxVanillaRadius) {
        this.maxVanillaRadius = maxVanillaRadius;
    }

    public Location getRandomLocation(World world) {
        return getRandomLocationFromVanilla(world);
    }

    private Location getRandomLocationFromVanilla(World world) {
        org.bukkit.WorldBorder vanillaBorder = world.getWorldBorder();
        int size = (int) vanillaBorder.getSize();

        // Limit border size to configured value
        if (size > maxVanillaRadius * 2) {
            size = maxVanillaRadius * 2;
        }

        int x = random.nextInt(size) - size / 2;
        int z = random.nextInt(size) - size / 2;
        Location randomLocation = vanillaBorder.getCenter().add(x, 0, z);

        return world.getHighestBlockAt(randomLocation).getLocation();
    }

}
