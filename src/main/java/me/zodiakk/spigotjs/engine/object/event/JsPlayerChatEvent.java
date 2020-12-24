package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsPlayer;

public interface JsPlayerChatEvent extends JsPlayerEvent {
    public String getFormat();
    public String getMessage();
    public JsPlayer[] getRecipients();
    public void setFormat(String format);
    public void setMessage(String message);
    public void setRecipients(JsPlayer[] recipients);
}
