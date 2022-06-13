package de.stenya.cacheoverflow.textapi.events;

public interface IHoverEvent {

    enum EnumAction {

        SHOW_TEXT,
        SHOW_ITEM,
        SHOW_ENTITY,

        @Deprecated
        SHOW_ARCHIEVEMENT

    }

}
