package de.stenya.cacheoverflow.textapi.types;

import de.stenya.cacheoverflow.textapi.EnumColor;
import de.stenya.cacheoverflow.textapi.IText;
import de.stenya.cacheoverflow.textapi.events.IClickEvent;
import de.stenya.cacheoverflow.textapi.events.IHoverEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LiteralText implements IText {

    private final List<IText> childTexts = new ArrayList<>();
    private final String text;
    private IHoverEvent hoverEvent;
    private IClickEvent clickEvent;
    private EnumColor color;

    public LiteralText(@NotNull final String text) {
        this.text = text;
    }

    @Override
    public @NotNull IText append(@NotNull IText text) {
        this.childTexts.add(text);
        return this;
    }

    @Override
    public @NotNull IText hoverEvent(@NotNull IHoverEvent event) {
        this.hoverEvent = event;
        return this;
    }

    @Override
    public @NotNull IText clickEvent(@NotNull IClickEvent event) {
        this.clickEvent = event;
        return this;
    }

    @Override
    public @NotNull IText color(@NotNull EnumColor color) {
        this.color = color;
        return this;
    }

    @Override
    public @Nullable IHoverEvent hoverEvent() {
        return this.hoverEvent;
    }

    @Override
    public @Nullable IClickEvent clickEvent() {
        return this.clickEvent;
    }

    @Override
    public @Nullable EnumColor color() {
        return this.color;
    }

    @Override
    public @NotNull List<IText> getChildTexts() {
        return this.childTexts;
    }

    @Override
    public @NotNull String asString(boolean colored) {
        String string = asStringInternal(this);
        return colored ? EnumColor.toColoredString('§', string) : EnumColor.stripColor(string);
    }

    @Override
    public @NotNull String getText() {
        return this.text;
    }

    public @NotNull String asStringInternal(@NotNull final IText text) {
        StringBuilder stringBuilder = new StringBuilder();
        if (text.color() != null)
            stringBuilder.append(text.color());
        else
            stringBuilder.append(EnumColor.RESET);
        stringBuilder.append(text.getText());
        text.getChildTexts().forEach(child -> stringBuilder.append(this.asStringInternal(child)));
        return stringBuilder.toString();
    }

}
