package de.stenya.cacheoverflow.textapi.formatter;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import de.stenya.cacheoverflow.textapi.IText;
import de.stenya.cacheoverflow.textapi.utils.JsonArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class DefaultJsonFormatter implements IJsonFormatter {

    public static final IJsonFormatter INSTANCE = new DefaultJsonFormatter();

    @Override
    public @NotNull JsonElement format(@NotNull IText text) {
        JsonArray array = new JsonArray();
        this.format(text, array);
        if (array.size() > 1)
            array = JsonArrayUtils.appendFirst(new JsonPrimitive(""), array);

        return array.size() == 1 ? array.get(0) : array;
    }

    @SuppressWarnings("all")
    public void format(@NotNull final IText text, @NotNull final JsonArray array) {
        JsonObject object = new JsonObject();
        object.addProperty("text", text.getText());
        if (text.color() != null)
            object.addProperty("color", text.color().name().toLowerCase(Locale.ROOT));

        if (text.clickEvent() != null) {
            JsonObject clickEventObject = new JsonObject();
            clickEventObject.addProperty("action", text.clickEvent().getAction().name().toLowerCase(Locale.ROOT));
            clickEventObject.addProperty("value", text.clickEvent().getValue());
            object.add("clickEvent", clickEventObject);
        }
        array.add(object);


        text.getChildTexts().forEach(childText -> this.format(childText, array));
    }

}
