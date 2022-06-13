package de.stenya.cacheoverflow.textapi.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.jetbrains.annotations.NotNull;

public class JsonArrayUtils {

    public static @NotNull JsonArray appendFirst(@NotNull final JsonElement element, @NotNull final JsonArray array) {
        JsonArray newArray = new JsonArray();
        newArray.add(element);
        array.forEach(newArray::add);
        return newArray;
    }

}
