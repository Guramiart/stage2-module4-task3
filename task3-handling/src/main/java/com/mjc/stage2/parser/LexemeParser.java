package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.stream.Stream;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String[] str = string.split(LEXEME_REGEX);
        Stream.of(str).forEach(w -> abstractTextComponent.add(new TextComponent(TextComponentType.WORD)));
    }

}
