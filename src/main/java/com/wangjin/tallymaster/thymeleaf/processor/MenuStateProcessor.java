package com.wangjin.tallymaster.thymeleaf.processor;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.Arguments;
import org.thymeleaf.Configuration;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractAttributeModifierAttrProcessor;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/16 下午2:39.
 */
public class MenuStateProcessor extends AbstractAttributeModifierAttrProcessor {

    public MenuStateProcessor(String attributeName) {
        super(attributeName);
    }

    @Override
    protected Map<String, String> getModifiedAttributeValues(Arguments arguments, Element element, String attributeName) {
        Configuration configuration = arguments.getConfiguration();
        // 获得属性值
        String attributeValue = element.getAttributeValue(attributeName);
        // 获得Thymeleaf的标准表达式解析器
        IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
        // 以一个标准Thymeleaf表达式解析属性值
        IStandardExpression iStandardExpression = parser.parseExpression(configuration, arguments, attributeValue);
        // 取得传入的菜单URI
        String menuURI = (String) iStandardExpression.execute(configuration, arguments);

        final Map<String, String> values = new HashMap<>();
        // 判断URL是否相同
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String currentURI = httpServletRequest.getRequestURI();
        if (menuURI.equals(currentURI)) {
            values.put("class", "active");
        }
        return values;
    }

    @Override
    protected ModificationType getModificationType(Arguments arguments, Element element, String s, String s1) {
        // 万一该元素已经设置了Class属性，我们将把我们的新值拼接到后面（用空格隔开），或者简单的取代他
        return ModificationType.APPEND_WITH_SPACE;
    }

    @Override
    protected boolean removeAttributeIfEmpty(Arguments arguments, Element element, String s, String s1) {
        // 如果算出来的class属性是空则根本不显示出来
        return true;
    }

    @Override
    protected boolean recomputeProcessorsAfterExecution(Arguments arguments, Element element, String s) {
        // 当这个元素被执行完成后不需要再重新计算
        return false;
    }

    @Override
    public int getPrecedence() {
        return 0;
    }
}
