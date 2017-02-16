package com.wangjin.tallymaster.thymeleaf.dialect;

import com.wangjin.tallymaster.thymeleaf.processor.MenuStateProcessor;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/16 下午2:32.
 */
public class MenuStateDialect extends AbstractDialect {
    @Override
    public String getPrefix() {
        return "menu-state";
    }

    @Override
    public Set<IProcessor> getProcessors() {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new MenuStateProcessor("menu-state"));
        return processors;
    }
}
