package de.stenya.cacheoverflow.textapi;

import com.google.gson.JsonElement;
import de.stenya.cacheoverflow.textapi.events.IClickEvent;
import de.stenya.cacheoverflow.textapi.events.IHoverEvent;
import de.stenya.cacheoverflow.textapi.formatter.DefaultJsonFormatter;
import de.stenya.cacheoverflow.textapi.types.LiteralText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface IText {

    static @NotNull IText literal(@NotNull final String literal) {
        return new LiteralText(literal);
    }

    @NotNull IText append(@NotNull final IText text);

    @NotNull IText hoverEvent(@NotNull final IHoverEvent event);

    @NotNull IText clickEvent(@NotNull final IClickEvent event);

    @NotNull IText color(@NotNull final EnumColor color);

    @Nullable IHoverEvent hoverEvent();

    @Nullable IClickEvent clickEvent();

    @Nullable EnumColor color();

    default @NotNull JsonElement toJson() {
        return DefaultJsonFormatter.INSTANCE.format(this);
    }


    @NotNull List<IText> getChildTexts();

    @NotNull String asString(final boolean colored);

    @NotNull String getText();

    default @NotNull String asUncoloredString() {
        return this.asString(false);
    }

    default @NotNull String asColoredString() {
        return this.asString(true);
    }

}
