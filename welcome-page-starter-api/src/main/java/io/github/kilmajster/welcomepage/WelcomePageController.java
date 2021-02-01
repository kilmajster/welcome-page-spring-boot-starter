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

    public static final String TEMPLATE_MAIN_PAGE_CLEAN = "welcome-page-clean";
    public static final String TEMPLATE_MAIN_PAGE_BOOTSTRAP = "welcome-page-bootstrap";
    public static final String TEMPLATE_MAIN_PAGE_MDB = "welcome-page-mdb";
    public static final String TEMPLATE_ERROR_PAGE = "welcome-page-error";

    private final WelcomePageConfigurationProvider welcomePageConfig;

    @GetMapping
    public String welcomePage(final ModelMap modelMap) {
        modelMap.addAttribute(ATTR_TITLE, welcomePageConfig.getTitle());
        modelMap.addAttribute(ATTR_HTML_CONTENT, MarkdownParser.toHtml(welcomePageConfig.getMarkdown()));

        return chooseTemplate();
    }

    private String chooseTemplate() {
        return welcomePageConfig.getStyle() == WelcomePage.Style.CLEAN
                ? TEMPLATE_MAIN_PAGE_CLEAN
                : welcomePageConfig.getStyle() == WelcomePage.Style.BOOTSTRAP
                ? TEMPLATE_MAIN_PAGE_BOOTSTRAP
                : welcomePageConfig.getStyle() == WelcomePage.Style.MATERIAL_DESIGN
                ? TEMPLATE_MAIN_PAGE_MDB
                : TEMPLATE_ERROR_PAGE;
    }
}