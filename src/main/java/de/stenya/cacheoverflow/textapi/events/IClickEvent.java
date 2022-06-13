package de.stenya.cacheoverflow.textapi.events;

import org.jetbrains.annotations.NotNull;

public interface IClickEvent {

    @NotNull EnumAction getAction();

    @NotNull String getValue();

    enum EnumAction {

        OPEN_URL,
        OPEN_FILE,
        RUN_COMMAND,
        SUGGEST_COMMAND,
        COPY_TO_CLIPBOARD

    }


}
