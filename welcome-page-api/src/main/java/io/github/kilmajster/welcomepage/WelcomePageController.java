package io.github.kilmajster.welcomepage;

import io.github.kilmajster.welcomepage.util.MarkdownParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("${welcomePage.url:/}")
public class WelcomePageController {

    public static final String ATTR_TITLE = "title";
    public static final String ATTR_HTML_CONTENT = "html_body_content";
    public static final String ATTR_PRETTIFY = "prettify";

    public static final String TEMPLATE_MAIN_PAGE_CLEAN = "welcome-page-clean";
    public static final String TEMPLATE_MAIN_PAGE_BOOTSTRAP = "welcome-page-bootstrap";
    public static final String TEMPLATE_MAIN_PAGE_MDB = "welcome-page-mdb";
    public static final String TEMPLATE_ERROR_PAGE = "welcome-page-error";

    private final WelcomePage welcomePage;

    @GetMapping
    public String welcomePage(final ModelMap modelMap) {
        modelMap.addAttribute(ATTR_TITLE, welcomePage.getTitle());
        modelMap.addAttribute(ATTR_HTML_CONTENT, MarkdownParser.toHtml(welcomePage.getMarkdown()));
        modelMap.addAttribute(ATTR_PRETTIFY, welcomePage.getStyle().isPrettify());

        return chooseTemplate();
    }

    private String chooseTemplate() {
        return welcomePage.getStyle() == WelcomePage.Style.CLEAN
                ? TEMPLATE_MAIN_PAGE_CLEAN
                : welcomePage.getStyle() == WelcomePage.Style.BOOTSTRAP || welcomePage.getStyle() == WelcomePage.Style.PRETTIFY_BOOTSTRAP
                ? TEMPLATE_MAIN_PAGE_BOOTSTRAP
                : welcomePage.getStyle() == WelcomePage.Style.MATERIAL_DESIGN || welcomePage.getStyle() == WelcomePage.Style.PRETTIFY_MATERIAL_DESIGN
                ? TEMPLATE_MAIN_PAGE_MDB
                : TEMPLATE_ERROR_PAGE;
    }
}