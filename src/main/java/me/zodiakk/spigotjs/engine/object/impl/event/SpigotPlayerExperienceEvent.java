package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.player.PlayerExpChangeEvent;

import me.zodiakk.spigotjs.engine.object.event.JsPlayerExperienceEvent;

public class SpigotPlayerExperienceEvent extends SpigotPlayerEvent implements JsPlayerExperienceEvent {
    private PlayerExpChangeEvent event;

    public SpigotPlayerExperienceEvent(PlayerExpChangeEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public Number getAmount() {
        return event.getAmount();
    }

    @Override
    public void setAmount(Number amount) {
        event.setAmount(amount.intValue());
    }
}
