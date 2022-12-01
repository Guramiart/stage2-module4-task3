package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractTextParser {
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";
    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {

        Matcher matcher = Pattern.compile(WORD_REGEX).matcher(string);

        while (matcher.find()) {
            abstractTextComponent.add(new TextComponent(TextComponentType.WORD));
        }

    }

}
