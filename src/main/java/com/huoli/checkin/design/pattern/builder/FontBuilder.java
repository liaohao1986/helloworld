package com.huoli.checkin.design.pattern.builder;

import java.awt.Font;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class FontBuilder implements Builder<Font> {
    private Font font;

    public FontBuilder(String fontName) {
        this.font = new Font(fontName, Font.PLAIN, 12);
    }

    public FontBuilder bold() {
        this.font = this.font.deriveFont(Font.BOLD);
        return this; // Reference returned so calls can be chained
    }

    public FontBuilder size(float pointSize) {
        this.font = this.font.deriveFont(pointSize);
        return this; // Reference returned so calls can be chained
    }

    // Other Font construction methods

    public Font build() {
        return this.font;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static void main(String[] args) {
        Font bold14ptSansSerifFont = new FontBuilder(Font.SANS_SERIF).bold().size(14.0f).build();
        System.out.println(bold14ptSansSerifFont);

    }
}
