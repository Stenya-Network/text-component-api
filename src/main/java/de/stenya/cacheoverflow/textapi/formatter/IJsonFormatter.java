package de.stenya.cacheoverflow.textapi.formatter;

import com.google.gson.JsonElement;
import de.stenya.cacheoverflow.textapi.IText;
import org.jetbrains.annotations.NotNull;

public interface IJsonFormatter {

    @NotNull JsonElement format(@NotNull final IText text);

}
